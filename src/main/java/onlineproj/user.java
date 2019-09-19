package onlineproj;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class user implements  UserInter{

    Buser cusr= new Buser();
    Buser.CuserBuilder builder= cusr.new CuserBuilder();
    Bcart bcart= new Bcart();
    Bcart.BcartBuilder bcartBuilder= bcart.new BcartBuilder();
    Bbill bbill= new Bbill();
    Bbill.BbillBuilder bbillBuilder= bbill.new BbillBuilder();
    //Cart cart= new Cart();
    int chn=0;
    Scanner sc= new Scanner(System.in);
    public Connection connect(){
        String url="jdbc:mysql://localhost:3306/shopdb";
        Connection conn=null;
        try{

            conn = DriverManager.getConnection(url,"root","");
        }
        catch (SQLException e){
            System.out.println(e);
            // e.printStackTrace();
        }
        return conn;
    }

    public void showcart(int uid){
            bcartBuilder.setUid(uid);
        try{
        //    ResultSet rs=Queries.showcartt(uid);
            ResultSet rs=Queries.showcartt(bcartBuilder);
            System.out.printf("%-8s%-12s%-20s%-18s\n","UID","PID","Quan","Price");
            System.out.println("------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-8s%-12s%-20s%-18s\n",rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                //  System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        /*String sql= "SELECT * FROM cart WHERE uid=?;";
        String url="jdbc:mysql://localhost:3306/shopdb";
        try(Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/shopdb","root",""); PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setInt(1,uid);
            //stmt.setString(1, uname);
            //stmt.setString(2, pswd);
            System.out.printf("%-8s%-12s%-20s%-18s\n","UID","PID","Quan","Price");
            System.out.println("------------------------------------------------");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("%-8s%-12s%-20s%-18s\n",rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                //  System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }*/

    }

    public void displayStoreProducts() {

        Queries.displayproducts();
    }

public void deepremovprodfromcart(int uid,int pid){
        
        bcartBuilder.setUid(uid);
        bcartBuilder.setPid(pid);
        int quan=getcartquan(pid,uid);
        if(checkifpresent(pid)){

            //  Queries.delprods(pid,uid);
            // Queries.delprods(bcartBuilder);
            try {
                PreparedStatement statement= Queries.delprods(bcartBuilder);
                statement.executeUpdate();
                System.out.println("product removed from cart");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            int stk=Queries.getstock(pid);
            //   System.out.println("Initial stk"+stk);

            stk=stk+quan;
            //  System.out.println(stk);
            Queries.updatestkinprod(pid,stk);
            decremusercnt(pid);
        }
        else{
            System.out.println("Product not found in cart");
        }
    }
    
    
    
    public void orderhis(int uid){
      //  Queries.orderhiss(uid);
    }
public int gettpricee(int pid){
    String sql= "SELECT price FROM products where pid=?;";
    int val=0;
    try(Connection conn= this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)) {
        stmt.setInt(1, pid);

        ResultSet rs = stmt.executeQuery();

        int price = 0;
        while (rs.next()) {
            price = rs.getInt(1);

        }
        val=price;
    }
    catch(SQLException e){
         System.out.println(e);

    }
    return val;

}

public int gettpricecart(int pid){

    String sql= "SELECT price FROM cart where pid=?;";
    int val=0;
    try(Connection conn= this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)) {
        stmt.setInt(1, pid);

        ResultSet rs = stmt.executeQuery();

        int price = 0;
        while (rs.next()) {
            price = rs.getInt(1);

        }
        val=price;
    }
    catch(SQLException e){
        System.out.println(e);

    }
    return val;

}


public  boolean checkifpresent(int pid) {
    String sql = "SELECT * FROM products WHERE pid = ?;";
    int cnt = 0;
    try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, pid);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            cnt++;
        }
        //System.out.println("Stock updated in products");
    } catch (SQLException e) {
        System.out.println(e);
    }
    if(cnt>0)
    return true;
    else
        return false;
}
    public  boolean checkifpresentincart(int pid) {
        String sql = "SELECT * FROM cart WHERE pid = ?;";
        int cnt = 0;
        try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cnt++;
            }
            //System.out.println("Stock updated in products");
        } catch (SQLException e) {
            System.out.println(e);
        }
        if(cnt>0)
            return true;
        else
            return false;
    }

    public  int noofuser(int pid){
        String sqlr = "select noofusers from products where pid = ?";
        int noofusers=0;
        try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sqlr)) {
            stmt.setInt(1, pid);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                noofusers=rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return noofusers;
    }

    public void incremusercnt(Integer pid ){

        Integer noofusers=noofuser(pid);

        ++noofusers;
        String sql="UPDATE products\n" +
                "SET noofusers=?\n" +
                "WHERE pid=? ";
        try(Connection conn= this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)){
          stmt.setInt(1,noofusers);
          stmt.setInt(2,pid);
            stmt.executeUpdate();
            System.out.println("No of users updated in product table");
        }
        catch (SQLException e){
            e.getMessage();
        }

    }
    public void deepakaddtocart(int uid,int pid,int quan){
        bcartBuilder.setUid(uid); //using builder
        Scanner sc= new Scanner(System.in);
        bcartBuilder.setPid(pid);  // using builder
        int nquan=0;
        if(checkifpresent(pid)) {
            bcartBuilder.setQuantity(quan); // using builder
            nquan=quan;
            int temp = 0;
            int price = gettpricee(pid);

            temp = price * quan;  // calculated price will be holded here
            bcartBuilder.setPrice(temp);
            int stk= Queries.getstock(pid);

            if (stk >= quan) {

                if (checkifpresentincart(pid)) {
                    System.out.println("The Product is already present in cart, would you like to increase the quantity");
                    System.out.println("----1.Yes----2.No---");
                    int ee=sc.nextInt();

                    if(ee==1){
                        String query = "update cart set quantity=?, price=? where pid=?";
                        int temp2;// will hold the new price

                        int Uquan = getcartquan(pid, uid);
                        Uquan=Uquan+quan;
                        temp2 = price * Uquan;
                        try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
                            stmt.setInt(1, Uquan);
                            stmt.setInt(2, temp2);
                            stmt.setInt(3, pid);
                            stmt.executeUpdate();
                            System.out.println("Quantity updated in cart");

                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        stk = stk - quan;
                        System.out.println("Deepak "+stk);
                        Queries.updatestkinprod(pid, stk);
                    }
                }
                else{
                    // insert the values into cart
                    Queries.insertintocart(bcartBuilder);

                    stk = stk - quan;
                    Queries.updatestkinprod(pid, stk);
                }
                // meant for incrementing the count in no of users
                if(nquan>0){
                    incremusercnt(pid);
                }
            }
            else {
                System.out.println("Quantity Exceeded");
            }
        }
        else
        {
            System.out.println("Given ProductID isn't present in our product list");
        }
    }
    
    

    public void addtocart(int uid){
        bcartBuilder.setUid(uid); //using builder
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the ProductID to add");
        int pid=sc.nextInt();
        bcartBuilder.setPid(pid);  // using builder
        int nquan=0;
        if(checkifpresent(pid)) {

            System.out.println("Enter the Quantity");
            int quan = sc.nextInt();
            bcartBuilder.setQuantity(quan); // using builder
            nquan=quan;
            int temp = 0;
            int price = gettpricee(pid);

            temp = price * quan;  // calculated price will be holded here
            bcartBuilder.setPrice(temp);
            int stk= Queries.getstock(pid);

           /* int stk = 0;
            String sqlr = "select stock from products where pid=?";
           try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sqlr)) {
                stmt.setInt(1, pid);
                ResultSet rs = stmt.executeQuery();
                //    int cnt=0;
                while (rs.next()) {
                    stk = rs.getInt(1);
                    //      cnt++;
                }
                //
            } catch (SQLException e) {
                System.out.println(e);
            }*/

            if (stk >= quan) {

                if (checkifpresentincart(pid)) {
                    System.out.println("The Product is already present in cart, would you like to increase the quantity");
                    System.out.println("----1.Yes----2.No---");
                    int ee=sc.nextInt();

                    if(ee==1){
                    String query = "update cart set quantity=?, price=? where pid=?";
                    int temp2;// will hold the new price

                    int Uquan = getcartquan(pid, uid);
                    Uquan=Uquan+quan;
                    temp2 = price * Uquan;
                      try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
                        stmt.setInt(1, Uquan);
                        stmt.setInt(2, temp2);
                        stmt.setInt(3, pid);
                        stmt.executeUpdate();
                        System.out.println("Quantity updated in cart");

                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    stk = stk - quan;
                    System.out.println("Deepak "+stk);
                    Queries.updatestkinprod(pid, stk);
                }

                }
                else{
                    // insert the values into cart
                    Queries.insertintocart(bcartBuilder);
            /*    String sql = "insert into cart(uid,pid,quantity,price) values (?,?,?,?)";
                try (Connection conn = this.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, uid);
                    stmt.setInt(2, pid);
                    stmt.setInt(3, quan);
                    stmt.setInt(4, temp);
                    stmt.executeUpdate();
                    System.out.println("Inserted into the cart");
                    //    String sqlr= "insert into cart(uid,pid,quantity,price) values (?,?,?,?)";

                } catch (SQLException e) {
                    e.getMessage();
                }*/

                stk = stk - quan;
                Queries.updatestkinprod(pid, stk);
                         }

               // meant for incrementing the count in no of users
                if(nquan>0){
                    incremusercnt(pid);
                }
            }
            else {
                System.out.println("Quantity Exceeded");
            }
        }
        else
        {
            System.out.println("Given ProductID isn't present in our product list");
        }


    }


    public static int totalprice(int uid){
        int val=Queries.totalpricee(uid);
        return val;
    }
