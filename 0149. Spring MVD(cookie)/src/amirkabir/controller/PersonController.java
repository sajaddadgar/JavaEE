package amirkabir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {


    @RequestMapping("/get")
    public void getCookie(@CookieValue("id") String id, HttpServletRequest request, HttpServletResponse response){

        try {
            response.getWriter().print(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/create")
    public void createCookie(HttpServletRequest request, HttpServletResponse response){


        Cookie cookie = new Cookie("id", "1368");
        response.addCookie(cookie);
        try {
            response.getWriter().print("i am create cookie");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/header")
    public void getHeader(@RequestHeader("user-agent") String id, HttpServletRequest request, HttpServletResponse response){

        try {
            response.getWriter().print(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
