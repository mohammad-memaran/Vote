package Vote;
import java.util.Comparator;

import Vote.Vote_Test03;

public class Vote_Test03_2 implements Comparator<Vote_Test03> {

    @Override
    public int compare(Vote_Test03 o1, Vote_Test03 o2) {
        int flag = o2.getVotes() - o1.getVotes();

        // if the votes are the same 
        if(flag != 0){
            return flag;
        }
        if(o1.getTerms() - o2.getTerms() == 0){
            flag = o1.getName().compareTo(o2.getName());
        }else{
            flag = o1.getTerms() - o2.getTerms();
        }
        return flag;
    }
}