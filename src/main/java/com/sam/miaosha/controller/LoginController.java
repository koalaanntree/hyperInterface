package com.sam.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sam.miaosha.result.Result;
import com.sam.miaosha.service.MiaoshaUserService;
import com.sam.miaosha.vo.LoginVO;

/**
 * 
 * @author huangxin
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MiaoshaUserService userService;

	@RequestMapping("/to_login")
	public String toLogin(){
		return "login";
	}
	
	
	@RequestMapping("/do_login")
	@ResponseBody
	public Result<String> doLogin(HttpServletResponse response,@Valid LoginVO loginVO){
		log.info(loginVO.toString());
		//登录
		String token = userService.login(response,loginVO);
		return Result.success(token);
	}
	
}
