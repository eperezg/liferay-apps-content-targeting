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

package com.liferay.content.targeting.service.permission;

import com.liferay.content.targeting.model.Campaign;
import com.liferay.content.targeting.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo Garcia
 */
@Component(
	immediate = true,
	property = {"model.class.name=om.liferay.content.targeting.model.Campaign"},
	service = BaseModelPermissionChecker.class
)
public class CampaignPermission implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, Campaign campaign,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, campaign, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long campaignId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, campaignId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, Campaign campaign,
		String actionId) {

		if (permissionChecker.hasOwnerPermission(
				campaign.getCompanyId(), Campaign.class.getName(),
				campaign.getCampaignId(), campaign.getUserId(), actionId)) {

			return true;
		}

		return contains(
			permissionChecker, campaign.getGroupId(), campaign.getCampaignId(),
			actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, long campaignId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, Campaign.class.getName(), campaignId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long campaignId,
			String actionId)
		throws PortalException, SystemException {

		Campaign campaign = CampaignLocalServiceUtil.getCampaign(campaignId);

		return contains(permissionChecker, campaign, actionId);
	}

	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, primaryKey, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, Campaign.class.getName(),
				primaryKey, actionId);
		}
	}

}