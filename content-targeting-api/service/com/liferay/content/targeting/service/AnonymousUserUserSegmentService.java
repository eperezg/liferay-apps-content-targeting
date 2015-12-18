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

package com.liferay.content.targeting.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;

/**
 * Provides the remote service interface for AnonymousUserUserSegment. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserUserSegmentServiceUtil
 * @see com.liferay.content.targeting.service.base.AnonymousUserUserSegmentServiceBaseImpl
 * @see com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ct", "json.web.service.context.path=AnonymousUserUserSegment"}, service = AnonymousUserUserSegmentService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnonymousUserUserSegmentService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnonymousUserUserSegmentServiceUtil} to access the anonymous user user segment remote service. Add custom service methods to {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.content.targeting.model.AnonymousUserUserSegment addAnonymousUserUserSegment(
		long anonymousUserId, long userSegmentId, boolean manual,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentId(
		long userSegmentId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnonymousUsersByUserSegmentIdCount(long userSegmentId,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.content.targeting.anonymous.users.model.AnonymousUser> getAnonymousUsersByUserSegmentIds(
		long[] userSegmentIds, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnonymousUsersByUserSegmentIdsCount(long[] userSegmentIds,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByAnonymousUserId(
		long anonymousUserId, boolean active,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsByAnonymousUserIdCount(long anonymousUserId,
		boolean active, com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.content.targeting.model.UserSegment> getUserSegmentsByUserId(
		long userId, boolean active) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserSegmentsByUserIdCount(long userId, boolean active)
		throws PortalException, SystemException;

	public com.liferay.content.targeting.model.AnonymousUserUserSegment updateAnonymousUserUserSegment(
		long anonymousUserUserSegmentId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException, SystemException;
}