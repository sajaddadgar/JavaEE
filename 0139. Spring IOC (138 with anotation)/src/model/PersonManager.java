package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PersonManager {

    /*@Autowired*/
    @Inject
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void a(){
        System.out.println("aaaaaaaaa");
        document.send();
    }
}
