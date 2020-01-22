package com.alex.controller.permission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PermissionPageController {
	
	/**
	 * 写所有去页面的请求映射
	 * @return
	 */
	@GetMapping("/user.html")
	public String userPage() {
		
		
		return "permission/user";
	}
	
	/**
	 * 调到role页面的
	 */
	@GetMapping("/role.html")
	public String rolePage() {
		
		return "permission/role";
	}
	
	//
}
