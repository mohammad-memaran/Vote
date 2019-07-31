package Vote;

public class Voter {

	   private final String name;
	   private boolean didvote;

	   public Voter(String name){
	       this.name = name;
	       this.didvote = false;
	   }

	   public String getName(){
	       return this.name;
	   }

	   public void voted(){
	       this.didvote = true;
	   }

	   public boolean allreadyVoted(){
	       return this.didvote;
	   }

	}
