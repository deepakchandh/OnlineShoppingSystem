//$Id$
package com.deepak.userpack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDetails {

	private int uid=0;
	private int aid=0;
	private int pincode=0;
	private String address;
	private String phoneno;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
		return "UserDetails [uid=" + uid + ", aid=" + aid + ", pincode=" + pincode + ", address=" + address
				+ ", phoneno=" + phoneno + "]";
	}
}
