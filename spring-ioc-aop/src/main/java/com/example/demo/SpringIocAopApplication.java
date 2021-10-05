package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;	//ここで、lombokのslf4jをインポート

@Slf4j
/*
 * @Slf4jは下記のコードを自動生成
 * private static final Logger log = LoggerFactory.getLogger(SpringIocAopApplication.class);
 */

@RequiredArgsConstructor
@SpringBootApplication
public class SpringIocAopApplication implements CommandLineRunner {

    private final ApplicationContext appContext;	//ApplicationContextインタフェースがIoCコンテナを表す

    public static void main(String[] args) {
        SpringApplication.run(SpringIocAopApplication.class, args);	//ここの部分の引数二つの意味がわからない。 一旦、「IoCコンテナを起動するためのお作法」だと捉えておく。
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	//IoCコンテナに管理されるオブジェクトを Bean という。
    	// getBeanDefinitionNamesでIoCコンテナに登録されているBeanを確認できる。
    	
        String[] allBeanNames = appContext.getBeanDefinitionNames();
        
        for (String beanName: allBeanNames) {
            log.info("Bean名: {}", beanName);	//SLF4Jと@slf4j(Lombok)の組み合わせにより、ログ出力
            
            /*　log.info("Bean名: {}", beanName) は下記の記述と同じ
             * 
             * log.info("Bean名: " + beanName);
             * ただし公式ドキュメントによると、+を使った記法よりも{}を使った記法の方がパフォーマンスが30倍も良くなるとのこと。
             * 
             */
        }
    }
}
