import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CreateWordSquares {

    private final String VALID = "valid word square is ";
    private final String INVALID = "No valid word squares available !";

    /*
    Creates a map of the number of times a letter is in a string. abbccc would return a map of {a:1,b:2,c:3}
     */
    public Map createMapofString(String string) {
        Map letterMap = string.toLowerCase().chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

        return letterMap;

    }

    /*
    Takes a list of Strings and concatenates them into a single string with no spaces
     */
    private String stringCompressor(List list) {
        String string = String.join(",", list).replace(",", "").toLowerCase();

        return string;
    }

    /*
    Takes an array of words of the correct size and containing the correct letters and a map of the letters input by the user.
    checks if those words can form a valid wordsquare then concatenates those words and maps the resulting string.
    it checks if the maps match. if yes prints out the word and returns that wordsquare.
     */
    public List<String> checkIfValidWordSquare(String[] array, Map mapA) {
        WordSquareAlgorithm wordSquareAlgorithm = new WordSquareAlgorithm();

        List<String> squareWords = new ArrayList<>();

        boolean flag = false;

        for (List n : wordSquareAlgorithm.wordSquares(array)) {

            String string = stringCompressor(n);

            Map mapB = createMapofString(string);

            if (mapA.equals(mapB)) {
                System.out.println();
                System.out.println(VALID);
                System.out.println();

                for (Object word : n) {
                    System.out.println("\t" + word.toString());
                    squareWords.add(word.toString());

                    flag = true;
                }
            }

        }
        if (!flag) {
            System.out.println(INVALID);
        }

        return squareWords;

    }
}