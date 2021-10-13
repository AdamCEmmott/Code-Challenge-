import java.util.Scanner;


public class UserInput {

    private final String USERSIZE = "please enter the size of the word square and press enter: ";
    private final String USERLETTERS = "please enter \"%s\" letters for the word square and press enter: ";
    private final String VALIDINT = "You have entered a size of %d.\n";
    private final String INVALIDINT = "\"%s\" is not a valid number. Try again\n";

    Scanner scanner = new Scanner(System.in);

    /*
        Method creates a scanner and outputs USERSIZE. then takes a user input.
        validates the input is an int or returns INVALIDINT and awaits another entry.
        if valid int is entered it returns that int.
     */
    public int returnWordSize() {

        int size;
        do {
            System.out.print(USERSIZE);
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf(INVALIDINT, input);
            }
            size = scanner.nextInt();
        } while (size < 0);

        System.out.printf(VALIDINT, size);

        return size;
    }

    /*
        Method uses scanner and outputs USERLETTERS. then takes a user input.
        validates the input is the minimum length if not loops back to USERLETTERS and awaits input.
        if valid length string is entered it returns that string.
     */
    public String returnUserString(int lowest) {

        lowest = lowest * lowest;
        String letters;
        do {
            System.out.printf(USERLETTERS, lowest);
            while (!scanner.hasNext()) {
            }
            letters = scanner.next();
        } while (letters.length() < lowest);

        return letters;
    }

}
