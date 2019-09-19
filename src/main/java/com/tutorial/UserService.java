//$Id$
package com.tutorial;

import java.util.*;
public class UserService {
	 UserDAO userDao = new UserDAO();
	 
	 public List<Ttuser> getAllUsers() {
	        List<Ttuser> userList = userDao.getAllUsers();
	        return userList;
	    }
	 
	    public Ttuser getUserForId(String id) {
	    	Ttuser user = userDao.getUserForId(id);
	        return user;
	    }
	 
	 
	 public Ttuser createUser(Ttuser user) {
	        Ttuser userResponse = userDao.createUser(user);
	        return userResponse;
	    }
}
