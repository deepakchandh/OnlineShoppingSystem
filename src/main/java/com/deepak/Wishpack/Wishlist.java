//$Id$
package com.deepak.Wishpack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wishlist{
	
private	int uid=0;
private	int pid=0;
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
@Override
public String toString() {
	return "Wishlist [uid=" + uid + ", pid=" + pid + "]";
}
   

}