import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Main {

	public static void main(String[] args) throws IOException {

		//Get the size and letters from user.
		UserInput userInput = new UserInput();
		int size = userInput.returnWordSize();
		String userInputString = userInput.returnUserString(size);

		//Find all words from dictonary.txt with a size of user size.
		FindUsableWords findUsableWords = new FindUsableWords();
		List<String> myWords =findUsableWords.words(size, userInputString);

		//creat a map of the user string
		CreateWordSquares createWordSquares = new CreateWordSquares();
		Map map = createWordSquares.createMapofString(userInputString);

		//Create array of applicable words
		String[] array = myWords.toArray(new String[0]);
		//create wordsquares from the list of applicable words, and output valid wordsquares.
		List<String> wordDescription = createWordSquares.checkIfValidWordSquare(array,map);

		//return the definition of the words in wordsquare if user wants
		ReturnDefinition returnDescription = new ReturnDefinition();
		returnDescription.outputDefinition(wordDescription);

	}

}
