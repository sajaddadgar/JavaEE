package bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ManagedBean(name = "i") // dar index.xhtml ba name 'i' mishnase va age name nazarim name=class.name (dar inja index)
@ManagedBean // name = index
@RequestScoped // scope
public class index {
    //1

    private String name;
    private String family;
    private String menu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void ok(){
        System.out.println("i am ok " + getName() + " " + getFamily() + " " + getMenu());
    }

    public void cancel(){
        System.out.println("i am cancel " + getName() + " " + getFamily() + " " + getMenu());
    }

    // 2
    public String dispatch(){
        System.out.println("dispatch()");
        return "two"; // dispatch to two
    }

    public String send(){
        System.out.println("send()");
        return "two.xhtml?faces-redirect=true"; // redirect to two
    }

    // 3

    public void getrequestandresponse(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    public void getrequestandresponse2(HttpServletRequest request)
    {
        System.out.println("cancel clicked "+getName()+" "+getFamily());
    }
}
