package model.service;

import model.entity.Person;
import model.repository.PersonDA;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PersonServiceImpl extends UnicastRemoteObject implements PersonService {

    public PersonServiceImpl() throws Exception{}

    @Override
    public List<Person> getAll() throws Exception {
        PersonDA personDA = new PersonDA();
        List<Person> personList = personDA.select();
        personDA.close();
        return personList;
    }

    @Override
    public void register(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();
    }

    @Override
    public void change(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.update(person);
        personDA.close();
    }

    @Override
    public void remove(long id) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.delete(id);
        personDA.close();
    }
}
