package Entity;

import MyADT.MyHashMap;

import java.util.HashSet;
import java.util.Set;

public class VotingModule {
    public MyHashMap<String, Set<String>> voteMap = new MyHashMap<>();
    //    public Set<String> voterSet = new HashSet<>();
    public Voter voters = new Voter();

    public VotingModule(){
        MyHashMap<String, Set<Voter>> voteMap = new MyHashMap<>();
    }


    public void addVote(String book, Voter voter){
        String voterName = voter.getName();
        if (voteMap.containsKey(book)) {
            Set<String> voterSet = voteMap.get(book);
            voterSet.add(voterName);
        } else {
            Set<String> voterSet = new HashSet<>();
            voterSet.add(voterName);
            voteMap.put(book,voterSet);
        }
        System.out.println(voteMap.get(book));
    }


    public Set<String> showVoters(String book){
        Set<String> voterName = voteMap.get(book);
        return voterName;
    }

    public int countVotes(String book){
        Set<String> voterName = voteMap.get(book);
        int count =voterName.size();
        return count;
    }

    public Set<String> showVotedBooks(){
        Set<String> votedBooks = voteMap.getKeys();
        return votedBooks;
    }

    public void cancelBook(String book){
        voteMap.remove(book);
    }
}
