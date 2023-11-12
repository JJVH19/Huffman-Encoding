import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomMapTest {

    @Test
    void put() {
        CustomMap<Object, Object> test = new CustomMap<>(11);
        test.put('x','x'%26);
        assertEquals(test.get('x'),1);


    }

    @Test
    void get() {
    }

    @Test
    void keys() {
    }

    @Test
    void size() {
    }
}