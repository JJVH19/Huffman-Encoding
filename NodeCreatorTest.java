import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeCreatorTest {
    @Test
    void setLeftChild() {
        //Creates node
        nodeCreator test = new nodeCreator((23+33));

        //Checks if node was created correctly
        assertEquals(test.getNode().getFrequency(),(23+33));

        //Set the left child of the node created to another node object
        test.getNode().setLeftChild(new nodeCreator.HuffmanNode(2,'c'));

        //Creates testing node
        nodeCreator.HuffmanNode left = test.getNode().getLeftChild();

        //Confirms that node set to the left child was done correctly
        assertEquals(left,test.getNode().getLeftChild());
    }

    @Test
    void setRightChild() {
        //Creates node
        nodeCreator test = new nodeCreator(5);

        //Checks if node was created correctly
        assertEquals(test.getNode().getFrequency(),5);

        //Set the left child of the node created to another node object
        test.getNode().setRightChild(new nodeCreator.HuffmanNode(2,'c'));

        //Creates testing node
        nodeCreator.HuffmanNode left = test.getNode().getRightChild();

        //Confirms that node set to the left child was done correctly
        assertEquals(left,test.getNode().getRightChild());
    }

    @Test
    void getRootNode() {
        //Creates node with only frequency
        nodeCreator tree = new nodeCreator(12);

        //Checks if node was created correctly
        assertEquals(tree.getNode().getFrequency(),12);

        //Creates node with letter and frequency
        nodeCreator withLetter = new nodeCreator(13,'c');

        //Checks if node was created correctly
        assertEquals(withLetter.getNode().getFrequency(),13);
        assertEquals(withLetter.getNode().getLetter(),'c');
    }
}