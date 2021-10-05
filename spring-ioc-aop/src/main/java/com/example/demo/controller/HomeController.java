package com.example.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ApplicationContext appContext;

    @GetMapping("/")
    public String showList(Model model) {
        CoffeeRepository repository =
                (CoffeeRepository)appContext.getBean("coffeeRepository");	//getBean("bean名") でIoCコンテナからBeanを取得。IoCコンテナに登録されているbean名は【先頭が小文字】
        model.addAttribute("toString", this.toString());
        model.addAttribute("allCoffee", repository.findAll());
        return "index";
    }
}
