package amirkabir.controller;

import amirkabir.model.entity.Car;
import amirkabir.model.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/register")
    public String register(@RequestParam("personId") long personId, @ModelAttribute Car car){
        carService.insert(personId, car);
        return "redirect:/person/getAll";
    }

    @RequestMapping("/change")
    public String change(@ModelAttribute Car car){
        carService.update(car);
        return "redirect:/person/getAll";
    }

    @RequestMapping("/remove")
    public String remove(@ModelAttribute Car car){
        carService.delete(car);
        return "redirect:/person/getAll";
    }

}
