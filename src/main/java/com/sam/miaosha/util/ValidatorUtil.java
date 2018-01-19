package com.sam.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ValidatorUtil {
	
	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
	
	public static boolean isMobile(String src) {
		if (StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher matcher = mobile_pattern.matcher(src);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isMobile("18672388832"));
		System.out.println(isMobile("1867238883"));
	}

}
