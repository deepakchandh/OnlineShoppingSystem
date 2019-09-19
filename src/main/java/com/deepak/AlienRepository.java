//$Id$
package com.deepak;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.*;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AlienRepository {
	
	List<Alien>aliens;
  public Connection conn=null;
	
	public AlienRepository() {
		try{
		Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak","root","");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public List<Alien> getAlien() {
		List<Alien>aliens= new ArrayList<>();
		String sql= "select * from alien";
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()){
				Alien alien= new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setPoints(rs.getInt(3));
				aliens.add(alien);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return aliens; 
	}
	
	
	public Alien getAlien(int id) {
		String sql= "select * from alien where id="+id;
		Alien alien= new Alien();
		try{
			Statement stmt=(Statement) conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()){
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setPoints(rs.getInt(3));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return alien;
	}
	public void create(Alien a1) {
	//	aliens.add(a1);
		String sql= "insert into alien values(?,?,?)";
		try{
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
			stmt.setInt(1, a1.getId());
			stmt.setString(2, a1.getName());
			stmt.setInt(3, a1.getPoints());
			stmt.execute();
			System.out.println("Inserted in the table");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Alien a1) {
	//	aliens.add(a1);
		String sql= "update alien set name=?, points=? where id=?";
		try{
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
		
			stmt.setString(1, a1.getName());
			stmt.setInt(2, a1.getPoints());
			stmt.setInt(3, a1.getId());
			stmt.execute();
			System.out.println("updated in the table");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void delete(int id) {
		String sql=" delete from alien where id="+id;
		try{
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
		
		//	stmt.setInt(1, a1.getId());
			stmt.execute();
			System.out.println("deleted in the table");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
}