// made change here
    public static  int findbillid(int uid,int totp){
        String sql= "SELECT bid FROM bils WHERE uid = ? and totprice= ?;";
        int bill=0;

        try{
            Queries.createConnection();
            Connection con=null;
            PreparedStatement stmt= con.prepareStatement(sql);    stmt.setInt(1, uid);
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


    public int getcartquan(int pid,int uid){
        String sqlr = "select quantity from cart where pid=? and uid=?";
        int stk = 0;
      //  try (Connection conn = this.connect(); 
        try{
        	Queries.createConnection();
        	Connection con=null;
        PreparedStatement stmt = con.prepareStatement(sqlr);
            stmt.setInt(1, pid);
            stmt.setInt(2,uid);
            ResultSet rs = stmt.executeQuery();
            //    int cnt=0;
            while (rs.next()) {
                stk = rs.getInt(1);

            }
            //
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return stk;
    }


    public void decremusercnt(Integer pid ){

        Integer noofusers=noofuser(pid);

        --noofusers;
        String sql="UPDATE products\n" +
                "SET noofusers=?\n" +
                "WHERE pid=? ";
        try(Connection conn= this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setInt(1,noofusers);
            stmt.setInt(2,pid);
            stmt.executeUpdate();
            System.out.println("No of users updated in product table");
        }
        catch (SQLException e){
            e.getMessage();
        }

    }


public void removprodfromcart(int uid){
    System.out.println("Enter the product ID:");
    Integer pid=sc.nextInt();
    bcartBuilder.setUid(uid);
    bcartBuilder.setPid(pid);
    int quan=getcartquan(pid,uid);
    if(checkifpresent(pid)){

          //  Queries.delprods(pid,uid);
       // Queries.delprods(bcartBuilder);
        try {
            PreparedStatement statement= Queries.delprods(bcartBuilder);
                    statement.executeUpdate();
            System.out.println("product removed from cart");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        int stk=Queries.getstock(pid);
     //   System.out.println("Initial stk"+stk);

        stk=stk+quan;
      //  System.out.println(stk);
       Queries.updatestkinprod(pid,stk);
        decremusercnt(pid);
    }
    else{
        System.out.println("Product not found in cart");
    }
}

public int deepakusercredentials(String uname, String pswd) {
    builder.setUname(uname);
    builder.setPasswd(pswd);
    int cntt = 0;
    int id = 0;
    try {
        ResultSet rs = Queries.usercred(builder);
        while (rs.next()) {
            id = rs.getInt(1);
            cntt++;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    if(cntt>0)
    return id;
    else
    	return 0;
}


public void deliveryaddress(int uid){
        String sql="insert into user_details(uid,pincode,address,phone) values(?,?,?,?)";
    System.out.println("Enter your address: "); String addr= sc.next();
    System.out.println("Enter your Pincode: "); Integer pincode= sc.nextInt();
    System.out.println("Enter your Phone no.: "); Integer phone= sc.nextInt();
    try(Connection conn=this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setInt(1,uid);
            stmt.setString(2,addr);
        stmt.setInt(3,pincode);
        stmt.setInt(4,phone);
        stmt.executeUpdate();
        System.out.println("Contacts Successfully Inserted");
    }
        catch (SQLException e){
            e.getMessage();
        }

}
/*
    public void wishlist(int uid){

        //Queries.wishlistt(uid);
    }*/




    public void userdetails(int uid){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your Username");
        String name= sc.next();
        System.out.println("Enter Your Email");
        String email=sc.next();
        builder.setUsid(uid);
        builder.setUname(name);
        builder.setUemail(email);
        Queries.insertuserdetails(builder);

      //  insertuserdetails(uid,name,email);


//        System.out.println("1.Add Additional Details");
//        Integer choi=sc.nextInt();
//        if(choi==1){
//        }
//        else{
//            System.out.println("Thank you");
//        }

    }
    public static void deepaks(){
        try{
            // createConnection();
           ResultSet rs= Queries.deepakproducts();
            if(rs==null){
                System.out.println("yes null");
                return;
            }
            System.out.printf("%-8s%-12s%-20s%-18s%-14s%-14s%-16s","SID","ProductID","ProductName","StocksAvailable","Price","noofusers","prodrating");

            System.out.println("\n--------------------------------------------------------------------------------------------------");
            while(rs.next())
                System.out.printf("%-8s%-12s%-20s%-18s%-14s%-14s%-16s\n",rs.getInt(5),rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getInt(4),rs.getInt(6),rs.getInt(7));
            //terminateconnection();

        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
    public  void wishlist(int uid){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your Product ID to be added in wishlist");
        Integer wl=sc.nextInt();
       bcartBuilder.setUid(uid);
       bcartBuilder.setPid(wl);
       try {
           PreparedStatement stmt = Queries.wishlistt(bcartBuilder);
           stmt.executeUpdate();
           System.out.println("Added to wishlist");
       }
       catch (Exception e){
           e.printStackTrace();
       }


        /*
        String sql="insert into wishlist(uid,pid) values(?,?)";
        String url="jdbc:mysql://localhost:3306/shopdb";
        //   try(Connection conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/shopdb","root",""); PreparedStatement stmt=conn.prepareStatement(sql)){
        try {
            createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setInt(1,uid);
            stmt.setInt(2,wl);
            //insertquery(sql);
            stmt.executeUpdate();
        }
        catch (Exception e){
            e.getMessage();
        }*/

    }

    public void billprods(int uid,String mop){

    	System.out.println("inside billprods");
        bbillBuilder.setUid(uid);
        bbillBuilder.setMop(mop);
        try {
            PreparedStatement statement=(PreparedStatement) Queries.billprodss(bbillBuilder);
            System.out.println("deepak "+statement);
            statement.executeUpdate();
            System.out.println("chandh");
            System.out.println("Products Billed");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    /*    java.util.Date date = new Date();
        String sql= "insert into bils(uid,ts,mop,totprice) values (?,?,?,?)";
        int totp=totalpricee(uid);
        try
        {   createConnection();
            PreparedStatement stmt= con.prepareStatement(sql);     // stmt.setString(1, );
            stmt.setInt(1, uid);
            stmt.setTimestamp(2,new Timestamp(date.getTime()));
            stmt.setString(3,mop);
            stmt.setInt(4,totp);

            stmt.executeUpdate();
            System.out.println("Products billed");

        }
        catch (Exception e){
            System.out.println(e);
        }*/
    }




    public void usercredentials(String uname, String pswd){
        builder.setUname(uname);
        builder.setPasswd(pswd);
        try{
        ResultSet rs= Queries.usercred(builder);
        int cnt=0; int id=0;

        while(rs.next()){
            id=rs.getInt(1);
            cnt++;
        }

        /*String sql= "SELECT uid FROM user_credentials WHERE uname = ? and password = ?;";
        try(Connection conn= this.connect(); PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setString(1,uname);
            stmt.setString(2,pswd);
            ResultSet rs =stmt.executeQuery();
            int cnt=0; int id=0;
            while(rs.next()){
                id=rs.getInt(1);
                cnt++;
            }*/
           // System.out.println(cnt);
            if(cnt>=1)
            {

                do{
                    System.out.println("Welcome user ");
                    System.out.println("Your User ID is "+id);
                System.out.println("1. Add products to cart 2. Wish list 3. remove products from cart  4.show cart 5.Bill the products 6. Add Details 7.View all products  8. see my details0.Sign Out");
                chn=sc.nextInt();
                switch (chn){
                    case 1:
                     //  Queries.displayproducts();
                        deepaks();
                    	//displayStoreProducts();
                        addtocart(id);
                        break;
                    case 2:
                        wishlist(id);
                        break;
                    case 3:
                        showcart(id);
                        removprodfromcart(id);
                        break;
                    case 4:
                        showcart(id);
                        break;
                    case 5:
                        System.out.println("Mode of Payment");
                        String mop=sc.next();
                        billprods(id,mop);// till here
                        Queries.orderhiss(id);
                        //deliveryaddress(id);
                        break;
                    case 6:
                        userdetails(id);
                        break;
                    case 7:
                        displayStoreProducts();
                        break;
                    case 8:
                   //     cusr.seemydetails();
                        break;
                }
                }while(chn!=0);

            }

            else
                System.out.println("Wrong credentials");
        }
        catch (SQLException e){
            e.getMessage();
        }
    }

}
