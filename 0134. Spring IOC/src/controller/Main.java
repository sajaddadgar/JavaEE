package controller;

import model.PersonManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext iocContainer = new ClassPathXmlApplicationContext("spring.xml");
        PersonManager personManager = (PersonManager) iocContainer.getBean("x");

        personManager.a();

    }
}
