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

package com.liferay.consumer.manager.service.base;

import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService;
import com.liferay.consumer.manager.service.persistence.ConsumerExtensionInstancePersistence;
import com.liferay.consumer.manager.service.persistence.ConsumerPersistence;
import com.liferay.consumer.manager.service.persistence.ConsumerReportInstancePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the consumer report instance local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.consumer.manager.service.impl.ConsumerReportInstanceLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.consumer.manager.service.impl.ConsumerReportInstanceLocalServiceImpl
 * @see com.liferay.consumer.manager.service.ConsumerReportInstanceLocalServiceUtil
 * @generated
 */
public abstract class ConsumerReportInstanceLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ConsumerReportInstanceLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.consumer.manager.service.ConsumerReportInstanceLocalServiceUtil} to access the consumer report instance local service.
	 */

	/**
	 * Adds the consumer report instance to the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerReportInstance the consumer report instance
	 * @return the consumer report instance that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConsumerReportInstance addConsumerReportInstance(
		ConsumerReportInstance consumerReportInstance)
		throws SystemException {
		consumerReportInstance.setNew(true);

		return consumerReportInstancePersistence.update(consumerReportInstance);
	}

	/**
	 * Creates a new consumer report instance with the primary key. Does not add the consumer report instance to the database.
	 *
	 * @param consumerReportInstanceId the primary key for the new consumer report instance
	 * @return the new consumer report instance
	 */
	@Override
	public ConsumerReportInstance createConsumerReportInstance(
		long consumerReportInstanceId) {
		return consumerReportInstancePersistence.create(consumerReportInstanceId);
	}

	/**
	 * Deletes the consumer report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerReportInstanceId the primary key of the consumer report instance
	 * @return the consumer report instance that was removed
	 * @throws PortalException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConsumerReportInstance deleteConsumerReportInstance(
		long consumerReportInstanceId) throws PortalException, SystemException {
		return consumerReportInstancePersistence.remove(consumerReportInstanceId);
	}

	/**
	 * Deletes the consumer report instance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param consumerReportInstance the consumer report instance
	 * @return the consumer report instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConsumerReportInstance deleteConsumerReportInstance(
		ConsumerReportInstance consumerReportInstance)
		throws SystemException {
		return consumerReportInstancePersistence.remove(consumerReportInstance);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ConsumerReportInstance.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return consumerReportInstancePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return consumerReportInstancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return consumerReportInstancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return consumerReportInstancePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return consumerReportInstancePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ConsumerReportInstance fetchConsumerReportInstance(
		long consumerReportInstanceId) throws SystemException {
		return consumerReportInstancePersistence.fetchByPrimaryKey(consumerReportInstanceId);
	}

	/**
	 * Returns the consumer report instance with the matching UUID and company.
	 *
	 * @param uuid the consumer report instance's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching consumer report instance, or <code>null</code> if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance fetchConsumerReportInstanceByUuidAndCompanyId(
		String uuid, long companyId) throws SystemException {
		return consumerReportInstancePersistence.fetchByUuid_C_First(uuid,
			companyId, null);
	}

	/**
	 * Returns the consumer report instance with the primary key.
	 *
	 * @param consumerReportInstanceId the primary key of the consumer report instance
	 * @return the consumer report instance
	 * @throws PortalException if a consumer report instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance getConsumerReportInstance(
		long consumerReportInstanceId) throws PortalException, SystemException {
		return consumerReportInstancePersistence.findByPrimaryKey(consumerReportInstanceId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return consumerReportInstancePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the consumer report instance with the matching UUID and company.
	 *
	 * @param uuid the consumer report instance's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching consumer report instance
	 * @throws PortalException if a matching consumer report instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConsumerReportInstance getConsumerReportInstanceByUuidAndCompanyId(
		String uuid, long companyId) throws PortalException, SystemException {
		return consumerReportInstancePersistence.findByUuid_C_First(uuid,
			companyId, null);
	}

	/**
	 * Returns a range of all the consumer report instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.consumer.manager.model.impl.ConsumerReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer report instances
	 * @param end the upper bound of the range of consumer report instances (not inclusive)
	 * @return the range of consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConsumerReportInstance> getConsumerReportInstances(int start,
		int end) throws SystemException {
		return consumerReportInstancePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of consumer report instances.
	 *
	 * @return the number of consumer report instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getConsumerReportInstancesCount() throws SystemException {
		return consumerReportInstancePersistence.countAll();
	}

	/**
	 * Updates the consumer report instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param consumerReportInstance the consumer report instance
	 * @return the consumer report instance that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConsumerReportInstance updateConsumerReportInstance(
		ConsumerReportInstance consumerReportInstance)
		throws SystemException {
		return consumerReportInstancePersistence.update(consumerReportInstance);
	}

	/**
	 * Returns the consumer local service.
	 *
	 * @return the consumer local service
	 */
	public com.liferay.consumer.manager.service.ConsumerLocalService getConsumerLocalService() {
		return consumerLocalService;
	}

	/**
	 * Sets the consumer local service.
	 *
	 * @param consumerLocalService the consumer local service
	 */
	public void setConsumerLocalService(
		com.liferay.consumer.manager.service.ConsumerLocalService consumerLocalService) {
		this.consumerLocalService = consumerLocalService;
	}

	/**
	 * Returns the consumer remote service.
	 *
	 * @return the consumer remote service
	 */
	public com.liferay.consumer.manager.service.ConsumerService getConsumerService() {
		return consumerService;
	}

	/**
	 * Sets the consumer remote service.
	 *
	 * @param consumerService the consumer remote service
	 */
	public void setConsumerService(
		com.liferay.consumer.manager.service.ConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	/**
	 * Returns the consumer persistence.
	 *
	 * @return the consumer persistence
	 */
	public ConsumerPersistence getConsumerPersistence() {
		return consumerPersistence;
	}

	/**
	 * Sets the consumer persistence.
	 *
	 * @param consumerPersistence the consumer persistence
	 */
	public void setConsumerPersistence(ConsumerPersistence consumerPersistence) {
		this.consumerPersistence = consumerPersistence;
	}

	/**
	 * Returns the consumer extension instance local service.
	 *
	 * @return the consumer extension instance local service
	 */
	public com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService getConsumerExtensionInstanceLocalService() {
		return consumerExtensionInstanceLocalService;
	}

	/**
	 * Sets the consumer extension instance local service.
	 *
	 * @param consumerExtensionInstanceLocalService the consumer extension instance local service
	 */
	public void setConsumerExtensionInstanceLocalService(
		com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService consumerExtensionInstanceLocalService) {
		this.consumerExtensionInstanceLocalService = consumerExtensionInstanceLocalService;
	}

	/**
	 * Returns the consumer extension instance remote service.
	 *
	 * @return the consumer extension instance remote service
	 */
	public com.liferay.consumer.manager.service.ConsumerExtensionInstanceService getConsumerExtensionInstanceService() {
		return consumerExtensionInstanceService;
	}

	/**
	 * Sets the consumer extension instance remote service.
	 *
	 * @param consumerExtensionInstanceService the consumer extension instance remote service
	 */
	public void setConsumerExtensionInstanceService(
		com.liferay.consumer.manager.service.ConsumerExtensionInstanceService consumerExtensionInstanceService) {
		this.consumerExtensionInstanceService = consumerExtensionInstanceService;
	}

	/**
	 * Returns the consumer extension instance persistence.
	 *
	 * @return the consumer extension instance persistence
	 */
	public ConsumerExtensionInstancePersistence getConsumerExtensionInstancePersistence() {
		return consumerExtensionInstancePersistence;
	}

	/**
	 * Sets the consumer extension instance persistence.
	 *
	 * @param consumerExtensionInstancePersistence the consumer extension instance persistence
	 */
	public void setConsumerExtensionInstancePersistence(
		ConsumerExtensionInstancePersistence consumerExtensionInstancePersistence) {
		this.consumerExtensionInstancePersistence = consumerExtensionInstancePersistence;
	}

	/**
	 * Returns the consumer report instance local service.
	 *
	 * @return the consumer report instance local service
	 */
	public com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService getConsumerReportInstanceLocalService() {
		return consumerReportInstanceLocalService;
	}

	/**
	 * Sets the consumer report instance local service.
	 *
	 * @param consumerReportInstanceLocalService the consumer report instance local service
	 */
	public void setConsumerReportInstanceLocalService(
		com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService consumerReportInstanceLocalService) {
		this.consumerReportInstanceLocalService = consumerReportInstanceLocalService;
	}

	/**
	 * Returns the consumer report instance remote service.
	 *
	 * @return the consumer report instance remote service
	 */
	public com.liferay.consumer.manager.service.ConsumerReportInstanceService getConsumerReportInstanceService() {
		return consumerReportInstanceService;
	}

	/**
	 * Sets the consumer report instance remote service.
	 *
	 * @param consumerReportInstanceService the consumer report instance remote service
	 */
	public void setConsumerReportInstanceService(
		com.liferay.consumer.manager.service.ConsumerReportInstanceService consumerReportInstanceService) {
		this.consumerReportInstanceService = consumerReportInstanceService;
	}

	/**
	 * Returns the consumer report instance persistence.
	 *
	 * @return the consumer report instance persistence
	 */
	public ConsumerReportInstancePersistence getConsumerReportInstancePersistence() {
		return consumerReportInstancePersistence;
	}

	/**
	 * Sets the consumer report instance persistence.
	 *
	 * @param consumerReportInstancePersistence the consumer report instance persistence
	 */
	public void setConsumerReportInstancePersistence(
		ConsumerReportInstancePersistence consumerReportInstancePersistence) {
		this.consumerReportInstancePersistence = consumerReportInstancePersistence;
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
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.consumer.manager.model.ConsumerReportInstance",
			consumerReportInstanceLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.consumer.manager.model.ConsumerReportInstance");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return ConsumerReportInstance.class;
	}

	protected String getModelClassName() {
		return ConsumerReportInstance.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = consumerReportInstancePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.consumer.manager.service.ConsumerLocalService.class)
	protected com.liferay.consumer.manager.service.ConsumerLocalService consumerLocalService;
	@BeanReference(type = com.liferay.consumer.manager.service.ConsumerService.class)
	protected com.liferay.consumer.manager.service.ConsumerService consumerService;
	@BeanReference(type = ConsumerPersistence.class)
	protected ConsumerPersistence consumerPersistence;
	@BeanReference(type = com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService.class)
	protected com.liferay.consumer.manager.service.ConsumerExtensionInstanceLocalService consumerExtensionInstanceLocalService;
	@BeanReference(type = com.liferay.consumer.manager.service.ConsumerExtensionInstanceService.class)
	protected com.liferay.consumer.manager.service.ConsumerExtensionInstanceService consumerExtensionInstanceService;
	@BeanReference(type = ConsumerExtensionInstancePersistence.class)
	protected ConsumerExtensionInstancePersistence consumerExtensionInstancePersistence;
	@BeanReference(type = com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService.class)
	protected com.liferay.consumer.manager.service.ConsumerReportInstanceLocalService consumerReportInstanceLocalService;
	@BeanReference(type = com.liferay.consumer.manager.service.ConsumerReportInstanceService.class)
	protected com.liferay.consumer.manager.service.ConsumerReportInstanceService consumerReportInstanceService;
	@BeanReference(type = ConsumerReportInstancePersistence.class)
	protected ConsumerReportInstancePersistence consumerReportInstancePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ConsumerReportInstanceLocalServiceClpInvoker _clpInvoker = new ConsumerReportInstanceLocalServiceClpInvoker();
}