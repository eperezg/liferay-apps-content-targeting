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

package com.liferay.content.targeting.hook;

import com.liferay.content.targeting.util.UserSegmentUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceWrapper;
import com.liferay.portlet.asset.NoSuchVocabularyException;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.model.AssetVocabularyDisplay;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyService;
import com.liferay.portlet.asset.service.AssetVocabularyServiceWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class CTAssetVocabularyServiceImpl
		extends AssetVocabularyServiceWrapper {

	public CTAssetVocabularyServiceImpl() {
		super(null);
	}

	public CTAssetVocabularyServiceImpl(
		AssetVocabularyService assetVocabularyService) {

		super(assetVocabularyService);
	}

	@Override
	public AssetVocabularyDisplay getGroupVocabulariesDisplay(
			long groupId, String name, int start, int end,
			boolean addDefaultVocabulary, OrderByComparator obc)
		throws PortalException, SystemException {

		AssetVocabularyDisplay vocabularyDisplay =
			super.getGroupVocabulariesDisplay(
				groupId, name, start, end, addDefaultVocabulary, obc);

		List<AssetVocabulary> vocabularies =
			vocabularyDisplay.getVocabularies();

		AssetVocabulary vocabulary = null;

		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(
					groupId, UserSegmentUtil.getAssetVocabularyName());
		}
		catch (NoSuchVocabularyException nsve) {
			return vocabularyDisplay;
		}

		List<AssetVocabulary> removes = new ArrayList<AssetVocabulary>();

		removes.add(vocabulary);

		vocabularyDisplay.setVocabularies(
			ListUtil.remove(vocabularies, removes));

		return vocabularyDisplay;
	}

	@Override
	public List<AssetVocabulary> getVocabularies(long[] vocabularyIds)
		throws PortalException, SystemException {

		List<AssetVocabulary> vocabularies = super.getVocabularies(
			vocabularyIds);

		if (vocabularies.size() <= 1) {
			return vocabularies;
		}

		List<AssetVocabulary> unambiguousVocabularies =
			new ArrayList<AssetVocabulary>();

		Locale locale = LocaleThreadLocal.getThemeDisplayLocale();

		for (AssetVocabulary vocabulary : vocabularies) {
			String vocabularyTitle = vocabulary.getTitle(locale);

			if (vocabularyTitle.equals(
					UserSegmentUtil.getAssetVocabularyName())) {

				Group vocabularyGroup = GroupLocalServiceUtil.getGroup(
					vocabulary.getGroupId());

				if (!vocabularyGroup.isCompany()) {
					StringBundler sb = new StringBundler(5);

					sb.append(vocabularyTitle);
					sb.append(StringPool.SPACE);
					sb.append(StringPool.OPEN_PARENTHESIS);
					sb.append(vocabularyGroup.getDescriptiveName(locale));
					sb.append(StringPool.CLOSE_PARENTHESIS);

					vocabulary.setTitle(sb.toString(), locale);
				}
			}

			unambiguousVocabularies.add(vocabulary);
		}

		return unambiguousVocabularies;
	}

}