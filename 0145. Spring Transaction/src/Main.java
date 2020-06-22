import model.entity.Person;
import model.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-servlet.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");

        Person person = new Person("sajad");
        personService.insert(person);

        /*List<Person> personList = personService.getAll();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
        }*/

    }
}
