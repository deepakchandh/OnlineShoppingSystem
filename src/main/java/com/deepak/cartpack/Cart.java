//$Id$
package com.deepak.cartpack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {

	private int uid=0;
	private int pid=0;
	private int quan=0;
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
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [uid=" + uid + ", pid=" + pid + ", quan=" + quan + ", price=" + price + "]";
	}
	
	
}
