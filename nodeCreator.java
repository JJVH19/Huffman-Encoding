public class nodeCreator {

    public static class HuffmanNode {
        private int frequency;
        private char letter;
        private HuffmanNode left;
        private HuffmanNode right;

        //This constructor will make a leaf node holding the character and frequency
        HuffmanNode(int frequency, char letter) {
            this.frequency = frequency;
            this.letter = letter;
            this.left = null;
            this.right = null;
        }

        //This constructor will make a node holding only the frequency to connect them with the leaf nodes
        HuffmanNode(int frequency) {
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        public void setLeftChild(HuffmanNode leftChild) {
            this.left = leftChild;
        }

        public HuffmanNode getLeftChild() {
            return this.left;
        }

        public HuffmanNode getRightChild() {
            return this.right;
        }

        public void setRightChild(HuffmanNode rightChild) {
            this.right = rightChild;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public int getLetter() {
            return this.letter;
        }

    }

    public HuffmanNode node;

    public nodeCreator(int frequency) {
        this.node = new HuffmanNode(frequency);
    }
    public nodeCreator(int frequency, char letter) {
        this.node = new HuffmanNode(frequency,letter);
    }

    public HuffmanNode getNode() {
        return this.node;
    }

}
