package com.yiibai.springmvc.test;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLCon3 {
	public static String isValid(String strLink) {
		URL url;
		try {
			url = new URL(strLink);
			HttpURLConnection connt = (HttpURLConnection) url.openConnection();
			connt.setRequestMethod("HEAD");
			String strMessage = connt.getResponseMessage();
			System.out.println(strMessage);
			if (strMessage.compareTo("Not Found") == 0) {
				return "false";
			}
			connt.disconnect();
		} catch (Exception e) {
			return "false";
		}
		return "true";
	}

}
