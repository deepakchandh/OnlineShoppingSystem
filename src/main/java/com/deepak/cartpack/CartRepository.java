//$Id$
package com.deepak.cartpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deepak.productspack.Product;
import com.deepak.userpack.User;
import com.mysql.jdbc.Statement;

import onlineproj.*;
import Productspack.*;

public class CartRepository {

	user usr= new user();
	
	 Bcart bcart= new Bcart();
	    Bcart.BcartBuilder bcartBuilder= bcart.new BcartBuilder();
	Connection con=null;
	 public void createConnection()throws  SQLException,ClassNotFoundException{
		    Class.forName("com.mysql.jdbc.Driver");
		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb","root","");
		}
	public List<Cart> getCartItems(int uid) {
		List<Cart>carts= new ArrayList<>();
		try{
			System.out.println("before conn");
			createConnection();
			System.out.println("after conn");
            String sql="select * from cart where uid="+uid;
            Statement stmt=(Statement) con.createStatement();
            System.out.println("after statement");
			ResultSet rs= stmt.executeQuery(sql);
			System.out.println("after rs");
			while(rs.next()){
				Cart cart= new Cart();
				cart.setUid(rs.getInt(1));
				cart.setPid(rs.getInt(2));
				cart.setQuan(rs.getInt(3));
				cart.setPrice(rs.getInt(4));
				carts.add(cart);
				System.out.println(carts);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return carts; 
	}
	
public void addtocart(Cart cart) {
	
	int uid=cart.getUid();
	System.out.println("dee uid "+uid);
	int pid=cart.getPid();
	System.out.println("dee upid "+pid);
	int quan=cart.getQuan();
	System.out.println("dee quan "+quan);
		usr.deepakaddtocart(uid, pid, quan);

              }
	
public Cart getcartproduct(int pid) {
//	Product product= new Product();
	Cart cart= new Cart();
	try{
		String sql="select * from cart where pid="+pid;
		Statement stmt=(Statement)con.createStatement();
     //   Statement stmt=(Statement) con.createStatement();
        System.out.println("after statement");
		ResultSet rs= stmt.executeQuery(sql);
		System.out.println("after rs");
		while(rs.next()){
			cart.setUid(rs.getInt(1));
			cart.setPid(rs.getInt(2));
			cart.setQuan(rs.getInt(3));
			cart.setPrice(rs.getInt(4));
		//	carts.add(cart);
			//System.out.println(carts);
		}
		}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return cart;
}

		public void deletefromcart(int uid,int pid) {
			
			usr.deepremovprodfromcart(uid, pid);
		}

}
