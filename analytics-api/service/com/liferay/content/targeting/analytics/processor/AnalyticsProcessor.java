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

package com.liferay.content.targeting.analytics.processor;

/**
 *
 * @author Eduardo Garcia
 */
public interface AnalyticsProcessor {

	public String addTrackingLinks(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String content);

	public String getTrackingEventURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String event, String additionalInfo);

	public String getTrackingImageHTML(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String additionalInfo);

	public String getTrackingImageURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String additionalInfo);

	public String getTrackingLinkURL(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String redirect);

	public void trackEvent(
		long companyId, long userId, long anonymousUserId, String className,
		long classPK, String elementId, String event, String additionalInfo);

}