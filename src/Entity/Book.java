package Entity;
import MyADT.*;

public class Book {
    private int bookID;
    private String bookName;
    private String authorName;
    private String descriptions;
    private HashSet<String> categoryList;



    public Book(int bookID, String bookName, String authorName, String descriptions) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.authorName = authorName;
        this.descriptions = descriptions;
        this.categoryList = new HashSet<>();
    }

    //  getter & setter
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public HashSet<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(HashSet<String> categoryList) {
        this.categoryList = categoryList;
    }

    public String getDescriptions() { return descriptions; }

    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }
}
