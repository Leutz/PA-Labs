package docmanagement;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

public class OnlineDocument implements Serializable, Document {
    private DocumentType documentType;
    private URI url;
    private int ID;
    private String name;

    public OnlineDocument(DocumentType documentType, String url, String name) {
        this.documentType = documentType;

        try {
            this.url = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    @Override
    public void view(){
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
