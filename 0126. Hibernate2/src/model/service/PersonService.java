package model.service;

import model.common.ManagerProvider;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Locale;

public class PersonService {

    public static void main(String[] args) {

        // jpql -> createQuery , behtarin query bara orm framework
        // sql -> createNativeQuery


        Locale.setDefault(Locale.ENGLISH);
        selectAllByJPQL();

    }

    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("sajad");
        person.setFamily("dadgar");

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void findOne(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        Person person = entityManager.find(Person.class, 1L);
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getFamily());
        entityManager.close();

    }

    public static void delete(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = entityManager.find(Person.class, 1L);
        entityManager.remove(person);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void change(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = entityManager.find(Person.class, 2L);
        person.setName("bahar");
        //person.setFamily("dadgari");

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void selectAllBySQL(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from person where name like '%'", Person.class);
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getName());
        }
    }

    public static void selectAllBySQLAndParram(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from person where name like :s1 or family = :s2", Person.class);
        query.setParameter("s1", "%saj%");
        query.setParameter("s2", "%adg%");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getName());
        }
    }

    public static void selectAllByJPQL(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        Query query = entityManager.createQuery("select p from Person p where p.name like '%'");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getName());
        }

    }

}
