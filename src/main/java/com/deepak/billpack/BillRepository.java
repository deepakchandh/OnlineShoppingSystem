//$Id$
package com.deepak.billpack;

import onlineproj.user;

public class BillRepository {
		
	user uss= new user();
		public void billproducts(int uid) {
			uss.billprods(uid, "cash");
		}
}
