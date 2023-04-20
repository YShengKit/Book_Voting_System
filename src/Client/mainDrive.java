package Client;


import java.util.Scanner;

import Entity.*;
import MyADT.*;

public class mainDrive {
    private static MyHashMap<Integer, Voter> voters = new MyHashMap<>();
    private static Voter currentVoter = null;

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

        Book b1 = admin1.addBook(123,"How_to_java","james","This is a very hard and fun subject.");
        Book b2 = admin1.addBook(1009,"one_piece","jump","A young guy on a journey to find one piece.");
        Book b3 = admin1.addBook(462,"killers","conny","Series killers in London.");
        Book b4 = admin1.addBook(654,"help_me","donald", "Mental health analysis for student.");
        Book b5 = admin1.addBook(874,"surviveXX","Ali", "Based on true story.");
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



        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.printf("\n            //=================================//");
            System.out.printf("\n           //            Welcome              //");
            System.out.printf("\n          //               To                //");
            System.out.printf("\n         //     TARUMT Book Voting System   //");
            System.out.printf("\n        //=================================//");
            System.out.printf("\n       //           1. Voter              //");
            System.out.printf("\n      //            2. Admin             //");
            System.out.printf("\n     //             3. Quit System      //");
            System.out.printf("\n    //                                 //");
            System.out.printf("\n   //   (Select role to continue...)  //");
            System.out.printf("\n  //=================================//");
            System.out.printf("\n           Your choice: ");
            String roleChoice = sc.next();

