package docmanagement;

import java.io.*;

public class CatalogExternalOperation {

    public CatalogExternalOperation(){}

    public Catalog load(String name){
        FileInputStream fis = null;
        Catalog catalog;
        try {
            fis = new FileInputStream(name+".cat");
            ObjectInputStream in = new ObjectInputStream(fis);
             catalog = (Catalog)in.readObject();
            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return catalog;
    }

    public void save(Catalog catalog, String name){
        try {
            FileOutputStream fos = new FileOutputStream(name+".cat");
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(catalog);
            out.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
