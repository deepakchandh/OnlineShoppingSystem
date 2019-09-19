//$Id$
package org.glassfish.jersey.archetypes.Task;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.deepak.Alien;
import com.deepak.productspack.Product;
import com.deepak.productspack.ProductRepository;


@Path("products")
public class ProductResource {
	ProductRepository prepo= new ProductRepository();
	
//	public Product getProduct(int pid) {
//		Client client = ClientBuilder.newClient();
//    WebTarget target = client.target("http://localhost:8080/shoppingcentre/webapi/products/"+ pid);
//    Product product = target.request().get(Product.class);
//    return product;
//	}
@GET
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_XML)	
public List<Product> getAllProducts() {
			return prepo.getAllProducts();
		}
	   
@GET
@Path("id/{id}")
//@Produces(MediaType.APPLICATION_XML)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Product getProducts(@PathParam("id") int id){
	//   return repo.getAlien(id);
	return prepo.getproduct(id);
}

@GET
@Path("name/{id}")
//@Produces(MediaType.APPLICATION_XML)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Product getProducts(@PathParam("id") String id){
	//   return repo.getAlien(id);
	return prepo.getproductbyname(id);
}

	


}
