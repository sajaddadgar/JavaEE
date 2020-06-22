package model;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
public class PersonDA extends GenericDA {


    public void insert(Person person) throws Exception{

        PreparedStatement preparedStatement = getConnection().prepareStatement("insert into person (id) values (?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();


    }

}
