package onlineproj;

import java.sql.Connection;

public interface UserInter {
    public Connection connect();
    public void showcart(int uid);
    public void displayStoreProducts();
    public void orderhis(int uid);
    public int gettpricee(int pid);
    public int gettpricecart(int pid);
    public  boolean checkifpresent(int pid);
    public  boolean checkifpresentincart(int pid);
    public  int noofuser(int pid);
    public void incremusercnt(Integer pid );
    public void addtocart(int uid);
    public int getcartquan(int pid,int uid);
    public void decremusercnt(Integer pid );
    public void removprodfromcart(int uid);
    public void deliveryaddress(int uid);
    public void wishlist(int uid);
   // public int totalprice(int uid);
    public void userdetails(int uid);
    public void usercredentials(String uname, String pswd);

}
