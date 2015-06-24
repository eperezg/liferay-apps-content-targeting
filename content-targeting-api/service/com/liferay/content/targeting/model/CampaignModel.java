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

package com.liferay.content.targeting.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Campaign service. Represents a row in the &quot;CT_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.content.targeting.model.impl.CampaignModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.content.targeting.model.impl.CampaignImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Campaign
 * @see com.liferay.content.targeting.model.impl.CampaignImpl
 * @see com.liferay.content.targeting.model.impl.CampaignModelImpl
 * @generated
 */
public interface CampaignModel extends BaseModel<Campaign>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campaign model instance should use the {@link Campaign} interface instead.
	 */

	/**
	 * Returns the primary key of this campaign.
	 *
	 * @return the primary key of this campaign
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campaign.
	 *
	 * @param primaryKey the primary key of this campaign
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this campaign.
	 *
	 * @return the uuid of this campaign
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this campaign.
	 *
	 * @param uuid the uuid of this campaign
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the campaign ID of this campaign.
	 *
	 * @return the campaign ID of this campaign
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this campaign.
	 *
	 * @param campaignId the campaign ID of this campaign
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the group ID of this campaign.
	 *
	 * @return the group ID of this campaign
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this campaign.
	 *
	 * @param groupId the group ID of this campaign
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this campaign.
	 *
	 * @return the company ID of this campaign
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this campaign.
	 *
	 * @param companyId the company ID of this campaign
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this campaign.
	 *
	 * @return the user ID of this campaign
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this campaign.
	 *
	 * @param userId the user ID of this campaign
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this campaign.
	 *
	 * @return the user uuid of this campaign
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this campaign.
	 *
	 * @param userUuid the user uuid of this campaign
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this campaign.
	 *
	 * @return the user name of this campaign
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this campaign.
	 *
	 * @param userName the user name of this campaign
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this campaign.
	 *
	 * @return the create date of this campaign
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this campaign.
	 *
	 * @param createDate the create date of this campaign
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this campaign.
	 *
	 * @return the modified date of this campaign
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this campaign.
	 *
	 * @param modifiedDate the modified date of this campaign
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this campaign.
	 *
	 * @return the name of this campaign
	 */
	public String getName();

	/**
	 * Returns the localized name of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this campaign
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this campaign
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this campaign
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this campaign.
	 *
	 * @return the locales and localized names of this campaign
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this campaign.
	 *
	 * @param name the name of this campaign
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this campaign in the language.
	 *
	 * @param name the localized name of this campaign
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this campaign in the language, and sets the default locale.
	 *
	 * @param name the localized name of this campaign
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this campaign from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this campaign
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this campaign from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this campaign
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the description of this campaign.
	 *
	 * @return the description of this campaign
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this campaign
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this campaign
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this campaign
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this campaign.
	 *
	 * @return the locales and localized descriptions of this campaign
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this campaign.
	 *
	 * @param description the description of this campaign
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this campaign in the language.
	 *
	 * @param description the localized description of this campaign
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this campaign in the language, and sets the default locale.
	 *
	 * @param description the localized description of this campaign
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this campaign from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this campaign
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this campaign from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this campaign
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the start date of this campaign.
	 *
	 * @return the start date of this campaign
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this campaign.
	 *
	 * @param startDate the start date of this campaign
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this campaign.
	 *
	 * @return the end date of this campaign
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this campaign.
	 *
	 * @param endDate the end date of this campaign
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the priority of this campaign.
	 *
	 * @return the priority of this campaign
	 */
	public int getPriority();

	/**
	 * Sets the priority of this campaign.
	 *
	 * @param priority the priority of this campaign
	 */
	public void setPriority(int priority);

	/**
	 * Returns the active of this campaign.
	 *
	 * @return the active of this campaign
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this campaign is active.
	 *
	 * @return <code>true</code> if this campaign is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this campaign is active.
	 *
	 * @param active the active of this campaign
	 */
	public void setActive(boolean active);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(Campaign campaign);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Campaign> toCacheModel();

	@Override
	public Campaign toEscapedModel();

	@Override
	public Campaign toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}