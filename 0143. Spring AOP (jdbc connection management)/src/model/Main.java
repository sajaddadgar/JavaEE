package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        // be barname nevis migi har varght khasti ye data access benivisi bayad ers bebare az GenericDA
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        PersonDA personDA = (PersonDA) applicationContext.getBean("personDA");
        Person person = new Person();
        person.setId(2);
        personDA.insert(person);

    }
}
