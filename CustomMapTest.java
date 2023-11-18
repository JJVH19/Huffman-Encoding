import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomMapTest {

    @Test
    void testHashtable() {
        //Creates simulated hashtable
        CustomMap<Character, Integer> test = new CustomMap<>(256);

        //Checks to see if hashtable is initially empty
        assertEquals(test.size(),0);

        //Adds character and its frequency to hashtable
        test.put('c',1);

        //Checks to see if frequency and letter are added correctly
        assertEquals(test.size(),1);
        assertEquals(test.get('c'),1);

        //Adds another character and its frequency to hashtable
        test.put('d',1);

        //Checks to see if frequency and letter are added correctly
        assertEquals(test.size(),2);
        assertEquals(test.get('d'),1);

        //Checks to see if it did not affect previous elements within the hashtable
        assertEquals(test.get('c'),1);

        //Increments frequency of a specific letter
        test.put('c', (test.get('c')+1));

        //Checks to see if incrementation was done correctly
        assertEquals(test.size(),2);
        assertEquals(test.get('c'),2);
    }
}