import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HuffmanMain {

    private static String path;

    public static void main(String[] args){
        CustomMap<Character, Integer> hashTable = new CustomMap<>(256);
        CustomPriorityQueue<nodeCreator> huffmanTreeQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));
        CustomMap<Character, String> codes = new CustomMap<>(256);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the phrase to encode:\n");
        String userInput = scanner.nextLine();

        // Put frequencies in the hashtable
        for(int character = 0; character < userInput.toCharArray().length; character++){
            char currentChar = userInput.toCharArray()[character];
            if(hashTable.get(userInput.toCharArray()[character]) != null){
                hashTable.put(currentChar,hashTable.get(currentChar)+1);
            } else{
                hashTable.put(currentChar,1);
            }
        }

        List<Character> frequencies = hashTable.keys();

        // Build tree of frequencies
        for (Character frequency : frequencies) {
            nodeCreator newNode = new nodeCreator(hashTable.get(frequency), frequency);
            huffmanTreeQueue.addandMove(newNode);
        }

        while(huffmanTreeQueue.size() != 1){
            nodeCreator node1 = huffmanTreeQueue.poll();
            nodeCreator node2 = huffmanTreeQueue.poll();
            nodeCreator newRoot = new nodeCreator(node1.getNode().getFrequency() + node2.getNode().getFrequency());
            newRoot.getNode().setLeftChild(node1.getNode());
            newRoot.getNode().setRightChild(node2.getNode());
            huffmanTreeQueue.addandMove(newRoot);
        }
        nodeCreator huffmanTree = huffmanTreeQueue.poll();
        traverse(huffmanTree.getNode(), codes);
        String encoded = getEncodedString(userInput, codes);
        System.out.println(encoded);

        // Idea: build a custom map object with letter keys and encoded string (1&0)
        // need to traverse the tree (backtracking?) -- until reach leaf node

//        String encoded = "";
//        for(int character = 0; character < userInput.toCharArray().length; character++){
//            char currentChar = userInput.toCharArray()[character];
//            encoded+=encode(huffmanTree.getNode(),currentChar);
//        }
//        System.out.println(encoded);
        //Priority queue insertion here

    }

    public static void traverse(nodeCreator.HuffmanNode node, CustomMap<Character, String> codes) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {  // leaf node, corresponds to a letter
            codes.put((char) node.getLetter(), path);
            path = path.substring(0, path.length()-1);  // remove last char in string
            return;
        }
        if (node.getLeftChild() != null) {
            path += "0";
            traverse(node.getLeftChild(), codes);
        }
        if (node.getRightChild() != null) {
            path += "1";
            traverse(node.getRightChild(), codes);
        }
    }

    private static String getEncodedString(String input, CustomMap<Character, String> codes) {
        String encoded = "";
        char[] symbols = input.toCharArray();
        for (char symbol : symbols) {
            encoded += codes.get(symbol);
        }
        return encoded;
    }

//    public static String encode(nodeCreator.HuffmanNode node, char currentChar){
//        if(node.getLeftChild() == null && node.getRightChild() == null && node.getLetter() == currentChar){
//            return "";
//        }
//        if(node.getLeftChild() != null){
//            return "0" + encode(node.getLeftChild(),currentChar);
//        }
//        if(node.getRightChild() != null){
//            return "1" + encode(node.getRightChild(),currentChar);
//        }
//
//        return null;
//    }
}
