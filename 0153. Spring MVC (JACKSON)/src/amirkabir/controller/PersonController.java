package amirkabir.controller;

import amirkabir.model.entity.Car;
import amirkabir.model.entity.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/person")
/*@Scope("prototype")*/        // be ezaye har darkhast kardan (farghes ba request ine ke tu request setAttribute ham mishe)*
/*@Scope("singletone")*/     // faghat ye dune dar tul barname (beyn hame karbara yekie)**
/*@Scope("request")*/       // be ezaye har request
@Scope("session")          // be ezaye har session
public class PersonController {

    public PersonController(){
        System.out.println("PS!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public Object getParam(HttpServletRequest request, HttpServletResponse response){

        // age nakhaym car ro tu json nayare tu class 'person' balaye car bayad anotation @JsonIgnore bezarim

        List<Person> personList = Arrays.asList(
                new Person(1, "sajad", "dadgar", new Car("bmw")),
                 new Person(2, "mohammad", "shirzad", new Car("benz"))
        );

        return personList;
    }
}
