package model;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class PersonDA extends GenericDA{

    public void insert(Person person) throws SQLException {

        PreparedStatement preparedStatement = getConnection().prepareStatement("insert into person (id) values (?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

}
