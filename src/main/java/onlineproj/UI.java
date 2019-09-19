package onlineproj;
import java.util.*;
import java.sql.*;
import java.util.Scanner;
import java.sql.*;

public class UI {
    public static Connection conn;
    seller sell= new seller();
    user uss=new user();
    Admin admin= new Admin();
    private int ch = 0;
    private String s;
    private Double d;
    Scanner sc= new Scanner(System.in);
    public UI () {
        validation();
    }
    public Connection connect(){
        String url="jdbc:mysql://localhost:3306/shopdb";
        Connection conn=null;
        try{
            conn = DriverManager.getConnection(url,"root","");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    


    public  void validation() {
        do {
            System.out.println("Welcome to Shopping System");
            System.out.println("1. ADMIN");
            System.out.println("2. SELLER");
            System.out.println("3. USER");
            System.out.println("0. Exit");
            ch = getUserInput();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Username:");
                    String aname = sc.next();
                    System.out.println("Enter the Password:");
                    String apswd = sc.next();
                    admin.admincredentials(aname,apswd);
                    break;
                case 2:
                    System.out.println("1. Sign in\t 2.Sign up");
                    Integer inchoi=sc.nextInt();
                    if(inchoi==1){
                    System.out.println("Enter the Username:");
                    String sname = sc.next();
                    System.out.println("Enter the Password:");
                    String spswd = sc.next();
                    sell.sellcredential(sname, spswd);}
                    if(inchoi==2){
                       admin.addseller();
                    }
                //    terminateconnection();

                    break;
                case 3:
                    System.out.println("1. Sign in\t 2.Sign up");
                    Integer inchoice=sc.nextInt();
                    if(inchoice==1){
                    System.out.println("Enter the Username:");
                    String uname = sc.next();
                    System.out.println("Enter the Password:");
                    String pswd = sc.next();
                    uss.usercredentials(uname, pswd);}
                    if(inchoice==2){
//                        System.out.println("Enter User ID");
//                        Integer uuid=sc.nextInt();
//                        System.out.println("Enter the Username:");
//                        String aaname = sc.next();
//                        System.out.println("Enter the Password:");
//                        String aapswd = sc.next();
                        admin.addusers();

                    }
                    break;
            }
        }while (ch!=0);
    }

    public int getUserInput() throws NumberFormatException {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }
    private String getStringInput() {
        Scanner in = new Scanner (System.in);
        s=in.nextLine();
        return s;
    }
    private Double getDoubleInput() {
        Scanner in = new Scanner (System.in);
        d=in.nextDouble();
        return d;
    }

}

