package Entity;

import MyADT.*;

public class Admin {
    private int adminID;
    private String adminName;
    private String adminpw;
    private MyHashMap<String, HashSet<String>> adminBookLists;

    public Admin(int adminID, String adminName, String adminpw) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminpw = adminpw;
    }

    public Admin(int adminID, String adminName, String adminpw, MyHashMap<String, HashSet<String>> adminBookLists) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminpw = adminpw;
        this.adminBookLists = adminBookLists;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminpw() {
        return adminpw;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminpw(String adminpw) {
        this.adminpw = adminpw;
    }


//    add book
    public Book addBook(int bookID, String bookName, String author){
        Book book = new Book(bookID,bookName,author);
        return book;
    }

    public void addToBookList(String category ,Book bookObject){
        String bookName = bookObject.getBookName();
        if (this.adminBookLists.containsKey(category)) {
            HashSet<String> bookSet = this.adminBookLists.get(category);
            bookSet.add(bookName);
            bookObject.getCategoryList().add(category);

        } else {
            HashSet<String> bookSet = new HashSet<>();
            bookSet.add(bookName);
            this.adminBookLists.put(category,bookSet);
            bookObject.getCategoryList().add(category);

        }

    }
}
