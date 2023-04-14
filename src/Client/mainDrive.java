package Client;


import java.util.Scanner;

import Entity.Voter;
import Entity.VotingModule;
import MyADT.*;

public class mainDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VotingModule voteMap = new VotingModule();
        Voter voter1 = new Voter(1, "John", voteMap);
        HashSet<String> books = new HashSet<>();

        MyHashMap<String, HashSet<String>> book_cat= new MyHashMap<>();
        //books: categories (each book might have multiple categories)
        books.add("book1");
        books.add("book2");
        books.add("book3");

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

        voter1.addVote(temp_book_lists.toArray()[choice_book-1]);

        String[] abc = voteMap.showVotedBooks();
        for (int i = 0; i < abc.length; i++) {
            System.out.println(abc[i]);
        }
        voter1.showRanking();
    }

}
