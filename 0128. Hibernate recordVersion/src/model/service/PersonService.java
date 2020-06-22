package model.service;

import model.common.ManagerProvider;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Locale;

public class PersonService {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        //insertWithVersion();
        updateVersion();

    }


    public static void insertWithVersion(){

        // 1
        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("sajad");

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void updateVersion(){

        // 2
        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setId(1);
        person.setName("reza");
        // age 2 bar update konim exception mide chon record version avaz shode
        // dar surati ke bekhad update beshe bayad record version ham avaz beshe va mosavi record version database beshe
        person.setRecordVersion(2);

        // merge -> update mikone va farghesh ba update mamuli dar in ast ke niaz be find nadare
        // va detach exception nemide
        // badish ine ke age ma ye field dgE dashte bashim va oon field ro set nakonim oon field null mikhabe ro database
        entityManager.merge(person);


        entityTransaction.commit();
        entityManager.close();

    }


}
