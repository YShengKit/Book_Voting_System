package Client;


import java.util.Scanner;

import Entity.Voter;
import Entity.VotingModule;
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

        voters.put(voter1.getId(), voter1);
        voters.put(voter2.getId(), voter2);
        voters.put(voter3.getId(), voter3);

        HashSet<String> books = new HashSet<>();

        MyHashMap<String, HashSet<String>> book_cat= new MyHashMap<>();
        //books: categories (each book might have multiple categories)
        books.add("book1");
        books.add("book2");
        books.add("book3");
        books.add("book4");
        books.add("book5");

        HashSet<String> cat1 = new HashSet<>();
        cat1.add("cat1");
        cat1.add("cat2");
        HashSet<String> cat2 = new HashSet<>();
        cat2.add("cat3");
        cat2.add("cat4");
        //voters: books that voters voted (implement in voters system)
        book_cat.put("book1",cat1); //cat1 and cat2
        book_cat.put("book2",cat2); //cat3 and cat4
        book_cat.put("book3",cat2); //cat3 and cat4
        book_cat.put("book5",cat2);

        // Login loop
        Scanner sc = new Scanner(System.in);
        while (currentVoter == null) {
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
                System.out.println("Hi " + currentVoter.getName() + ", welcome to Book Voting System\n 1. vote \n 2. check rank \n 3) logout");
                int menuChoices = sc.nextInt();
                if (menuChoices ==1){
                    VotingModule vm = new VotingModule();
                    HashSet<String> temp_cat_list = vm.displayCategory(book_cat);
                    for (int i = 0; i < temp_cat_list.size(); i++) {
                        System.out.println((i+1) + ". " + temp_cat_list.toArray()[i]);
                    }

                    System.out.println("Which category u want to choose?(use no.)");
                    int cat_choice = sc.nextInt();

                    String category = temp_cat_list.toArray()[cat_choice - 1] ;

                    HashSet<String> temp_book_lists = vm.displayBook(book_cat, category);
                    for (int i=0; i<temp_book_lists.size(); i++){
                        System.out.println((i+1) + ". " + temp_book_lists.toArray()[i]);
                    }

                    System.out.println("Which book u want to vote?");
                    int choice_book = sc.nextInt();

                    currentVoter.addVote(temp_book_lists.toArray()[choice_book-1]);

//                    String[] abc = voteMap.showVotedBooks();
//                    for (int i = 0; i < abc.length; i++) {
                    System.out.println("You have voted for "+ currentVoter.getVotedBook());
//                    }

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
//        System.out.println("Currently logged in as: " + currentVoter.getName());



            // Do whatever you need to do with the logged-in voter here


        }

    }

}
