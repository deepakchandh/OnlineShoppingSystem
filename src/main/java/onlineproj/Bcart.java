package onlineproj;

public class Bcart {
    private int uid=0;
    private int pid=0;
    private int quantity=0;
    private int price=0;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public class BcartBuilder{
        private int uid=0;
        private int pid=0;
        private int quantity=0;
        private int price=0;

        public BcartBuilder setUid(int uid){
            this.uid=uid;
            return this;
        }
        public BcartBuilder setPid(int pid){
            this.pid=pid;
            return this;
        }

        public BcartBuilder setQuantity(int quantity){
            this.quantity=quantity;
            return this;
        }
        public BcartBuilder setPrice(int price){
            this.price=price;
            return this;
        }


        public int getPid() {
            return pid;
        }

        public int getUid() {
            return uid;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getPrice() {
            return price;
        }
    }

    @Override
    public String toString() {
        return getPid()+" "+getUid()+" "+getPrice()+" "+getQuantity();
    }
}
