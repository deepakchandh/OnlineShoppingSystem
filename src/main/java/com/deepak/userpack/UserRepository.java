//$Id$
package com.deepak.userpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deepak.sellerpack.Seller;
import com.deepak.sellerpack.SellerDetails;
import com.mysql.jdbc.Statement;

import onlineproj.Admin;
import onlineproj.user;

public class UserRepository {
		
	Admin admin= new Admin();
	Connection con=null;
	 public void createConnection()throws  SQLException,ClassNotFoundException{
		    Class.forName("com.mysql.jdbc.Driver");
		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb","root","");
		}

	//List<User>users;	
		public List<User> getAllUser() {
			List<User>users= new ArrayList<>();
			try{
				System.out.println("before conn");
				createConnection();
				System.out.println("after conn");
	            String sql="select * from user_credentials";
	            Statement stmt=(Statement) con.createStatement();
	            System.out.println("after statement");
				ResultSet rs= stmt.executeQuery(sql);
				System.out.println("after rs");
				while(rs.next()){
					User user= new User();
					user.setUid(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setPassword(rs.getString(3));
					users.add(user);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return users; 
		}
	 
		public boolean usercredentials(User u1) {
			int id=0; int cnt=0;	
			  String sql= "SELECT uid FROM user_credentials WHERE uname ='"+u1.getUname()+"' and password ='"+u1.getPassword()+"'";
		        try{
		        	createConnection();
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

		public void signup(User u1) {
//			String sql= " insert into seller_credentials values"+(s1.getSid()+",'"+s1.getSname()+"','"+s1.getPassword()+"'");
			String sql= " insert into seller_credentials values(?,?,?)";
			
			try{
				admin.deepakaddusers(u1.getUid(), u1.getUname(), u1.getPassword());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		public List<UserDetails> getAllUserDetails() {
			List<UserDetails>userDetails= new ArrayList<>();
			try{
				createConnection();
	            String sql="select * from user_details";
	            System.out.println("before statement");
	            Statement stmt=(Statement) con.createStatement();
	            System.out.println("after statement");
				ResultSet rs= stmt.executeQuery(sql);
				   System.out.println("afeter rs");
				   int cnt=0;
		//ResultSet rs= Queries.allsellerdetails();
		while(rs.next()){
			cnt++;
			UserDetails userDetails2=new UserDetails();
			userDetails2.setUid(rs.getInt(1));
			userDetails2.setAid(rs.getInt(2));
			userDetails2.setPincode(rs.getInt(3));
			userDetails2.setAddress(rs.getString(4));
			userDetails2.setPhoneno(rs.getString(5));
			userDetails.add(userDetails2);
				}
		System.out.println("count "+cnt);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(userDetails);
			return userDetails; 
		}
		
		public UserDetails userdetailsbyid(int id) {
			UserDetails userDetails= new UserDetails();
		String sql="select * from user_details where uid="+id;   
		try{
	        	createConnection();
	        	Statement stmt=(Statement) con.createStatement();
	        	System.out.println("before execute");
	            ResultSet rs =stmt.executeQuery(sql);
	            System.out.println("after execute");
	            while(rs.next()){
	            	userDetails.setUid(rs.getInt(1));
	            	userDetails.setAid(rs.getInt(2));
	            	userDetails.setPincode(rs.getInt(3));
	            	userDetails.setAddress(rs.getString(4));
	            	userDetails.setPhoneno(rs.getString(5));
	            }
	        }
		catch (Exception e) {
			e.printStackTrace();
		}
	       
	  return userDetails;
	}

}
