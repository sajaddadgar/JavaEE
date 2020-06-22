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

    // az anotation @RequestParam ziad estefade nemikonam
    // be jash az anotation @ModelAttribute estefade konnnnnnnnnnn awlieee :
    // az url migire name o family o id va ye object az person misaze khod spring oona set mikone ru in va object ro be shoma tahvil mide
    // pas dg lazem nist ke request.getparameter koni va...

    @RequestMapping("/get")
    public void getCookie(@ModelAttribute Person person, HttpServletRequest request, HttpServletResponse response){

        try {
            response.getWriter().print(person.getId() + " ");
            response.getWriter().print(person.getName() + " ");
            response.getWriter().print(person.getFamily() + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
