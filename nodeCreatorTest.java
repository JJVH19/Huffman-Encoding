import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class nodeCreatorTest {



    @Test
    void setLeftChild() {
        nodeCreator test = new nodeCreator((23+33));
        assertEquals(test.getNode().getFrequency(),(23+33));
        test.getNode().setLeftChild(new nodeCreator.HuffmanNode(2,'c'));
        nodeCreator.HuffmanNode left = test.getNode().getLeftChild();
        assertEquals(left,test.getNode().getLeftChild());

    }

    @Test
    void setRightChild() {

        nodeCreator test = new nodeCreator(5);
        assertEquals(test.getNode().getFrequency(),5);
        test.getNode().setRightChild(new nodeCreator.HuffmanNode(2,'c'));
        nodeCreator.HuffmanNode left = test.getNode().getRightChild();
        assertEquals(left,test.getNode().getRightChild());
    }

    @Test
    void getRootNode() {
        nodeCreator tree = new nodeCreator(12);
        assertEquals(tree.getNode().getFrequency(),12);
        nodeCreator withLetter = new nodeCreator(13,'c');
        assertEquals(withLetter.getNode().getFrequency(),13);
        assertEquals(withLetter.getNode().getLetter(),'c');
    }
}