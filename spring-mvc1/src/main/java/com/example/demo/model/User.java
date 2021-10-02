package com.example.demo.model;

// lombokをインポートしているおかげで、セッターやゲッターの記述は不要
// その他、equals()やcanEqual(),hashCode(),toString()なども生成されている

import lombok.Data;

@Data
public class User {
    private String name;
    private String email;
    private Integer age;
}
