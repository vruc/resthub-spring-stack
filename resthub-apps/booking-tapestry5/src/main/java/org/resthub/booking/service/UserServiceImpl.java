package org.resthub.booking.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.booking.model.User;
import org.resthub.core.dao.GenericDao;
import org.resthub.core.service.GenericServiceImpl;


@Named("userService")
public class UserServiceImpl extends
		GenericServiceImpl<User, GenericDao<User, Long>, Long> implements
		UserService {

	@Inject
	@Named("userDao")
	@Override
	public void setDao(GenericDao<User, Long> userDao) {
		this.dao = userDao;
	}

	/**
	 * Naive implementation of checkLogin Real life implementation should store
	 * and compare encrypted passwords
	 **/
	public User checkCredentials(String username, String password) {
		List<User> users = this.dao.findEquals("username", username);

		if ((users != null) && (users.size() == 1)
				&& users.get(0).getPassword().equals(password)) {
			return users.get(0);
		}
		return null;
	}

	public User findByUsername(String username) {

		List<User> users = this.dao.findEquals("username", username);

		if (users.size() > 1) {
			throw new RuntimeException("username should be unique");
		}

		if (users.isEmpty()) {
			return null;
		}

		return users.get(0);
	}

	public User findByEmail(String email) {

		List<User> users = this.dao.findEquals("email", email);

		if (users.size() > 1) {
			throw new RuntimeException("email should be unique");
		}

		if (users.isEmpty()) {
			return null;
		}

		return users.get(0);
	}

}
