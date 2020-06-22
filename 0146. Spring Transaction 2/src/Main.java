import model.entity.Document;
import model.entity.Person;
import model.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-servlet.xml");
        PersonService personService = (PersonService) applicationContext.getBean("personService");

        Person person = new Person("dadgar");
        Document document1 = new Document();
        document1.setContent("hello");
        Document document2 = new Document();
        document2.setContent("bye");
        /*List<Document> documents = Arrays.asList(document1, document2);
        person.setDocument(documents);*/
        List<Document> documents = new ArrayList<>();
        documents.add(document1);
        documents.add(document2);
        person.setDocument(documents);
        personService.insert(person);
        /*List<Person> personList = personService.getAll();
        for (Person person : personList) {
            System.out.println(person.getName());
            for (Document document : person.getDocument()) {
                System.out.println(document.getContent());
            }
        }*/
    }
}