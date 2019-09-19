//$Id$
package com.deepak.sellerpack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Seller {

	private int sid=0;
	private String sname;
	private String password;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sname=" + sname + ", password=" + password + "]";
	}
	
	
}
