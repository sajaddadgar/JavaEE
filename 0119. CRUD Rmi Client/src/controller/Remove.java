package controller;

import model.service.PersonService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Remove extends HttpServlet {

    private PersonService personService;

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            personService = (PersonService) Naming.lookup(config.getServletContext().getInitParameter("server"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            personService.remove(Long.parseLong(req.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/getAll.do");

    }
}
