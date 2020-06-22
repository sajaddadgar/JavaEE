package amirkabir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {

    // multiAction
    @RequestMapping("/insert/{name}")
    // dynamic path not parameter
    public void insert(@PathVariable("name")String x, @RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response){
        try {
            response.getWriter().print("i'm insert " + x + " this is parameter: "+id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getAll")
    public void getAll(HttpServletRequest request, HttpServletResponse response){

        try {
            response.getWriter().print("i'm getAll");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
