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

        } catch (ClassNotFoundException e) {
            System.err.println("Error deserializing. Class does not exist!");
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            System.err.println("File " + name + " not found!");
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.err.println("Unexpected error opening the catalog file!");
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
        }catch (IOException e) {
            System.err.println("Unexpected error saving the catalog file!");
            e.printStackTrace();
        }
    }
}
