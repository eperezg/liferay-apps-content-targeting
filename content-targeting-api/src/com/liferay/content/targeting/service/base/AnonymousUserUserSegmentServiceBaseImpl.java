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

package com.liferay.content.targeting.service.base;

import com.liferay.content.targeting.model.AnonymousUserUserSegment;
import com.liferay.content.targeting.service.AnonymousUserUserSegmentService;
import com.liferay.content.targeting.service.persistence.AnonymousUserUserSegmentPersistence;
import com.liferay.content.targeting.service.persistence.CampaignFinder;
import com.liferay.content.targeting.service.persistence.CampaignPersistence;
import com.liferay.content.targeting.service.persistence.ChannelInstancePersistence;
import com.liferay.content.targeting.service.persistence.ReportInstancePersistence;
import com.liferay.content.targeting.service.persistence.RuleInstancePersistence;
import com.liferay.content.targeting.service.persistence.TacticPersistence;
import com.liferay.content.targeting.service.persistence.TrackingActionInstancePersistence;
import com.liferay.content.targeting.service.persistence.UserSegmentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.SystemEventPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the anonymous user user segment remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.impl.AnonymousUserUserSegmentServiceImpl
 * @see com.liferay.content.targeting.service.AnonymousUserUserSegmentServiceUtil
 * @generated
 */
