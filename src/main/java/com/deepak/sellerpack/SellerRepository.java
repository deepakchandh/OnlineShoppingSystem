//$Id$
package com.deepak.sellerpack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.deepak.Alien;
import com.deepak.productspack.Product;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.deepak.sellerpack.*;
import com.deepak.sellerpack.Seller;

import onlineproj.*;

public class SellerRepository {
public Connection con= null;

Admin admin= new Admin();
seller sell= new seller();
 public void createConnection()throws  SQLException,ClassNotFoundException{
    Class.forName("com.mysql.jdbc.Driver");
    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb","root","");
}
	
	user usr= new user();
	List<Seller>sellers;
	List<SellerDetails>sellerDetails;
	public List<Seller> getAllSellers() {
		List<Seller>sellers= new ArrayList<>();
		try{
			createConnection();
            String sql="select * from seller_credentials";
            Statement stmt=(Statement) con.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()){
				Seller seller= new Seller();
				seller.setSid(rs.getInt(1));
				seller.setSname(rs.getString(2));
				seller.setPassword(rs.getString(3));
				sellers.add(seller);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sellers; 
	}
	
	
	
	public boolean sellercredentials(Seller s1) {
		int id=0; int cnt=0;
		  String sql= "SELECT sid FROM seller_credentials WHERE sname ='"+s1.getSname()+"' and password ='"+s1.getPassword()+"'";
	        try{
	        	createConnection();
	        //	PreparedStatement stmt= (PreparedStatement)con.prepareStatement(sql);
	        	Statement stmt=(Statement) con.createStatement();
	        	System.out.println("before execute");
	            ResultSet rs =stmt.executeQuery(sql);
	            System.out.println("inga came");
	            while(rs.next()){
	                id=rs.getInt(1);
	                cnt++;
	            }
	        }
		catch (Exception e) {
			e.printStackTrace();
		}
	        System.out.println("count "+cnt);
		if(cnt>0)
		return true; 
		
		return false;
	}



	public void signup(Seller s1) {
//		String sql= " insert into seller_credentials values"+(s1.getSid()+",'"+s1.getSname()+"','"+s1.getPassword()+"'");
		String sql= " insert into seller_credentials values(?,?,?)";
		
		try{
			
			admin.deepakaddseller(s1.getSid(),s1.getSname(),s1.getPassword());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	public Seller sellercredentialsbyid(int id) {
			Seller seller=new Seller();
		String sql="select * from seller_credentials where sid="+id;   
		try{
	        	createConnection();
	        	Statement stmt=(Statement) con.createStatement();
	        	System.out.println("before execute");
	            ResultSet rs =stmt.executeQuery(sql);
	            System.out.println("after execute");
	            while(rs.next()){
	               seller.setSid(rs.getInt(1));
	               seller.setSname(rs.getString(2));
	               seller.setPassword(rs.getString(3));
	            }
	        }
		catch (Exception e) {
			e.printStackTrace();
		}
	       
	return seller;
	}
	
	
	public List<SellerDetails> getAllSellerDetails() {
		List<SellerDetails>sellerDetails= new ArrayList<>();
		try{
			createConnection();
            String sql="select * from seller_details";
            System.out.println("before statement");
            Statement stmt=(Statement) con.createStatement();
            System.out.println("after statement");
			ResultSet rs= stmt.executeQuery(sql);
			   System.out.println("afeter rs");
			   int cnt=0;
	//ResultSet rs= Queries.allsellerdetails();
	while(rs.next()){
		cnt++;
			SellerDetails sellerDetails2= new SellerDetails();
			sellerDetails2.setSid(rs.getInt(1));
			sellerDetails2.setAsid(rs.getInt(2));
			sellerDetails2.setPincode(rs.getInt(3));
			sellerDetails2.setAddress(rs.getString(4));
			sellerDetails2.setPhoneno(rs.getString(5));
			sellerDetails.add(sellerDetails2);
			}
	System.out.println("count "+cnt);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sellerDetails);
		return sellerDetails; 
	}
	
	public SellerDetails sellerdetailsbyid(int id) {
		SellerDetails sellerDetails2= new SellerDetails();
		//Seller seller=new Seller();
	String sql="select * from seller_details where sid="+id;   
	try{
        	createConnection();
        	Statement stmt=(Statement) con.createStatement();
        	System.out.println("before execute");
            ResultSet rs =stmt.executeQuery(sql);
            System.out.println("after execute");
            while(rs.next()){
            	sellerDetails2.setSid(rs.getInt(1));
    			sellerDetails2.setAsid(rs.getInt(2));
    			sellerDetails2.setPincode(rs.getInt(3));
    			sellerDetails2.setAddress(rs.getString(4));
    			sellerDetails2.setPhoneno(rs.getString(5));
            }
        }
	catch (Exception e) {
		e.printStackTrace();
	}
       
  return sellerDetails2;
}
	
	
	
	
	public void updatename(Product a1) {
		System.out.println(1);
		sell.deepakmodname(a1.getPid(), a1.getPname(), a1.getSid());	
		}
	public void updateprice(Product a1) {
		System.out.println(1);
		sell.deepakmodprice(a1.getPid(), a1.getPrice(), a1.getSid());
		}
	public void updatestock(Product a1) {
		System.out.println(1);
		sell.deepakmodstock(a1.getPid(), a1.getStock(), a1.getStock());
		}
	
}
