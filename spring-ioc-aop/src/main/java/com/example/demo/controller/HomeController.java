package com.example.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

// このコントローラは@Scope の指定をしていないため、デフォルトのsingleton がスコープに設定されている。
// singletonの場合、1つのインスタンスを共有する。このため、ブラウザをリロードしてもブラウザに表示されるオブジェクトの値が変わらない

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ApplicationContext appContext;

    @GetMapping("/")
    public String showList(Model model) {

        //getBean("bean名") でIoCコンテナからBeanを取得。IoCコンテナに登録されているbean名は【先頭が小文字】
        //coffeeRepositoryインタフェースのおかげで、DB接続できる。 おそらく、下記のコードはDBからオブジェクトを取得してる

        CoffeeRepository repository = (CoffeeRepository)appContext.getBean("coffeeRepository");	

        model.addAttribute("toString", this.toString());
        model.addAttribute("allCoffee", repository.findAll());
        return "index";
    }
}
