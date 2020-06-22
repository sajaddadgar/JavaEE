import model.entity.Car;
import model.entity.Person;
import model.service.CarService;
import model.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.ENGLISH);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-servlet.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");


        Person person = new Person();
        person.setName("sajad");
        person.setFamily("dadgar");
        List<Car> parking = new ArrayList<>();
        Car car1 = new Car("benz");
        Car car2 = new Car("Bmw");
        Car car3 = new Car("lamborgini");
        parking.add(car1);
        parking.add(car2);
        parking.add(car3);

        person.setCar(parking);

        personService.register(person);

    }
}
