package com.sam.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.miaosha.domain.MiaoshaUser;
import com.sam.miaosha.result.Result;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/info")
	@ResponseBody
	public Result<MiaoshaUser> info(MiaoshaUser user ) {
		
		return Result.success(user);
	}

}
