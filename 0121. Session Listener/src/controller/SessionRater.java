package controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionRater implements HttpSessionListener {

    public static int visited;
    public static int online;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("yeki oomad ba session id: " + httpSessionEvent.getSession().getId());
        online++;
        visited++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        System.out.println("yeki raft ba session id: " + httpSessionEvent.getSession().getId());
        online--;
    }
}
