public class HuffmanMain {
    static TreeCreator huffmanTree;

    public static void main(String[] args){


        //frequency data structure here

        //Simulation to add things to the tree
        int[] frequencySimulator = new int[]{17,28,37,49,59,68};
        boolean firstRoot = true;
        for(int i = 0; i < frequencySimulator.length; i++){
            if(firstRoot){
                huffmanTree = new TreeCreator(frequencySimulator[i],frequencySimulator[i+1]);
                firstRoot = false;
            } else{
                huffmanTree = huffmanTree.addFrequency(huffmanTree.root, frequencySimulator[i]);
            }
        }





    }
}
