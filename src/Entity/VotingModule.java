package Entity;

import MyADT.*;

public class VotingModule {
    private MyHashMap<String, HashSet<String>> voteMap = new MyHashMap<>();
    //    public Set<String> voterSet = new HashSet<>();
//    public Voter voters = new Voter();

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
    }


    public HashSet<String> showVoters(String book){
        HashSet<String> voterName = voteMap.get(book);
        return voterName;
    }

    public int countVotes(String book){
        if(voteMap.containsKey(book)){
            HashSet<String> voterName = voteMap.get(book);
            return voterName.size();
        }
        else{
            return 0;
        }
    }

    public String[] showVotedBooks(){
        HashSet<String> votedBooks = voteMap.getKeys();
        return votedBooks.toArray();
    }

    public void cancelBook(String book){
        voteMap.remove(book);
    }

    @Override
    public String toString() {
        return voteMap.toString();
    }
}
