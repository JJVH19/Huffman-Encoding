public class HuffmanMain {
    static nodeCreator root;
    static nodeCreator leftChild;
    static nodeCreator rightChild;

    public static void main(String[] args){

        nodeCreator.HuffmanNode[] priorityQueueSimulation = new nodeCreator.HuffmanNode[6];
        int priorityQueueSimulationIndex = 0;
        //frequency data structure here

        //Simulation to add things to the tree
        int[] frequencySimulator = new int[]{17,28,37,49,59,68};
        char asciiCharacter = 97;
        for(int i = 0; i < frequencySimulator.length; i+=2){
            root = new nodeCreator((frequencySimulator[i]+frequencySimulator[i+1]));
            root.setLeftChild((new nodeCreator.HuffmanNode(frequencySimulator[i],asciiCharacter++)));
            root.setRightChild((new nodeCreator.HuffmanNode(frequencySimulator[i+1],asciiCharacter++)));


            //Simulation of pushing into priority queue
            priorityQueueSimulation[priorityQueueSimulationIndex] = root.getRootNode();
            root.print(priorityQueueSimulation[priorityQueueSimulationIndex]);
            priorityQueueSimulationIndex++;
        }
        //Priority queue insertion here

    }
}
