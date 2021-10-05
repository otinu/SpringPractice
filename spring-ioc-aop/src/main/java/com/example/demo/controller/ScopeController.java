package com.example.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

@Scope("request")
// Beanのスコープを指定する事が可能。
// @Scope("request")とすると、HTTPリクエスト毎にBeanが生成される。
// その他、sessionなど色々な指定方法の一覧は60%のところに記載あり。

@RequiredArgsConstructor
@Controller
public class ScopeController {

    private final CoffeeRepository repository;

    @GetMapping("/scope")
    public String showList(Model model) {
        model.addAttribute("toString", this.toString());
        model.addAttribute("allCoffee", repository.findAll());
        return "index";
    }
}
