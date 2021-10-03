package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Comment;

//JpaRepositoryを継承(extends)するだけで、DBの取得や保存などが可能になる。
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
