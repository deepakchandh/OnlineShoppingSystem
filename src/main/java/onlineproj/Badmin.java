package onlineproj;

public class Badmin {
    private int uid=0;
    private int pid=0;
    private String date1;
    private String date2;
    private String mop;

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

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

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public class BadminBuilder{
        private int uid=0;
        private int pid=0;
        private String date1;
        private String date2;
        private String mop;

        public BadminBuilder setUid(int uid) {
            this.uid = uid;
            return this;
        }

        public BadminBuilder setPid(int pid) {
            this.pid = pid;
            return this;
        }

        public BadminBuilder setDate1(String date1) {
            this.date1 = date1;
            return this;
        }

        public BadminBuilder setDate2(String date2) {
            this.date2 = date2;
            return this;
        }

        public String getMop() {
            return mop;
        }

        public BadminBuilder setMop(String mop) {
            this.mop = mop;
            return this;
        }

        public int getUid() {
            return uid;
        }

        public int getPid() {
            return pid;
        }

        public String getDate1() {
            return date1;
        }

        public String getDate2() {
            return date2;
        }
    }
}
