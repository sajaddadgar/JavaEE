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

    @RequestMapping(value = "/get")
    // yani na dispatch va na redirect
    // va age return konim chap mikone baraye user
    @ResponseBody
    public String getParam(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){

        return person.toString();

    }
}