public abstract class AnonymousUserUserSegmentServiceBaseImpl
	extends BaseServiceImpl implements AnonymousUserUserSegmentService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.content.targeting.service.AnonymousUserUserSegmentServiceUtil} to access the anonymous user user segment remote service.
	 */

	/**
	 * Returns the anonymous user user segment local service.
	 *
	 * @return the anonymous user user segment local service
	 */
	public com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService getAnonymousUserUserSegmentLocalService() {
		return anonymousUserUserSegmentLocalService;
	}

	/**
	 * Sets the anonymous user user segment local service.
	 *
	 * @param anonymousUserUserSegmentLocalService the anonymous user user segment local service
	 */
	public void setAnonymousUserUserSegmentLocalService(
		com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService anonymousUserUserSegmentLocalService) {
		this.anonymousUserUserSegmentLocalService = anonymousUserUserSegmentLocalService;
	}

	/**
	 * Returns the anonymous user user segment remote service.
	 *
	 * @return the anonymous user user segment remote service
	 */
	public AnonymousUserUserSegmentService getAnonymousUserUserSegmentService() {
		return anonymousUserUserSegmentService;
	}

	/**
	 * Sets the anonymous user user segment remote service.
	 *
	 * @param anonymousUserUserSegmentService the anonymous user user segment remote service
	 */
	public void setAnonymousUserUserSegmentService(
		AnonymousUserUserSegmentService anonymousUserUserSegmentService) {
		this.anonymousUserUserSegmentService = anonymousUserUserSegmentService;
	}

	/**
	 * Returns the anonymous user user segment persistence.
	 *
	 * @return the anonymous user user segment persistence
	 */
	public AnonymousUserUserSegmentPersistence getAnonymousUserUserSegmentPersistence() {
		return anonymousUserUserSegmentPersistence;
	}

	/**
	 * Sets the anonymous user user segment persistence.
	 *
	 * @param anonymousUserUserSegmentPersistence the anonymous user user segment persistence
	 */
	public void setAnonymousUserUserSegmentPersistence(
		AnonymousUserUserSegmentPersistence anonymousUserUserSegmentPersistence) {
		this.anonymousUserUserSegmentPersistence = anonymousUserUserSegmentPersistence;
	}

	/**
	 * Returns the campaign local service.
	 *
	 * @return the campaign local service
	 */
	public com.liferay.content.targeting.service.CampaignLocalService getCampaignLocalService() {
		return campaignLocalService;
	}

	/**
	 * Sets the campaign local service.
	 *
	 * @param campaignLocalService the campaign local service
	 */
	public void setCampaignLocalService(
		com.liferay.content.targeting.service.CampaignLocalService campaignLocalService) {
		this.campaignLocalService = campaignLocalService;
	}

	/**
	 * Returns the campaign remote service.
	 *
	 * @return the campaign remote service
	 */
	public com.liferay.content.targeting.service.CampaignService getCampaignService() {
		return campaignService;
	}

	/**
	 * Sets the campaign remote service.
	 *
	 * @param campaignService the campaign remote service
	 */
	public void setCampaignService(
		com.liferay.content.targeting.service.CampaignService campaignService) {
		this.campaignService = campaignService;
	}

	/**
	 * Returns the campaign persistence.
	 *
	 * @return the campaign persistence
	 */
	public CampaignPersistence getCampaignPersistence() {
		return campaignPersistence;
	}

	/**
	 * Sets the campaign persistence.
	 *
	 * @param campaignPersistence the campaign persistence
	 */
	public void setCampaignPersistence(CampaignPersistence campaignPersistence) {
		this.campaignPersistence = campaignPersistence;
	}

	/**
	 * Returns the campaign finder.
	 *
	 * @return the campaign finder
	 */
	public CampaignFinder getCampaignFinder() {
		return campaignFinder;
	}

	/**
	 * Sets the campaign finder.
	 *
	 * @param campaignFinder the campaign finder
	 */
	public void setCampaignFinder(CampaignFinder campaignFinder) {
		this.campaignFinder = campaignFinder;
	}

	/**
	 * Returns the channel instance local service.
	 *
	 * @return the channel instance local service
	 */
	public com.liferay.content.targeting.service.ChannelInstanceLocalService getChannelInstanceLocalService() {
		return channelInstanceLocalService;
	}

	/**
	 * Sets the channel instance local service.
	 *
	 * @param channelInstanceLocalService the channel instance local service
	 */
	public void setChannelInstanceLocalService(
		com.liferay.content.targeting.service.ChannelInstanceLocalService channelInstanceLocalService) {
		this.channelInstanceLocalService = channelInstanceLocalService;
	}

	/**
	 * Returns the channel instance remote service.
	 *
	 * @return the channel instance remote service
	 */
	public com.liferay.content.targeting.service.ChannelInstanceService getChannelInstanceService() {
		return channelInstanceService;
	}

	/**
	 * Sets the channel instance remote service.
	 *
	 * @param channelInstanceService the channel instance remote service
	 */
	public void setChannelInstanceService(
		com.liferay.content.targeting.service.ChannelInstanceService channelInstanceService) {
		this.channelInstanceService = channelInstanceService;
	}

	/**
	 * Returns the channel instance persistence.
	 *
	 * @return the channel instance persistence
	 */
	public ChannelInstancePersistence getChannelInstancePersistence() {
		return channelInstancePersistence;
	}

	/**
	 * Sets the channel instance persistence.
	 *
	 * @param channelInstancePersistence the channel instance persistence
	 */
	public void setChannelInstancePersistence(
		ChannelInstancePersistence channelInstancePersistence) {
		this.channelInstancePersistence = channelInstancePersistence;
	}

	/**
	 * Returns the report instance local service.
	 *
	 * @return the report instance local service
	 */
	public com.liferay.content.targeting.service.ReportInstanceLocalService getReportInstanceLocalService() {
		return reportInstanceLocalService;
	}

	/**
	 * Sets the report instance local service.
	 *
	 * @param reportInstanceLocalService the report instance local service
	 */
	public void setReportInstanceLocalService(
		com.liferay.content.targeting.service.ReportInstanceLocalService reportInstanceLocalService) {
		this.reportInstanceLocalService = reportInstanceLocalService;
	}

	/**
	 * Returns the report instance remote service.
	 *
	 * @return the report instance remote service
	 */
	public com.liferay.content.targeting.service.ReportInstanceService getReportInstanceService() {
		return reportInstanceService;
	}

	/**
	 * Sets the report instance remote service.
	 *
	 * @param reportInstanceService the report instance remote service
	 */
	public void setReportInstanceService(
		com.liferay.content.targeting.service.ReportInstanceService reportInstanceService) {
		this.reportInstanceService = reportInstanceService;
	}

	/**
	 * Returns the report instance persistence.
	 *
	 * @return the report instance persistence
	 */
	public ReportInstancePersistence getReportInstancePersistence() {
		return reportInstancePersistence;
	}

	/**
	 * Sets the report instance persistence.
	 *
	 * @param reportInstancePersistence the report instance persistence
	 */
	public void setReportInstancePersistence(
		ReportInstancePersistence reportInstancePersistence) {
		this.reportInstancePersistence = reportInstancePersistence;
	}

	/**
	 * Returns the rule instance local service.
	 *
	 * @return the rule instance local service
	 */
	public com.liferay.content.targeting.service.RuleInstanceLocalService getRuleInstanceLocalService() {
		return ruleInstanceLocalService;
	}

	/**
	 * Sets the rule instance local service.
	 *
	 * @param ruleInstanceLocalService the rule instance local service
	 */
	public void setRuleInstanceLocalService(
		com.liferay.content.targeting.service.RuleInstanceLocalService ruleInstanceLocalService) {
		this.ruleInstanceLocalService = ruleInstanceLocalService;
	}

	/**
	 * Returns the rule instance remote service.
	 *
	 * @return the rule instance remote service
	 */
	public com.liferay.content.targeting.service.RuleInstanceService getRuleInstanceService() {
		return ruleInstanceService;
	}

	/**
	 * Sets the rule instance remote service.
	 *
	 * @param ruleInstanceService the rule instance remote service
	 */
	public void setRuleInstanceService(
		com.liferay.content.targeting.service.RuleInstanceService ruleInstanceService) {
		this.ruleInstanceService = ruleInstanceService;
	}

	/**
	 * Returns the rule instance persistence.
	 *
	 * @return the rule instance persistence
	 */
	public RuleInstancePersistence getRuleInstancePersistence() {
		return ruleInstancePersistence;
	}

	/**
	 * Sets the rule instance persistence.
	 *
	 * @param ruleInstancePersistence the rule instance persistence
	 */
	public void setRuleInstancePersistence(
		RuleInstancePersistence ruleInstancePersistence) {
		this.ruleInstancePersistence = ruleInstancePersistence;
	}

	/**
	 * Returns the tactic local service.
	 *
	 * @return the tactic local service
	 */
	public com.liferay.content.targeting.service.TacticLocalService getTacticLocalService() {
		return tacticLocalService;
	}

	/**
	 * Sets the tactic local service.
	 *
	 * @param tacticLocalService the tactic local service
	 */
	public void setTacticLocalService(
		com.liferay.content.targeting.service.TacticLocalService tacticLocalService) {
		this.tacticLocalService = tacticLocalService;
	}

	/**
	 * Returns the tactic remote service.
	 *
	 * @return the tactic remote service
	 */
	public com.liferay.content.targeting.service.TacticService getTacticService() {
		return tacticService;
	}

	/**
	 * Sets the tactic remote service.
	 *
	 * @param tacticService the tactic remote service
	 */
	public void setTacticService(
		com.liferay.content.targeting.service.TacticService tacticService) {
		this.tacticService = tacticService;
	}

	/**
	 * Returns the tactic persistence.
	 *
	 * @return the tactic persistence
	 */
	public TacticPersistence getTacticPersistence() {
		return tacticPersistence;
	}

	/**
	 * Sets the tactic persistence.
	 *
	 * @param tacticPersistence the tactic persistence
	 */
	public void setTacticPersistence(TacticPersistence tacticPersistence) {
		this.tacticPersistence = tacticPersistence;
	}

	/**
	 * Returns the tracking action instance local service.
	 *
	 * @return the tracking action instance local service
	 */
	public com.liferay.content.targeting.service.TrackingActionInstanceLocalService getTrackingActionInstanceLocalService() {
		return trackingActionInstanceLocalService;
	}

	/**
	 * Sets the tracking action instance local service.
	 *
	 * @param trackingActionInstanceLocalService the tracking action instance local service
	 */
	public void setTrackingActionInstanceLocalService(
		com.liferay.content.targeting.service.TrackingActionInstanceLocalService trackingActionInstanceLocalService) {
		this.trackingActionInstanceLocalService = trackingActionInstanceLocalService;
	}

	/**
	 * Returns the tracking action instance remote service.
	 *
	 * @return the tracking action instance remote service
	 */
	public com.liferay.content.targeting.service.TrackingActionInstanceService getTrackingActionInstanceService() {
		return trackingActionInstanceService;
	}

	/**
	 * Sets the tracking action instance remote service.
	 *
	 * @param trackingActionInstanceService the tracking action instance remote service
	 */
	public void setTrackingActionInstanceService(
		com.liferay.content.targeting.service.TrackingActionInstanceService trackingActionInstanceService) {
		this.trackingActionInstanceService = trackingActionInstanceService;
	}

	/**
	 * Returns the tracking action instance persistence.
	 *
	 * @return the tracking action instance persistence
	 */
	public TrackingActionInstancePersistence getTrackingActionInstancePersistence() {
		return trackingActionInstancePersistence;
	}

	/**
	 * Sets the tracking action instance persistence.
	 *
	 * @param trackingActionInstancePersistence the tracking action instance persistence
	 */
	public void setTrackingActionInstancePersistence(
		TrackingActionInstancePersistence trackingActionInstancePersistence) {
		this.trackingActionInstancePersistence = trackingActionInstancePersistence;
	}

	/**
	 * Returns the user segment local service.
	 *
	 * @return the user segment local service
	 */
	public com.liferay.content.targeting.service.UserSegmentLocalService getUserSegmentLocalService() {
		return userSegmentLocalService;
	}

	/**
	 * Sets the user segment local service.
	 *
	 * @param userSegmentLocalService the user segment local service
	 */
	public void setUserSegmentLocalService(
		com.liferay.content.targeting.service.UserSegmentLocalService userSegmentLocalService) {
		this.userSegmentLocalService = userSegmentLocalService;
	}

	/**
	 * Returns the user segment remote service.
	 *
	 * @return the user segment remote service
	 */
	public com.liferay.content.targeting.service.UserSegmentService getUserSegmentService() {
		return userSegmentService;
	}

	/**
	 * Sets the user segment remote service.
	 *
	 * @param userSegmentService the user segment remote service
	 */
	public void setUserSegmentService(
		com.liferay.content.targeting.service.UserSegmentService userSegmentService) {
		this.userSegmentService = userSegmentService;
	}

	/**
	 * Returns the user segment persistence.
	 *
	 * @return the user segment persistence
	 */
	public UserSegmentPersistence getUserSegmentPersistence() {
		return userSegmentPersistence;
	}

	/**
	 * Sets the user segment persistence.
	 *
	 * @param userSegmentPersistence the user segment persistence
	 */
	public void setUserSegmentPersistence(
		UserSegmentPersistence userSegmentPersistence) {
		this.userSegmentPersistence = userSegmentPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the system event local service.
	 *
	 * @return the system event local service
	 */
	public com.liferay.portal.service.SystemEventLocalService getSystemEventLocalService() {
		return systemEventLocalService;
	}

	/**
	 * Sets the system event local service.
	 *
	 * @param systemEventLocalService the system event local service
	 */
	public void setSystemEventLocalService(
		com.liferay.portal.service.SystemEventLocalService systemEventLocalService) {
		this.systemEventLocalService = systemEventLocalService;
	}

	/**
	 * Returns the system event persistence.
	 *
	 * @return the system event persistence
	 */
	public SystemEventPersistence getSystemEventPersistence() {
		return systemEventPersistence;
	}

	/**
	 * Sets the system event persistence.
	 *
	 * @param systemEventPersistence the system event persistence
	 */
	public void setSystemEventPersistence(
		SystemEventPersistence systemEventPersistence) {
		this.systemEventPersistence = systemEventPersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AnonymousUserUserSegmentService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AnonymousUserUserSegment.class;
	}

	protected String getModelClassName() {
		return AnonymousUserUserSegment.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = anonymousUserUserSegmentPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService.class)
	protected com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService anonymousUserUserSegmentLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.AnonymousUserUserSegmentService.class)
	protected AnonymousUserUserSegmentService anonymousUserUserSegmentService;
	@BeanReference(type = AnonymousUserUserSegmentPersistence.class)
	protected AnonymousUserUserSegmentPersistence anonymousUserUserSegmentPersistence;
	@BeanReference(type = com.liferay.content.targeting.service.CampaignLocalService.class)
	protected com.liferay.content.targeting.service.CampaignLocalService campaignLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.CampaignService.class)
	protected com.liferay.content.targeting.service.CampaignService campaignService;
	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	@BeanReference(type = CampaignFinder.class)
	protected CampaignFinder campaignFinder;
	@BeanReference(type = com.liferay.content.targeting.service.ChannelInstanceLocalService.class)
	protected com.liferay.content.targeting.service.ChannelInstanceLocalService channelInstanceLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.ChannelInstanceService.class)
	protected com.liferay.content.targeting.service.ChannelInstanceService channelInstanceService;
	@BeanReference(type = ChannelInstancePersistence.class)
	protected ChannelInstancePersistence channelInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.ReportInstanceLocalService.class)
	protected com.liferay.content.targeting.service.ReportInstanceLocalService reportInstanceLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.ReportInstanceService.class)
	protected com.liferay.content.targeting.service.ReportInstanceService reportInstanceService;
	@BeanReference(type = ReportInstancePersistence.class)
	protected ReportInstancePersistence reportInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.RuleInstanceLocalService.class)
	protected com.liferay.content.targeting.service.RuleInstanceLocalService ruleInstanceLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.RuleInstanceService.class)
	protected com.liferay.content.targeting.service.RuleInstanceService ruleInstanceService;
	@BeanReference(type = RuleInstancePersistence.class)
	protected RuleInstancePersistence ruleInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.TacticLocalService.class)
	protected com.liferay.content.targeting.service.TacticLocalService tacticLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.TacticService.class)
	protected com.liferay.content.targeting.service.TacticService tacticService;
	@BeanReference(type = TacticPersistence.class)
	protected TacticPersistence tacticPersistence;
	@BeanReference(type = com.liferay.content.targeting.service.TrackingActionInstanceLocalService.class)
	protected com.liferay.content.targeting.service.TrackingActionInstanceLocalService trackingActionInstanceLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.TrackingActionInstanceService.class)
	protected com.liferay.content.targeting.service.TrackingActionInstanceService trackingActionInstanceService;
	@BeanReference(type = TrackingActionInstancePersistence.class)
	protected TrackingActionInstancePersistence trackingActionInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.UserSegmentLocalService.class)
	protected com.liferay.content.targeting.service.UserSegmentLocalService userSegmentLocalService;
	@BeanReference(type = com.liferay.content.targeting.service.UserSegmentService.class)
	protected com.liferay.content.targeting.service.UserSegmentService userSegmentService;
	@BeanReference(type = UserSegmentPersistence.class)
	protected UserSegmentPersistence userSegmentPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ClassNameLocalService.class)
	protected com.liferay.portal.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.service.ClassNameService.class)
	protected com.liferay.portal.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.SystemEventLocalService.class)
	protected com.liferay.portal.service.SystemEventLocalService systemEventLocalService;
	@BeanReference(type = SystemEventPersistence.class)
	protected SystemEventPersistence systemEventPersistence;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}