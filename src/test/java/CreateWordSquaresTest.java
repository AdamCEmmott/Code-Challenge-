import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CreateWordSquaresTest {

    private String userInputString = "eeeeddoonnnsssrv";
    private String testString = "aabbbcccc";


    private List testList = new ArrayList<String>();

    private String[] array = {"rose", "oven", "send", "ends"};


    @Test
    @DisplayName("check that validwordsquare returns valid wordsquare")
    void check_that_validwordsquare_returns_valid_wordsquare() throws IOException {

        testList.add("rose");
        testList.add("oven");
        testList.add("send");
        testList.add("ends");

        CreateWordSquares createWordSquares = new CreateWordSquares();
        Map map = createWordSquares.createMapofString(userInputString);

        List list = createWordSquares.checkIfValidWordSquare(array, map);

        assertEquals(list, testList);
        assertTrue("test that wordsquare returns correct number of words",list.size() == 4);

    }

    @Test
    @DisplayName("check that returnmaptest returns correct mapping")
    void check_that_returnmaptest_returns_correct_mapping() {
        CreateWordSquares createWordSquares = new CreateWordSquares();

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("a", 2);
        myMap.put("b", 3);
        myMap.put("c", 4);

        Map map = createWordSquares.createMapofString(testString);

        assertEquals(map.toString(), myMap.toString());

    }
}