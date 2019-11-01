package onlineproj;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Admin implements newinter {
    Scanner sc= new Scanner(System.in);
    int choi=0;
    Buser cusr= new Buser();
    Buser.CuserBuilder builder= cusr.new CuserBuilder();
    Badmin badmin= new Badmin();
    Badmin.BadminBuilder badminBuilder= badmin.new BadminBuilder();

    public void addusers(){

        String url = "jdbc:mysql://localhost:3306/shopdb";
        System.out.println("Enter User ID");
        Integer uid=sc.nextInt();
        System.out.println("Enter the Username:");
        String uname = sc.next();
        System.out.println("Enter the Password:");
        String passwd = sc.next();
        builder.setUsid(uid);
        builder.setUname(uname);
        builder.setPasswd(passwd);
        Queries.insertintousercredentials(builder);


    }
    public void addseller(){
        System.out.println("Enter the Seller ID");
        builder.setUsid(sc.nextInt());

        System.out.println("Enter the Seller name");
        builder.setUname(sc.next());

        System.out.println("Enter the Password");
        builder.setPasswd(sc.next());

        Queries.insertintosellercredetials(builder);
    }

    public void quer6(Badmin.BadminBuilder buildd){

        try{
            ResultSet rs=Queries.resquer6(buildd);
            System.out.printf("%-8s%-12s%-20s%-20s%-16s%-16s\n","bid","uid","Date","Time","mop","totprice");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-8s%-12s%-20s%-20s%-16s%-16s\n",rs.getInt(1),rs.getInt(2),rs.getDate(3),
                        rs.getTime(3),rs.getString(4),rs.getInt(5));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void wishlistbyuid(int uid){
        badminBuilder.setUid(uid);
        quer2(badminBuilder);
    }
    public void deepakaddseller(int uid,String username, String password){
        builder.setUsid(uid);
        builder.setUname(username);
        builder.setPasswd(password);
        Queries.insertintosellercredetials(builder);
    }

    public void deepakaddusers(int uid,String username, String password){
        builder.setUsid(uid);
        builder.setUname(username);
        builder.setPasswd(password);
        Queries.insertintousercredentials(builder);
    }

    public static void quer1(Badmin.BadminBuilder builder){

        try{

            ResultSet rs= Queries.resquer1(builder);
            System.out.printf("%-8s%-12s%-12s%-14s%-14s%-16s\n","bid","uid","pid","quantity","rtrnquan","price");
            System.out.println("-----------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-8s%-12s%-12s%-14s%-14s%-12s\n",rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getInt(4),rs.getInt(5),rs.getInt(6));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void quer2(Badmin.BadminBuilder builder){
        try
        {
            //ResultSet rs = Queries.resquer2(uid);
            ResultSet rs = Queries.resquer2(builder);
            System.out.printf("%-8s%-12s\n","uid","pid");
            System.out.println("-----------------");
            while (rs.next()) {
                System.out.printf("%-8s%-12s\n",rs.getInt(1),rs.getInt(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static  void quer3(){
        try{
            ResultSet rs=Queries.resquer3();
            System.out.printf("%-8s%-12s\n","pid","qty");

            System.out.println("-----------------");
            while (rs.next()) {
                System.out.printf("%-8s%-12s\n",rs.getInt(1),rs.getInt(2));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void quer4(){
        try {
            ResultSet rs= Queries.resquer4();
            System.out.printf("%-8s%-14s%-14s%-14s%-14s%-14s%-14s\n","Uid","Uname","Bill Id","Date","Time","payment","Total Price");

            System.out.println("-----------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-8s%-14s%-14s%-14s%-14s%-14s%-16s\n", rs.getInt(1), rs.getString(2),rs.getInt(3),
                        rs.getDate(4),rs.getTime(4),rs.getString(5),rs.getInt(6));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // public static void quer5(String strs){
    public static void quer5(Badmin.BadminBuilder build){
        try {
            ResultSet rs=Queries.resquer5(build);
            System.out.println("Total Price");
            System.out.println("-----------------");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void admincredentials(String aname, String apswd) {
        String sql = "SELECT adid FROM admin_credentials WHERE adname = ? and password = ?;";
        String url = "jdbc:mysql://localhost:3306/shopdb";
        try(Connection conn= DriverManager.getConnection(url, "root", ""); PreparedStatement stmt= conn.prepareStatement(sql)){
            stmt.setString(1, aname);
            stmt.setString(2, apswd);
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            int aid = 0;
            while (rs.next()) {
                aid = rs.getInt(1);
                count++;
            }
            if(count>=1)
            {
                System.out.println("Welcome Admin ");
                do{
                    System.out.println("1.Add Users 2.Add Sellers 3.View Products 4.Analytics ");
                    choi=sc.nextInt();
                    switch (choi){
                        case 1:
                            addusers();
                            break;
                        case 2:
                            addseller();
                            break;
                        case 3:
                            // usr.displayStoreProducts();
                            Queries.displayproducts();
                            break;
                        case 4:
                            System.out.println("1. Check whether the user has bought a particular product or not");
                            System.out.println("2. Check the wish list of particular user");
                            System.out.println("3. Most sold product ");
                            System.out.println("4. Check the users who have purchased");
                            System.out.println("5. Amount billed by using specified mode of purchase");
                            System.out.println("6. Sales on a particular day");
                            Integer ch=sc.nextInt();
                            if(ch==1){
                                System.out.println("Enter User ID and Product ID");
                                Integer uid1= sc.nextInt(); Integer pid1=sc.nextInt();
                                badminBuilder.setUid(uid1); badminBuilder.setPid(pid1);
                                quer1(badminBuilder);
                            }
                            if(ch==2)
                            { System.out.println("Enter User ID ");
                                Integer uid2= sc.nextInt();
                                badminBuilder.setUid(uid2);
                                quer2(badminBuilder);
                            }
                            if(ch==3){
                                quer3();
                            }
                            if(ch==4){
                                quer4();
                            }
                            if(ch==5){
                                System.out.println("Enter mode of payment");
                                String mop= sc.next();
                                badminBuilder.setMop(mop);
                                // quer5(mop);
                                quer5(badminBuilder);
                            }
                            if(ch==6){
                                System.out.println("Enter start date yyyy-mm-dd");
                                String dda= sc.next();
                                System.out.println("Enter End date yyyy-mm-dd");
                                String enddate= sc.next();
                                badminBuilder.setDate1(dda);
                                badminBuilder.setDate2(enddate);
                                quer6(badminBuilder);
                            }
                            break;
                    }
                }while(choi!=0);

            }
            else
                System.out.println("Wrong credentials");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }


}
