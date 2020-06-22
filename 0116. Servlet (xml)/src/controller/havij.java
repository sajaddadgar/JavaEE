package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class havij extends HttpServlet {

    /*public String name="";*/

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("p1"));
        System.out.println(config.getServletContext().getInitParameter("jj"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*name = name+"<br/>"+req.getParameter("name");
        resp.getWriter().print(name);*/

        System.out.println(req.getParameter("name") + "->" + req.getPathInfo());
        resp.getWriter().print("OK");
        System.out.println("SERVICE()");

    }

    @Override
    public void destroy() {

    }
}
