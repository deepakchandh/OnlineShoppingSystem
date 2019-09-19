//$Id$
package com.deepak.productspack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deepak.Alien;
import com.mysql.jdbc.Statement;

import onlineproj.*;

public class ProductRepository {
	public static Connection con=null;
	Bproducts obj= new Bproducts();
    Bproducts.BproductsBuilder prodbuilder= obj.new BproductsBuilder();
    seller sell= new seller();
    Connection conn=null;
	List<Product>products;
	public List<Product> getAllProducts() {
		List<Product>products= new ArrayList<>();
		try{
	ResultSet rs= Queries.deepakproducts();
			while(rs.next()){
				Product product= new Product();
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setStock(rs.getInt(3));
				product.setPrice(rs.getInt(4));
				product.setSid(rs.getInt(5));
				product.setNoofusers(rs.getInt(6));
				product.setPrating(rs.getInt(7));
				products.add(product);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products; 
	}
//	public List<Product>getAllProductPaginated(int start,int size){
//		List<Product>list= new ArrayList<>(getAllProducts());
//		if(start+size >list.size())
//			return new ArrayList<Message>();
//		return list.subList(start, start+size);
//	}
	
	
	public Product getproduct(int id) {
		Product product= new Product();
		try{
			ResultSet rs= Queries.deepakproductsbyid(id);
			while(rs.next()){
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setStock(rs.getInt(3));
				product.setPrice(rs.getInt(4));
				product.setSid(rs.getInt(5));
				product.setNoofusers(rs.getInt(6));
				product.setPrating(rs.getInt(7));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	
	public List<Product> getSellerproducts(int id) {
		List<Product>products= new ArrayList<>();
		try{
	ResultSet rs= Queries.sellerproductsbyid(id);
			while(rs.next()){
				Product product= new Product();
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setStock(rs.getInt(3));
				product.setPrice(rs.getInt(4));
				product.setSid(rs.getInt(5));
				product.setNoofusers(rs.getInt(6));
				product.setPrating(rs.getInt(7));
				products.add(product);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products; 
		
	}
	
	public Product getproductbyname(String id) {
		//String sql= "select * from products where pid="+id;
		Product product= new Product();
		try{
			//Statement stmt=(Statement) con.createStatement();
		//	ResultSet rs= Queries.deepakproductsbyid(id);
			ResultSet rs= Queries.deepakproductsbyname(id);
			while(rs.next()){
				product.setPid(rs.getInt(1));
				product.setPname(rs.getString(2));
				product.setStock(rs.getInt(3));
				product.setPrice(rs.getInt(4));
				product.setSid(rs.getInt(5));
				product.setNoofusers(rs.getInt(6));
				product.setPrating(rs.getInt(7));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	
	public void addproduct(Product product) {
		
		prodbuilder.setSid(product.getSid());
		prodbuilder.setPname(product.getPname());
		prodbuilder.setPrice(product.getPrice());
		prodbuilder.setPid(product.getPid());
		prodbuilder.setStock(product.getStock());
		prodbuilder.setNoofusers(product.getNoofusers());
		try{
            PreparedStatement statement=Queries.insertprodsinlist(prodbuilder);
            statement.executeUpdate();
            System.out.println("values inserted");
        }
        catch (Exception e){
            e.printStackTrace();
        }
	
		}
	
	public void delete(int sid,int pid) {
		try{
		sell.deepakremprod(sid, pid);
			System.out.println("deleted in the table");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
