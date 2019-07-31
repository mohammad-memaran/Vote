package Vote;

import java.util.Scanner;

public class Vote_Test02 {


    public static void main(String[] args){
        new Vote_Test02().main_menu();
    }

    private Nominee a, b, c;
    private Voter[] voters = new Voter[3];

    public void main_menu(){

        Scanner menu = new Scanner(System.in);
        System.out.println("1. Vote");
        System.out.println("2. Credits");
        System.out.println("3. Exit");
        String n = menu.next();
        if (n.equals("1")){
            setNominees();
            voting();
        }
        else if (n.equals("2")){
            System.out.print("Continue");
        }
        else if (n.equals("3")){
            System.exit(0);
        }
        else{
            System.out.print("Please input Numbers 1, 2, 3,");
        }
    }


    private void setNominees(){

        boolean redoo = true;
        Scanner in = new Scanner(System.in);

        do{
            System.out.print("Enter 1st Nominee: ");
            a = new Nominee(in.nextLine());
            System.out.print("Enter 2nd Nominee: ");
            b = new Nominee(in.nextLine());
            System.out.print("Enter 3rd Nominee: ");
            c = new Nominee(in.nextLine());
            System.out.printf("Nominees are: %s, %s, %s\n", a.getName(), b.getName(), c.getName());


            /*
            confirm() comes here
            its looped until a break is called with A or B
            when A the outer loop is stoped aswell and we continue
            when B the inner loop breaks but the outer do-loop is repeated
            */
            do{
                System.out.println("Confirm Nominees ? A.Yes or B.No");
                String s = in.nextLine();

                if (s.equals("A")){
                    redoo = false;
                    break;
                }
                else if (s.equals("B")){
                    break;
                }
                else{
                    System.out.println("Please Enter A or B ");
                }
            }
            while(true);
        }
        while(redoo);
        //in.close();

    }

    private void voting(){

        /*
        the for-loop iterates as often as your voters-array has fields.
        In case you remove the voters array cause you decide to not NSA into everyones Votes,
        set numbervoters to the number, how often the loop should iterate.
         */
        int numbervoters = voters.length;
        for(int i = 0; i < numbervoters; i++ ){
            Scanner in1 = new Scanner(System.in);
            System.out.printf("Enter #%s Voters Name: \n", i+1);
            String name = in1.nextLine();
            //you might ask now if the Name is correct and build a loop over this.
            //when user misspelled his name you repeat the loop until he entered it correct, just an option
            voters[i] = new Voter(name);

            do {
                System.out.printf("Choose your Vote: 1. %s 2. %s 3. %s\n", a.getName(), b.getName(), c.getName());
                Scanner in2 = new Scanner(System.in);
                String choice = in2.next();

                if (choice.equals("1")) {
                    System.out.printf("Sure to vote for %s? Y/y=yes", a.getName());
                    Scanner in3 = new Scanner(System.in);
                    String sure = in3.next();
                    if (sure.equals("Y") || sure.equals("y")) {
                        a.addVote();
                        break;
                    }
                } else if (choice.equals("2")) {
                    System.out.printf("Sure to vote for %s? Y/y=yes", b.getName());
                    Scanner in3 = new Scanner(System.in);
                    String sure = in3.next();
                    if (sure.equals("Y") || sure.equals("y")) {
                        b.addVote();
                        break;
                    }
                } else if (choice.equals("3")) {
                    System.out.printf("Sure to vote for %s? Y/y=yes", c.getName());
                    Scanner in3 = new Scanner(System.in);
                    String sure = in3.next();
                    if (sure.equals("Y") || sure.equals("y")) {
                        c.addVote();
                        break;
                    }
                } else {
                    System.out.print("You have to chose one of the 3 Nominees! No chance to not Vote!");
                }
            }
            while(true);
            voters[i].voted();
        }

        System.out.printf("Results are: \n%d votes for %s\n%d votes for %s\n%d votes for %s\n",
                a.countVotes(), a.getName(),
                b.countVotes(), b.getName(),
                c.countVotes(), c.getName());
    }

}