package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Controller
public class CommentController {

    private final CommentRepository repository;

    //@Autowired ← コンストラクタが１つの場合、@Autowiredは省略できます
    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getAllComments(@ModelAttribute Comment comment,
            Model model) {

        model.addAttribute("comments", repository.findAll());	//findAll()メソッドはJpaRepositoryによる機能。データを全件取得する。
        return "list";
    }

    @PostMapping("/add")
    public String addComment(@Validated @ModelAttribute Comment comment,	//モデルにバリデーションの設定がされている。
            BindingResult result, Model model) {

        model.addAttribute("comments", repository.findAll()); //listファイルでは必ずテーブル内の全カラムを表示するから、この一行は必須
        if (result.hasErrors()) {
            return "list";
        }
        
        // formから送られてきた内容をCommentモデル(クラス)のローカル変数commentとして受け取り、CommentRepositoryインタフェースを活用してDB内に保存する
        
        repository.save(comment);	//save(object)メソッドはJpaRepositoryによる機能。データを保存する。	

        // ルートパス("/")に、リダイレクトします
        return "redirect:/";
    }
}
