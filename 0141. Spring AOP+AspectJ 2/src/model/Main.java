package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");

        System.out.println(personService.a());
        System.out.println(personService.b());

    }
}
