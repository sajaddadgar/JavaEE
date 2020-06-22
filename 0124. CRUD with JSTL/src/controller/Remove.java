package controller;

import model.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Remove extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PersonService.getInstance().remove(Long.parseLong(req.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/getAll.do");

    }
}
