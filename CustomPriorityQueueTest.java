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

    @Test
    void connectNodes() {
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));
        assertTrue(testQueue.isEmpty());

        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(85,'s'));
        testQueue.addandMove(new nodeCreator(10,'d'));
        testQueue.addandMove(new nodeCreator(23,'q'));
        assertEquals(testQueue.size(),4);
        assertFalse(testQueue.isEmpty());

        nodeCreator test1 = testQueue.poll();
        assertEquals(test1.getNode().getFrequency(),10);
        assertEquals(test1.getNode().getLetter(),'d');
        assertEquals(testQueue.size(),3);

        nodeCreator test2 = testQueue.poll();
        assertEquals(test2.getNode().getFrequency(),23);
        assertEquals(test2.getNode().getLetter(),'q');
        assertEquals(testQueue.size(),2);

        nodeCreator newRoot = new nodeCreator((test1.getNode().getFrequency()+test2.getNode().getFrequency()));
        assertEquals(newRoot.getNode().getFrequency(),33);

        newRoot.getNode().setLeftChild(test1.getNode());
        assertEquals(newRoot.getNode().getLeftChild().getFrequency(),10);
        assertEquals(newRoot.getNode().getLeftChild().getLetter(),'d');

        newRoot.getNode().setRightChild(test2.getNode());
        assertEquals(newRoot.getNode().getRightChild().getFrequency(),23);
        assertEquals(newRoot.getNode().getRightChild().getLetter(),'q');

        testQueue.addandMove(newRoot);
        assertEquals(testQueue.size(),3);

        nodeCreator test3 = testQueue.poll();
        assertEquals(test3.getNode().getFrequency(),23);
        assertEquals(test3.getNode().getLetter(),'c');
        assertEquals(testQueue.size(),2);

        nodeCreator finalTest = testQueue.poll();
        assertEquals(finalTest.getNode().getFrequency(),33);
        assertEquals(finalTest.getNode().getLeftChild().getFrequency(),10);
        assertEquals(finalTest.getNode().getLeftChild().getLetter(),'d');
        assertEquals(finalTest.getNode().getRightChild().getFrequency(),23);
        assertEquals(finalTest.getNode().getRightChild().getLetter(),'q');
        assertEquals(testQueue.size(),1);
    }
}