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

    public void showRanking(){
        for(String i: voteMap.showVotedBooks()){
            System.out.println(i + " : " + voteMap.countVotes(i));
        }
    }
}
