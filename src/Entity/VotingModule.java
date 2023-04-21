package Entity;

import MyADT.*;

public class VotingModule {
    /**@author Yeap Sheng Kit */
    private MyHashMap<String, HashSet<String>> voteMap = new MyHashMap<>();

    public VotingModule(){
        MyHashMap<String, HashSet<Voter>> voteMap = new MyHashMap<>();
    }


    /**@author Yeap Sheng Kit */
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


    /**@author Yeap Sheng Kit */
    public HashSet<String> showVoters(String book){
        HashSet<String> voterName = voteMap.get(book);
        return voterName;
    }

    /**@author Too Chin Xian */
    public int countVotes(String book){
        if(voteMap.containsKey(book)){
            HashSet<String> voterName = voteMap.get(book);
            return voterName.size();
        }
        else{
            return 0;
        }
    }

    /**@author Too Chin Xian */
    public String[] showVotedBooks(){
        HashSet<String> votedBooks = voteMap.getKeys();
        return votedBooks.toArray();
    }

    /**@author Too Chin Xian */
    public int size(){
        return voteMap.size();
    }

    /**@author Yeap Sheng Kit */
    @Override
    public String toString() {
        return voteMap.toString();
    }

}
