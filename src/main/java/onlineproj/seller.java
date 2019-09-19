package onlineproj;
//package com.deepak.exampleapi;
import Productspack.Bseller;

import java.sql.*;
import java.util.*;

public class seller implements SellerInter{
	 public static Connection con;
    Bproducts obj= new Bproducts();
    Bproducts.BproductsBuilder prodbuilder= obj.new BproductsBuilder();
    Buser buser= new Buser();
    Buser.CuserBuilder cuserBuilder =buser.new CuserBuilder();
    Bseller bseller= new Bseller();
    Bseller.BsellerBuilder bsellerBuilder= bseller.new BsellerBuilder();
    int choice=0;
    user usr=new user();
    Scanner sc= new Scanner(System.in);


    public Connection connect(){
        String url="jdbc:mysql://localhost:3306/shopdb";
        Connection conn=null;
        try{
            //da
            conn = DriverManager.getConnection(url,"root","");
        }
        catch (SQLException e){
            System.out.println(e);
            // e.printStackTrace();
        }
        return conn;
    }
    public void deepakmodprice(Integer id, int prici,int sid) {
    	System.out.println("deepak modprice");
        prodbuilder.setSid(sid);
        prodbuilder.setPid(id);
        prodbuilder.setPrice(prici);
        modprice(prodbuilder);
        System.out.println("okay deepak");
    }
    public void deepakmodstock(int id, int stk,int sid) {
    	System.out.println("deepak modstock");
        prodbuilder.setSid(sid);
        prodbuilder.setPid(id);
        prodbuilder.setStock(stk);
        modstk(prodbuilder);
        System.out.println("okay deepak");
    }

    public void deepakmodname(Integer id, String  name,int sid){
    	System.out.println("prod id "+id);
    	System.out.println("name "+name);
    	System.out.println("sid "+sid);
    	
    	prodbuilder.setSid(sid);
        prodbuilder.setPid(id);
        prodbuilder.setPname(name);
        modname(prodbuilder);
        System.out.println("okay deepak");
     
    }

    public void addprod(int sid){
        System.out.println("Enter no. of Products to be added");
        int n=sc.nextInt();
        while(n!=0){

            System.out.println("Enter Prod ID:");
            Integer pid= sc.nextInt();
            System.out.println("Enter Prod Name:");
            String nam= sc.next();
            System.out.println("Enter Prod Price:");
            Integer price= sc.nextInt();
            System.out.println("Enter Prod Stock:");
            Integer stk= sc.nextInt();
            prodbuilder.setPid(pid);
            prodbuilder.setPname(nam);
            prodbuilder.setPrice(price);
            prodbuilder.setStock(stk);
            prodbuilder.setSid(sid);

          //  Queries.insert(prodbuilder);
            try{
                PreparedStatement statement=Queries.insertprodsinlist(prodbuilder);
                statement.executeUpdate();
                System.out.println("values inserted");
            }
            catch (Exception e){
                e.printStackTrace();
            }

      //  Queries.insert(sid,pid,nam,price,stk);

            n--;
        }

    }
   // public static void remov(Integer id,int sid){
   public static void remov(Bproducts.BproductsBuilder build){

       try{
    	   System.out.println(2);
           PreparedStatement statement=Queries.removeprodsinlist(build);
           System.out.println(3);
           statement.executeUpdate();
           System.out.println("Product Removed");
       }
       catch (Exception e){
           e.printStackTrace();
       }

        /*String sql = "delete from products where pid=? and sid=?";
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setInt(2,sid);
            stmt.executeUpdate();
            System.out.println("row removed");
        }
        catch (Exception e){
            System.out.println("You're not authorized seller to delete");
            e.getMessage();
        }*/
    }

    public void remprod(int sid){
            System.out.println("Enter Prod ID:");
            Integer pid= sc.nextInt();
            prodbuilder.setPid(pid);
            prodbuilder.setSid(sid);
        if(sellerbelongs(pid,sid)) {
            remov(prodbuilder);
        }
        else
        {
            System.out.println("You don't have access to remove the products");
        }

    }

