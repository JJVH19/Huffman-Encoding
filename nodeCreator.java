public class nodeCreator {

    public static class HuffmanNode {
        private int frequency;
        private char letter;
        private HuffmanNode left;
        private HuffmanNode right;

        HuffmanNode(int frequency, char letter) {
            this.frequency = frequency;
            this.letter = letter;
            this.left = null;
            this.right = null;
        }

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

        public void setFrequency(int newFrequency) {
            this.frequency = newFrequency;
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

    public void print(HuffmanNode node) {
        System.out.println("Root Frequency: " + node.frequency + "\n--Left Child Frequency: " + node.left.frequency + "->" + node.left.letter +
                "\n--Right Child Frequency: " + node.right.frequency + "->" + node.right.letter + "\n");
    }

}
