package controller;

import model.entity.Person;
import model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Change extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person().setId(Long.parseLong(req.getParameter("id"))).setName(req.getParameter("name"))
                .setFamily(req.getParameter("family"));

        try {
            PersonService.getInstance().change(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/getAll.do");
    }
}
