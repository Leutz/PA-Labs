package docmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private List<Document> entries = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public void addDocument(Document document){
        document.assignID(entries.size()+1);
        entries.add(document);
    }

    public void removeEntryByName(String name){
        entries.removeIf(e -> e.getName().equals(name));
        resetIDs();
    }

    public void removeEntryByID(int ID){
        entries.removeIf(e -> e.getID() == ID);
        resetIDs();
    }

    public String getName() {
        return name;
    }

    public void viewAll(){
        for (Document doc : entries){
            doc.view();
        }
    }

    private void resetIDs(){
        for (Document doc: entries){
            doc.assignID(entries.indexOf(doc));
        }
    }
}
