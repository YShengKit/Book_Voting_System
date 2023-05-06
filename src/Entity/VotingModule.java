package Entity;

import MyADT.*;

public class VotingModule {
    /**@author Yeap Sheng Kit */
    //create shared hashmap that use to store the votes in the form of <bookname,voterHashset>
    private MyHashMap<String, HashSet<String>> voteMap = new MyHashMap<>();

    //constructor
    public VotingModule(){
        MyHashMap<String, HashSet<Voter>> voteMap = new MyHashMap<>();
    }

    /**@author Yeap Sheng Kit */
    //add the entry into the shared hashmap for selected K,key --> bookname, and value, V --> votername
    public void addVote(String book, Voter voter){
        //parameter takes in voter object but it is convert to
        // voter name and stored in the value, V of shared hashmap
        String voterName = voter.getName();
        if (voteMap.containsKey(book)) { //if the key, K (bookname) exists
            HashSet<String> voterSet = voteMap.get(book);
            voterSet.add(voterName); //update the hashset instead
        } else {
            HashSet<String> voterSet = new HashSet<>();
            voterSet.add(voterName);
            voteMap.put(book,voterSet);
        }
    }

    /**@author Yeap Sheng Kit */
    //display the voters for selected books
    //obtain information from shared hashmap
    public HashSet<String> showVoters(String book){
        HashSet<String> voterName = voteMap.get(book);
        return voterName;
    }

    /**@author Too Chin Xian */
    // return the number of votes for each books (size of the hashset of each key, K (bookname))
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
    // display all the books that has participated (key, K of the shared hashmap)
    public String[] showVotedBooks(){
        HashSet<String> votedBooks = voteMap.getKeys();
        return votedBooks.toArray();
    }

    /**@author Too Chin Xian */
    //size for the entire hashmap (index)
    public int size(){
        return voteMap.size();
    }

    /**@author Yeap Sheng Kit */
    //default method to print the shared hashmap
    @Override
    public String toString() {
        return voteMap.toString();
    }

}
