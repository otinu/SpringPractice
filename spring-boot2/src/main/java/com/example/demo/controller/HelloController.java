package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
	
	@GetMapping("/")
	public String greeting() {
		return "hello";
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam("message") String message, Model model) {
		model.addAttribute("sample", message);
		return "hello";
	}
}
