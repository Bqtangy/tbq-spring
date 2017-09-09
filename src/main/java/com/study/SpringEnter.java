package com.study;

import com.study.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的入口
 *
 * Created by Administrator on 2017/8/20.
 */
public class SpringEnter {

    public static void main(String[] args) {

        ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");

        System.out.println("获取用户的姓名："+user.getUserName());

    }
}
