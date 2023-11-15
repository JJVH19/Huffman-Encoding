import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomMapTest {

    @Test
    void put() {
        CustomMap<Character, Integer> test = new CustomMap<>(256);
        assertEquals(test.size(),0);
        test.put('c',1);
        assertEquals(test.size(),1);
        assertEquals(test.get('c'),1);
        test.put('d',1);
        assertEquals(test.size(),2);
        assertEquals(test.get('d'),1);
        assertEquals(test.get('c'),1);

        test.put('c', (test.get('c')+1));
        assertEquals(test.size(),2);
        assertEquals(test.get('c'),2);
    }
}