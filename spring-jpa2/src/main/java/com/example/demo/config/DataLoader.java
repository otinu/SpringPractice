package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;


/*
 * @RequiredArgsConstructorにより下記のコードが生成されるのと同じ
 * 
 * @Component
 * public class DataLoader implements CommandLineRunner {
 * 	private final CommentRepository repository;
 * 
 * public DataLoader(CommentRepository repository) {	//この部分が自動生成
 * 		this.repository = repository;
 * 	}
 * }
 */
@RequiredArgsConstructor	//コンストラクタの自動生成。対象はfinalのフィールド
@Component
public class DataLoader implements CommandLineRunner {	//CommandLineRunnerインタフェースを付けて、runメソッドに処理内容を記載することでターミナル上に処理内容が表示される。application.propertiesにも類似の内容記載ある点に注目

    private final CommentRepository repository;	

    @Override	//ここで、CommentRepositoryをオーバーライドしている(はず)。つまり、コントローラからCommentRepositoryのオブジェクトを呼び出した際、下記のrunメソッドも実行されている(はず)
    
    public void run(String... args) throws Exception {
        Comment comment = new Comment();
        comment.setContent("こんにちは");
        repository.save(comment);

        comment = new Comment();
        comment.setContent("テストコメント");
        repository.save(comment);
    }
}
