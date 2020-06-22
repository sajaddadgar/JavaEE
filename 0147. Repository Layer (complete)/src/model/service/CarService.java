package model.service;


import model.entity.Car;
import model.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    GenericRepository<Car> genericRepository;

    @Transactional
    public void register(Car car){
        genericRepository.save(car);
    }

    public void update(Car car){
        genericRepository.update(car);
    }

    public void remove(long id){
        genericRepository.delete(id, Car.class);
    }

    public Car findOne(long id){
        return genericRepository.selectOne(id, Car.class);
    }

    public List<Car> findAll(){
        return genericRepository.selectAll(Car.class);
    }

}
