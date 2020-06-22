package model.service;

import model.entity.Person;
import model.repository.PersonDA;

import java.util.List;

public class PersonService {

    private static PersonService personService = new PersonService();
    private PersonService(){}

    public static PersonService getInstance() {
        return personService;
    }

    public List<Person> getAll() throws Exception{
        PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.select();
        personDA.close();
        return personList;
    }

    public void register(Person person)throws Exception{
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();
    }

    public void change(Person person) throws Exception{

        PersonDA personDA = new PersonDA();
        personDA.update(person);
        personDA.close();

    }

    public void remove(long id) throws Exception{

        PersonDA personDA = new PersonDA();
        personDA.delete(id);
        personDA.close();

    }
}
