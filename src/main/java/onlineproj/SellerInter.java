package onlineproj;

import java.sql.Connection;

public interface SellerInter {
    public Connection connect();
    public void addprod(int sid);
    public void remprod(int sid);
    public  boolean sellerbelongs(int pid,int sid);
    public void modifyproducts(int sid);
    public void selldetails(int sid);
    public void sellcredential(String uname,String pswd);

}
