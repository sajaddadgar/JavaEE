package model;


public class PersonManager {

    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void a(){
        System.out.println("aaaaaaaaaa");
        document.send();
    }
}
