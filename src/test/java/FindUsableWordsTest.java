import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;


class FindUsableWordsTest {

    private FindUsableWords findUsableWords;
    private int size = 4;
    private String letters = "eeeeddoonnnsssrv";
    private int stringSize = letters.length();

    @Test
    @DisplayName("check that returnwords only returns correct sized words")
    void check_that_returnwords_only_returns_correct_sized_words() throws IOException {
        findUsableWords = new FindUsableWords();

        List<String> matchingWords = findUsableWords.words(size,letters);

        assertTrue(stringSize == size * size);
        for(String n : matchingWords){
            assertTrue(n.length()==size);
        }

    }

}