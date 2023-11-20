import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CustomPriorityQueueTest {

    @Test
    void pollAndAdding() {

        //Creates priority queue simulation
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));

        //Adds node objects to the priority queue
        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(85,'s'));
        testQueue.addandMove(new nodeCreator(10,'d'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        //Empties the queue by taking elements from it and checks to see if they were placed in order based on their frequency values
        assertTrue(testQueue.poll().getNode().getFrequency() < testQueue.poll().getNode().getFrequency());
        assertTrue(testQueue.poll().getNode().getFrequency() < testQueue.poll().getNode().getFrequency());

        //Adds two of the four nodes taken off from the queue back in
        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        //Checks to see if the queue maintains consistency with the frequency value order
        assertEquals(testQueue.poll().getNode().getFrequency(),testQueue.poll().getNode().getFrequency());
    }

    @Test
    void isEmpty() {

        //Creates priority queue simulation
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));

        //Confirms that queue starts empty
        assertTrue(testQueue.isEmpty());

        //Adds node objects to the priority queue
        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(85,'s'));
        testQueue.addandMove(new nodeCreator(10,'d'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        //Confirms that queue is no longer empty
        assertFalse(testQueue.isEmpty());

        //Takes off elements one by one to check if it affects other elements in the queue
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

        //Creates priority queue simulation
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));

        //Checks size of queue to confirm nothing else is being added other than the node itself
        assertEquals(testQueue.size(),0);
        testQueue.addandMove(new nodeCreator(23,'c'));
        assertEquals(testQueue.size(),1);
        testQueue.addandMove(new nodeCreator(85,'s'));
        assertEquals(testQueue.size(),2);
        testQueue.addandMove(new nodeCreator(10,'d'));
        assertEquals(testQueue.size(),3);
        testQueue.addandMove(new nodeCreator(23,'q'));
        assertEquals(testQueue.size(),4);

        //Confirms that queue keeps count of its size
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
    void huffmanTreeSimulation() {

        //Creates priority queue simulation
        CustomPriorityQueue<nodeCreator> testQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));

        //Confirms that queue starts empty
        assertTrue(testQueue.isEmpty());

        //Adds node objects to the priority queue
        testQueue.addandMove(new nodeCreator(23,'c'));
        testQueue.addandMove(new nodeCreator(85,'s'));
        testQueue.addandMove(new nodeCreator(10,'d'));
        testQueue.addandMove(new nodeCreator(23,'q'));

        //Confirms that only four nodes are added
        assertEquals(testQueue.size(),4);
        assertFalse(testQueue.isEmpty());

        //Confirms that the first node is the one with the lowest frequency
        nodeCreator test1 = testQueue.poll();
        assertEquals(test1.getNode().getFrequency(),10);
        assertEquals(test1.getNode().getLetter(),'d');
        assertEquals(testQueue.size(),3);

        //Confirms that the next node is the one with the lowest frequency
        nodeCreator test2 = testQueue.poll();
        assertEquals(test2.getNode().getFrequency(),23);
        assertEquals(test2.getNode().getLetter(),'q');
        assertEquals(testQueue.size(),2);

        //Creates a new node that will connect the two previously created nodes with their frequency sum
        nodeCreator newRoot = new nodeCreator((test1.getNode().getFrequency()+test2.getNode().getFrequency()));
        assertEquals(newRoot.getNode().getFrequency(),33);

        //Confirms that the new node's left child is the test1 node
        newRoot.getNode().setLeftChild(test1.getNode());
        assertEquals(newRoot.getNode().getLeftChild().getFrequency(),10);
        assertEquals(newRoot.getNode().getLeftChild().getLetter(),'d');

        //Confirms that the new node's right child is the test2 node
        newRoot.getNode().setRightChild(test2.getNode());
        assertEquals(newRoot.getNode().getRightChild().getFrequency(),23);
        assertEquals(newRoot.getNode().getRightChild().getLetter(),'q');

        //Adds new node into the priority queue
        testQueue.addandMove(newRoot);
        assertEquals(testQueue.size(),3);

        //Pull from queue next lowest node
        nodeCreator test3 = testQueue.poll();
        assertEquals(test3.getNode().getFrequency(),23);
        assertEquals(test3.getNode().getLetter(),'c');
        assertEquals(testQueue.size(),2);

        //Should pull the new node we created with its children already filled
        nodeCreator test4 = testQueue.poll();
        assertEquals(test4.getNode().getFrequency(),33);
        assertEquals(test4.getNode().getLeftChild().getFrequency(),10);
        assertEquals(test4.getNode().getLeftChild().getLetter(),'d');
        assertEquals(test4.getNode().getRightChild().getFrequency(),23);
        assertEquals(test4.getNode().getRightChild().getLetter(),'q');
        assertEquals(testQueue.size(),1);

        //Creates another new node that will connect the two previously created nodes with their frequency sum
        nodeCreator secondConnection = new nodeCreator((test3.getNode().getFrequency() + test4.getNode().getFrequency()));
        assertEquals(secondConnection.getNode().getFrequency(),56);

        //Confirms that the second new node's left child is the test3 node
        secondConnection.getNode().setLeftChild(test3.getNode());
        assertEquals(secondConnection.getNode().getLeftChild().getFrequency(),23);
        assertEquals(secondConnection.getNode().getLeftChild().getLetter(),'c');

        //Confirms that the second new node's right child is the newRoot node
        secondConnection.getNode().setRightChild(test4.getNode());
        assertEquals(secondConnection.getNode().getRightChild().getFrequency(),33);

        //Pushes in the secondConnection node back into the queue
        testQueue.addandMove(secondConnection);
        assertEquals(testQueue.size(),2);

        //Confirms that the next node is the secondConnection node previous created
        nodeCreator finalTest1 = testQueue.poll();
        assertEquals(testQueue.size(),1);
        assertEquals(finalTest1.getNode().getFrequency(),56);
        assertEquals(finalTest1.getNode().getLeftChild().getFrequency(),23);
        assertEquals(finalTest1.getNode().getLeftChild().getLetter(),'c');
        assertEquals(finalTest1.getNode().getRightChild().getFrequency(),33);

        //Last node should be the one with the highest frequency, in this case, 83
        nodeCreator finalTest2 = testQueue.poll();
        assertEquals(testQueue.size(),0);
        assertTrue(testQueue.isEmpty());
        assertEquals(finalTest2.getNode().getFrequency(),85);
        assertEquals(finalTest2.getNode().getLetter(),'s');

        //Creates a final new node that will connect the two previously created nodes with their frequency sum
        nodeCreator root = new nodeCreator(finalTest1.getNode().getFrequency() + finalTest2.getNode().getFrequency());
        assertEquals(root.getNode().getFrequency(),141);

        //Confirms that the final new node's left child is the finalTest1 node
        root.getNode().setLeftChild(finalTest1.getNode());
        assertEquals(root.getNode().getLeftChild().getFrequency(),56);

        //Confirms that the final new node's right child is the finalTest2 node
        root.getNode().setRightChild(finalTest2.getNode());
        assertEquals(root.getNode().getRightChild().getFrequency(),85);
        assertEquals(root.getNode().getRightChild().getLetter(),'s');

        //Confirms that queue only has one node left and the huffman tree is complete
        testQueue.addandMove(root);
        assertEquals(testQueue.size(),1);
    }
}