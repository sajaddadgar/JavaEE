package model.service;

import model.common.ManagerProvider;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Locale;

public class PersonService {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        register();
    }

    public static void register(){

        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AMIRKABIR");
        EntityManager entityManager = entityManagerFactory.createEntityManager();*/
        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("Sajad");
        person.setFamily("Dadgar");

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();


    }


}
