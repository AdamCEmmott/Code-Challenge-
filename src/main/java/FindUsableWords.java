import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FindUsableWords {

    private final String DICTONARY = "src/main/resources/dictonary.txt";


    /*
    Takes in a string and a size then opens a text file and loops through returning words of the correct size,
    then runs checker method to return a list of only words that can be made from the characters of the input string.
     */
    public List<String> words(int size, String letters) throws IOException {

        List<String> matchingWords = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(DICTONARY));
        String dictWord;
        while ((dictWord = br.readLine()) != null) {
            if (dictWord.length() == size) {
                if (checker(dictWord.toLowerCase(), letters.toLowerCase())) {
                    matchingWords.add(dictWord);

                }
            }
        }

        return matchingWords;
    }

    /*
        Takes a word and a string of letters. splits the word into a char array. then checks that every character can be found in the string.
     */
    private boolean checker(String arg, String letters) {

        boolean contains = false;
        String wordTocheck = letters.toLowerCase();

        char[] charArray = arg.toCharArray();

        for (char n : charArray) {

            contains = wordTocheck.contains(Character.toString(n));
            if (!contains) {
                return false;
            }
        }
        return contains;
    }

}
