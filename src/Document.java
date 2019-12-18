public class Document {
    private String bookID;
    private String nameDocument;
    private String author;
    private String BookType;
    private int amount;

    String getBookID() {
        return bookID;
    }

    String getNameDocument() {
        return nameDocument;
    }

    String getAuthor() {
        return author;
    }

    int getAmount() {
        return amount;
    }

    String getBookType() {
        return BookType;
    }

    void setBookID(String bookID) {
        this.bookID = bookID;
    }

    void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    void setBookType(String bookType) {
        BookType = bookType;
    }

    void showDocument() {
        System.out.println("BookID : " + bookID);
        System.out.println("Name Document: " + nameDocument);
        System.out.println("Author: " + author);
        System.out.println("Book Type: " + BookType);
        System.out.println("Amount " + amount);
    }
}
