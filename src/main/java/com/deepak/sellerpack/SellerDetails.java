//$Id$
package com.deepak.sellerpack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SellerDetails {

	private int sid=0;
	private int asid=0;
	private int pincode=0;
	private String address;
	private String phoneno;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getAsid() {
		return asid;
	}
	public void setAsid(int asid) {
		this.asid = asid;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "SellerDetails [sid=" + sid + ", asid=" + asid + ", pincode=" + pincode + ", address=" + address
				+ ", phoneno=" + phoneno + "]";
	}
	
	
	
}
