package tehran;

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
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sajad", "java123");
        connection.setAutoCommit(false);
    }

    public void insert(Person person) throws Exception{

        preparedStatement = connection.prepareStatement("insert into person (id, name, family) values (person_seq.nextval, ?, ?)");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.executeUpdate();

    }

    public List<Person> select()throws Exception{

        preparedStatement = connection.prepareStatement("select * from person");
        List<Person> personList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            Person person = new Person();
            person.setName(resultSet.getString("NAME"));
            person.setFamily(resultSet.getString("FAMILY"));
            personList.add(person);
        }
        return personList;
    }

    public void close()throws Exception{

        connection.commit();
        preparedStatement.close();
        connection.close();

    }

}
