package Entity;
import MyADT.*;

/**@author Yeap Sheng Kit */

public class Voter {
    private int id;
    private String name;
    private HashSet<String> votedBook;
    private VotingModule voteMap;

    // constructors
    //default
    public Voter() {
        int id;
        String name;
    }

    // with id and name
    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.votedBook = new HashSet<>();
    }

    // with id, name and shared hashmap
    public Voter(int id, String name, VotingModule voteMap) {
        this.id = id;
        this.name = name;
        this.votedBook = new HashSet<>();
        this.voteMap = voteMap;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getVotedBook() {
        return votedBook;
    }

    public void setVotedBook(HashSet<String> votedBook) { this.votedBook = votedBook;}


    // cast vote and store in a shared hashmap
    public boolean addVote(String book){
        //store as set
        boolean res = votedBook.add(book);
        this.voteMap.addVote(book,this);
        return res;
    }

    // deletes vote from the shared hashmap
    public void removeVote(String book){
        //remove
        HashSet<String> voterList = voteMap.showVoters(book);
        votedBook.remove(book);
        voterList.remove(this.getName());
    }

    /**@author Too Chin Xian */
    // display the current ranking of vote
    public void showRanking() {
        // instantiate the sortedArray ADT
        SortedArray<Integer> sortedArray = new SortedArray<>(voteMap.size());
        // HashMap to store vote count & book name
        MyHashMap<Integer, HashSet<String>> rank = new MyHashMap<>();

        // loop through the shared hashmap
        for (String book : voteMap.showVotedBooks()) {
            int voteCount = voteMap.countVotes(book);
            // check existing key
            // if exist already
            if (rank.containsKey(voteCount)) {
                HashSet<String> bookList = rank.get(voteCount);
                bookList.add(book); // update the hashset of the hashmap
                sortedArray.add(voteCount); // add the vote count into sorted array
            }
            // if key not exist
            else {
                HashSet<String> bookList = new HashSet<>(); // new hashset
                bookList.add(book); // add value (book name) into it
                rank.put(voteCount, bookList); // add entry into hashmap
                sortedArray.add(voteCount); // add the vote count into sorted array
            }
        }

        // visualize vote ranking (ranking listing)
        System.out.printf("\n            //====================================================//");
        System.out.printf("\n           //                  Current Vote Rank                 //");
        System.out.printf("\n          //====================================================//\n");
        Integer[] sortedArr = sortedArray.getSortedArr();
        int prevVoteCount = -1; // to avoid repeated value in looping
        for (int i : sortedArr) {
            HashSet<String> books = rank.get(i);
            // to avoid repeated value in looping
            if (i != prevVoteCount) {
                System.out.println("                      "+books + " : " + i);
            }
            prevVoteCount = i;
        }

        // visualize ranking (summary)
        int highest = sortedArr[0];
        System.out.printf("\n      //====================================================//");
        System.out.printf("\n     //   Current  o o o o > "+rank.get(highest)+"                     //");
        System.out.printf("\n    //    Winner   o o o o >                               //");
        System.out.printf("\n   //                                                     //");
        System.out.printf("\n  //    Vote     o o o o >  "+ highest+"                            //");
        System.out.printf("\n //    Count    o o o o >                              //");
        System.out.printf("\n//====================================================//");
    }
}
