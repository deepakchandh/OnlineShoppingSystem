//$Id$
package com.deepak.productspack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private Integer pid=0;
	private String pname;
	private Integer price=0;
	private Integer stock=0;
	private Integer sid=0;
	private Integer noofusers=0;
	private Integer prating=0;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getNoofusers() {
		return noofusers;
	}
	public void setNoofusers(Integer noofusers) {
		this.noofusers = noofusers;
	}
	public Integer getPrating() {
		return prating;
	}
	public void setPrating(Integer prating) {
		this.prating = prating;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", stock=" + stock + ", sid=" + sid
				+ ", noofusers=" + noofusers + ", prating=" + prating + "]";
	}
	
}
