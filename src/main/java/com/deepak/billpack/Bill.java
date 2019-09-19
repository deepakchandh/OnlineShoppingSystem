//$Id$
package com.deepak.billpack;

import java.sql.Time;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Bill {

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
	@Override
	public String toString() {
		return "Bill [bid=" + bid + ", uid=" + uid + ", mop=" + mop + ", totalprice=" + totalprice + ", date=" + date
				+ ", time=" + time + "]";
	}
	
	
}
