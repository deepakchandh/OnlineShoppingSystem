//$Id$
package org.glassfish.jersey.archetypes.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deepak.Alien;
import com.deepak.AlienRepository;

@Path("aliens")
public class AlienResource 
{  	
	AlienRepository repo= new AlienRepository();
   
	@GET
 // @Produces(MediaType.APPLICATION_XML)
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public List<Alien> getAliens() {
		return repo.getAlien();
	}
   
   @GET
   @Path("aliens/{id}")
   //@Produces(MediaType.APPLICATION_XML)
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public Alien getAlien(@PathParam("id") int id){
	   return repo.getAlien(id);
   }
   
   @POST
   @Path("aliensd")
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public Alien createalien(Alien a1){
	   System.out.println(a1);
	   repo.create(a1);
	   return a1;
   }
   
   @PUT
   @Path("alienup")
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public Alien updatealien(Alien a1){
	   System.out.println(a1);
	   if(repo.getAlien(a1.getId()).getId()==0)
	   {
		   repo.create(a1);
	   }
	   else
	   repo.update(a1);
	   return a1;
   }
   
   
   @DELETE
   @Path("aliens/{id}")
   public Alien deleteAlien(@PathParam("id") int id) {
	
	   Alien alien=repo.getAlien(id);
	   
	   if(alien.getId()!=0)
	   repo.delete(id);
	   
	   
	   return alien;
     }
   
}
