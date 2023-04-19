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

    public int size(){
        return voteMap.size();
    }

    @Override
    public String toString() {
        return voteMap.toString();
    }

    private HashSet<String> allbooks = new HashSet<>();
    public HashSet<String> displayCategory(MyHashMap<String, HashSet<String>> book_cat){
        //books: categories (each book might have multiple categories)
        allbooks = book_cat.getKeys();
        HashSet<String> temp_cat_list = new HashSet<>();
        String[] s = {};
        for (int i = 0; i < allbooks.size(); i++) {
            s =  book_cat.get(allbooks.toArray()[i]).toArray();
            for (int j = 0; j < s.length; j++) {
                temp_cat_list.add(s[j]);
            }
        }
        return temp_cat_list;
    }

    public HashSet<String> displayBook(MyHashMap<String, HashSet<String>> book_cat, String category){
        String[] temp = {};
        HashSet<String> temp_book_lists = new HashSet<>();
        for (int i = 0; i < allbooks.size(); i++) {
            temp = book_cat.get(allbooks.toArray()[i]).toArray();
            for (int j = 0; j < temp.length; j++) {
                if (category.equals(temp[j]))
                    temp_book_lists.add(allbooks.toArray()[i]);
            }

        }return temp_book_lists;
    }
}
