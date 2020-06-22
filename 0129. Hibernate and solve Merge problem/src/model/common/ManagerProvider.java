package model.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerProvider {


    private static EntityManagerFactory entityManagerFactory;


    static {

        entityManagerFactory = Persistence.createEntityManagerFactory("AMIRKABIR");

    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
