package amirkabir.controller;

import amirkabir.model.entity.Car;
import amirkabir.model.entity.Person;
import amirkabir.model.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/register")
    @ResponseBody
    public Object register(@ModelAttribute Person person, @ModelAttribute Car car){
        carService.save(person, car);
        return car;
    }

    @RequestMapping("/change")
    @ResponseBody
    public Object change(@ModelAttribute Car car){
        carService.update(car);
        return car;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Object remove(@ModelAttribute Car car){
        carService.remove(car);
        return car;
    }

}
