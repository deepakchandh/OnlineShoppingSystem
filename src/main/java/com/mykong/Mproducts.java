//$Id$
package com.mykong;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mproducts {

	private String name;
	private int qty=0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Mproducts [name=" + name + ", qty=" + qty + "]";
	}
	
}
