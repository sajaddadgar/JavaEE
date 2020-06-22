package model.service;

import model.entity.Person;
import model.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    GenericRepository<Person> genericRepository;

    @Transactional
    public void register(Person person){
        genericRepository.save(person);
    }

    public void update(Person person){
        genericRepository.update(person);
    }

    public void remove(long id){
        genericRepository.delete(id, Person.class);
    }

    public Person findOne(long id){
        return genericRepository.selectOne(id, Person.class);
    }

    public List<Person> findAll(){
        return genericRepository.selectAll(Person.class);
    }
}
