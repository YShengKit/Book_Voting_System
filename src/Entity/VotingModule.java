package Entity;

import MyADT.*;

public class VotingModule {
    public MyHashMap<String, HashSet<String>> voteMap = new MyHashMap<>();
    //    public Set<String> voterSet = new HashSet<>();
    public Voter voters = new Voter();

    public VotingModule(){
        MyHashMap<String, HashSet<Voter>> voteMap = new MyHashMap<>();
    }


    public void addVote(String book, Voter voter){
        String voterName = voter.getName();
        if (voteMap.containsKey(book)) {
            HashSet<String> voterSet = voteMap.get(book);
            voterSet.add(voterName);
        } else {
            HashSet<String> voterSet = new HashSet<>();
            voterSet.add(voterName);
            voteMap.put(book,voterSet);
        }
        System.out.println(voteMap.get(book));
    }


    public HashSet<String> showVoters(String book){
        HashSet<String> voterName = voteMap.get(book);
        return voterName;
    }

    public int countVotes(String book){
        HashSet<String> voterName = voteMap.get(book);
        int count =voterName.size();
        return count;
    }

    public HashSet<String> showVotedBooks(){
        HashSet<String> votedBooks = voteMap.getKeys();
        return votedBooks;
    }

    public void cancelBook(String book){
        voteMap.remove(book);
    }
}
