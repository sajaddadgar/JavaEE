package model.service;

import model.entity.Person;

import java.rmi.Remote;
import java.util.List;

public interface PersonService extends Remote {

    List<Person> getAll() throws Exception;
    void register(Person person) throws Exception;
    void change(Person person)throws Exception;
    void remove(long id) throws Exception;

}
