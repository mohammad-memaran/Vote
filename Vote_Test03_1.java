package Vote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Vote.Vote_Test03_2;

public class Vote_Test03_1 extends Vote_Test03{

    // Priority Queue using a max heap.
    private List<Vote_Test03> ballotPq;

    // Stores the votes read from the *votes* file.
    private List<Integer> votes = new ArrayList<Integer>();

    public Vote_Test03_1(String name, int id, int terms){
        super(name, id, terms);
    }
    public Vote_Test03_1(){
        ballotPq = new ArrayList<Vote_Test03>();
    }

    // Change to PQ offer method.
    public void offer(Vote_Test03 cand) {
        countVotes(cand);
        ballotPq.add(cand);

        int child = ballotPq.size() - 1;
        int parent = ((child - 1) / 2);

        while (parent >= 0 && ballotPq.get(parent).getVotes() < ballotPq.get(child).getVotes()) {
            swap(parent, child);
            child = parent;
            parent = ((child - 1) / 2);
        }
    }

    // Modified Priority Queue method poll.
    private Vote_Test03 poll() {

        // Return null if the ArrayList is empty.
        if (isEmpty())
            return null;

        // Sets cand to the Candidate object at index 0.
        Vote_Test03 cand = ballotPq.get(0);

        // Check if there is only one Candidate object.
        if (ballotPq.size() == 1) {
            ballotPq.remove(0);
            return cand;
        }

        // Move the last element to the head of the Priority Queue.
        ballotPq.set(0, ballotPq.remove(ballotPq.size() - 1));
        int parent = 0;

        while (true) {

            // Finds the parents left-child, i.e. Parents left child is at 2i + 1.
            int leftChild = ((2 * parent) + 1);

            // Break out of loop.
            if (leftChild >= ballotPq.size()) {
                break;
            }

            // Finds the parents right-child, i.e. Parents right child is at 2i + 2.
            int rightChild = (leftChild + 1);

            // Assert that the leftChild is the min child 
            int minChild = leftChild;

            // If true sets the min child
            if (rightChild < ballotPq.size() && ballotPq.get(leftChild).getVotes() < ballotPq.get(rightChild).getVotes()) {
                minChild = rightChild;

            }
            //  Swaps the parent and min child if true
            if (ballotPq.get(parent).getVotes() < ballotPq.get(minChild).getVotes()) {
                swap(parent, minChild);
                parent = minChild;

            } else {break;}
        }
        return cand;
    }

    // Checks if the ArrayList is empty.
    private boolean isEmpty() {
        return ballotPq.size() == 0;
    }

    // Swaps the parent and child at the specified indices.
    private void swap(int i, int j) {
    	Vote_Test03 one = ballotPq.get(i);
    	Vote_Test03 two = ballotPq.get(j);

        ballotPq.set(i, two);
        ballotPq.set(j, one);
    }

    // Reads the votes from the *votes* txt file.
    private void readVotes() {
        File file = new File("votes");
        Scanner readFile;

        try {
            readFile = new Scanner(file);

            while (readFile.hasNextInt()) {
                int vote = readFile.nextInt();
                votes.add(vote);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Counts the total votes casted for each Candidate.
    private void countVotes(Vote_Test03 cand) {
        for (int i = 0; i < votes.size(); i++) {
            if (votes.get(i).equals(cand.getId())) {
                cand.addVote();
            }
        }
    }

    // Starts the election for problem one
    public void startElectionProblemOne() {
        readVotes();

        offer(new Vote_Test03("Washington", 1, 3));
        offer(new Vote_Test03("Adams", 2, 3));
        offer(new Vote_Test03("Jefferson", 3, 2));
        offer(new Vote_Test03("Madison", 4, 2));
        offer(new Vote_Test03("Monroe", 5, 2));
        offer(new Vote_Test03("Quincy Adams", 6, 1));
        offer(new Vote_Test03("Jackson", 7, 1));
        offer(new Vote_Test03("Van Buren", 8, 3));
        offer(new Vote_Test03("Harrision", 9, 1));
        offer(new Vote_Test03("Tyler", 10, 2));
        offer(new Vote_Test03("Polk", 11, 2));
        offer(new Vote_Test03("Taylor", 12, 3));
        offer(new Vote_Test03("Fillmore", 13, 2));
        offer(new Vote_Test03("Pierce", 14, 2));
        offer(new Vote_Test03("Buchanan", 15, 1));
        offer(new Vote_Test03("Lincoln", 16, 1));
        offer(new Vote_Test03("Johnson", 17, 2));
        offer(new Vote_Test03("Grant", 18, 3));
        offer(new Vote_Test03("Hayes", 19, 2));
        offer(new Vote_Test03("Garfield", 20, 1));
        offer(new Vote_Test03("Arthur", 21, 1));
        offer(new Vote_Test03("Cleveland", 22, 4));
        offer(new Vote_Test03("McKinely", 23, 1));
        offer(new Vote_Test03("Roosevelt", 24, 3));

        System.out.println("Elected City Supervisor " + "\n" + poll());

        for (int i = 0; i < 4; i++) {
            System.out.println("Elected City Council " + "\n" + poll());
        }
    }

    // Starts the election for problem two
    public void startElectionProblemTwo(){
        readVotes();

        offer(new Vote_Test03("Washington", 1, 3));
        offer(new Vote_Test03("Adams", 2, 3));
        offer(new Vote_Test03("Jefferson", 3, 2));
        offer(new Vote_Test03("Madison", 4, 2));
        offer(new Vote_Test03("Monroe", 5, 2));
        offer(new Vote_Test03("Quincy Adams", 6, 1));
        offer(new Vote_Test03("Jackson", 7, 1));
        offer(new Vote_Test03("Van Buren", 8, 3));
        offer(new Vote_Test03("Harrision", 9, 1));
        offer(new Vote_Test03("Tyler", 10, 2));
        offer(new Vote_Test03("Polk", 11, 2));
        offer(new Vote_Test03("Taylor", 12, 3));
        offer(new Vote_Test03("Fillmore", 13, 2));
        offer(new Vote_Test03("Pierce", 14, 2));
        offer(new Vote_Test03("Buchanan", 15, 1));
        offer(new Vote_Test03("Lincoln", 16, 1));
        offer(new Vote_Test03("Johnson", 17, 2));
        offer(new Vote_Test03("Grant", 18, 3));
        offer(new Vote_Test03("Hayes", 19, 2));
        offer(new Vote_Test03("Garfield", 20, 1));
        offer(new Vote_Test03("Arthur", 21, 1));
        offer(new Vote_Test03("Cleveland", 22, 4));
        offer(new Vote_Test03("McKinely", 23, 1));
        offer(new Vote_Test03("Roosevelt", 24, 3));

        for (int i = 0; i < 24; i++) {
            // Comparator for candidates
            Collections.sort(ballotPq, new Vote_Test03_2());
            System.out.println(poll());
        }
    }
}