package docmanagement;

public interface Document {
    enum DocumentType {Article, Book}

    void assignID(int id);
    void view();
    String getName();
    int getID();
}
