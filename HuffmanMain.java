public class HuffmanMain {
    static nodeCreator huffmanTreeNode;

    public static void main(String[] args){

        nodeCreator.HuffmanNode[] priorityQueueSimulation = new nodeCreator.HuffmanNode[6];
        int priorityQueueSimulationIndex = 0;
        //frequency data structure here

        //Simulation to add things to the tree
        int[] frequencySimulator = new int[]{17,28,37,49,59,68};
        for(int i = 0; i < frequencySimulator.length; i+=2){
            huffmanTreeNode = new nodeCreator(frequencySimulator[i],frequencySimulator[i+1]);

            //Simulation of pushing into priority queue
            priorityQueueSimulation[priorityQueueSimulationIndex] = huffmanTreeNode.getRootNode();
            huffmanTreeNode.print(priorityQueueSimulation[priorityQueueSimulationIndex]);
            priorityQueueSimulationIndex++;
        }
        //Priority queue insertion here

    }
}
