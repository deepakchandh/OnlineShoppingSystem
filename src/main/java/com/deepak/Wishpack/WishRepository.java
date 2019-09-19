//$Id$
package com.deepak.Wishpack;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deepak.productspack.Product;

import onlineproj.Admin;
import onlineproj.Queries;
import onlineproj.newinter;
import onlineproj.user;

public class WishRepository {
		
	Admin admin= new Admin();
	public List<Wishlist> getWishProducts() {
		List<Wishlist>wishlists= new ArrayList<>();
		try{
			System.out.println(1);
	ResultSet rs=Queries.wishlistquery();
	System.out.println(4);
			while(rs.next()){
				Wishlist wishlist= new Wishlist();
				wishlist.setUid(rs.getInt(1));
				wishlist.setPid(rs.getInt(2));
				wishlists.add(wishlist);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return wishlists; 
	}
	

	public List<Wishlist> getwishlistofusers(int id) {
		List<Wishlist>wishlists= new ArrayList<>();
	//	Product product= new Product();
		try{
			ResultSet rs= Queries.wishlistbyid(id);
			while(rs.next()){
				Wishlist wishlist= new Wishlist();
				wishlist.setUid(rs.getInt(1));
				wishlist.setPid(rs.getInt(2));
				
				wishlists.add(wishlist);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return wishlists;
	}
}
