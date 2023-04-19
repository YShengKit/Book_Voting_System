package Client;
import MyADT.*;
import Entity.*;

import java.util.Scanner;

public class adminAddBookTest {
    private static boolean stat = true;

    public static void main(String[] args) {
        MyHashMap<String, HashSet<String>> bookLists = new MyHashMap<>();
        HashSet<String> cat = new HashSet<>();
        MyHashMap<Integer,Book> bookOnly = new MyHashMap<>();

        // Create some sample admin
        Admin admin1 = new Admin(123, "Alice","1234",bookLists);
        Admin admin2 = new Admin(456, "Bob","12345",bookLists);
        Admin admin3 = new Admin(234,"john","123456",bookLists);

        cat.add("Education");
        cat.add("Programming");
        cat.add("Anime");
        cat.add("Horror");
        cat.add("Social");
        cat.add("Politics");

        Scanner sc = new Scanner(System.in);
        while(stat){
            System.out.println("Hi "  + ", welcome to Admin System\n 1. Create Book \n 2. Check all category list \n 3. Show hashmap \n 4. Check book details \n 5. Log out ");
            int menuChoices = sc.nextInt();
            if (menuChoices ==1){
                String [] cats = cat.toArray();
                for(int i =0; i<cats.length;i++) {
                    System.out.println(i + ". " + cats[i]);
                }
                System.out.println("Select one category");
                int catchoice = sc.nextInt();
                String catchosen = cats[catchoice];
                System.out.println("Enter Book ID:");
                int bookid = sc.nextInt();
                System.out.println("Enter Book name:");
                String bookname = sc.next();
                System.out.println("Enter author name:");
                String authorname = sc.next();

                Book tempbook = admin1.addBook(bookid,bookname,authorname);
                admin1.addToBookList(catchosen,tempbook);
                bookOnly.put(tempbook.getBookID(),tempbook);



            }else if (menuChoices==2){
                System.out.println("Showing all category");
                System.out.println(bookLists.getKeys());
            }else if(menuChoices==3){
                System.out.println("Showing the hashmap");
                System.out.println(bookLists);
            }else if(menuChoices == 4){
                System.out.println("Insert the BookID:");
                int hey = sc.nextInt();
                String name = bookOnly.get(hey).getBookName();
                String aname = bookOnly.get(hey).getAuthorName();
                System.out.println(name + ", " + aname);

            }else if(menuChoices == 5) {
                System.out.println("proceed to logout");
                stat = false;
                break;
            }

        }
    }
}
