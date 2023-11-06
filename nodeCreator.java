public class nodeCreator {

    public static class HuffmanNode{
        private final int frequency;
        private char letter;
        private HuffmanNode left;
        private HuffmanNode right;

        HuffmanNode(int frequency, char letter){
            this.frequency = frequency;
            this.letter = letter;
            this.left = null;
            this.right = null;
        }

        HuffmanNode(int frequency){
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

    }
    public HuffmanNode node;

    public nodeCreator(int frequency) {
        this.node = new HuffmanNode(frequency);
    }

    public void setLeftChild(HuffmanNode leftChild){
        this.node.left = leftChild;
    }

    public void setRightChild(HuffmanNode rightChild){
        this.node.right = rightChild;
    }
    public HuffmanNode getRootNode(){
        return this.node;
    }

    public void print(HuffmanNode node){
        System.out.println("Root Frequency: " + node.frequency + "\n--Left Child Frequency: " + node.left.frequency + "->" + node.left.letter +
                "\n--Right Child Frequency: " + node.right.frequency + "->"+ node.right.letter + "\n");
    }

}
