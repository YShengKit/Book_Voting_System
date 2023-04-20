package Entity;
import MyADT.*;

public class Voter {
    private int id;
    private String name;
    private HashSet<String> votedBook;
    private VotingModule voteMap;

    public Voter() {
        int id;
        String name;
    }

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.votedBook = new HashSet<>();
    }

    public Voter(int id, String name, VotingModule voteMap) {
        this.id = id;
        this.name = name;
        this.votedBook = new HashSet<>();
        this.voteMap = voteMap;
    }

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
// getter and setter methods for id and name go here


    public boolean addVote(String book){
        //store as set
        boolean res = votedBook.add(book);
        this.voteMap.addVote(book,this);
        return res;
    }

    public void removeVote(String book){
        //remove
        HashSet<String> voterList = voteMap.showVoters(book);
        votedBook.remove(book);
        voterList.remove(this.getName());
    }

    public void showRanking() {
        SortedArray<Integer> sortedArray = new SortedArray<>(voteMap.size());
        MyHashMap<Integer, HashSet<String>> rank = new MyHashMap<>();

        for (String book : voteMap.showVotedBooks()) {
            int voteCount = voteMap.countVotes(book);
            if (rank.containsKey(voteCount)) {
                HashSet<String> bookList = rank.get(voteCount);
                bookList.add(book);
                sortedArray.add(voteCount);
            } else {
                HashSet<String> bookList = new HashSet<>();
                bookList.add(book);
                rank.put(voteCount, bookList);
                sortedArray.add(voteCount);
            }
        }

        Integer[] sortedArr = sortedArray.getSortedArr();
        int prevVoteCount = Integer.MAX_VALUE;
        for (int i : sortedArr) {
            HashSet<String> books = rank.get(i);
            if (i != prevVoteCount) {
                System.out.println(books + " : " + i);
            }
            prevVoteCount = i;
        }
        int highest = sortedArr[0];
        System.out.println("Current winner --> "+ rank.get(highest)+ " with vote count of " + highest);
    }
}
