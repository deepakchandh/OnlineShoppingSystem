package onlineproj;

public class Bproducts {
    private int pid=0;
    private String pname;
    private int stock=0;
    private int price=0;
    private int sid=0;
    private int noofusers=0;

    public Bproducts(){

    }
    public Bproducts(int pid,String pname, int stock, int price,int sid, int noofusers){
        this.pid=pid;
        this.pname=pname;
        this.stock=stock;
        this.price=price;
        this.sid=sid;
        this.noofusers=noofusers;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getNoofusers() {
        return noofusers;
    }

    public void setNoofusers(int noofusers) {
        this.noofusers = noofusers;
    }

    public class BproductsBuilder{
        private int pid=0;
        private String pname;
        private int stock=0;
        private int price=0;
        private int sid=0;
        private int noofusers=0;


      public BproductsBuilder setPid(int pid){
        this.pid=pid;
        return this;
      }

        public BproductsBuilder setPname(String pname) {
            this.pname = pname;
            return this;
        }

        public BproductsBuilder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public BproductsBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public BproductsBuilder setSid(int sid) {
            this.sid = sid;
            return this;
        }

        public BproductsBuilder setNoofusers(int noofusers) {
            this.noofusers = noofusers;
            return this;
        }

        public int getPid() {
            return pid;
        }

        public String getPname() {
            return pname;
        }

        public int getStock() {
            return stock;
        }

        public int getPrice() {
            return price;
        }

        public int getSid() {
            return sid;
        }

        public int getNoofusers() {
            return noofusers;
        }

        public Bproducts getdetails(){
          return new Bproducts (pid,pname,stock,price,sid,noofusers);
        }



    }

    @Override
    public String toString() {
        return getPid()+" "+getPname()+" "+getStock()+" "+getPrice()+" "+getSid()+" "+getNoofusers();
    }
}
