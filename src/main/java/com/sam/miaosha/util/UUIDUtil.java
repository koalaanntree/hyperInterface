package com.sam.miaosha.util;

import java.util.UUID;

/**
 * 
 * @author huangxin
 *
 */
public class UUIDUtil {
	
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
