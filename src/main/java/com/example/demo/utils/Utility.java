package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static boolean isValidAddress(String addr) {
		String regex = "^0x[a-fA-F0-9]{40}$";

		//System.out.println("Incoming Address " + addr);
		if (addr.matches(regex)) {
			return true;
		}
		return false;
	}

}
