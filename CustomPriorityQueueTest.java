import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CustomPriorityQueueTest {

    @Test
    void pollAndAdding() {
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));
        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(85,'s'));
        testQueue.addandMove(new nodeCreator(10,'d'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        assertTrue(testQueue.poll().getNode().getFrequency() < testQueue.poll().getNode().getFrequency());
        assertTrue(testQueue.poll().getNode().getFrequency() < testQueue.poll().getNode().getFrequency());

        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        assertEquals(testQueue.poll().getNode().getFrequency(),testQueue.poll().getNode().getFrequency());
    }

    @Test
    void isEmpty() {
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));
        assertTrue(testQueue.isEmpty());

        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(85,'s'));
        testQueue.addandMove(new nodeCreator(10,'d'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        assertFalse(testQueue.isEmpty());

        testQueue.poll();
        assertFalse(testQueue.isEmpty());
        testQueue.poll();
        assertFalse(testQueue.isEmpty());
        testQueue.poll();
        assertFalse(testQueue.isEmpty());
        testQueue.poll();
        assertTrue(testQueue.isEmpty());
    }

    @Test
    void size() {
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));
        assertEquals(testQueue.size(),0);
        testQueue.addandMove(new nodeCreator(23,'c'));
        assertEquals(testQueue.size(),1);
        testQueue.addandMove(new nodeCreator(85,'s'));
        assertEquals(testQueue.size(),2);
        testQueue.addandMove(new nodeCreator(10,'d'));
        assertEquals(testQueue.size(),3);
        testQueue.addandMove(new nodeCreator(23,'q'));
        assertEquals(testQueue.size(),4);

        testQueue.poll();
        assertEquals(testQueue.size(),3);
        testQueue.poll();
        assertEquals(testQueue.size(),2);
        testQueue.poll();
        assertEquals(testQueue.size(),1);
        testQueue.poll();
        assertEquals(testQueue.size(),0);
    }
}