package model.service;

import model.common.ManagerProvider;
import model.entity.Car;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

public class PersonService {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        getAll();
    }


    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        /*Person person = new Person();
        person.setName("sajad");
        person.setFamily("dadgar");
        Car car = new Car();
        car.setModel("BMW");
        person.setCar(car);*/
        Person person = new Person();
        Car car = entityManager.find(Car.class, 2l);
        person.setName("bahar");
        person.setFamily("dadgar");
        person.setCar(car);

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();


    }

    public static void getAll(){

        EntityManager entityManager = ManagerProvider.getEntityManager();

        Query query = entityManager.createQuery("select p from Person p");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
            System.out.println(person.getCar().getId());
            System.out.println(person.getCar().getModel());
            System.out.println("-------");
        }

        entityManager.close();
    }
}
