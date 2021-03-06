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

@RequiredArgsConstructor    //ここは今までと違う記述
@SpringBootApplication
public class SpringIocAopApplication implements CommandLineRunner {

    private final ApplicationContext appContext;	//ApplicationContextインタフェースがIoCコンテナを表す

    public static void main(String[] args) {
        SpringApplication.run(SpringIocAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {  //ここで、24行目のrunメソッドをオーバーライドして、オリジナルの処理を実装している。
    	
    	//IoCコンテナに管理されるオブジェクトを Bean という。
    	// ApplicationContextインタフェースのgetBeanDefinitionNamesでIoCコンテナに登録されているBeanを取得できる。
    	
        String[] allBeanNames = appContext.getBeanDefinitionNames();
        
        //そもそも、この章の本筋は「IoCとは何か」を理解する章のため、下記に関するライブラリに深追いする必要はあまりないと思う。

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
