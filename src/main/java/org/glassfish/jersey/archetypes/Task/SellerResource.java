//$Id$
package org.glassfish.jersey.archetypes.Task;

import java.util.List;
import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.deepak.Alien;
import com.deepak.Wishpack.WishRepository;
import com.deepak.Wishpack.Wishlist;
import com.deepak.productspack.Product;
import com.deepak.productspack.ProductRepository;
import com.deepak.sellerpack.*;
import com.deepak.userpack.User;
import com.sun.research.ws.wadl.Application;

import Productspack.hello;
import onlineproj.newinter;
import onlineproj.seller;

@Path("seller")
public class SellerResource {
	
		SellerRepository srepo= new SellerRepository();
		ProductRepository prepo= new ProductRepository();
		WishRepository wrepo= new WishRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Seller> getAllSellers() {
		return srepo.getAllSellers();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Seller getsellerbyid(@PathParam("id") int id){
	return srepo.sellercredentialsbyid(id);
	
	}
	
	@GET
	@Path("products/{id}")
	//@Produces(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Product> getProducts(@PathParam("id") int id){
		//   return repo.getAlien(id);
		return prepo.getSellerproducts(id);
		
	}
	
	@GET
	@Path("wishlist")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Wishlist> getwishProducts(){
		//   return repo.getAlien(id);
		return wrepo.getWishProducts();
		
	}
	
	  @POST
	   @Path("products/add")
	   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public Product createProduct(Product a1){
		   System.out.println(a1);
		   prepo.addproduct(a1);
		   //repo.create(a1);
		   return a1;
	   }
	  
	  @DELETE
	   @Path("{id1}/products/remove/{id2}")
	   public Product removeproduct(@PathParam("id2") int id,@PathParam("id1") int sid) {
		
		  Product product= prepo.getproduct(id);
		//   Alien alien=repo.getAlien(id);
	//	  if(product.getPid()!=0)
			  prepo.delete(sid,id);
			  return product;
	     }
	  
	  
	@GET
	@Path("details")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<SellerDetails> getAllSellerdetails() {
		System.out.println("comes inside");
		return srepo.getAllSellerDetails();
	}

	@GET
	@Path("details/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public SellerDetails getsellerdetailsbyid(@PathParam("id") int id){
	return srepo.sellerdetailsbyid(id);
	}
	

/*	
 *  normally done using postman
 *    @POST
	   @Path("login")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_XML)
	 //  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public String validseller(Seller s1){
		   System.out.println(s1);
		  boolean value=srepo.sellercredentials(s1);
		 System.out.println("value "+value);
		   if(value==true) 
		  return "true";
		  return "false";
	   }*/
	
	
	@POST
	   @Path("login")
	   public String validuser(@QueryParam("uname") String name,@QueryParam("password") String password){
		Seller s1 = new Seller();
		System.out.println(name); System.out.println(password);
		s1.setSname(name); s1.setPassword(password);
	//	 System.out.println(s1);
		  boolean value=srepo.sellercredentials(s1);
		 System.out.println("value "+value);
		   if(value==true) 
		  return "true";
		  return "false";
	   }
	   
	
	
/*	// form param 
	@POST
	   @Path("login")
	   public String validuser(@FormParam("uname") String name,@FormParam("password") String password){
		Seller s1 = new Seller();
		System.out.println(name); System.out.println(password);
		s1.setSname(name); s1.setPassword(password);
	//	 System.out.println(s1);
		  boolean value=srepo.sellercredentials(s1);
		 System.out.println("value "+value);
		   if(value==true) 
		  return "true";
		  return "false";
	   }*/
	   
	  
	/*
	// postman method
	   @POST
	   @Path("signup")
	   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	//   @Produces(MediaType.APPLICATION_XML)
	//   @Consumes(MediaType.APPLICATION_XML)
	   public Seller signupseller(Seller s1){
		   System.out.println(s1);
		   srepo.signup(s1);
		   System.out.println("done deepak");
		   return s1;
	
	   }*/
	// form param 
	 @POST
	   @Path("signup")
	 public String signupseller(@FormParam("name") String name,@FormParam("password") String password,@FormParam("id") Integer id){
		 	Seller s1= new Seller();
		 	s1.setSname(name); s1.setPassword(password); s1.setSid(id);
		 System.out.println(s1);
		 srepo.signup(s1);
		 return "account created";
		 
	 }
	
	   
	   @PUT
	   @Path("modname")
	   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public Product updatename(Product a1){
		   System.out.println(a1);
//		   if(prepo.getproduct(a1.getPid()).getPid()==0)
//		   {
//			   prepo.addproduct(a1);
//		   }
//		   else
		  srepo.updatename(a1);
		   return a1;
	   }
	   
	   @PUT
	   @Path("modprice")
	   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public Product updateprice(Product a1){
		   System.out.println(a1);
//		   if(prepo.getproduct(a1.getPid()).getPid()==0)
//		   {
//			   prepo.addproduct(a1);
//		   }
//		   else
		  srepo.updateprice(a1);
		   return a1;
	   }
	   
	   @PUT
	   @Path("modstock")
	   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   public Product updatestock(Product a1){
		   System.out.println(a1);
//		   if(prepo.getproduct(a1.getPid()).getPid()==0)
//		   {
//			   prepo.addproduct(a1);
//		   }
//		   else
		  srepo.updatestock(a1);
		   return a1;
	   }
}
