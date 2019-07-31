package Vote;
import java.util.*;
/*import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;*/

public class Vote_Test01 {

final Map<String, List<String>> votingMap = new HashMap<>();

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Set<String> names = new LinkedHashSet<>(Arrays.asList("1", "2", "3"));
    Vote_Test01 Vote_Test01 = new Vote_Test01(names);
    int counter = 1;

    while (true) {
        System.out.println("1. Vote\n2. Credit\n3. Exit");
        switch (in.nextLine()) {
            case "1":
            	Vote_Test01.vote(in, counter++);
                break;
            case "2":
            	Vote_Test01.dumpResults(names);
                break;
            case "3":
                return;
            default:
                System.out.print("Please input Numbers 1, 2, 3,");
        }
    }
}

public Vote_Test01(Set<String> names) {
    for (String name : names) 
        votingMap.put(name, new ArrayList<>());
}

private void vote(Scanner in, int counter) {
    System.out.print("Enter " + counter + nth(counter) + " Voters Name: ");
    String name = in.nextLine();
    while (true) {
        System.out.println("Choose your Vote: " + votingMap.keySet().stream().collect(Collectors.joining(",")));
        String voteFor = in.nextLine();
        List<String> voters = votingMap.get(voteFor);
        if (voters != null) {
            voters.add(name);
            return;
        }
    }
}

private void dumpResults() {
    votingMap.forEach((k, v) -> {
        System.out.println(k + ": "+ v);
    });
}
}