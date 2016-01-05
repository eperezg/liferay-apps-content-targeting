/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.lar;

import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.api.model.RulesRegistry;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.service.RuleInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.UserSegmentLocalServiceUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.exportimport.lar.BaseStagedModelDataHandler;
import com.liferay.portlet.exportimport.lar.ExportImportPathUtil;
import com.liferay.portlet.exportimport.lar.PortletDataContext;
import com.liferay.portlet.exportimport.lar.PortletDataException;
import com.liferay.portlet.exportimport.lar.PortletDataHandler;

import java.util.List;
import java.util.Map;

import com.liferay.portlet.exportimport.lar.StagedModelDataHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	service = StagedModelDataHandler.class
)
public class RuleInstanceStagedModelDataHandler
	extends BaseStagedModelDataHandler<RuleInstance> {

	public static final String[] CLASS_NAMES = {RuleInstance.class.getName()};

	@Override
	public void deleteStagedModel(RuleInstance stagedRuleInstance)
		throws PortalException {

		RuleInstanceLocalServiceUtil.deleteRuleInstance(stagedRuleInstance);
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException, SystemException {

		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.fetchRuleInstanceByUuidAndGroupId(
				uuid, groupId);

		RuleInstanceLocalServiceUtil.deleteRuleInstance(ruleInstance);
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(RuleInstance ruleInstance) {
		Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

		if (rule == null) {
			_log.error(
				"Cannot find rule with key " + ruleInstance.getRuleKey());

			return StringPool.BLANK;
		}

		return rule.getName(LocaleUtil.getDefault());
	}

	@Override
	public List<RuleInstance>
		fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {

		throw new UnsupportedOperationException();
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, RuleInstance ruleInstance)
		throws Exception {

		Element ruleInstanceElement = portletDataContext.getExportDataElement(
			ruleInstance);

		Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

		if (rule == null) {
			_log.error(
				"Cannot find rule with key " + ruleInstance.getRuleKey());

			return;
		}

		UserSegment userSegment =
			UserSegmentLocalServiceUtil.getUserSegment(
				ruleInstance.getUserSegmentId());

		Element userSegmentElement = portletDataContext.getExportDataElement(
			userSegment);

		try {
			rule.exportData(
				portletDataContext, userSegmentElement, userSegment,
				ruleInstanceElement, ruleInstance);
		}
		catch (Exception e) {
			_log.error(
				"Cannot export custom data for rule " +
					rule.getName(LocaleUtil.getDefault()) +
						" in user segment " +
							userSegment.getName(LocaleUtil.getDefault()),
				e);
		}

		portletDataContext.addClassedModel(
			ruleInstanceElement,
			ExportImportPathUtil.getModelPath(ruleInstance), ruleInstance);
	}

	@Override
	public void importCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid,
			long ruleInstanceId)
		throws PortletDataException {

		RuleInstance existingRuleInstance =
			RuleInstanceLocalServiceUtil.fetchRuleInstanceByUuidAndGroupId(
				uuid, portletDataContext.getCompanyGroupId());

		Map<Long, Long> ruleInstanceIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				RuleInstance.class);

		ruleInstanceIds.put(
			ruleInstanceId, existingRuleInstance.getRuleInstanceId());
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, RuleInstance ruleInstance)
		throws Exception {

		Rule rule = _rulesRegistry.getRule(ruleInstance.getRuleKey());

		if (rule == null) {
			_log.error(
				"Cannot find rule with key " + ruleInstance.getRuleKey());

			return;
		}

		UserSegment userSegment =
			UserSegmentLocalServiceUtil.getUserSegment(
				ruleInstance.getUserSegmentId());

		try {
			rule.importData(portletDataContext, userSegment, ruleInstance);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Cannot import custom data for rule " +
						rule.getName(LocaleUtil.getDefault()) +
							" in user segment " +
								userSegment.getName(LocaleUtil.getDefault()),
					e);
			}
		}

		long userId = portletDataContext.getUserId(ruleInstance.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			ruleInstance);

		RuleInstance existingRuleInstance =
			RuleInstanceLocalServiceUtil.fetchRuleInstanceByUuidAndGroupId(
				ruleInstance.getUuid(), portletDataContext.getScopeGroupId());

		RuleInstance importedRuleInstance = null;

		if (existingRuleInstance == null) {
			serviceContext.setUuid(ruleInstance.getUuid());

			importedRuleInstance = RuleInstanceLocalServiceUtil.addRuleInstance(
				userId, ruleInstance.getRuleKey(),
				ruleInstance.getUserSegmentId(), ruleInstance.getTypeSettings(),
				serviceContext);
		}
		else {
			importedRuleInstance =
				RuleInstanceLocalServiceUtil.updateRuleInstance(
					existingRuleInstance.getRuleInstanceId(),
					ruleInstance.getTypeSettings(), serviceContext);
		}

		portletDataContext.importClassedModel(
			ruleInstance, importedRuleInstance);
	}

	@Override
	protected boolean validateMissingReference(String uuid, long groupId) {
		RuleInstance ruleInstance =
			RuleInstanceLocalServiceUtil.fetchRuleInstanceByUuidAndGroupId(
				uuid, groupId);

		if (ruleInstance == null) {
			return false;
		}

		return true;
	}

	@Reference(unbind="-")
	protected void setRulesRegistry(RulesRegistry rulesRegistry) {
		_rulesRegistry = rulesRegistry;
	}

	private static Log _log = LogFactoryUtil.getLog(
		RuleInstanceStagedModelDataHandler.class);

	private RulesRegistry _rulesRegistry;

}