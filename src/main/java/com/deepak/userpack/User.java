//$Id$
package com.deepak.userpack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int uid=0;
	private String uname;
	private String password;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}
	
}
