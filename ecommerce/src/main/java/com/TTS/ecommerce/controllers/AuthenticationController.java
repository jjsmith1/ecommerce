package com.TTS.ecommerce.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TTS.ecommerce.Services.UserService;

@Controller
public class AuthenticationController {

	@AutoWired
	private UserService userService;
	
	@GetMapping("signin")
	public String loging() {
		return "signin";

	}

	@PostMapping("/signin")
	public String signup(@Valid User user,
			@RequestParam String submit,
			BindingResult bindingResult,
			HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		if(submit.equals("up")) {
			if(UserService.findbyUsername(user.getUsername()) == null) {
			else {
				bindingResult.rejectValue("username", "errorname", "Username is already taken.");
				return "signin";
			}
			}
			request.login(user.getUsername(), password);
			return "redirect:/";
		}
	}
 