    public  boolean sellerbelongs(int pid,int sid) {
        int cnt = 0;
        try {
            ResultSet resultSet = Queries.belongstosellerornot(pid, sid);
            while (resultSet.next()) {
            cnt++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
       /* String sql = "SELECT * FROM products WHERE pid = ? and sid=?";

        try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pid);
            stmt.setInt(2,sid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cnt++;
            }
            //System.out.println("Stock updated in products");
        } catch (SQLException e) {
            System.out.println(e);
        }*/
        if(cnt>0)
            return true;
        else
            return false;
    }

//    public void modname(Integer id, String  name,int sid){
public void modname(Bproducts.BproductsBuilder builder){
        try {
        	System.out.println("before");
          //  PreparedStatement statement=Queries.prepmodname(id,name,sid);
            PreparedStatement statement=Queries.prepmodname(builder);
            System.out.println("after");
          statement.executeUpdate();
            System.out.println("Name updated");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    /*    String sql="UPDATE products\n" +
                "SET pname=?\n" +
                "WHERE pid=? and sid=?";

        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,id);
            stmt.setInt(3,sid);
            stmt.executeUpdate();
            System.out.println("Name updated");
        }
        catch (Exception e){
            e.getMessage();
        }*/

    }

    //public static void modstk(Integer id,Integer stk,int sid){
    public static void modstk(Bproducts.BproductsBuilder builder){
        try{
           // PreparedStatement statement= Queries.prepmodstk(id,stk,sid);
        	System.out.println("before");
            PreparedStatement statement= Queries.prepmodstk(builder);
            
            statement.executeUpdate();
            System.out.println("stock modified");

        }
        catch (Exception e){
            e.printStackTrace();
        }
       /* String sql="UPDATE products\n" +
                "SET stock=?\n" +
                "WHERE pid=? and sid=?";
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1,stk);
            stmt.setInt(2,id);
            stmt.setInt(3,sid);
            stmt.executeUpdate();
            System.out.println("Stock updated");
        }
        catch (Exception e){
            e.getMessage();
        }*/
    }


//    public void modprice(Integer id, Integer price,int sid){
public void modprice(Bproducts.BproductsBuilder builder){
        try {
          //  PreparedStatement statement= Queries.prepmodprice(id,price,sid);
            PreparedStatement statement= Queries.prepmodprice(builder);
            statement.executeUpdate();
            System.out.println("Price updated");
        }
        catch (Exception e){
            e.printStackTrace();
        }
     /*   String sql="UPDATE products\n" +
                "SET price=?\n" +
                "WHERE pid=? and sid=?";

        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1,price);
            stmt.setInt(2,id);
            stmt.setInt(3,sid);
            stmt.executeUpdate();
            System.out.println("Price updated");
        }
        catch (Exception e){
            e.getMessage();
        }*/

    }
    public void modifyproducts(int sid){
        System.out.println("1.Modify Name 2.Modify Price 3.Modify Stock ");
        Integer inp=sc.nextInt();
        switch (inp){
            case 1:
                    System.out.println("Enter Prod ID:");
                    Integer pid=sc.nextInt();
                if(sellerbelongs(pid,sid)){
                    System.out.println("Enter new name:");
                    String name=sc.next();
                    prodbuilder.setSid(sid);
                    prodbuilder.setPid(pid);
                    prodbuilder.setPname(name);
                //    modname(pid,name,sid);
                    modname(prodbuilder);
                }
                else{
                    System.out.println("You don't have access to modify other seller products");
                }

                break;
            case 2:

                    System.out.println("Enter Prod ID:");
                    Integer pidi= sc.nextInt();
                if(sellerbelongs(pidi,sid)) {
                    System.out.println("Enter new price:");
                    Integer prici = sc.nextInt();
                    prodbuilder.setSid(sid);
                    prodbuilder.setPid(pidi);
                    prodbuilder.setPrice(prici);
                   // modprice(pidi, prici, sid);
                    modprice(prodbuilder);
                }
                else{
                    System.out.println("You don't have access to modify other seller products");
                }
                break;
            case 3:

                    System.out.println("Enter Prod ID:");
                    Integer pida=sc.nextInt();
                if(sellerbelongs(pida,sid)) {
                    System.out.println("Enter new stock:");
                    Integer stka= sc.nextInt();
                    prodbuilder.setSid(sid);
                    prodbuilder.setPid(pida);
                    prodbuilder.setStock(stka);
                    //modstk(pida,stka,sid);
                    modstk(prodbuilder);
                }
                        else{
                System.out.println("You don't have access to modify other seller products");
            }
                break;
            default:
                break;
        }

    }
    
    public static void deepakremovbyid(Integer id,int sid){

        try{
            String sql = "delete from products where pid=? and sid=?";
            System.out.println("1");
            
              Queries.createConnection();
              System.out.println("2");
                PreparedStatement stmt= con.prepareStatement(sql);
                System.out.println("3");
                stmt.setInt(1,id);
                stmt.setInt(2,sid);
                stmt.executeUpdate();
                System.out.println("row removed");
        }
        catch (Exception e){
            System.out.println("You're not authorized seller to delete");
            e.getMessage();
        }
    }

    
    
    public void deepakremprod(int sid,int pid){
    	System.out.println(1);
        prodbuilder.setPid(pid);
        prodbuilder.setSid(sid);
        if(sellerbelongs(pid,sid)) {
            remov(prodbuilder);
            System.out.println("**");
        }
        else
        {
            System.out.println("You don't have access to remove the products");
        }

    }

    public void selldetails(int sid){
        System.out.println("Enter your name");
        String name= sc.next();
        System.out.println("Enter Your Email");
        String email=sc.next();
       /* String sql="UPDATE products\n" +
                "SET stock=?\n" +
                "WHERE pid=?";*/
       cuserBuilder.setUsid(sid);
       cuserBuilder.setUname(name);
       cuserBuilder.setUemail(email);
       // Queries.selldetailss(sid,name,email);

        try{
            PreparedStatement statement= Queries.selldetailss(cuserBuilder);
            statement.executeUpdate();
            System.out.println("Username and email updated");

        }
        catch (Exception e){
            e.printStackTrace();
        }
       // Queries.selldetailss(cuserBuilder);
    }
    public void deepakselldetails(int sid){
        System.out.println("Enter your name");
        String name= sc.next();
        System.out.println("Enter Your Email");
        String email=sc.next();
       /* String sql="UPDATE products\n" +
                "SET stock=?\n" +
                "WHERE pid=?";*/
        bsellerBuilder.setUserid(sid);
        bsellerBuilder.setUsname(name);
        bsellerBuilder.setUemail(email);
        // Queries.selldetailss(sid,name,email);

        try{
//            PreparedStatement statement= Queries.selldetailss(cuserBuilder);
            PreparedStatement statement= Queries.deepakselldetailss(bsellerBuilder);
            statement.executeUpdate();
            System.out.println("Username and email updated");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        // Queries.selldetailss(cuserBuilder);
    }


        public void sellcredential(String uname,String pswd){

        cuserBuilder.setUname(uname);
        cuserBuilder.setPasswd(pswd);
        try{
            //ResultSet rs=Queries.sellercred(uname,pswd);
            ResultSet rs=Queries.sellercred(cuserBuilder);
            int cnt=0; int sid=0;
            while(rs.next()){
                sid=rs.getInt(1);
                cnt++;
            }
           /* String sql= "SELECT sid FROM seller_credentials WHERE sname = ? and password = ?;";
            try(Connection conn= this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)){
                stmt.setString(1,uname);
                stmt.setString(2,pswd);
                ResultSet rs =stmt.executeQuery();
                int cnt=0; int sid=0;
                while(rs.next()){
                    sid=rs.getInt(1);
                    cnt++;
                }*/
           //     System.out.println(cnt);

                if(cnt>=1) {
                    do {
                        System.out.println("Welcome Seller");
                        System.out.println("Your Seller ID is "+sid);
                        System.out.println("1.Add Products  2.Remove Products 3.Modify Products 4.Add Details 5.view products 0. sign out");

                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                addprod(sid);
                                break;
                            case 2:
                               // displayStoreProducts();
                                Queries.displayproducts();
                                remprod(sid);
                                break;
                            case 3:
                                Queries.displayproducts();
                                modifyproducts(sid);
                                break;
                            case 4:
                                selldetails(sid);
                                break;
                            case 5:
                                Queries.displayproducts();
                                break;
                                default:
                                    System.out.println("Enter a proper choice");
                                    break;
                        }

                    } while (choice != 0);

                }

                else
                    System.out.println("Your Credentials are wrong");
            }

            catch (SQLException e){
                e.getMessage();
            }
        }



}
