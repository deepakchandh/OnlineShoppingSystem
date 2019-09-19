package onlineproj;


public class Buser {
    private int userid=0;
    private String usname,uemail,passwd;

    public Buser(){

    }
    public Buser(int userid,String usname, String passwd){
        this.userid=userid;
        this.usname=usname;
        this.passwd=passwd;
    }
    public Buser(int userid){
        this.userid=userid;
    }

    public int getUserid() {
        return userid;
    }

    public String getUemail() {
        return uemail;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUsname() {
        return usname;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }


    public class CuserBuilder {
        private int usid=0;
        private String uname,uemail,passwd;

        public CuserBuilder setUsid(int id){
            this.usid=id;
            return this;
        }
        public CuserBuilder setUname(String uname){
            this.uname=uname;
            return this;
        }
        public CuserBuilder setUemail(String uemail){
            this.uemail=uemail;
            return this;
        }

        public CuserBuilder setPasswd(String passwd) {
            this.passwd = passwd;
            return this;
        }

        public int getuserid(){
            return usid;
        }

        public String getUname(){
            return uname;
        }

        public String getUemail(){
            return uemail;
        }
        public String getPasswd(){
            return passwd;
        }

        public Buser getdetails(){
           return new Buser(usid,uname,uemail);
//            return new Buser()
        }


    }

    public void seemydetails(){

    }



    @Override
    public String toString() {
        String t = usname + " " + (userid) + " " + getPasswd();
        return t;
    }



}

