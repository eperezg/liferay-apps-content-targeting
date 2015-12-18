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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.ResourcePermissionChecker;
import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {"resource.name=com.liferay.content.targeting.model"},
	service = ResourcePermissionChecker.class
)
public class ContentTargetingPermission extends BaseResourcePermissionChecker  {

	public static final String RESOURCE_NAME =
		"com.liferay.content.targeting.model";

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	@Override
	public Boolean checkResource(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		try {
			check(permissionChecker, groupId, actionId);

			return true;
		}
		catch (PortalException e) {}

		return false;
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(
			groupId, RESOURCE_NAME, groupId, actionId);
	}

}