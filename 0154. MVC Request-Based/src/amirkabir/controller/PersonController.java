package amirkabir.controller;

import amirkabir.model.entity.Person;
import amirkabir.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
        request.setAttribute("list", personService.selectAll());
        return "index";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute Person person){
        personService.insert(person);
        return "redirect:/person/getAll";
    }

    @RequestMapping("/change")
    public String change(@ModelAttribute Person person){
        personService.update(person);
        return "redirect:/person/getAll";
    }

    @RequestMapping("/remove")
    public String remove(@ModelAttribute Person person){
        personService.delete(person);
        return "redirect:/person/getAll";
    }



}
