package Entity;

public class Voter {
    private int id;
    private String name;

    public Voter() {
        int id;
        String name;
    }

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
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
// getter and setter methods for id and name go here


    public void addVote(){
        //store as set

    }

    public void removeVote(){
        //remove
    }
}
