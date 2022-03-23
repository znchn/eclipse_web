package com.znchn.util;

import javax.servlet.http.Cookie;

public class CookieUtil {

	public static Cookie getCookieByName(Cookie[] cookies, String name) {
		if(cookies != null && name != null) {
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
}
