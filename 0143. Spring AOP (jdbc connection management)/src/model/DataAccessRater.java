package model;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

@Aspect
public class DataAccessRater {

    private String driver, url, username, password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Around("execution(* model.*.*(..))")
    public void execute(ProceedingJoinPoint point) throws Throwable {

        // polymorphism: pedar ro migire ke vabastegi nadashte bashe
        // pas genericDA ya personDA ast ya carDA
        GenericDA genericDA = (GenericDA) point.getTarget();
        Class.forName(driver);
        genericDA.setConnection(DriverManager.getConnection(url, username, password));
        point.proceed();
        /*genericDA.getConnection().commit();*/
        genericDA.getConnection().close();

    }

}
