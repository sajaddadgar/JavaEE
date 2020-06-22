package amirkabir.model.service;

import amirkabir.model.entity.Car;
import amirkabir.model.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CarService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(long personId, Car car){
        Person person = entityManager.find(Person.class, personId);
        person.getCarList().add(car);
        entityManager.persist(person);
    }

    @Transactional
    public void update(Car car){
        Car dbCar = entityManager.find(Car.class, car.getId());
        dbCar.setModel(car.getModel());
        entityManager.merge(dbCar);
    }

    @Transactional
    public void delete(Car car){
        car = entityManager.find(Car.class, car.getId());
        entityManager.remove(car);
    }

}
