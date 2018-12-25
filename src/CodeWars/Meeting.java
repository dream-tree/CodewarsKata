package CodeWars;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Meeting {

    public static void main(String[] args) {
        String invitedPeople = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;"
                + "Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(meeting1(invitedPeople));
        System.out.println(meeting2(invitedPeople));
        System.out.println(meeting3(invitedPeople));
    }

    // "manual"
    public static String meeting1(String unsortedInvitedPeople) {
        String[] separatedPeople = unsortedInvitedPeople.split(";");
        String[] separatedNames = new String[2];
        String[] sortedInvitedPeople = new String[separatedPeople.length];
        for (int i = 0; i < separatedPeople.length; i++) {
            separatedNames = separatedPeople[i].split(":");
            sortedInvitedPeople[i] = "(" + separatedNames[1].toUpperCase()
                    + ", " + separatedNames[0].toUpperCase() + ")";
        }
        Arrays.sort(sortedInvitedPeople);
        Optional<String> temp = Arrays.stream(sortedInvitedPeople)
                .reduce((String x, String y) -> (x + y));
        return temp.get();
    }

    // preparing to "real" stream resolution
    public static String meeting2(String unsortedInvitedPeople) {
        Stream<String> separatedPeople = Arrays.stream(unsortedInvitedPeople.split(";"));
        Stream<String[]> separatedNames = separatedPeople.map(names -> names.split(":"));
        Stream<String> separatedNamesWithBraces = separatedNames.map(
            lastAndFirst -> (
                    "("
                    + lastAndFirst[1].toUpperCase()
                    + ", "
                    + lastAndFirst[0].toUpperCase()
                    + ")"));
        Stream<String> sortedInvitedPeople = separatedNamesWithBraces.sorted();
        return sortedInvitedPeople.reduce(
            (String onePerson, String anotherPerson)
                -> (onePerson + anotherPerson))
                .get();
    }

    // "real" stream resolution
    public static String meeting3(String unsortedInvitedPeople) {
        return
                Arrays.stream(unsortedInvitedPeople.toUpperCase().split(";"))
                    .map(names -> names.split(":"))
                    .map(
                        lastAndFirst -> (
                            "("
                            + lastAndFirst[1]
                            + ", "
                            + lastAndFirst[0]
                            + ")"))
                    .sorted()
                    .reduce((String onePerson, String anotherPerson)
                        -> (onePerson + anotherPerson))
                    .get();
    }
}
