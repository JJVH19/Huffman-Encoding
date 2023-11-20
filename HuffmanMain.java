import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HuffmanMain {

    private static String path;

    public static void main(String[] args){
        //Creating hashtable
        CustomMap<Character, Integer> hashTable = new CustomMap<>(256);
        CustomMap<Character, String> codes = new CustomMap<>(256);

        //Creating priority queue
        CustomPriorityQueue<nodeCreator> huffmanTreeQueue = new CustomPriorityQueue<>(Comparator.comparingInt(o -> o.getNode().getFrequency()));

        //Accept user input to decode
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the phrase to encode:\n");
        String userInput = scanner.nextLine();

        // Populate hashtable with frequencies
        for(int character = 0; character < userInput.toCharArray().length; character++){
            char currentChar = userInput.toCharArray()[character];
            if(hashTable.get(userInput.toCharArray()[character]) != null){
                hashTable.put(currentChar,hashTable.get(currentChar)+1);
            } else{
                hashTable.put(currentChar,1);
            }
        }

        List<Character> frequencies = hashTable.keys();

        // Build nodes of frequencies
        for (Character frequency : frequencies) {
            nodeCreator newNode = new nodeCreator(hashTable.get(frequency), frequency);
            huffmanTreeQueue.addandMove(newNode);
        }

        //Populate huffman tree with current created nodes
        while(huffmanTreeQueue.size() != 1){
            nodeCreator node1 = huffmanTreeQueue.poll();
            nodeCreator node2 = huffmanTreeQueue.poll();
            nodeCreator newRoot = new nodeCreator(node1.getNode().getFrequency() + node2.getNode().getFrequency());
            newRoot.getNode().setLeftChild(node1.getNode());
            newRoot.getNode().setRightChild(node2.getNode());
            huffmanTreeQueue.addandMove(newRoot);
        }

        //Traverse tree to get huffman codes
        nodeCreator huffmanTree = huffmanTreeQueue.poll();
        traverse(huffmanTree.getNode(), codes);

        String encoded = getEncodedString(userInput, codes);

        //Presentation display for user interaction
        System.out.println("\nCharacter\tHuffman Code");

        //Creates list of huffman codes to iterate and print through
        String[] huffmanDetails = encoded.split("null");
        int userInputIndex = 0;
        for(int index = 1; index < huffmanDetails.length; index++){
            System.out.println("\t" + userInput.toCharArray()[userInputIndex] + "\t\t\t" + huffmanDetails[index]);
            userInputIndex++;
        }

        //Display final results
        System.out.println("\nEncoded user input:");
        encoded = encoded.replace("null","");
        System.out.println(encoded);

        String decoded = "";
    }

    //Traverses the tree to find the huffman codes for each character
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

    //Concatenates the string 'encoded' with huffman codes
    private static String getEncodedString(String input, CustomMap<Character, String> codes) {
        String encoded = "";
        char[] symbols = input.toCharArray();
        for (char symbol : symbols) {
            encoded += codes.get(symbol);
        }
        return encoded;
    }

    private static String decode(String toDecode, String decoded, nodeCreator.HuffmanNode node) {
        if (node.getLeftChild() == null && node.getLeftChild() == null) {
            decoded = decoded + (char) node.getLetter();
            return decoded;
        }
        return "";
    }

}