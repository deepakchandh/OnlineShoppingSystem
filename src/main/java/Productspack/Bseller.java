package Productspack;

public class Bseller {
    private int userid=0;
    private String usname,uemail,passwd;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public class BsellerBuilder{
        private int userid=0;
        private String usname,uemail,passwd;

        public BsellerBuilder setUserid(int userid) {
            this.userid = userid;
            return this;
        }

        public BsellerBuilder setUsname(String usname) {
            this.usname = usname;
            return this;
        }

        public BsellerBuilder setUemail(String uemail) {
            this.uemail = uemail;
            return this;
        }

        public BsellerBuilder setPasswd(String passwd) {
            this.passwd = passwd;
            return this;
        }

        public int getUserid() {
            return userid;
        }

        public String getUsname() {
            return usname;
        }

        public String getUemail() {
            return uemail;
        }

        public String getPasswd() {
            return passwd;
        }
    }
}
