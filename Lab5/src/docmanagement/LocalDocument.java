package docmanagement;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class LocalDocument implements Serializable, Document {
    private DocumentType documentType;
    private File file;
    private int ID;
    private String name;

    public LocalDocument(DocumentType documentType, String path, String name) {
        this.documentType = documentType;

        this.file = new File(path);
        this.name = name;
    }

    @Override
    public void view(){

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void assignID(int id){
        ID = id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getID(){
        return ID;
    }

    @Override
    public String toString() {
        return "LocalDocument: " +
                "ID = " + ID +
                ", name= '" + name + '\'' ;
    }


}
