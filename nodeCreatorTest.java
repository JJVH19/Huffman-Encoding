import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class nodeCreatorTest {



    @Test
    void setLeftChild() {

        nodeCreator test = new nodeCreator((23+33));
        assertEquals(test.getFrequency(),(23+33));
        test.setLeftChild(new nodeCreator.HuffmanNode(2,'c'));
        nodeCreator.HuffmanNode left = test.getLeftChild();
        assertEquals(left,test.getLeftChild());

    }

    @Test
    void setRightChild() {
    }

    @Test
    void getRootNode() {
        nodeCreator tree = new nodeCreator(12);
        assertEquals(tree.getFrequency(),12);
        nodeCreator withLetter = new nodeCreator(13,'c');
        assertEquals(withLetter.getFrequency(),13);
        assertEquals(withLetter.getLetter(),'c');
    }
}