//$Id$
package org.glassfish.jersey.archetypes.Task;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tutorial.Ttuser;
import com.tutorial.UserService;

@Path("/userInfo")
public class TtuserResource {
	   UserService userService = new UserService();
	
	   
	   @GET
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Ttuser> getAllUsers() {
	        List<Ttuser> userList = userService.getAllUsers();
	        return userList;
	    }
	@POST
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Ttuser createUser(@FormParam("id") String id,@FormParam("name") String name,@FormParam("password") String password)      
        {
        Ttuser user = new Ttuser();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        Ttuser userResponse = userService.createUser(user);
        return userResponse;
    }
	
}
