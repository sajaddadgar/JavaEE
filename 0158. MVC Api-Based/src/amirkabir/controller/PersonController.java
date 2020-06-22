package amirkabir.controller;

import amirkabir.model.entity.Car;
import amirkabir.model.entity.Person;
import amirkabir.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/register")
    @ResponseBody
    public Object register(@ModelAttribute Person person){
        personService.save(person);
        return person;
    }

    @RequestMapping("/change")
    @ResponseBody
    public Object change(@ModelAttribute Person person){
        personService.update(person);
        return person;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Object remove(@ModelAttribute Person person){
        personService.remove(person);
        return person;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Object getOne(@ModelAttribute Person person){
        return personService.getOne(person);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Object getAll(){
        return personService.getAll();
    }

}
