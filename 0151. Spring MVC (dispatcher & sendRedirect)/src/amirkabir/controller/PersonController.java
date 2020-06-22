package amirkabir.controller;

import amirkabir.model.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {

    @RequestMapping(value = "/dis")
    public String getParam(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){

        // go to index.jsp by dipatcher
        //request.getRequestDispatcher("/index.jsp").forward(request,response);
        // or
        return "index";
        // "/index.jsp" nemikad chon tu spring.xml goftim ghabl o baadesh chi bashe
    }

    @RequestMapping("/redirect")
    public String getParam2(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){

        // go to index.jsp by sendRedirect
        /*response.sendRedirect("index.jsp");*/
        // or
        return "redirect:/index.jsp";


    }
}
