package org.liferay.lifebringer.model.impl;

import com.liferay.portal.model.User;

import org.liferay.lifebringer.model.UserValue;

public class UserValueImpl implements UserValue {
	
	

	public UserValueImpl(User user, int value) {
		_value = value;
		_user = user;
	}

	@Override
	public User getUser() {
		return _user;
	}

	@Override
	public int getValue() {
		return _value;
	}

	@Override
	public long getUserId() {
		return _user.getUserId();
	}
	
	private int _value;
	private User _user;

}
