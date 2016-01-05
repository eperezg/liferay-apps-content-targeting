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

import com.liferay.content.targeting.api.model.Channel;
import com.liferay.content.targeting.api.model.ChannelsRegistry;
import com.liferay.content.targeting.model.ChannelInstance;
import com.liferay.content.targeting.model.Tactic;
import com.liferay.content.targeting.service.ChannelInstanceLocalServiceUtil;
import com.liferay.content.targeting.service.TacticLocalServiceUtil;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
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
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	service = StagedModelDataHandler.class
)
public class ChannelInstanceStagedModelDataHandler
	extends BaseStagedModelDataHandler<ChannelInstance> {

	public static final String[] CLASS_NAMES = {
		ChannelInstance.class.getName()};

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		ChannelInstance channelInstance =
			ChannelInstanceLocalServiceUtil.
				fetchChannelInstanceByUuidAndGroupId(uuid, groupId);

		ChannelInstanceLocalServiceUtil.deleteChannelInstance(channelInstance);
	}

	@Override
	public void deleteStagedModel(ChannelInstance channelInstance)
		throws PortalException {

		ChannelInstanceLocalServiceUtil.deleteChannelInstance(channelInstance);
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(ChannelInstance channelInstance) {
		return channelInstance.getAlias();
	}

	@Override
	public List<ChannelInstance>
	fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {

		throw new UnsupportedOperationException();
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext,
			ChannelInstance channelInstance)
		throws Exception {

		Element channelInstanceElement =
			portletDataContext.getExportDataElement(channelInstance);

		Channel channel = _channelsRegistry.getChannel(
				channelInstance.getChannelKey());

		if (channel == null) {
			_log.error(
				"Cannot find channel with key " +
					channelInstance.getChannelKey());

			return;
		}

		Tactic tactic = TacticLocalServiceUtil.getTactic(
			channelInstance.getTacticId());

		Element tacticElement = portletDataContext.getExportDataElement(tactic);

		try {
			channel.exportData(
				portletDataContext, tacticElement, tactic,
				channelInstanceElement, channelInstance);
		}
		catch (Exception e) {
			e.printStackTrace();
			_log.error(
				"Cannot export custom data for channel " +
					channel.getName(LocaleUtil.getDefault()) +
						" in tactic" +
							tactic.getName(LocaleUtil.getDefault()),
				e);
		}

		portletDataContext.addClassedModel(
			channelInstanceElement,
			ExportImportPathUtil.getModelPath(channelInstance),
			channelInstance);
	}

	@Override
	public void importCompanyStagedModel(
			PortletDataContext portletDataContext, String uuid,
			long channelInstanceId)
		throws PortletDataException {

		ChannelInstance existingChannelInstance =
			ChannelInstanceLocalServiceUtil.
				fetchChannelInstanceByUuidAndGroupId(
					uuid, portletDataContext.getCompanyGroupId());

		Map<Long, Long> channelInstanceIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				ChannelInstance.class);

		channelInstanceIds.put(
			channelInstanceId, existingChannelInstance.getChannelInstanceId());
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			ChannelInstance channelInstance)
		throws Exception {

		Channel channel = _channelsRegistry.getChannel(
			channelInstance.getChannelKey());

		if (channel == null) {
			_log.error(
				"Cannot find channel with key " +
					channelInstance.getChannelKey());

			return;
		}

		Tactic tactic = TacticLocalServiceUtil.getTactic(
			channelInstance.getTacticId());

		long userId = portletDataContext.getUserId(
			channelInstance.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			channelInstance);

		ChannelInstance existingChannelInstance =
			ChannelInstanceLocalServiceUtil.
				fetchChannelInstanceByUuidAndGroupId(
					channelInstance.getUuid(),
					portletDataContext.getScopeGroupId());

		ChannelInstance importedChannelInstance = null;

		if (existingChannelInstance == null) {
			serviceContext.setUuid(channelInstance.getUuid());

			importedChannelInstance =
				ChannelInstanceLocalServiceUtil.addChannelInstance(
					userId, channelInstance.getTacticId(),
					channelInstance.getChannelKey(),
					channelInstance.getCampaignId(), channelInstance.getAlias(),
					channelInstance.getTypeSettings(), serviceContext);
		}
		else {
			importedChannelInstance =
				ChannelInstanceLocalServiceUtil.updateChannelInstance(
					existingChannelInstance.
						getChannelInstanceId(),
					channelInstance.getAlias(),
					channelInstance.getTypeSettings(), serviceContext);
		}

		portletDataContext.importClassedModel(
			channelInstance, importedChannelInstance);

		try {
			channel.importData(portletDataContext, tactic, channelInstance);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Cannot import custom data for channel " +
						channel.getName(LocaleUtil.getDefault()) +
							" in tactic" +
								tactic.getName(LocaleUtil.getDefault()));
			}
		}
	}

	@Override
	protected boolean validateMissingReference(String uuid, long groupId) {

		ChannelInstance channelInstance =
			ChannelInstanceLocalServiceUtil.
				fetchChannelInstanceByUuidAndGroupId(uuid, groupId);

		if (channelInstance == null) {
			return false;
		}

		return true;
	}

	@Reference(unbind = "-")
	protected void setChannelsRegistry(ChannelsRegistry channelsRegistry) {
		_channelsRegistry = channelsRegistry;
	}

	private static Log _log = LogFactoryUtil.getLog(
		ChannelInstanceStagedModelDataHandler.class);

	private ChannelsRegistry _channelsRegistry;

}