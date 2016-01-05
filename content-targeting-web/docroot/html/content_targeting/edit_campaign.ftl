<#--
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
-->

<#include "../init.ftl" />
<#include "../macros.ftl" />
<#include "../macros_exceptions.ftl" />

<#if validator.isNull(backURL)>
	<@portlet["renderURL"] copyCurrentRenderParameters=false var="backURL">
		<@portlet["param"] name="mvcPath" value="${contentTargetingPath.VIEW}" />
		<@portlet["param"] name="tabs1" value="campaigns" />
	</@>
</#if>

<@liferay_ui["header"]
	backURL="${backURL}"
	title='${(campaign.getName(locale))!"new-campaign"}'
/>

<#assign classPK=campaignId>
<#assign className=campaignClass.getName()>

<#if (campaignId > 0)>
	<#assign pills="details,promotions,reports">
<#else>
	<#assign pills="details">
</#if>

<@portlet["renderURL"] copyCurrentRenderParameters=false varImpl="switchTabsURL">
	<@portlet["param"] name="mvcPath" value="${contentTargetingPath.EDIT_CAMPAIGN}" />
	<@portlet["param"] name="campaignId" value="${campaignId}" />
</@>

<@liferay_ui["tabs"]
	names="${pills}"
	param="campaignTabs"
	portletURL=switchTabsURL
	refresh=true
	type="pills"
	value="${campaignTabs}"
>
	<@liferay_ui["section"]>
		<#include "campaign_details.ftl" />
	</@>

	<#if (campaignId > 0)>
		<@liferay_ui["section"]>
			<#include "view_tactics.ftl" />
		</@>

		<@liferay_ui["section"]>
			<#include "view_reports.ftl" />
		</@>
	</#if>
</@>