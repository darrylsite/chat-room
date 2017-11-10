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

package com.darrylsite.liferay.chat.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.darrylsite.liferay.chat.model.Lounge;
import com.darrylsite.liferay.chat.model.LoungeModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Lounge service. Represents a row in the &quot;chatRoom_Lounge&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LoungeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LoungeImpl}.
 * </p>
 *
 * @author Darryl Kpizingui
 * @see LoungeImpl
 * @see Lounge
 * @see LoungeModel
 * @generated
 */
@ProviderType
public class LoungeModelImpl extends BaseModelImpl<Lounge>
	implements LoungeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lounge model instance should use the {@link Lounge} interface instead.
	 */
	public static final String TABLE_NAME = "chatRoom_Lounge";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "priviledge", Types.INTEGER },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priviledge", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table chatRoom_Lounge (id_ LONG not null primary key,name VARCHAR(75) null,priviledge INTEGER,userId LONG,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table chatRoom_Lounge";
	public static final String ORDER_BY_JPQL = " ORDER BY lounge.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY chatRoom_Lounge.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.darrylsite.liferay.chat.room.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.darrylsite.liferay.chat.model.Lounge"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.darrylsite.liferay.chat.room.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.darrylsite.liferay.chat.model.Lounge"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.darrylsite.liferay.chat.room.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.darrylsite.liferay.chat.model.Lounge"),
			true);
	public static final long PRIVILEDGE_COLUMN_BITMASK = 1L;
	public static final long NAME_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.darrylsite.liferay.chat.room.service.util.ServiceProps.get(
				"lock.expiration.time.com.darrylsite.liferay.chat.model.Lounge"));

	public LoungeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Lounge.class;
	}

	@Override
	public String getModelClassName() {
		return Lounge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("priviledge", getPriviledge());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer priviledge = (Integer)attributes.get("priviledge");

		if (priviledge != null) {
			setPriviledge(priviledge);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public int getPriviledge() {
		return _priviledge;
	}

	@Override
	public void setPriviledge(int priviledge) {
		_columnBitmask |= PRIVILEDGE_COLUMN_BITMASK;

		if (!_setOriginalPriviledge) {
			_setOriginalPriviledge = true;

			_originalPriviledge = _priviledge;
		}

		_priviledge = priviledge;
	}

	public int getOriginalPriviledge() {
		return _originalPriviledge;
	}

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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Lounge.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Lounge toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Lounge)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LoungeImpl loungeImpl = new LoungeImpl();

		loungeImpl.setId(getId());
		loungeImpl.setName(getName());
		loungeImpl.setPriviledge(getPriviledge());
		loungeImpl.setUserId(getUserId());
		loungeImpl.setCreateDate(getCreateDate());
		loungeImpl.setModifiedDate(getModifiedDate());

		loungeImpl.resetOriginalValues();

		return loungeImpl;
	}

	@Override
	public int compareTo(Lounge lounge) {
		int value = 0;

		value = getName().compareTo(lounge.getName());

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

		if (!(obj instanceof Lounge)) {
			return false;
		}

		Lounge lounge = (Lounge)obj;

		long primaryKey = lounge.getPrimaryKey();

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
		LoungeModelImpl loungeModelImpl = this;

		loungeModelImpl._originalPriviledge = loungeModelImpl._priviledge;

		loungeModelImpl._setOriginalPriviledge = false;

		loungeModelImpl._setModifiedDate = false;

		loungeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Lounge> toCacheModel() {
		LoungeCacheModel loungeCacheModel = new LoungeCacheModel();

		loungeCacheModel.id = getId();

		loungeCacheModel.name = getName();

		String name = loungeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			loungeCacheModel.name = null;
		}

		loungeCacheModel.priviledge = getPriviledge();

		loungeCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			loungeCacheModel.createDate = createDate.getTime();
		}
		else {
			loungeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			loungeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			loungeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return loungeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", priviledge=");
		sb.append(getPriviledge());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.darrylsite.liferay.chat.model.Lounge");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priviledge</column-name><column-value><![CDATA[");
		sb.append(getPriviledge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Lounge.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Lounge.class
		};
	private long _id;
	private String _name;
	private int _priviledge;
	private int _originalPriviledge;
	private boolean _setOriginalPriviledge;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Lounge _escapedModel;
}