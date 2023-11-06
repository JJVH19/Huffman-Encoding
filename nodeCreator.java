public class nodeCreator {

    public static class HuffmanNode{
        private final int frequency;
        private HuffmanNode left;
        private HuffmanNode right;

        HuffmanNode(int frequency){
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

    }
    public HuffmanNode rootNode;

    public nodeCreator(int firstFrequency, int secondFrequency) {
        this.rootNode = new HuffmanNode(firstFrequency + secondFrequency);
        this.rootNode.left = new HuffmanNode(firstFrequency);
        this.rootNode.right = new HuffmanNode(secondFrequency);
    }

    public HuffmanNode getRootNode(){
        return this.rootNode;
    }

    public void print(HuffmanNode node){
        System.out.println("Root Frequency: " + node.frequency + "\n--Left Child Frequency: " + node.left.frequency + "\n--Right Child Frequency: " + node.right.frequency + "\n");
    }

}
