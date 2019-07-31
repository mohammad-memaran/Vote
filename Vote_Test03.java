package Vote;

public class Vote_Test03 {
	private String name;
    private int id;
    private int votes;
    private int terms;

    public Vote_Test03(String name, int id, int terms){
        this.name = name;
        this.id = id;
        this.terms = terms;
        votes = 0;
    }

    public Vote_Test03(){

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    public int getTerms() {
        return terms;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Candidate: " + getName());
        str.append("\nID: " + getId());
        str.append("\nTerms: " + getTerms());
        str.append("\nVotes: " + getVotes() + "\n");

        return str.toString();
    }
}
