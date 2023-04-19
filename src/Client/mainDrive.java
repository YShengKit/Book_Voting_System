package Client;


import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.*;
import MyADT.*;

public class mainDrive {
    private static MyHashMap<Integer, Voter> voters = new MyHashMap<>();
    private static Voter currentVoter = null;
    private static boolean stat = true;

    public static void main(String[] args) {
        VotingModule voteMap = new VotingModule();
        // Create some sample voters
        Voter voter1 = new Voter(123, "Alice",voteMap);
        Voter voter2 = new Voter(456, "Bob",voteMap);
        Voter voter3 = new Voter(234,"john",voteMap);
        Voter voter4 = new Voter(789,"billy",voteMap);

        voters.put(voter1.getId(), voter1);
        voters.put(voter2.getId(), voter2);
        voters.put(voter3.getId(), voter3);

        MyHashMap<String, HashSet<String>> bookLists = new MyHashMap<>();
        MyHashMap<Integer,Book> bookOnly = new MyHashMap<>();
        HashSet<String> cat = new HashSet<>();
        Admin admin1 = new Admin(123, "Alice","1234",bookLists);
        Admin admin2 = new Admin(456, "Bob","12345",bookLists);
        Admin admin3 = new Admin(234,"john","123456",bookLists);

        cat.add("Education");
        cat.add("Programming");
        cat.add("Anime");
        cat.add("Horror");
        cat.add("Social");
        cat.add("Politics");

        Book b1 = admin1.addBook(123,"How_to_java","james");
        Book b2 = admin1.addBook(1009,"one_piece","jump");
        Book b3 = admin1.addBook(462,"killers","conny");
        Book b4 = admin1.addBook(654,"help_me","donald");
        Book b5 = admin1.addBook(874,"surviveXX","Ali");
        admin1.addToBookList("Education",b1);
        admin1.addToBookList("Horror",b1);
        admin1.addToBookList("Anime",b2);
        admin1.addToBookList("Social",b2);
        admin1.addToBookList("Horror",b3);
        admin1.addToBookList("Social",b4);
        admin1.addToBookList("Horror",b4);
        admin1.addToBookList("Politics",b5);
        bookOnly.put(b1.getBookID(),b1);
        bookOnly.put(b2.getBookID(),b2);
        bookOnly.put(b3.getBookID(),b3);
        bookOnly.put(b4.getBookID(),b4);
        bookOnly.put(b5.getBookID(),b5);


//        HashSet<String> books = new HashSet<>();
//
//        MyHashMap<String, HashSet<String>> book_cat= new MyHashMap<>();
//        //books: categories (each book might have multiple categories)
//        books.add("book1");
//        books.add("book2");
//        books.add("book3");
//        books.add("book4");
//        books.add("book5");
//
//        HashSet<String> cat1 = new HashSet<>();
//        cat1.add("cat1");
//        cat1.add("cat2");
//        HashSet<String> cat2 = new HashSet<>();
//        cat2.add("cat3");
//        cat2.add("cat4");
//        //voters: books that voters voted (implement in voters system)
//        book_cat.put("book1",cat1); //cat1 and cat2
//        book_cat.put("book2",cat2); //cat3 and cat4
//        book_cat.put("book3",cat2); //cat3 and cat4
//        book_cat.put("book5",cat2);

        Scanner sc = new Scanner(System.in);

        while (currentVoter == null) {
            System.out.println("Welcome to TARUMT Book Voting System");
            System.out.println("1. Voter\n2. Admin\nSelect role to continue");
            String roleChoice = sc.next();
            while (!roleChoice.equals("1") && !roleChoice.equals("2")) {
                System.out.println("Input is invalid. Enter again...");
                System.out.println("1. Admin");
                System.out.println("2. Student");
                roleChoice = sc.next();
            }
            if (roleChoice.equals("1")){
                // Login loop for voter

                System.out.println("Enter voter ID:");
                int id = sc.nextInt();
                System.out.println("Enter voter name:");
                String name = sc.next();

                Voter voter = voters.get(id);
                if (voter != null && voter.getName().equals(name)) {
                    currentVoter = voter;
                    System.out.println("Login successful. Welcome, " + currentVoter.getName() + "!");
                } else {
                    System.out.println("Incorrect voter ID or name. Please try again.");
                }

                while(currentVoter!=null){
                    System.out.println("Hi " + currentVoter.getName() + ", welcome to Book Voting System\n 1. vote \n 2. check rank \n 3. logout");
                    int menuChoices = sc.nextInt();
                    if (menuChoices ==1){

                        HashSet<String> temp_cat_list = bookLists.getKeys();
                        for (int i = 0; i < temp_cat_list.size(); i++) {
                            System.out.println((i+1) + ". " + temp_cat_list.toArray()[i]);
                        }

                        System.out.println("Which category u want to choose?(use no.)");

                        String cat_choice = sc.next();
                        while (!(cat_choice.matches("\\d+"))) {
                            System.out.println("Choose again\nChoose a category:");
                            cat_choice = sc.next();
                        }
                        while (Integer.parseInt(cat_choice) > temp_cat_list.size()) {
                            System.out.println("Choose again\nChoose a category:");
                            cat_choice = sc.next();
                        }

                        String category = temp_cat_list.toArray()[Integer.parseInt(cat_choice)-1] ;


                        HashSet<String> temp_book_lists = bookLists.get(category);
                        for (int i=0; i<temp_book_lists.size(); i++){
                            System.out.println((i+1) + ". " + temp_book_lists.toArray()[i]);
                        }

                        System.out.println("Which book u want to vote?");
                        String choice_book = sc.next();
                        while (!(choice_book.matches("\\d+"))) {
                            System.out.println("Choose again\nWhich book u want to vote?");
                            choice_book = sc.next();
                        }
                        while (Integer.parseInt(choice_book) > temp_book_lists.size()) {
                            System.out.println("Choose again\nWhich book u want to vote?");
                            choice_book = sc.next();
                        }

                        boolean res = currentVoter.addVote(temp_book_lists.toArray()[Integer.parseInt(choice_book)-1]);
                        if (!res){
                            System.out.println("You have voted "+ currentVoter.getVotedBook() + " before");
                        }else{
                            System.out.println("You have voted for " + currentVoter.getVotedBook());
                        }

                    }else if (menuChoices==2){
                        currentVoter.showRanking();
                    }else if(menuChoices == -1) {
                        break;
                    }else{
                        //logout
                        System.out.println("proceed to logout");
                        currentVoter = null;
                    }

                }
            }else if(roleChoice.equals("2")) {
                while(stat){
                    System.out.println("Hi "  + ", welcome to Admin System\n 1. Create Book \n 2. Check all category list \n 3. Show hashmap \n 4. Remove book \n 5. Check book details \n 6. Log out ");
                    int menuChoices = sc.nextInt();
                    if (menuChoices ==1){
                        String [] cats = cat.toArray();
                        for(int i =0; i<cats.length;i++) {
                            System.out.println((i+1) + ". " + cats[i]);
                        }
                        System.out.println("Select one category");
                        String catchoice = sc.next();
                        while (!(catchoice.matches("\\d+"))) {
                            System.out.println("Choose again\nChoose a category:");
                            catchoice = sc.next();
                        }
                        while (Integer.parseInt(catchoice) > cats.length) {
                            System.out.println("Choose again\nChoose a category:");
                            catchoice = sc.next();
                        }

                        String catchosen = cats[Integer.parseInt(catchoice)-1];
                        System.out.println("Enter Book ID:");
                        int bookid=sc.nextInt();
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
                        HashSet<Integer> bookIDLists = bookOnly.getKeys();
                        for (Integer i: bookIDLists.toIntArray()){
                            Book tempBook = bookOnly.get(i);
                            System.out.println(i + ". " + tempBook.getBookName());
                        }
                        System.out.println("Enter the book you want to remove");
                        int removeChoice = sc.nextInt();
                        admin1.removeBook(bookOnly.get(removeChoice));
                        bookOnly.remove(removeChoice);

                    }else if (menuChoices == 5){
                        System.out.println("Insert the BookID:");

                        int bookID = sc.nextInt();
                        String name = bookOnly.get(bookID).getBookName();
                        String aname = bookOnly.get(bookID).getAuthorName();
                        System.out.println(name + ", " + aname);
                    }else if(menuChoices == 6) {
                        System.out.println("proceed to logout");
                        stat = false;

                    }

                }

            }

        }
    }

}
