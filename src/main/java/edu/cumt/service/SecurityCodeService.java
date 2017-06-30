package edu.cumt.service;

import javax.servlet.http.Cookie;

public class SecurityCodeService {
	public static boolean codeIsTrue(String securitycode,Cookie[] cookies){
		Cookie ck = null;
		for (Cookie cookie : cookies) {
			if("code".equals(cookie.getName())){
				ck = cookie;		//如果存在code，将ck指向cookie
			}
		}
		System.out.println(securitycode+":"+ck.getValue());
		if(ck==null || !(securitycode.equalsIgnoreCase(ck.getValue()))){
			return false;
		}
		return true;
	}
}
