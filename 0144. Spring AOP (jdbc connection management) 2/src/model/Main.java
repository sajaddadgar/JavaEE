package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        /*PersonDA personDA = (PersonDA) applicationContext.getBean("personDA");
        Person person = new Person();
        person.setId(1);
        personDA.insert(person);*/
        CarDA carDA = (CarDA) applicationContext.getBean("carDA");
        Car car = new Car();
        car.setId(1);
        carDA.insert(car);

    }
}
