//$Id$
package org.glassfish.jersey.archetypes.Task;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deepak.Wishpack.WishRepository;
import com.deepak.Wishpack.Wishlist;
import com.deepak.billpack.Bill;
import com.deepak.billpack.BillRepository;
import com.deepak.cartpack.*;
import com.deepak.cartpack.CartRepository;
import com.deepak.productspack.Product;
import com.deepak.sellerpack.Seller;
import com.deepak.sellerpack.SellerDetails;
import com.deepak.userpack.User;
import com.deepak.userpack.UserDetails;
import com.deepak.userpack.UserRepository;

import onlineproj.Queries;
import onlineproj.newinter;

@Path("user")
public class UserResource {
		UserRepository urepo= new UserRepository();
		CartRepository crepo= new CartRepository();
		BillRepository brepo= new BillRepository();
		WishRepository wrepo= new WishRepository();
	
	@GET
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return urepo.getAllUser();
	}
	@GET
	@Path("details")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<UserDetails> getAllUserdetails() {
		System.out.println("comes inside");
		return urepo.getAllUserDetails();
	//	return srepo.getAllSellerDetails();
	}
	@GET
	@Path("details/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public UserDetails getuserdetailsbyid(@PathParam("id") int id){
	//return srepo.sellerdetailsbyid(id);
		return urepo.userdetailsbyid(id);
	}
	@GET
	@Path("wishlist/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Wishlist> getwishlistbyid(@PathParam("id") int id){
	
		return wrepo.getwishlistofusers(id);
	}
	
	
	
	@GET
	@Path("cart/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	@Produces(MediaType.APPLICATION_XML)
	public List<Cart> getCartList(@PathParam("id") int uid) {
		//int uid=1;
		return crepo.getCartItems(uid);
	}
	
	@GET
	@Path("cart/item/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	@Produces(MediaType.APPLICATION_XML)
	public Cart getCartItem(@PathParam("id") int pid) {
		//int uid=1;
		return crepo.getcartproduct(pid);
		//return crepo.getCartItems(uid);
	}
	
	@POST
	   @Path("addtocart")
	   public Cart addtocart(@QueryParam("uid") int uid,@QueryParam("pid") int pid,@QueryParam("quan") int quan){
		System.out.println("hi");
		Cart c1= new Cart();
		c1.setUid(uid); c1.setPid(pid); c1.setQuan(quan);
		 System.out.println(c1);
		   crepo.addtocart(c1);
		   System.out.println("added to cart");
		   return c1;
	   }
	
	
/*	
//normal postman method
 * @POST
	   @Path("addtocart")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	// @Produces(MediaType.APPLICATION_XML)
	 //  @Consumes(MediaType.APPLICATION_XML)
	   public Cart addtocart(Cart c1){
		   System.out.println(c1);
		   crepo.addtocart(c1);
		   System.out.println("done deepak");
		   return c1;
	   }*/
/*
 * normally done using postman
 * 	@POST
	   @Path("login")
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	   @Produces(MediaType.APPLICATION_XML)
//	   @Consumes(MediaType.APPLICATION_XML)
	   public String validuser(User u1){
		
		   System.out.println(u1);
		  boolean value=urepo.usercredentials(u1);
		 System.out.println("value "+value);
		   if(value==true) 
		  return "true";
		  return "false";
	   }*/
	@POST
	   @Path("login")
	//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public String validuser(@QueryParam("uname") String name,@QueryParam("password") String password){
		User u1= new User();
		u1.setUname(name); u1.setPassword(password);
		 System.out.println(u1);
		  boolean value=urepo.usercredentials(u1);
		 System.out.println("value "+value);
		 
		   if(value==true) 
		  return "true";
		  return "false";
	   }

/*	@POST
	   @Path("login")
	//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public String validuser(@FormParam("uname") String name,@FormParam("password") String password){
		User u1= new User();
		u1.setUname(name); u1.setPassword(password);
		 System.out.println(u1);
		  boolean value=urepo.usercredentials(u1);
		 System.out.println("value "+value);
		 
		   if(value==true) 
		  return "true";
		  return "false";
	   }*/

/*	// Using Postman
	@POST
	   @Path("signup")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	   @Produces(MediaType.APPLICATION_XML)
//	   @Consumes(MediaType.APPLICATION_XML)
	   public User signupuser(User u1){
		   System.out.println(u1);
		   urepo.signup(u1);
		   System.out.println("done deepak");
		   return u1;
	   }*/
	
	
	@POST
	   @Path("signup")
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public String signupuser(@FormParam("name") String name,@FormParam("password") String password,@FormParam("id") Integer id){
		User u1= new User();
		u1.setUid(id);
		u1.setUname(name); u1.setPassword(password);
//		System.out.println("name "+name);	System.out.println("name "+password);
//		System.out.println("name "+id);
		System.out.println(u1);
		   urepo.signup(u1);
		   System.out.println("done deepak");
		   return name;
	   }
	
	 
	  @DELETE
	   @Path("{id1}/cart/remove/{id2}")
	   public Cart removeproduct(@PathParam("id1") int uid,@PathParam("id2") int pid) {
		
		 Cart cart= crepo.getcartproduct(pid);
		 // Product product= prepo.getproduct(id);
		//  if(product.getPid()!=0)
		  crepo.deletefromcart(uid, pid);
			 // prepo.delete(sid,id);
			  return cart;
	     }
	  @GET
	  @Path("bill/{id}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String billproducts(@PathParam("id") int uid){
		  
		  brepo.billproducts(uid);
		  Queries.orderhiss(uid);
		  return "products billed";
	  }

}
