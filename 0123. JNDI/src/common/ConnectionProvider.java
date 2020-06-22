package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionProvider {

    private static DataSource dataSource;


    static {

        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/erp");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection()throws Exception{
        return dataSource.getConnection();
    }

}
