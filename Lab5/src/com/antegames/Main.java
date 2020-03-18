package com.antegames;

import docmanagement.*;

public class Main {

    public static void main(String[] args) {

        /* Saving a catalog */
        Catalog catalog = new Catalog("Catalog");
        CatalogExternalOperation ceo = new CatalogExternalOperation();

        /* Creating a couple of documents for testing purposes */
        Document doc1 = new LocalDocument(
                LocalDocument.DocumentType.Article,
                "test.txt",
                "Art1");
        catalog.addDocument(doc1);

        Document doc2 = new OnlineDocument(Document.DocumentType.Book, "https://9gag.com", "Fun");
        catalog.addDocument(doc2);

        /* Saving a catalog */
        ceo.save(catalog, "Catalog");

        /* Loading a catalog */
        Catalog catalog2 = ceo.load("Catalog");

        catalog2.viewAll();
    }
}
