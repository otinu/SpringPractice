package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "form";
	}
	
	@PostMapping("/confirm")
	public String confirm(@RequestParam String message, Model model) {
		model.addAttribute("message", message);
		System.out.println("移動しました");
		return "confirm";
	}
}
