package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Two {

    public void ok(String name){
        System.out.println("ok " + name);
    }

}
