package model.service;

import model.common.ManagerProvider;
import model.entity.Car;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Locale;

public class PersonService {

    public static void main(String[] args) {

        register();

    }


    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("sajad");
        person.setFamily("dadgar");
        Car car = new Car();
        car.setModel("Lamborgini");
        person.setCar(car);

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();

    }

}
