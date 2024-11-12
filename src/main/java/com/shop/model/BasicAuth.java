package com.shop.model;
import java.util.Base64;

public class BasicAuth {
	private  String user;

	public BasicAuth(String user) {
		this.user = user;
	}
	public BasicAuth(){}
	
	public String encode(String user) {
		String encodedUser = Base64.getEncoder().encodeToString(user.getBytes());
		return encodedUser;
	}
	public String decode(String users) {
		byte[] decode = Base64.getDecoder().decode(users);
		String decodedUser = new String(decode);
		return decodedUser;
	}
	
}
