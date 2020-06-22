package amirkabir.model.service;

import amirkabir.model.entity.Person;
import amirkabir.model.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    GenericRepository<Person> genericRepository;

    @Transactional
    public void save(Person person){
        genericRepository.insert(person);
    }

    @Transactional
    public void update(Person person){
        Person dbPerson = genericRepository.selectOne(person.getId(), Person.class);
        dbPerson.setName(person.getName());
        dbPerson.setFamily(person.getFamily());
        genericRepository.update(dbPerson);
    }

    @Transactional
    public void remove(Person person){
        genericRepository.delete(person.getId(), Person.class);
    }

    public Person getOne(Person person){
        return genericRepository.selectOne(person.getId(), Person.class);
    }

    public List<Person> getAll(){
        return genericRepository.selectAll(Person.class);
    }

}
