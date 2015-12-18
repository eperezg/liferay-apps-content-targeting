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

package com.liferay.content.targeting.util;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.service.CampaignLocalService;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Garcia
 */
@Component
public class CampaignSearchContainerIterator
	extends SearchContainerIterator<Campaign> {

	public CampaignSearchContainerIterator() {}

	public CampaignSearchContainerIterator(long groupId, String keywords)
		throws PortletException {

		super(groupId, keywords);
	}

	@Override
	public List<Campaign> getResults(int start, int end)
		throws PortalException, SystemException {

		if (Validator.isNull(keywords)) {
			return CampaignLocalServiceUtil.getCampaigns(
				groupId, start, end, null);
		}

		BaseModelSearchResult<Campaign> searchResults =
			CampaignLocalServiceUtil.searchCampaigns(
				groupId, keywords, start, end);

		return searchResults.getBaseModels();
	}

	@Override
	public int getTotal() throws PortalException, SystemException {
		if (Validator.isNull(keywords)) {
			return CampaignLocalServiceUtil.getCampaignsCount(groupId);
		}

		BaseModelSearchResult<Campaign> searchResults =
			CampaignLocalServiceUtil.searchCampaigns(
				groupId, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		return searchResults.getLength();
	}

}