            //voter side
            if (roleChoice.equals("1")){
                // Login loop for voter
                System.out.printf("\n   //=================================//");
                System.out.printf("\n  //      Voter Login Session        //");
                System.out.printf("\n //=================================//");

                System.out.printf("\n       Enter voter ID:");
                int id = sc.nextInt();
                System.out.printf("       Enter voter name:");
                sc.useDelimiter("\n");
                String name = sc.next();

                Voter voter = voters.get(id);
                if (voter != null && voter.getName().equals(name)) {
                    currentVoter = voter;
                    System.out.printf("\n   //======================================//");
                    System.out.printf("\n  //   Login successful. Welcome, %8s !//" ,currentVoter.getName());                                 //");
                    System.out.printf("\n //==========================================//");
                } else {
                    System.out.printf("\n  ***************************************************");
                    System.out.printf("\n // Incorrect voter ID or name! Please try again. //");
                    System.out.printf("\n***************************************************");
                }

                while(currentVoter!=null){
                    System.out.println("\n    Hi " + currentVoter.getName() + ", Welcome to Book Voting System");
                    System.out.printf("\n\n       //===================================//");
                    System.out.printf("\n      //       1. Cast Vote                //");
                    System.out.printf("\n     //        2. Check Vote Ranking      //");
                    System.out.printf("\n    //         3. Profile                //");
                    System.out.printf("\n   //          4. Book details          //");
                    System.out.printf("\n  //           5. Remove Vote          //");
                    System.out.printf("\n //            6. Logout              //");
                    System.out.printf("\n//===================================//");
                    System.out.printf("\n           Your choice: ");
                    String menuChoices = sc.next();
                    while (!(menuChoices.matches("\\d+"))) {
                        System.out.printf("\n  ***************************************************");
                        System.out.printf("\n //         Invalid input! Choose again           //");
                        System.out.printf("\n***************************************************");
                        System.out.printf("\n\n       //===================================//");
                        System.out.printf("\n      //       1. Cast Vote                //");
                        System.out.printf("\n     //        2. Check Vote Ranking      //");
                        System.out.printf("\n    //         3. Profile                //");
                        System.out.printf("\n   //          4. Book details          //");
                        System.out.printf("\n  //           5. Remove Vote          //");
                        System.out.printf("\n //            6. Logout              //");
                        System.out.printf("\n//===================================//");
                        System.out.printf("\n            Choose again: ");
                        menuChoices = sc.next();
                    }
                    while (Integer.parseInt(menuChoices) > 7 || Integer.parseInt(menuChoices)==0) {
                        System.out.printf("\n  ***************************************************");
                        System.out.printf("\n //         Invalid input! Choose again           //");
                        System.out.printf("\n***************************************************");
                        System.out.printf("\n\n       //===================================//");
                        System.out.printf("\n      //       1. Cast Vote                //");
                        System.out.printf("\n     //        2. Check Vote Ranking      //");
                        System.out.printf("\n    //         3. Profile                //");
                        System.out.printf("\n   //          4. Book details          //");
                        System.out.printf("\n  //           5. Remove Vote          //");
                        System.out.printf("\n //            6. Logout              //");
                        System.out.printf("\n//===================================//");
                        System.out.printf("\n            Choose again: ");
                        menuChoices = sc.next();
                    }
                    if (menuChoices.equals("1")){

                        System.out.println("========================================");
                        HashSet<String> temp_cat_list = bookLists.getKeys();
                        for (int i = 0; i < temp_cat_list.size(); i++) {
                            System.out.println("             "+(i+1) + ". " + temp_cat_list.toArray()[i]);
                        }
                        System.out.println("========================================");

                        System.out.printf("\n   //====================================================//");
                        System.out.printf("\n  //   Which category u want to choose?(use index no.)  //");
                        System.out.printf("\n //====================================================//");
                        System.out.printf("\n           Your choice: ");

                        String cat_choice = sc.next();
                        while (!(cat_choice.matches("\\d+"))) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which category u want to choose?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            cat_choice = sc.next();
                        }
                        while (Integer.parseInt(cat_choice) > temp_cat_list.size() || Integer.parseInt(cat_choice)==0) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which category u want to choose?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            cat_choice = sc.next();
                        }


                        String category = temp_cat_list.toArray()[Integer.parseInt(cat_choice)-1] ;

                        System.out.println("========================================");
                        HashSet<String> temp_book_lists = bookLists.get(category);
                        for (int i=0; i<temp_book_lists.size(); i++){
                            System.out.println("             "+(i+1) + ". " + temp_book_lists.toArray()[i]);
                        }
                        System.out.println("========================================");

                        System.out.printf("\n   //====================================================//");
                        System.out.printf("\n  //    Which book do you want to vote?(use index no.)  //");
                        System.out.printf("\n //====================================================//");
                        System.out.printf("\n           Your choice: ");

                        String choice_book = sc.next();
                        while (!(choice_book.matches("\\d+"))) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which book do you want to vote?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            choice_book = sc.next();
                        }
                        while (Integer.parseInt(choice_book) > temp_book_lists.size() || Integer.parseInt(choice_book)==0) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which book do you want to vote?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            choice_book = sc.next();
                        }

                        boolean res = currentVoter.addVote(temp_book_lists.toArray()[Integer.parseInt(choice_book)-1]);
                        if (!res){
                            System.out.println("            You have voted "+ currentVoter.getVotedBook() + " before");
                        }else{
                            System.out.println("            You have voted for " + currentVoter.getVotedBook());
                        }

                    }else if (menuChoices.equals("2")){
                        currentVoter.showRanking();

                    }else if(menuChoices.equals("3")){
                        System.out.println("========================================");
                        HashSet<String> votedBookList = currentVoter.getVotedBook();
                        for(int i =0; i<votedBookList.size();i++){
                            System.out.println("             "+(i+1) + ". " + votedBookList.toArray()[i]);
                        }
                        System.out.println("========================================");
                        System.out.println("\n         Books you have voted");

                    }else if(menuChoices.equals("4")){
                        System.out.println("========================================");
                        HashSet<Integer> bookIDLists = bookOnly.getKeys();
                        for (Integer i: bookIDLists.toIntArray()){
                            Book tempBook = bookOnly.get(i);
                            System.out.println("             "+i + ". " + tempBook.getBookName());
                        }
                        System.out.println("========================================");
                        System.out.printf("\n        Insert the BookID:");
                        int bookID = sc.nextInt();
                        while(!bookOnly.containsKey(bookID)){
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid BookID! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n                     Choose again: ");
                            bookID = sc.nextInt();
                        }

                        String bname = bookOnly.get(bookID).getBookName();
                        String aname = bookOnly.get(bookID).getAuthorName();
                        HashSet<String> bookCat= bookOnly.get(bookID).getCategoryList();
                        String desc = bookOnly.get(bookID).getDescriptions();

                        System.out.println("============================================================");
                        System.out.println("The book "+"<<" + bname + ">> " +"is written by " + aname);
                        System.out.println("Category(s): "+bookCat);
                        System.out.println("Description of the book: ");
                        System.out.println(desc);
                        System.out.println("============================================================");
                    }else if(menuChoices.equals("5")){

                        System.out.println("========================================");
                        HashSet<String> votedBookList = currentVoter.getVotedBook();
                        for(int i =0; i<votedBookList.size();i++){
                            System.out.println("             "+(i+1) + ". " + votedBookList.toArray()[i]);
                        }
                        System.out.println("========================================");

                        System.out.printf("\n   //====================================================//");
                        System.out.printf("\n  //          Which book do you want to remove?(no.)    //");
                        System.out.printf("\n //====================================================//");
                        System.out.printf("\n           Your choice: ");
                        String remove_choice = sc.next();

                        while (!(remove_choice.matches("\\d+"))) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which book do you want to remove?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            remove_choice = sc.next();
                        }

                        while (Integer.parseInt(remove_choice) > votedBookList.size()|| Integer.parseInt(remove_choice)==0) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which book do you want to remove?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            remove_choice = sc.next();
                        }

                        String removedBookName = votedBookList.toArray()[Integer.parseInt(remove_choice)-1];
                        votedBookList.remove(removedBookName);
                        currentVoter.removeVote(removedBookName);

                    }else if(menuChoices.equals("6")) {
                        System.out.printf("\n   //====================================================//");
                        System.out.printf("\n  //                  Proceed to logout                 //");
                        System.out.printf("\n //====================================================//");
                        currentVoter = null;
                    }else {
                        System.out.printf("\n  ***************************************************");
                        System.out.printf("\n //         Invalid input! Please try again        //");
                        System.out.printf("\n***************************************************");
                    }

                }
            }
            //admin side
            else if(roleChoice.equals("2")) {
                while(true){
                    System.out.printf("\n         //===================================//");
                    System.out.printf("\n        //      Welcome to Admin System      //");
                    System.out.printf("\n       //===================================//");
                    System.out.printf("\n      //       1. Create Book              //");
                    System.out.printf("\n     //   2. Check all category list      //");
                    System.out.printf("\n    //         3. Show hashmap           //");
                    System.out.printf("\n   //      4. Check Book Details        //");
                    System.out.printf("\n  //          5. Add Category          //");
                    System.out.printf("\n //            6. Logout              //");
                    System.out.printf("\n//===================================//");
                    System.out.printf("\n             Your choice: ");
                    String menuChoices = sc.next();
                    while (!(menuChoices.matches("\\d+"))) {
                        System.out.printf("\n  ***************************************************");
                        System.out.printf("\n //         Invalid input! Choose again           //");
                        System.out.printf("\n***************************************************");
                        System.out.printf("\n         //===================================//");
                        System.out.printf("\n        //      Welcome to Admin System      //");
                        System.out.printf("\n       //===================================//");
                        System.out.printf("\n      //       1. Create Book              //");
                        System.out.printf("\n     //   2. Check all category list      //");
                        System.out.printf("\n    //         3. Show hashmap           //");
                        System.out.printf("\n   //      4. Check Book Details        //");
                        System.out.printf("\n  //          5. Add Category          //");
                        System.out.printf("\n //            6. Logout              //");
                        System.out.printf("\n//===================================//");
                        System.out.printf("\n        Choose again:");
                        menuChoices = sc.next();
                    }
                    while (Integer.parseInt(menuChoices) > 7 || Integer.parseInt(menuChoices)==0) {
                        System.out.printf("\n  ***************************************************");
                        System.out.printf("\n //         Invalid input! Choose again           //");
                        System.out.printf("\n***************************************************");
                        System.out.printf("\n         //===================================//");
                        System.out.printf("\n        //      Welcome to Admin System      //");
                        System.out.printf("\n       //===================================//");
                        System.out.printf("\n      //       1. Create Book              //");
                        System.out.printf("\n     //   2. Check all category list      //");
                        System.out.printf("\n    //         3. Show hashmap           //");
                        System.out.printf("\n   //      4. Check Book Details        //");
                        System.out.printf("\n  //          5. Add Category          //");
                        System.out.printf("\n //            6. Logout              //");
                        System.out.printf("\n//===================================//");
                        System.out.printf("\n        Choose again:");
                        menuChoices = sc.next();
                    }
                    if (menuChoices.equals("1")){
                        String [] cats = cat.toArray();

                        System.out.println("========================================");
                        for(int i =0; i<cats.length;i++) {
                            System.out.println("             "+(i+1) + ". " + cats[i]);
                        }
                        System.out.println("========================================");
                        System.out.printf("\n   //====================================================//");
                        System.out.printf("\n  //   Which category u want to choose?(use index no.)  //");
                        System.out.printf("\n //====================================================//");
                        System.out.printf("\n             Your choice: ");
                        String catchoice = sc.next();
                        while (!(catchoice.matches("\\d+"))) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which category u want to choose?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            catchoice = sc.next();
                        }
                        while (Integer.parseInt(catchoice) > cats.length) {
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n  Which category u want to choose?(use index no.)");
                            System.out.printf("\n            Choose again: ");
                            catchoice = sc.next();
                        }

                        String catchosen = cats[Integer.parseInt(catchoice)-1];
                        System.out.printf("Enter Book ID:");
                        int bookid = sc.nextInt();
                        System.out.printf("Enter Book name:");
                        sc.useDelimiter("\n");
                        String bookname = sc.next();
                        System.out.printf("Enter author name:");
                        sc.useDelimiter("\n");
                        String authorname = sc.next();
                        System.out.printf("Enter the description of book:");
                        sc.useDelimiter("\n");
                        String desc = sc.next();

                        Book tempbook = admin1.addBook(bookid,bookname,authorname,desc);
                        admin1.addToBookList(catchosen,tempbook);
                        bookOnly.put(tempbook.getBookID(),tempbook);

                    }else if (menuChoices.equals("2")){
                        System.out.printf("\n   ////////////////////////////////////////");
                        System.out.printf("\n  //         Showing all category       //");
                        System.out.printf("\n ////////////////////////////////////////");
                        System.out.println("\n========================================");
                        for (int i = 0; i < cat.size(); i++) {
                            System.out.println("             "+cat.toArray()[i]);
                        }
                        System.out.println("========================================");
                    }else if(menuChoices.equals("3")){
                        System.out.printf("\n   ////////////////////////////////////////");
                        System.out.printf("\n  //         Showing the hashmap        //");
                        System.out.printf("\n ////////////////////////////////////////\n");
                        System.out.println(bookLists);

                    }else if (menuChoices.equals("4")){
                        System.out.printf("\n   ////////////////////////////////////////");
                        System.out.printf("\n  //         Showing all books          //");
                        System.out.printf("\n ////////////////////////////////////////");
                        HashSet<Integer> bookID_list = bookOnly.getKeys();
                        System.out.println("\n========================================");
                        for (int i = 0; i < bookID_list.size(); i++) {
                            System.out.println("             "+bookID_list.toIntArray()[i] + " " + bookOnly.get(bookID_list.toIntArray()[i]).getBookName());
                        }
                        System.out.println("========================================");
                        System.out.printf("Insert the BookID:");

                        int bookID = sc.nextInt();
                        while(!bookOnly.containsKey(bookID)){
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid BookID! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n                     Choose again: ");
                            bookID = sc.nextInt();
                        }

                        String name = bookOnly.get(bookID).getBookName();
                        String aname = bookOnly.get(bookID).getAuthorName();
                        HashSet<String> bookCat= bookOnly.get(bookID).getCategoryList();
                        String desc = bookOnly.get(bookID).getDescriptions();

                        System.out.println("============================================================");
                        System.out.println("The book "+"<<" + name + ">> " +"is written by " + aname);
                        System.out.println("Category(s): "+bookCat);
                        System.out.println("Description of the book: ");
                        System.out.println(desc);
                        System.out.println("============================================================");

                        System.out.printf("\n         //===================================//");
                        System.out.printf("\n        //         Further Action?            //");
                        System.out.printf("\n       //===================================//");
                        System.out.printf("\n      //            1. Update              //");
                        System.out.printf("\n     //             2. Remove             //");
                        System.out.printf("\n    //              3. Exit              //");
                        System.out.printf("\n   //===================================//");
                        System.out.printf("\n             Your choice: ");
                        String update_choice = sc.next();
                        while (!(update_choice.equals("1")) && !(update_choice.equals("2")) && !(update_choice.equals("3"))){
                            System.out.printf("\n  ***************************************************");
                            System.out.printf("\n //         Invalid input! Choose again           //");
                            System.out.printf("\n***************************************************");
                            System.out.printf("\n         //===================================//");
                            System.out.printf("\n        //         Further Action?            //");
                            System.out.printf("\n       //===================================//");
                            System.out.printf("\n      //            1. Update              //");
                            System.out.printf("\n     //             2. Remove             //");
                            System.out.printf("\n    //              3. Exit              //");
                            System.out.printf("\n   //===================================//");
                            System.out.printf("\n            Choose again: ");
                            update_choice = sc.next();
                        }

                        if(update_choice.equals("1")){
                            String modify_choice ="";
                            do {
                                System.out.printf("\n         //====================================//");
                                System.out.printf("\n        //         Modification Menu          //");
                                System.out.printf("\n       //====================================//");
                                System.out.printf("\n      //           1. Category              //");
                                System.out.printf("\n     //            2. Book Name            //");
                                System.out.printf("\n    //             3. Author              //");
                                System.out.printf("\n   //              4. Description        //");
                                System.out.printf("\n  //               5. Exit              //");
                                System.out.printf("\n //====================================//");
                                System.out.printf("\n             Your choice: ");
                                modify_choice = sc.next();
                                while (!(modify_choice.equals("1")) && !(modify_choice.equals("2")) && !(modify_choice.equals("3")) && !(modify_choice.equals("4")) && !(modify_choice.equals("5"))) {
                                    System.out.printf("\n  ***************************************************");
                                    System.out.printf("\n //         Invalid input! Choose again           //");
                                    System.out.printf("\n***************************************************");
                                    System.out.printf("\n         //====================================//");
                                    System.out.printf("\n        //         Modification Menu          //");
                                    System.out.printf("\n       //====================================//");
                                    System.out.printf("\n      //           1. Category              //");
                                    System.out.printf("\n     //            2. Book Name            //");
                                    System.out.printf("\n    //             3. Author              //");
                                    System.out.printf("\n   //              4. Description        //");
                                    System.out.printf("\n  //               5. Exit              //");
                                    System.out.printf("\n //====================================//");
                                    System.out.printf("\n            Choose again: ");
                                    modify_choice = sc.next();
                                }
                                if (modify_choice.equals("1")) {
                                    System.out.printf("\n         //====================================//");
                                    System.out.printf("\n        //       Modification on category     //");
                                    System.out.printf("\n       //====================================//");
                                    System.out.printf("\n      //           1. Change category       //");
                                    System.out.printf("\n     //            2. Add category         //");
                                    System.out.printf("\n    //             3. Remove category     //");
                                    System.out.printf("\n   //              4. Exit               //");
                                    System.out.printf("\n  //====================================//");
                                    System.out.printf("\n            Your choice: ");
                                    String modify_cat = sc.next();
                                    while (!(modify_cat.equals("1")) && !(modify_cat.equals("2")) && !(modify_cat.equals("3")) && !(modify_cat.equals("4"))) {
                                        System.out.printf("\n  ***************************************************");
                                        System.out.printf("\n //         Invalid input! Choose again           //");
                                        System.out.printf("\n***************************************************");
                                        System.out.printf("\n         //====================================//");
                                        System.out.printf("\n        //       Modification on category     //");
                                        System.out.printf("\n       //====================================//");
                                        System.out.printf("\n      //           1. Change category       //");
                                        System.out.printf("\n     //            2. Add category         //");
                                        System.out.printf("\n    //             3. Remove category     //");
                                        System.out.printf("\n   //              4. Exit               //");
                                        System.out.printf("\n  //====================================//");
                                        System.out.printf("\n            Choose again: ");
                                        modify_cat = sc.next();
                                    }
                                    if (modify_cat.equals("1")){
                                        HashSet<String> new_cat_list = bookOnly.get(bookID).getCategoryList();
                                        System.out.println("Current category list for " + bookOnly.get(bookID).getBookName());

                                        System.out.println("========================================");
                                        for (int i = 0; i < new_cat_list.size(); i++) {
                                            System.out.println("             "+(i+1) + ". " + new_cat_list.toArray()[i]);
                                        }
                                        System.out.println("========================================\n");
                                        System.out.printf("Choose a category(no.) to change: ");
                                        int old_cat_choice = sc.nextInt();

                                        System.out.println("========================================");
                                        for(int i=0; i < cat.size(); i++){
                                            System.out.println((i+1) + ". " + cat.toArray()[i]);
                                        }
                                        System.out.println("========================================\n");
                                        System.out.printf("Choose a new category: ");
                                        int cat_choice = sc.nextInt();

                                        new_cat_list.remove(new_cat_list.toArray()[old_cat_choice-1]);
                                        new_cat_list.add(cat.toArray()[cat_choice-1]);
                                        bookOnly.get(bookID).setCategoryList(new_cat_list);
                                        admin1.addToBookList(new_cat_list.toArray()[old_cat_choice-1],bookOnly.get(bookID));
                                        System.out.println("Modified to "+bookOnly.get(bookID).getCategoryList());
                                    } else if (modify_cat.equals("2")) {

                                        System.out.println("========================================");
                                        for(int i=0; i < cat.size(); i++){
                                            System.out.println("             "+(i+1) + ". " + cat.toArray()[i]);
                                        }
                                        System.out.println("========================================\n");
                                        System.out.printf("Choose a category(no.): ");
                                        int cat_choice = sc.nextInt();
                                        HashSet<String> new_cat_list = bookOnly.get(bookID).getCategoryList();
                                        new_cat_list.add(cat.toArray()[cat_choice-1]);
                                        admin1.addToBookList(new_cat_list.toArray()[cat_choice-1],bookOnly.get(bookID));
                                        bookOnly.get(bookID).setCategoryList(new_cat_list);
                                        System.out.println("Successfully added!!");
                                    } else if (modify_cat.equals("3")) {
                                        HashSet<String> new_cat_list = bookOnly.get(bookID).getCategoryList();
                                        if (new_cat_list.size() !=1 ){
                                            System.out.println("Current category list for " + bookOnly.get(bookID).getBookName());
                                            System.out.println("========================================");
                                            for (int i = 0; i < new_cat_list.size(); i++) {
                                                System.out.println("             "+(i+1) + ". " + new_cat_list.toArray()[i]);
                                            }
                                            System.out.println("========================================\n");
                                            System.out.printf("Choose a category(no.) to remove: ");
                                            int old_cat_choice = sc.nextInt();
                                            admin1.addToBookList(new_cat_list.toArray()[old_cat_choice-1],bookOnly.get(bookID));
                                            new_cat_list.remove(new_cat_list.toArray()[old_cat_choice-1]);
                                            bookOnly.get(bookID).setCategoryList(new_cat_list);

                                            System.out.println("Modified to "+bookOnly.get(bookID).getCategoryList());
                                        }
                                        else{
                                            System.out.printf("\n  ***************************************************");
                                            System.out.printf("\n //    Each book must have at least one category   //");
                                            System.out.printf("\n***************************************************");
                                        }

                                    }
                                }

                                else if (modify_choice.equals("2")) {
                                    System.out.printf("Enter new book name: ");
                                    sc.useDelimiter("\n");
                                    String new_bookName= sc.next();
                                    String old = bookOnly.get(bookID).getBookName();
                                    bookOnly.get(bookID).setBookName(new_bookName);
                                    System.out.println(old + " have successfully changed to " + new_bookName);

                                }
                                else if (modify_choice.equals("3")) {
                                    System.out.printf("Enter new author name: ");
                                    sc.useDelimiter("\n");
                                    String new_authorName= sc.next();

                                    String old = bookOnly.get(bookID).getAuthorName();
                                    bookOnly.get(bookID).setAuthorName(new_authorName);
                                    System.out.println(old + " have successfully changed to " + new_authorName);
                                }
                                else if (modify_choice.equals("4")) {
                                    System.out.printf("Enter new description: ");
                                    sc.useDelimiter("\n");
                                    String new_desc= sc.next();
                                    bookOnly.get(bookID).setDescriptions(new_desc);
                                    System.out.println("Successfully changed");
                                }


                            }while (!(modify_choice.equals("5")));
                        }
                        else if (update_choice.equals("2")){
                            System.out.println(bookOnly.get(bookID).getBookName() + " have been removed");
                            admin1.removeBook(bookOnly.get(bookID));
                            bookOnly.remove(bookID);
                        }
                    }else if(menuChoices.equals("5")) {
                        System.out.printf("Enter new category: ");
                        sc.useDelimiter("\n");
                        String new_cat = sc.next();
                        cat.add(new_cat);
                    }else if(menuChoices.equals("6")) {
                        System.out.printf("\n   //====================================================//");
                        System.out.printf("\n  //                  Proceed to logout                 //");
                        System.out.printf("\n //====================================================//");
                        break;
                    }else {
                        System.out.printf("\n  ***************************************************");
                        System.out.printf("\n //         Invalid choice! Choose again           //");
                        System.out.printf("\n***************************************************");
                    }

                }

            }
            //logout (quit entire system)
            else if (roleChoice.equals("3")) {
                System.out.printf("\n   //====================================================//");
                System.out.printf("\n  //              Logging out entire system             //");
                System.out.printf("\n //====================================================//");
                break;
            } else {
                System.out.printf("\n  ***************************************************");
                System.out.printf("\n //         Invalid choice! Choose again           //");
                System.out.printf("\n***************************************************");
            }

        }
        sc.close();

    }

}
