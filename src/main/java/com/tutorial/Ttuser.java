//$Id$
package com.tutorial;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="User")
public class Ttuser {
    private String id;
    private String name;
    private String password;
    public String getId() {
        return id;
    }
   
    @XmlElement
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
   
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

	public String getPassword() {
		return password;
	}
	 @XmlElement
	public void setPassword(String password) {
		this.password = password;
	}
    
}