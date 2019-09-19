//$Id$
package com.tutorial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class UserDAO {

	static HashMap<String, Ttuser> usersMap = new HashMap<String,Ttuser>();
	 
    public UserDAO() {
    	Ttuser user1 = new Ttuser();
            user1.setId("1");
           
            user1.setName("raj");
           user1.setPassword("qwerty");
           
            usersMap.put("1", user1);
            
    }
 
    public List<Ttuser> getAllUsers() {
 
        List<Ttuser> userList = new ArrayList<Ttuser>(usersMap.values());
        return userList;
    }
 
    public Ttuser getUserForId(String id) {
    	Ttuser user = usersMap.get(id);
        return user;
    }
 
    public Ttuser createUser(Ttuser user) {
        usersMap.put(user.getId(), user);
        return usersMap.get(user.getId());
    }
 
    public Ttuser updateUser(Ttuser user) {
    	Ttuser existingUser= usersMap.get(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
        } else {
            usersMap.put(user.getId(), user);
        }
        return usersMap.get(user.getId());
    }
 
    public Ttuser deleteUser(String id) {
    	Ttuser userResponse = usersMap.remove(id);
        return userResponse;
    }
	
	
}
