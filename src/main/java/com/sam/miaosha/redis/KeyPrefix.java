package com.sam.miaosha.redis;

public interface KeyPrefix {
	
	public int expireSeconds();
	
	public String getPrefix();

}
