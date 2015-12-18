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

package com.liferay.content.targeting.anonymous.users.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.Accessor;
import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the AnonymousUser service. Represents a row in the &quot;CT_AU_AnonymousUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymousUserModel
 * @see com.liferay.content.targeting.anonymous.users.model.impl.AnonymousUserImpl
 * @see com.liferay.content.targeting.anonymous.users.model.impl.AnonymousUserModelImpl
 * @generated
 */
@ProviderType
public interface AnonymousUser extends AnonymousUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.anonymous.users.model.impl.AnonymousUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnonymousUser, Long> ANONYMOUS_USER_ID_ACCESSOR =
		new Accessor<AnonymousUser, Long>() {
			@Override
			public Long get(AnonymousUser anonymousUser) {
				return anonymousUser.getAnonymousUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnonymousUser> getTypeClass() {
				return AnonymousUser.class;
			}
		};

	public com.liferay.portal.model.User getUser();
}