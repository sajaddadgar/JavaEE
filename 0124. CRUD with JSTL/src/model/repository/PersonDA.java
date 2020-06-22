package model.repository;

import model.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonDA {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA()throws Exception{

        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sajadba1", "java123");
        connection.setAutoCommit(false);

    }

    public List<Person> select() throws Exception{

        preparedStatement = connection.prepareStatement("select * from person");
        List<Person> personList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Person person = new Person(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("family"));
            personList.add(person);
        }
        return personList;
    }

    public void insert(Person person) throws Exception{

        preparedStatement = connection.prepareStatement("select person_seq.nextval nid from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("nid"));
        preparedStatement = connection.prepareStatement("insert into person (id, name, family) values (?, ?, ?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.executeUpdate();

    }

    public void update(Person person) throws Exception{

        preparedStatement = connection.prepareStatement("update person set name=?, family=? where id=?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setLong(3, person.getId());
        preparedStatement.executeUpdate();

    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from person where id=?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public void close()throws Exception{
        connection.commit();
        preparedStatement.close();
        connection.close();
    }
}
