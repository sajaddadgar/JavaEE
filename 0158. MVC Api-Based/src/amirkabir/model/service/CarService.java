package amirkabir.model.service;

import amirkabir.model.entity.Car;
import amirkabir.model.entity.Person;
import amirkabir.model.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    @Autowired
    GenericRepository<Car> genericRepository;

    @Transactional
    public void save(Person person, Car car){
        person.getCarList().add(car);
        PersonService personService = new PersonService();
        personService.save(person);
    }

    @Transactional
    public void update(Car car){
        Car dbCar = genericRepository.selectOne(car.getId(), Car.class);
        dbCar.setModel(car.getModel());
        genericRepository.update(dbCar);
    }

    @Transactional
    public void remove(Car car){
        genericRepository.delete(car.getId(), Car.class);
    }

}
