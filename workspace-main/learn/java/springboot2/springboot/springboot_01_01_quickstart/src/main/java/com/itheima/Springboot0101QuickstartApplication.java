package com.itheima;

import com.itheima.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        BookController bean1 = ctx.getBean(BookController.class);
        User bean2 = ctx.getBean(User.class);
        System.out.println(bean1);
        System.out.println(bean2);
    }

}
