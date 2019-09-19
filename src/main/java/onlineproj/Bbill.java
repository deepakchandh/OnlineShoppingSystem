package onlineproj;

import java.sql.Time;
import java.util.Date;

public class Bbill {
    private int bid=0;
    private int uid=0;
    private String mop;
    private int totalprice=0;
    private Date date;
    private Time time;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    public class BbillBuilder{
        private int bid=0;
        private int uid=0;
        private String mop;
        private int totalprice=0;
        private Date date;
        private Time time;

        public BbillBuilder setBid(int bid) {
            this.bid = bid;
            return this;
        }

        public BbillBuilder setUid(int uid) {
            this.uid = uid;
            return this;
        }

        public BbillBuilder setMop(String mop) {
            this.mop = mop;
            return this;
        }

        public BbillBuilder setTotalprice(int totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public BbillBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public BbillBuilder setTime(Time time) {
            this.time = time;
            return this;
        }

        public int getBid() {
            return bid;
        }

        public int getUid() {
            return uid;
        }

        public String getMop() {
            return mop;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public Date getDate() {
            return date;
        }

        public Time getTime() {
            return time;
        }
    }
}
