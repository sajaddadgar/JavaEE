package model.service;

import model.common.ManagerProvider;
import model.entity.Car;
import model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonService {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        register2();

    }

    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person1 = new Person();
        person1.setName("sajad");
        person1.setFamily("dadgar");
        List<Car> sajadParking = new ArrayList<>();
        Car car1 = new Car();
        car1.setModel("BMW");
        Car car2 = new Car();
        car2.setModel("lamborgini");
        Car car3 = new Car();
        car3.setModel("pride");
        sajadParking.add(car1);
        sajadParking.add(car2);
        sajadParking.add(car3);
        person1.setCarList(sajadParking);

        entityManager.persist(person1);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void register2(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person1 = new Person();
        person1.setName("mohammad");
        person1.setFamily("shirzad");
        Car car1 = (Car) entityManager.createQuery("select o from Car o where o.model='BMW'").getSingleResult();
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        person1.setCarList(carList);

        entityManager.persist(person1);

        entityTransaction.commit();
        entityManager.close();

    }

}
