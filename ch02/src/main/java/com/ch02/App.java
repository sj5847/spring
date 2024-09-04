package com.ch02;

import com.ch02.config.AppConfig;
import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import com.ch02.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2장 Spring IoC/DI 실습
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //스프링 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //빈 가져오기
        Hello hello = context.getBean(Hello.class);
        hello.show();

        Welcome welcome = (Welcome)context.getBean("welcome");
        welcome.show();

        Greeting greeting = (Greeting)context.getBean("greet");
        greeting.show();


        //IoC/DI
        Computer com = (Computer) context.getBean("com");//등록한 빈이름으로 설정해줘야 함
        com.show();


    }
}
