package onlineproj;
import Productspack.Bseller;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

//import javax.servlet.http.HttpServlet;
import javax.xml.ws.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Queries {
    static ResultSet rs= null;
    Buser cusr= new Buser();
    Buser.CuserBuilder builder= cusr.new CuserBuilder();
	Bproducts bproducts= new Bproducts();
	Bproducts.BproductsBuilder bproductsBuilder= bproducts.new BproductsBuilder();
    //Bcart bcart= new Bcart();
   // Bcart.BcartBuilder bcartBuilder= bcart.new BcartBuilder();
	
	

	public static Connection con;

	  public   static void createConnection()throws  SQLException,ClassNotFoundException{
	        Class.forName("com.mysql.jdbc.Driver");
	        con= DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/shopdb","root","");
	    }
	  public static void terminateconnection()throws SQLException{
	        con.close();
	    }
	   public static ResultSet selectquery(String query)throws  SQLException,ClassNotFoundException{
	        PreparedStatement st=con.prepareStatement(query);
	        ResultSet rs=st.executeQuery();
	        return rs;
	    }


public static ResultSet usercred(Buser.CuserBuilder builder){
    String sql= "SELECT uid FROM user_credentials WHERE uname = ? and password = ?;";
    try{
        createConnection();
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1,builder.getUname());
        stmt.setString(2,builder.getPasswd());
       // stmt.setString(1,uname);
       // stmt.setString(2,pswd);
         rs =stmt.executeQuery();
//        int cnt=0; int id=0;
//        while(rs.next()){
//            id=rs.getInt(1);
//            cnt++;
//        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
return rs;

}


	    public static void insertintocart(Bcart.BcartBuilder builder){
            String sql = "insert into cart(uid,pid,quantity,price) values (?,?,?,?)";
            try {
                createConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
              /*  stmt.setInt(1, uid);
                stmt.setInt(2, pid);
                stmt.setInt(3, quan);
                stmt.setInt(4, temp);*/
                stmt.setInt(1, builder.getUid());
                stmt.setInt(2, builder.getPid());
                stmt.setInt(3, builder.getQuantity());
                stmt.setInt(4, builder.getPrice());
                stmt.executeUpdate();
                System.out.println("Inserted into the cart");
                //    String sqlr= "insert into cart(uid,pid,quantity,price) values (?,?,?,?)";

            } catch (Exception e) {
                e.getMessage();
            }

        }


    public static  void displayproducts(){
        try{
            createConnection();
           Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from products");
            System.out.printf("%-8s%-12s%-20s%-18s%-14s%-14s%-16s","SID","ProductID","ProductName","StocksAvailable","Price","noofusers","prodrating");
            System.out.println("\n--------------------------------------------------------------------------------------------------");
            while(rs.next())
                System.out.printf("%-8s%-12s%-20s%-18s%-14s%-14s%-16s\n",rs.getInt(5),rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getInt(4),rs.getInt(6),rs.getInt(7));
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }

    public static ResultSet belongstosellerornot(int pid,int sid){
        String sql = "SELECT * FROM products WHERE pid = ? and sid=?";

        try {
            createConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pid);
            stmt.setInt(2,sid);
             rs = stmt.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e);
        }

	      return rs;
    }

