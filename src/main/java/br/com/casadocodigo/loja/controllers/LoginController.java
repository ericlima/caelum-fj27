package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login/form";
	}
	
	@RequestMapping("/login2")
	public String login2() {
		return "login/form";
	}
}
