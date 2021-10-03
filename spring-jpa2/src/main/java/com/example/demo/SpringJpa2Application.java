package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//「@Configuration、@EnableAutoConfiguration,@ComponentScan」の３つのアノテーションを使用するのと同等
@SpringBootApplication 

/*
 * @Configuration・・・設定（構成）クラスであることを示します。
 * @EnableAutoConfiguration・・・自動構成機能を有効にします。必要となる設定を、推測て構成しようとします。
 * @ComponentScan・・・コンポーネントスキャンを有効にします。 これは、対象クラスをスキャンし、利用可能にする機能です。（対象は何個かありますが、主なもので言うと@Componet、@Controller、@Service、@Repositoryなどです）
 */

public class SpringJpa2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpa2Application.class, args);
	}

}
