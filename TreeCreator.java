public class TreeCreator {

    public class HuffmanNode{
        private final int frequency;
        private HuffmanNode left;
        private HuffmanNode right;

        HuffmanNode(int frequency){
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

    }
    public HuffmanNode root;

    public TreeCreator(int firstFrequency, int secondFrequency){
        this.root = new HuffmanNode(firstFrequency+secondFrequency);
        if(firstFrequency < secondFrequency){
            this.root.left = new HuffmanNode(firstFrequency);
            this.root.right = new HuffmanNode(secondFrequency);
        } else{
            this.root.right = new HuffmanNode(firstFrequency);
            this.root.left = new HuffmanNode(secondFrequency);
        }
    }

    private TreeCreator(HuffmanNode prevRoot, int frequency){
        this.root = new HuffmanNode(prevRoot.frequency+frequency);
        if(prevRoot.frequency < frequency){
            this.root.left = prevRoot;
            this.root.right = new HuffmanNode(frequency);
        } else{
            this.root.right = prevRoot;
            this.root.left = new HuffmanNode(frequency);
        }
    }

    public TreeCreator addFrequency(HuffmanNode prevRoot, int frequency){
        return new TreeCreator(prevRoot,frequency);
    }

}
