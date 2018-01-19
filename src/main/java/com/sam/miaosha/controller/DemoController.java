package com.sam.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.miaosha.domain.User;
import com.sam.miaosha.redis.RedisService;
import com.sam.miaosha.redis.UserKey;
import com.sam.miaosha.result.CodeMsg;
import com.sam.miaosha.result.Result;
import com.sam.miaosha.service.UserService;

/**
 * 
 * @author huangxin
 *
 */
@Controller
public class DemoController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RedisService redisService;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "hello world!";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello() {
		return Result.success("hello,sam");
	}
	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloError() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name","sam");
		return "hello";
	}
	@RequestMapping("/db/get")
	@ResponseBody
	public Result<User> dbGet() {
		User user = userService.getById(1);
		
		return Result.success(user);
	}
	
	@RequestMapping("/db/tx")
	@ResponseBody
	public Result<Boolean> dbTx() {
		userService.tx();
		return Result.success(true);
	}
	
	@RequestMapping("/redis/get")
	@ResponseBody
	public Result<User> redisGet() {
		
		User user = redisService.get(UserKey.getById,""+1, User.class);
		
		return Result.success(user);
	}
	
	@RequestMapping("/redis/set")
	@ResponseBody
	public Result<Boolean> redisSet() {
		User user = new User();
		user.setId(1);
		user.setName("111111");
		redisService.set(UserKey.getById,""+1,user);
		return Result.success(true);
	}
	
	
}
