package com.cafe24.pjshop.frontend.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping({"", "/main"})
	public String adminMain() {
		return "admin/index";
	}
	
	@RequestMapping({"/login"})
	public String adminLogin() {
		return "admin/login";
	}
	
	@RequestMapping({"/register"})
	public String adminRegister() {
		return "admin/register";
	}
	
	@RequestMapping({"/forgot/password"})
	public String adminForgotPassword() {
		return "admin/forgot-password";
	}
	
	@RequestMapping({"/error"})
	public String adminError() {
		return "admin/404";
	}
	
	@RequestMapping({"/blank"})
	public String adminBlank() {
		return "admin/blank";
	}
	
	@RequestMapping({"/charts"})
	public String adminCharts() {
		return "admin/charts";
	}
	
	@RequestMapping({"/tables"})
	public String adminTable() {
		return "admin/tables";
	}
	
	
}
