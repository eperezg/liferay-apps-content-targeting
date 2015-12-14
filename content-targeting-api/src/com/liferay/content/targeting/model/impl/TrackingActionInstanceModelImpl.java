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

package com.liferay.content.targeting.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.TrackingActionInstance;
import com.liferay.content.targeting.model.TrackingActionInstanceModel;
import com.liferay.content.targeting.model.TrackingActionInstanceSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.exportimport.lar.StagedModelType;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TrackingActionInstance service. Represents a row in the &quot;CT_TrackingActionInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TrackingActionInstanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrackingActionInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstanceImpl
 * @see TrackingActionInstance
 * @see TrackingActionInstanceModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TrackingActionInstanceModelImpl extends BaseModelImpl<TrackingActionInstance>
	implements TrackingActionInstanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tracking action instance model instance should use the {@link TrackingActionInstance} interface instead.
	 */
	public static final String TABLE_NAME = "CT_TrackingActionInstance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "trackingActionInstanceId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "trackingActionKey", Types.VARCHAR },
			{ "campaignId", Types.BIGINT },
			{ "reportInstanceId", Types.BIGINT },
			{ "alias_", Types.VARCHAR },
			{ "referrerClassName", Types.VARCHAR },
			{ "referrerClassPK", Types.BIGINT },
			{ "elementId", Types.VARCHAR },
			{ "eventType", Types.VARCHAR },
			{ "typeSettings", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trackingActionInstanceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("trackingActionKey", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("campaignId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reportInstanceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("alias_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("referrerClassName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("referrerClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("elementId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table CT_TrackingActionInstance (uuid_ VARCHAR(75) null,trackingActionInstanceId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,trackingActionKey VARCHAR(75) null,campaignId LONG,reportInstanceId LONG,alias_ VARCHAR(75) null,referrerClassName VARCHAR(75) null,referrerClassPK LONG,elementId VARCHAR(75) null,eventType VARCHAR(75) null,typeSettings TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table CT_TrackingActionInstance";
	public static final String ORDER_BY_JPQL = " ORDER BY trackingActionInstance.trackingActionKey DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_TrackingActionInstance.trackingActionKey DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.api.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.content.targeting.model.TrackingActionInstance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.api.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.content.targeting.model.TrackingActionInstance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.api.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.content.targeting.model.TrackingActionInstance"),
			true);
	public static final long ALIAS_COLUMN_BITMASK = 1L;
	public static final long CAMPAIGNID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long ELEMENTID_COLUMN_BITMASK = 8L;
	public static final long EVENTTYPE_COLUMN_BITMASK = 16L;
	public static final long GROUPID_COLUMN_BITMASK = 32L;
	public static final long REFERRERCLASSNAME_COLUMN_BITMASK = 64L;
	public static final long REFERRERCLASSPK_COLUMN_BITMASK = 128L;
	public static final long REPORTINSTANCEID_COLUMN_BITMASK = 256L;
	public static final long UUID_COLUMN_BITMASK = 512L;
	public static final long TRACKINGACTIONKEY_COLUMN_BITMASK = 1024L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TrackingActionInstance toModel(
		TrackingActionInstanceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TrackingActionInstance model = new TrackingActionInstanceImpl();

		model.setUuid(soapModel.getUuid());
		model.setTrackingActionInstanceId(soapModel.getTrackingActionInstanceId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTrackingActionKey(soapModel.getTrackingActionKey());
		model.setCampaignId(soapModel.getCampaignId());
		model.setReportInstanceId(soapModel.getReportInstanceId());
		model.setAlias(soapModel.getAlias());
		model.setReferrerClassName(soapModel.getReferrerClassName());
		model.setReferrerClassPK(soapModel.getReferrerClassPK());
		model.setElementId(soapModel.getElementId());
		model.setEventType(soapModel.getEventType());
		model.setTypeSettings(soapModel.getTypeSettings());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TrackingActionInstance> toModels(
		TrackingActionInstanceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TrackingActionInstance> models = new ArrayList<TrackingActionInstance>(soapModels.length);

		for (TrackingActionInstanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.content.targeting.api.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.content.targeting.model.TrackingActionInstance"));

	public TrackingActionInstanceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _trackingActionInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTrackingActionInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _trackingActionInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TrackingActionInstance.class;
	}

	@Override
	public String getModelClassName() {
		return TrackingActionInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trackingActionInstanceId", getTrackingActionInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("trackingActionKey", getTrackingActionKey());
		attributes.put("campaignId", getCampaignId());
		attributes.put("reportInstanceId", getReportInstanceId());
		attributes.put("alias", getAlias());
		attributes.put("referrerClassName", getReferrerClassName());
		attributes.put("referrerClassPK", getReferrerClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("typeSettings", getTypeSettings());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long trackingActionInstanceId = (Long)attributes.get(
				"trackingActionInstanceId");

		if (trackingActionInstanceId != null) {
			setTrackingActionInstanceId(trackingActionInstanceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String trackingActionKey = (String)attributes.get("trackingActionKey");

		if (trackingActionKey != null) {
			setTrackingActionKey(trackingActionKey);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long reportInstanceId = (Long)attributes.get("reportInstanceId");

		if (reportInstanceId != null) {
			setReportInstanceId(reportInstanceId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		String referrerClassName = (String)attributes.get("referrerClassName");

		if (referrerClassName != null) {
			setReferrerClassName(referrerClassName);
		}

		Long referrerClassPK = (Long)attributes.get("referrerClassPK");

		if (referrerClassPK != null) {
			setReferrerClassPK(referrerClassPK);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTrackingActionInstanceId() {
		return _trackingActionInstanceId;
	}

	@Override
	public void setTrackingActionInstanceId(long trackingActionInstanceId) {
		_trackingActionInstanceId = trackingActionInstanceId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTrackingActionKey() {
		if (_trackingActionKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _trackingActionKey;
		}
	}

	@Override
	public void setTrackingActionKey(String trackingActionKey) {
		_columnBitmask = -1L;

		_trackingActionKey = trackingActionKey;
	}

	@JSON
	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_columnBitmask |= CAMPAIGNID_COLUMN_BITMASK;

		if (!_setOriginalCampaignId) {
			_setOriginalCampaignId = true;

			_originalCampaignId = _campaignId;
		}

		_campaignId = campaignId;
	}

	public long getOriginalCampaignId() {
		return _originalCampaignId;
	}

	@JSON
	@Override
	public long getReportInstanceId() {
		return _reportInstanceId;
	}

	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_columnBitmask |= REPORTINSTANCEID_COLUMN_BITMASK;

		if (!_setOriginalReportInstanceId) {
			_setOriginalReportInstanceId = true;

			_originalReportInstanceId = _reportInstanceId;
		}

		_reportInstanceId = reportInstanceId;
	}

	public long getOriginalReportInstanceId() {
		return _originalReportInstanceId;
	}

	@JSON
	@Override
	public String getAlias() {
		if (_alias == null) {
			return StringPool.BLANK;
		}
		else {
			return _alias;
		}
	}

	@Override
	public void setAlias(String alias) {
		_columnBitmask |= ALIAS_COLUMN_BITMASK;

		if (_originalAlias == null) {
			_originalAlias = _alias;
		}

		_alias = alias;
	}

	public String getOriginalAlias() {
		return GetterUtil.getString(_originalAlias);
	}

	@JSON
	@Override
	public String getReferrerClassName() {
		if (_referrerClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _referrerClassName;
		}
	}

	@Override
	public void setReferrerClassName(String referrerClassName) {
		_columnBitmask |= REFERRERCLASSNAME_COLUMN_BITMASK;

		if (_originalReferrerClassName == null) {
			_originalReferrerClassName = _referrerClassName;
		}

		_referrerClassName = referrerClassName;
	}

	public String getOriginalReferrerClassName() {
		return GetterUtil.getString(_originalReferrerClassName);
	}

	@JSON
	@Override
	public long getReferrerClassPK() {
		return _referrerClassPK;
	}

	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_columnBitmask |= REFERRERCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalReferrerClassPK) {
			_setOriginalReferrerClassPK = true;

			_originalReferrerClassPK = _referrerClassPK;
		}

		_referrerClassPK = referrerClassPK;
	}

	public long getOriginalReferrerClassPK() {
		return _originalReferrerClassPK;
	}

	@JSON
	@Override
	public String getElementId() {
		if (_elementId == null) {
			return StringPool.BLANK;
		}
		else {
			return _elementId;
		}
	}

	@Override
	public void setElementId(String elementId) {
		_columnBitmask |= ELEMENTID_COLUMN_BITMASK;

		if (_originalElementId == null) {
			_originalElementId = _elementId;
		}

		_elementId = elementId;
	}

	public String getOriginalElementId() {
		return GetterUtil.getString(_originalElementId);
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_columnBitmask |= EVENTTYPE_COLUMN_BITMASK;

		if (_originalEventType == null) {
			_originalEventType = _eventType;
		}

		_eventType = eventType;
	}

	public String getOriginalEventType() {
		return GetterUtil.getString(_originalEventType);
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				TrackingActionInstance.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TrackingActionInstance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TrackingActionInstance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TrackingActionInstance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TrackingActionInstanceImpl trackingActionInstanceImpl = new TrackingActionInstanceImpl();

		trackingActionInstanceImpl.setUuid(getUuid());
		trackingActionInstanceImpl.setTrackingActionInstanceId(getTrackingActionInstanceId());
		trackingActionInstanceImpl.setGroupId(getGroupId());
		trackingActionInstanceImpl.setCompanyId(getCompanyId());
		trackingActionInstanceImpl.setUserId(getUserId());
		trackingActionInstanceImpl.setUserName(getUserName());
		trackingActionInstanceImpl.setCreateDate(getCreateDate());
		trackingActionInstanceImpl.setModifiedDate(getModifiedDate());
		trackingActionInstanceImpl.setTrackingActionKey(getTrackingActionKey());
		trackingActionInstanceImpl.setCampaignId(getCampaignId());
		trackingActionInstanceImpl.setReportInstanceId(getReportInstanceId());
		trackingActionInstanceImpl.setAlias(getAlias());
		trackingActionInstanceImpl.setReferrerClassName(getReferrerClassName());
		trackingActionInstanceImpl.setReferrerClassPK(getReferrerClassPK());
		trackingActionInstanceImpl.setElementId(getElementId());
		trackingActionInstanceImpl.setEventType(getEventType());
		trackingActionInstanceImpl.setTypeSettings(getTypeSettings());

		trackingActionInstanceImpl.resetOriginalValues();

		return trackingActionInstanceImpl;
	}

	@Override
	public int compareTo(TrackingActionInstance trackingActionInstance) {
		int value = 0;

		value = getTrackingActionKey()
					.compareTo(trackingActionInstance.getTrackingActionKey());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TrackingActionInstance)) {
			return false;
		}

		TrackingActionInstance trackingActionInstance = (TrackingActionInstance)obj;

		long primaryKey = trackingActionInstance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TrackingActionInstanceModelImpl trackingActionInstanceModelImpl = this;

		trackingActionInstanceModelImpl._originalUuid = trackingActionInstanceModelImpl._uuid;

		trackingActionInstanceModelImpl._originalGroupId = trackingActionInstanceModelImpl._groupId;

		trackingActionInstanceModelImpl._setOriginalGroupId = false;

		trackingActionInstanceModelImpl._originalCompanyId = trackingActionInstanceModelImpl._companyId;

		trackingActionInstanceModelImpl._setOriginalCompanyId = false;

		trackingActionInstanceModelImpl._setModifiedDate = false;

		trackingActionInstanceModelImpl._originalCampaignId = trackingActionInstanceModelImpl._campaignId;

		trackingActionInstanceModelImpl._setOriginalCampaignId = false;

		trackingActionInstanceModelImpl._originalReportInstanceId = trackingActionInstanceModelImpl._reportInstanceId;

		trackingActionInstanceModelImpl._setOriginalReportInstanceId = false;

		trackingActionInstanceModelImpl._originalAlias = trackingActionInstanceModelImpl._alias;

		trackingActionInstanceModelImpl._originalReferrerClassName = trackingActionInstanceModelImpl._referrerClassName;

		trackingActionInstanceModelImpl._originalReferrerClassPK = trackingActionInstanceModelImpl._referrerClassPK;

		trackingActionInstanceModelImpl._setOriginalReferrerClassPK = false;

		trackingActionInstanceModelImpl._originalElementId = trackingActionInstanceModelImpl._elementId;

		trackingActionInstanceModelImpl._originalEventType = trackingActionInstanceModelImpl._eventType;

		trackingActionInstanceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TrackingActionInstance> toCacheModel() {
		TrackingActionInstanceCacheModel trackingActionInstanceCacheModel = new TrackingActionInstanceCacheModel();

		trackingActionInstanceCacheModel.uuid = getUuid();

		String uuid = trackingActionInstanceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			trackingActionInstanceCacheModel.uuid = null;
		}

		trackingActionInstanceCacheModel.trackingActionInstanceId = getTrackingActionInstanceId();

		trackingActionInstanceCacheModel.groupId = getGroupId();

		trackingActionInstanceCacheModel.companyId = getCompanyId();

		trackingActionInstanceCacheModel.userId = getUserId();

		trackingActionInstanceCacheModel.userName = getUserName();

		String userName = trackingActionInstanceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			trackingActionInstanceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			trackingActionInstanceCacheModel.createDate = createDate.getTime();
		}
		else {
			trackingActionInstanceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			trackingActionInstanceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			trackingActionInstanceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		trackingActionInstanceCacheModel.trackingActionKey = getTrackingActionKey();

		String trackingActionKey = trackingActionInstanceCacheModel.trackingActionKey;

		if ((trackingActionKey != null) && (trackingActionKey.length() == 0)) {
			trackingActionInstanceCacheModel.trackingActionKey = null;
		}

		trackingActionInstanceCacheModel.campaignId = getCampaignId();

		trackingActionInstanceCacheModel.reportInstanceId = getReportInstanceId();

		trackingActionInstanceCacheModel.alias = getAlias();

		String alias = trackingActionInstanceCacheModel.alias;

		if ((alias != null) && (alias.length() == 0)) {
			trackingActionInstanceCacheModel.alias = null;
		}

		trackingActionInstanceCacheModel.referrerClassName = getReferrerClassName();

		String referrerClassName = trackingActionInstanceCacheModel.referrerClassName;

		if ((referrerClassName != null) && (referrerClassName.length() == 0)) {
			trackingActionInstanceCacheModel.referrerClassName = null;
		}

		trackingActionInstanceCacheModel.referrerClassPK = getReferrerClassPK();

		trackingActionInstanceCacheModel.elementId = getElementId();

		String elementId = trackingActionInstanceCacheModel.elementId;

		if ((elementId != null) && (elementId.length() == 0)) {
			trackingActionInstanceCacheModel.elementId = null;
		}

		trackingActionInstanceCacheModel.eventType = getEventType();

		String eventType = trackingActionInstanceCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			trackingActionInstanceCacheModel.eventType = null;
		}

		trackingActionInstanceCacheModel.typeSettings = getTypeSettings();

		String typeSettings = trackingActionInstanceCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			trackingActionInstanceCacheModel.typeSettings = null;
		}

		return trackingActionInstanceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", trackingActionInstanceId=");
		sb.append(getTrackingActionInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", trackingActionKey=");
		sb.append(getTrackingActionKey());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", reportInstanceId=");
		sb.append(getReportInstanceId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", referrerClassName=");
		sb.append(getReferrerClassName());
		sb.append(", referrerClassPK=");
		sb.append(getReferrerClassPK());
		sb.append(", elementId=");
		sb.append(getElementId());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.liferay.content.targeting.model.TrackingActionInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trackingActionInstanceId</column-name><column-value><![CDATA[");
		sb.append(getTrackingActionInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trackingActionKey</column-name><column-value><![CDATA[");
		sb.append(getTrackingActionKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportInstanceId</column-name><column-value><![CDATA[");
		sb.append(getReportInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassName</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassPK</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TrackingActionInstance.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TrackingActionInstance.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _trackingActionInstanceId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _trackingActionKey;
	private long _campaignId;
	private long _originalCampaignId;
	private boolean _setOriginalCampaignId;
	private long _reportInstanceId;
	private long _originalReportInstanceId;
	private boolean _setOriginalReportInstanceId;
	private String _alias;
	private String _originalAlias;
	private String _referrerClassName;
	private String _originalReferrerClassName;
	private long _referrerClassPK;
	private long _originalReferrerClassPK;
	private boolean _setOriginalReferrerClassPK;
	private String _elementId;
	private String _originalElementId;
	private String _eventType;
	private String _originalEventType;
	private String _typeSettings;
	private long _columnBitmask;
	private TrackingActionInstance _escapedModel;
}