// done using pojo
    public static ResultSet allsellerdetails(){
        ResultSet rs=null;
        try {
           createConnection();
            String sql="select * from seller_details";
            PreparedStatement st=con.prepareStatement(sql);
            rs=st.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static ResultSet sellerproductsbyid(int id){
        ResultSet rs=null;
        try {
           createConnection();
            String sql="select * from products where sid=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, id);
            rs=st.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    
    public static ResultSet deepakproducts(){
        ResultSet rs=null;
        try {
           createConnection();
            String sql="select * from products";
            PreparedStatement st=con.prepareStatement(sql);
            rs=st.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet deepakproductsbyid(int id){
        ResultSet rs=null;
        try {
           createConnection();
            String sql="select * from products where pid=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, id);
            rs=st.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet deepakproductsbyname(String id){
        ResultSet rs=null;
        try {
           createConnection();
            String sql="select * from products where pname=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, id);
            rs=st.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet deepakproductslimit(int lmt){
        ResultSet rs=null;
        try {
           createConnection();
           int lmt1=lmt-5;
            String sql="select * from products limit ?,?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, lmt);
            st.setInt(2, 5);
            rs=st.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }



    public static  PreparedStatement deepname(int pid,String name, int sid){
        ResultSet res=null;
        try{
            createConnection();
            String sql="UPDATE products\n" +
                    "SET pname=?\n" +
                    "WHERE pid=? and sid=?";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,pid);
            stmt.setInt(3,sid);
            stmt.executeUpdate();
            System.out.println("Name updated");
            return stmt;
        }
        catch (Exception e){
            e.printStackTrace();
        }
     //   return st
      //  return  res;
        return null;
    }

    public static void  insertintosellercredetials(Buser.CuserBuilder bull)
   // public static void  insertintosellercredetials(int sid,String sname,String password)
    {
        String sql="insert into seller_credentials(sid,sname,password) values(?,?,?)";
      //  String url = "jdbc:mysql://localhost:3306/shopdb";
        // try(Connection conn= DriverManager.getConnection(url, "root", ""); PreparedStatement stmt= conn.prepareStatement(sql)){
        try{
            createConnection();
            PreparedStatement stmt=con.prepareStatement(sql);
//            stmt.setInt(1,sid);//bull.getuserid());
//            stmt.setString(2,sname);//bull.getUname());
//            stmt.setString(3,password);//bull.getPasswd());
            stmt.setInt(1,bull.getuserid());
            stmt.setString(2,bull.getUname());
            stmt.setString(3,bull.getPasswd());
            stmt.executeUpdate();
            System.out.println("Username and password Added for seller");
        }
        catch (Exception e){
            e.getMessage();
        }


    }
    public static void insertuserdetails(Buser.CuserBuilder builder){
        // public void insertuserdetails(int uid,String name,String email){
        String sql="insert into users(uid,name,email) values(?,?,?)";
        //String url="jdbc:mysql://localhost:3306/shopdb";
       // try(Connection conn=DriverManager.getConnection( url,"root",""); PreparedStatement stmt=conn.prepareStatement(sql)){
        try{
            createConnection();
        PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,builder.getuserid());
            stmt.setString(2,builder.getUname());
            stmt.setString(3,builder.getUemail());
//            stmt.setInt(1,uid);
//            stmt.setString(2,name);
//            stmt.setString(3,email);
            stmt.executeUpdate();
            System.out.println("Username and Email Updated");
        }
        catch (Exception e){
            e.getMessage();
        }
    }


    public static boolean insertintousercred(Buser.CuserBuilder bull){
    //  public static void insertintousercredentials(int uid,String uname,String password){

          String sql="insert into user_credentials(uid,uname,password) values(?,?,?)";
          	int count=0;
            try
            {   createConnection();
                PreparedStatement stmt= con.prepareStatement(sql);
//                stmt.setInt(1,uid);//bull.getuserid());
//                stmt.setString(2,uname);//bull.getUname());
//                stmt.setString(3,password);//bull.getPasswd());
                stmt.setInt(1,bull.getuserid());
                stmt.setString(2,bull.getUname());
                stmt.setString(3,bull.getPasswd());
                stmt.executeUpdate();
                ++count;
              //  System.out.println("Username and password Added for seller");
            }
            catch (Exception e){
                e.getMessage();
            }
            if(count>0)
            return true;
            else 
            	return false;
        }

    
    public static void insertintousercredentials(Buser.CuserBuilder bull){
//  public static void insertintousercredentials(int uid,String uname,String password){

      String sql="insert into user_credentials(uid,uname,password) values(?,?,?)";

        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1,bull.getuserid());
            stmt.setString(2,bull.getUname());
            stmt.setString(3,bull.getPasswd());
            stmt.executeUpdate();
            System.out.println("Username and password Added for seller");
        }
        catch (Exception e){
            e.getMessage();
        }
    }


    // Query for the wishlist
//    @Override
public static PreparedStatement wishlistt(Bcart.BcartBuilder build){
    String sql="insert into wishlist(uid,pid) values(?,?)";
    PreparedStatement stmt=null;
    try {
        createConnection();
        stmt= con.prepareStatement(sql);
//        stmt.setInt(1,uid);
//        stmt.setInt(2,wl);
        stmt.setInt(1,build.getUid());
        stmt.setInt(2,build.getPid());
        //insertquery(sql);
    //    stmt.executeUpdate();
    }
    catch (Exception e){
        e.getMessage();
    }
    return stmt;
}

    //Show Cart(USER)
    //public static ResultSet showcartt(int uid){
    public static ResultSet showcartt(Bcart.BcartBuilder build){
        String sql= "SELECT * FROM cart WHERE uid=?;";
        PreparedStatement stmt=null;
        try {
            createConnection();
            stmt= con.prepareStatement(sql);
            stmt.setInt(1,build.getUid());
            //stmt.setString(1, uname);
            //stmt.setString(2, pswd);

             rs = stmt.executeQuery();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return rs;
    }
    // Total price calculation(USER)
    public static int totalpricee(int uid){
        String sql= "SELECT sum(price) FROM cart where uid=? ;";
        int val=0;
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();
            int price = 0;
            while (rs.next()) {
                price = rs.getInt(1);

            }
            val=price;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return val;
    }
    // For Deleting the products which is present in Remove products (USER)
   // public static void delprods(int pid,int uid){
  //  public static void delprods(Bcart.BcartBuilder buil){
    public static PreparedStatement delprods(Bcart.BcartBuilder buil){
        String sql = "delete from cart where pid=? and uid=?";
        PreparedStatement stmt=null;
        try
        {   createConnection();
            stmt= con.prepareStatement(sql);
//            stmt.setInt(1,pid);
//            stmt.setInt(2,uid);
            stmt.setInt(1,buil.getPid());
            stmt.setInt(2,buil.getUid());
           // stmt.executeUpdate();
            //System.out.println("Product removed from cart");
        }

        catch (Exception e){
            e.getMessage();
        }
        return stmt;
    }

    public static int getstock(int pid){
        String sqlr = "select stock from products where pid=?";
        int stk = 0;
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sqlr);
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            //    int cnt=0;
            while (rs.next()) {
                stk = rs.getInt(1);

            }
            //
        } catch (Exception e) {
            System.out.println(e);
        }
        return stk;
    }

    public static void updatestkinprod(int pid,int stk){
        String sqlr="UPDATE products\n" +
                "SET stock=?\n" +
                "WHERE pid=?";
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sqlr);
            stmt.setInt(1,stk);
            stmt.setInt(2,pid);
            stmt.executeUpdate();
            System.out.println("Stock updated in products");
        }
        catch (Exception e){
            System.out.println(e);}

    }

    public static PreparedStatement billprodss(Bbill.BbillBuilder builder){
    	System.out.println("inside queries");
        java.util.Date date = new Date();
        String sql= "insert into bils(uid,ts,mop,totprice) values (?,?,?,?)";
        int totp=totalpricee(builder.getUid());
        PreparedStatement stmt= null;
        try
        {   createConnection();
        System.out.println(1);
            stmt= con.prepareStatement(sql);     // stmt.setString(1, );
            System.out.println(2);
            stmt.setInt(1, builder.getUid());
            stmt.setTimestamp(2,new Timestamp(date.getTime()));
            stmt.setString(3,builder.getMop());
            stmt.setInt(4,totp);

         //   stmt.executeUpdate();
         //   System.out.println("Products billed");

        }
        catch (Exception e){
            System.out.println(e);
        }
        return stmt;

    }

    public static ResultSet wishlistquery(){
        String sqlr = "select * from wishlist";
        try
        {
            createConnection();
            System.out.println(2);
            PreparedStatement stmt= con.prepareStatement(sqlr);
            System.out.println(3);
          //  stmt.setInt(1, uid);
            rs= stmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
        }
    
    public static ResultSet wishlistbyid(int uid){
        String sqlr = "select * from wishlist where uid = ?";
        try
        {
            createConnection();
            PreparedStatement stmt= con.prepareStatement(sqlr);
              stmt.setInt(1, uid);
            rs= stmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public static int findbillid(int uid,int totp){
        String sql= "SELECT bid FROM bils WHERE uid = ? and totprice= ?;";
        int bill=0;
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1, uid);
            stmt.setInt(2, totp);
            ResultSet rs = stmt.executeQuery();
            int bid=0;
            while (rs.next()) {
                bid = rs.getInt(1);
            }
            bill=bid;
        }
        catch (Exception e){
            e.getMessage();
        }

        return bill;
    }

//public static  ResultSet orderhistory(int uid){
public static  ResultSet orderhistory(Bbill.BbillBuilder buil){
    try{
        createConnection();
        //ResultSet rs=stmt.executeQuery("select pid,quantity,price from cart where uid=?");
        String sql= "select pid,quantity,price from cart where uid=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,buil.getUid());
        int totp=totalpricee(buil.getUid());
        int bill=findbillid(buil.getUid(),totp);
        //int bill=
         rs =statement.executeQuery();
        System.out.println("Bill no: "+bill);
        System.out.println("Total price : "+totp);
    /*    while(rs.next())
        {
            //     System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
            int p1,p2,p3; p1=rs.getInt(1);  p2=rs.getInt(2);  p3=rs.getInt(3);
            String sqli="insert into ord_history(bid,uid,pid,quantity,rtrnquan,price) values(?,?,?,?,?,?)";
            String url="jdbc:mysql://localhost:3306/shopdb";
            try(Connection conn=DriverManager.getConnection( url,"root",""); PreparedStatement pstmt=conn.prepareStatement(sql)){
                pstmt.setInt(1,bill);
                pstmt.setInt(2,uid);
                pstmt.setInt(3,p1);
                pstmt.setInt(4,p2);
                pstmt.setInt(5,0);
                pstmt.setInt(6,p3);
                pstmt.executeUpdate();
                System.out.println("Updated in the Ord_history");
            }
            catch (SQLException e){
                e.getMessage();
            }

        }
        */
        //con.close();
       // System.out.println("done");
    }
    catch(Exception e){ System.out.println(e);}

    return rs;
}

//public static  PreparedStatement delfromcart(int uid){
public static  PreparedStatement delfromcart(Bbill.BbillBuilder build){
    String sqlrem = "delete from cart where uid=? ";
    PreparedStatement stmt=null;
    try{
        createConnection();
      stmt=con.prepareStatement(sqlrem);
       // stmt.setInt(1,uid);
        stmt.setInt(1,build.getUid());
//        stmt.executeUpdate();
//        System.out.println("cart cleared");
    }
    catch (Exception e){
        //   System.out.println("You're not authorized seller to delete");
        e.getMessage();
    }
    return stmt;
}

    public static void orderhiss(int uid){
      //  bbillBuilder.setUid(uid);
     /*   try{
            ResultSet rs=Queries.orderhistory(bbillBuilder);
            while (rs.next()){

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        try{
            createConnection();
           // Connection con=null;
            //ResultSet rs=stmt.executeQuery("select pid,quantity,price from cart where uid=?");
            String sql= "select pid,quantity,price from cart where uid=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,uid);
//            int totp=Queries.totalpricee(uid);
            int totp=totalpricee(uid);
            int bill=findbillid(uid,totp);
            //int bill=
            ResultSet rs =statement.executeQuery();
            System.out.println("Bill no: "+bill);
            System.out.println("Total price : "+totp);
            while(rs.next())
            {
                //     System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
                int p1,p2,p3; p1=rs.getInt(1);  p2=rs.getInt(2);  p3=rs.getInt(3);
                String sqli="insert into ord_history(bid,uid,pid,quantity,rtrnquan,price) values(?,?,?,?,?,?)";
                String url="jdbc:mysql://localhost:3306/shopdb";
             //   try(Connection conn=DriverManager.getConnection( url,"root",""); PreparedStatement pstmt=conn.prepareStatement(sql)){
                try {
                    createConnection();
                        PreparedStatement pstmt = con.prepareStatement(sqli);
                pstmt.setInt(1,bill);
                    pstmt.setInt(2,uid);
                    pstmt.setInt(3,p1);
                    pstmt.setInt(4,p2);
                    pstmt.setInt(5,0);
                    pstmt.setInt(6,p3);
                    pstmt.executeUpdate();
                    System.out.println("Updated in the Ord_history");
                }
                catch (SQLException e){
                    e.getMessage();
                }

            }

            //con.close();
            System.out.println("done");
        }
        catch(Exception e){ System.out.println(e);}

      /*  try{
            PreparedStatement statement=Queries.delfromcart(bbillBuilder);
            statement.executeUpdate();
            System.out.println("cart cleared");
        }
        catch (Exception e){
            e.printStackTrace();
        }*/
        String sqlrem = "delete from cart where uid=? ";
        String url="jdbc:mysql://localhost:3306/shopdb";
        try(Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/shopdb","root",""); PreparedStatement stmt=conn.prepareStatement(sqlrem)){
            stmt.setInt(1,uid);
            stmt.executeUpdate();
            System.out.println("cart cleared");
        }
        catch (SQLException e){
            //   System.out.println("You're not authorized seller to delete");
            e.getMessage();
        }
    }




    // SELLER SIDE
   // public static ResultSet sellercred(String uname, String pswd){
    public static ResultSet sellercred(Buser.CuserBuilder builder){

        String sql= "SELECT sid FROM seller_credentials WHERE sname = ? and password = ?;";
        try{
            createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
       /*    stmt.setString(1,uname);
            stmt.setString(2,pswd);*/
       stmt.setString(1,builder.getUname());
       stmt.setString(2,builder.getPasswd());
             rs =stmt.executeQuery();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }




    public static PreparedStatement removeprodsinlist(Bproducts.BproductsBuilder build){

        String sql = "delete from products where pid=? and sid=?";
        PreparedStatement stmt=null;
        try
        {   createConnection();
        System.out.println("deepk");
            stmt= con.prepareStatement(sql);
            System.out.println("chandh");
       //     stmt.setInt(1,id);
         //   stmt.setInt(2,sid);
           stmt.setInt(1,build.getPid());
           stmt.setInt(2,build.getSid());
           // stmt.executeUpdate();
            //System.out.println("row removed");
        }
        catch (Exception e){
            System.out.println("You're not authorized seller to delete");
            e.getMessage();
        }
	      return stmt;
    }

    public static PreparedStatement insertprodsinlist(Bproducts.BproductsBuilder build){
        String sql = "INSERT INTO products(pid,pname,stock,price,sid,noofusers,prodrating) VALUES(?,?,?,?,?,?,?)";
	      PreparedStatement stmt=null;
	      try {
              createConnection();
              stmt=con.prepareStatement(sql);
//            stmt.setInt(1,pid);//build.getPid());
//            stmt.setString(2,name);//build.getPname());
//            stmt.setInt(3,stk);//build.getStock());
//            stmt.setInt(4,price);//build.getPrice());
//            stmt.setInt(5,sid);//build.getSid());
              stmt.setInt(1,build.getPid());
              stmt.setString(2,build.getPname());
              stmt.setInt(3,build.getStock());
              stmt.setInt(4,build.getPrice());
              stmt.setInt(5,build.getSid());
              stmt.setInt(6,0);
              stmt.setInt(7,0);
            //  stmt.executeUpdate();
              //System.out.println("Values Inserted");


          }
	      catch (Exception e){
	          e.printStackTrace();
          }
	      return stmt;
    }


    public static void insert(Bproducts.BproductsBuilder build){
//public static void insert(int sid,int pid,String name,int price,int stk){
       /* try{
            PreparedStatement statement=insertprodsinlist(build);
            statement.executeUpdate();
            System.out.println("values inserted");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        */

       /* String sql = "INSERT INTO products(pid,pname,stock,price,sid,noofusers,prodrating) VALUES(?,?,?,?,?,?,?)";
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);

//            stmt.setInt(1,pid);//build.getPid());
//            stmt.setString(2,name);//build.getPname());
//            stmt.setInt(3,stk);//build.getStock());
//            stmt.setInt(4,price);//build.getPrice());
//            stmt.setInt(5,sid);//build.getSid());
            stmt.setInt(1,build.getPid());
            stmt.setString(2,build.getPname());
            stmt.setInt(3,build.getStock());
            stmt.setInt(4,build.getPrice());
            stmt.setInt(5,build.getSid());
           stmt.setInt(6,0);
            stmt.setInt(7,0);
            stmt.executeUpdate();
            System.out.println("Values Inserted");
        }
        catch (Exception e){
            e.getMessage();
        }*/
    }


  //  public static void selldetailss(int sid,String name,String email){
//  public static void selldetailss(Buser.CuserBuilder builder){
  public static PreparedStatement selldetailss(Buser.CuserBuilder builder){
        String sql="insert into seller(sid,sname,email) values(?,?,?)";
      PreparedStatement stmt=null;
        try
        {   createConnection();
             stmt= con.prepareStatement(sql);
           /* stmt.setInt(1,sid);
            stmt.setString(2,name);
            stmt.setString(3,email);*/
           stmt.setInt(1,builder.getuserid());
            stmt.setString(2,builder.getUname());
            stmt.setString(3,builder.getUemail());
//            stmt.executeUpdate();
//            System.out.println("Username and Email Updated");
        }
        catch (Exception e){
            e.getMessage();
        }
        return stmt;
    }
    public static PreparedStatement deepakselldetailss(Bseller.BsellerBuilder builder){
        String sql="insert into seller(sid,sname,email) values(?,?,?)";
        PreparedStatement stmt=null;
        try
        {   createConnection();
            stmt= con.prepareStatement(sql);
           /* stmt.setInt(1,sid);
            stmt.setString(2,name);
            stmt.setString(3,email);*/
            stmt.setInt(1,builder.getUserid());
            stmt.setString(2,builder.getUsname());
            stmt.setString(3,builder.getUemail());
//            stmt.executeUpdate();
//            System.out.println("Username and Email Updated");
        }
        catch (Exception e){
            e.getMessage();
        }
        return stmt;
    }

//public static PreparedStatement prepmodname(int id,String name,int sid){
public static PreparedStatement prepmodname(Bproducts.BproductsBuilder build){
    String sql="UPDATE products\n" +
            "SET pname=?\n" +
            "WHERE pid=? and sid=?";
    PreparedStatement stmt=null;
    try
    {   createConnection();
        stmt= con.prepareStatement(sql);
//        stmt.setString(1,name);
//        stmt.setInt(2,id);
//        stmt.setInt(3,sid);
        stmt.setString(1,build.getPname());
        stmt.setInt(2,build.getPid());
        stmt.setInt(3,build.getSid());
//       // stmt.executeUpdate();
     //   System.out.println("Name updated");
    }
    catch (Exception e){
        e.getMessage();
    }
    return stmt;
}

//public static PreparedStatement prepmodstk(int id,int stk,int sid){
public static PreparedStatement prepmodstk (Bproducts.BproductsBuilder build){
    String sql="UPDATE products\n" +
            "SET stock=?\n" +
            "WHERE pid=? and sid=?";
    PreparedStatement stmt=null;
    try
    {   createConnection();
    System.out.println("hello ");
        stmt= con.prepareStatement(sql);
        System.out.println("world");
     /*   stmt.setInt(1,stk);
        stmt.setInt(2,id);
        stmt.setInt(3,sid);*/
     stmt.setInt(1,build.getStock());
     stmt.setInt(2,build.getPid());
     stmt.setInt(3,build.getSid());
//        stmt.executeUpdate();
//        System.out.println("Stock updated");
    }
    catch (Exception e){
        e.getMessage();
    }
    return stmt;
}
//public static PreparedStatement prepmodprice(int id, int price,int sid){
public static PreparedStatement prepmodprice(Bproducts.BproductsBuilder builder){
    PreparedStatement stmt=null;
    String sql="UPDATE products\n" +
            "SET price=?\n" +
            "WHERE pid=? and sid=?";

    try
    {   createConnection();
         stmt= con.prepareStatement(sql);
       /* stmt.setInt(1,price);
        stmt.setInt(2,id);
        stmt.setInt(3,sid);*/
        stmt.setInt(1,builder.getPrice());
        stmt.setInt(2,builder.getPid());
        stmt.setInt(3,builder.getSid());
//        stmt.executeUpdate();
//        System.out.println("Price updated");
    }
    catch (Exception e){
        e.getMessage();
    }
    return stmt;
}



    //-- ADMIN --
   // public static ResultSet resquer1(int uid,int pid){
    public static ResultSet resquer1(Badmin.BadminBuilder buil){

        String sql = "select * from ord_history where uid = ? and pid = ?";
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
//            stmt.setInt(1, uid);
//            stmt.setInt(2,pid);
            stmt.setInt(1,buil.getUid());
            stmt.setInt(2,buil.getPid());
            rs = stmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
	      return rs;
    }

//public static ResultSet resquer2(int uid){
public static ResultSet resquer2(Badmin.BadminBuilder builder){

    String sqlr = "select * from wishlist where uid = ?";
    try
    {
        createConnection();
        PreparedStatement stmt= con.prepareStatement(sqlr);
        stmt.setInt(1, builder.getUid());
        rs= stmt.executeQuery();

    } catch (Exception e) {
        System.out.println(e);
    }
    return rs;
}

public static ResultSet resquer3(){
    String sql="select pid,qty from t1 where qty in (select max(qty) from t1);";
    try
    {   createConnection();
        PreparedStatement stmt= con.prepareStatement(sql);
         rs = stmt.executeQuery();
        //
    } catch (Exception e) {
        System.out.println(e);
    }
    return rs;
}

public static  ResultSet resquer4(){
    //    String sql="select a.uid,a.uname,b.bid,b.totprice from user_credentials as a inner join bils as b where b.uid=a.uid order by uid";
    String sql=" select a.uid,a.uname,b.bid,b.ts,b.mop,b.totprice from user_credentials as a inner join bils as b where b.uid=a.uid order by uid;";
    try
    {   createConnection();
        PreparedStatement stmt= con.prepareStatement(sql);
         rs = stmt.executeQuery();

    } catch (Exception e) {
        System.out.println(e);
    }
    return rs;
}
//public static ResultSet resquer5(String strs){
public static ResultSet resquer5(Badmin.BadminBuilder build){

    String sql="select sum(totprice) from bils where mop=?;";
    try
    {   createConnection();
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setString(1,build.getMop());
         rs = stmt.executeQuery();
        //
    } catch (Exception e) {
        System.out.println(e);
    }
    return rs;
}
//public static ResultSet resquer6(String daate,String daa){
public static ResultSet resquer6(Badmin.BadminBuilder build){
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date d2=null;// start date
    Date d3=null;// end date
    try{
        Date d1 = df.parse(build.getDate1());
        Date dd=df.parse(build.getDate2());
        // System.out.println("Date: " + d1);
        System.out.println("Date in dd/MM/yyyy format is: "+df.format(d1));
        d2=d1;
        d3=dd;

    }
    catch (Exception e){
        e.getMessage();
    }
    String sql="select * from bils WHERE ts >= ? AND ts <= ?";
    try
    {   createConnection();
        PreparedStatement stmt= con.prepareStatement(sql);
        stmt.setDate(1,new java.sql.Date(d2.getTime()));
        stmt.setDate(2,new java.sql.Date(d3.getTime()));
         rs = stmt.executeQuery();
    } catch (Exception e) {
        System.out.println(e);
    }
    return rs;
}

}
