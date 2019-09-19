//$Id$
package org.glassfish.jersey.archetypes.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.mykong.Mproducts;

@Path("/json/product")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public Mproducts getProductInJSON() {
		Mproducts product = new Mproducts();
		product.setName("iPad 3");
		product.setQty(999);
		return product; 
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Mproducts product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}
}
