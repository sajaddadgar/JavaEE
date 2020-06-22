package controller;

import model.entity.Person;
import model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAll extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            List<Person> personList = PersonService.getInstance().getAll();
            req.setAttribute("personList", personList);
            req.getRequestDispatcher("person.jsp").forward(req, resp);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
