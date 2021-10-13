import java.util.List;
import java.util.Scanner;


public class ReturnDefinition {

    private final String DEFINITION = "would you like to see the definitions of the words? please enter Y or N";
    private final String GOODBYE = "Goodbye!";
    private final String YES = "y";
    private final String NO = "n";
    private final String YESDEFINITION = " Definition:";
    private final String NODEFINITION = "no definition found";

    /*
        Asks the user if they would like to see the definitions of the words in the wrodsquare. if y then output the word followed by the definition.
        if n then say goodbye and close.
        if not y or n, then repeat the quetion and await a valid input.
     */
    public void outputDefinition(List list) {

        Scanner scanner = new Scanner(System.in);

        System.out.println();

        String answer;

        do {
            System.out.printf(DEFINITION);
            while (!scanner.hasNext()) {

            }
            answer = scanner.next();

        } while (!answer.equals(YES) && !(answer).equals(NO));

        if ((YES).equals(answer)) {

            returnDefinition(list);
            System.out.println();
            System.out.println(GOODBYE);

        } else if ((NO).equals(answer)) {
            System.out.println();
            System.out.println(GOODBYE);

        }

    }

    /*
        takes a word, sends to an Api and returns the definition of that word
     */
    private List<String> findDefinition(String word) {

        Api api = new Api();
        GetDescription getDescription = new GetDescription();

        String payload = api.getDefinitions(word);
        return getDescription.definitions(payload);

    }

    /*
        takes a list of words, sends each to an Api and returns the definition of those words as a list of strings
     */
    private void returnDefinition(List<String> list) {

        for (String word : list) {

            List<String> descriptions = findDefinition(word);
            if (descriptions == null || descriptions.isEmpty()) {
                System.out.println();
                System.out.println(word + YESDEFINITION);
                System.out.println(NODEFINITION);
            } else {

                System.out.println();
                System.out.println(word + YESDEFINITION);
                for (String string1 : descriptions) {
                    System.out.println(string1);

                }
            }

        }

    }
}
