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

        getAll();
    }


    public static void register(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        /*person.setName("sajad");
        person.setFamily("dadgar");
        List<Car> parking = new ArrayList<>();
        Car car1 = new Car();
        car1.setModel("BMW");
        Car car2 = new Car();
        car2.setModel("Lamborgini");

        parking.add(car1);
        parking.add(car2);

        person.setCarList(parking);

        entityManager.persist(person);*/

        entityTransaction.commit();
        entityManager.close();

    }

    public static void getAll(){

        EntityManager entityManager = ManagerProvider.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        //select o from person o where o.car.id =>one2one and many2one
        // chon chand ta car darim nemitunim mesl bala select begirim, dar in surat darim:
        // select o from person o join fetch o.carList c where c.id=2 => OneToMany and ManyToMany
        Person person =
                (Person) entityManager.createQuery("select o from Person o join fetch o.carList c where c.id=2").getSingleResult();


        entityTransaction.commit();
        entityManager.close();

        System.out.println(person.getName());
        System.out.println(person.getFamily());
        for (Car car : person.getCarList()) {

            System.out.println(car.getModel());

        }


    }

}
