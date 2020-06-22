package model;


import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
public class CarDA extends GenericDA{


    public void insert(Car car) throws Exception{

        PreparedStatement preparedStatement = getConnection().prepareStatement("insert into car (id) values (?)");
        preparedStatement.setLong(1, car.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

}
