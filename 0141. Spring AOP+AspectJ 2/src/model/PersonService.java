package model;

import org.springframework.stereotype.Component;

@Component
public class PersonService {

    public String a(){
        System.out.println("aaaa");
        return "a>>>";
    }

    public String b(){
        System.out.println("bbbb");
        return "b>>>";
    }

}
