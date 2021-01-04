public class FindDuplicateBeastMode {

    //find a duplicate number in an array of length n + 1 and in range 1...n
    //should be in O(n) time and O(1) space
    //traverse the array like a linked list
    //- the head of the linked list will be the node in the last position since the
    // length is n + 1 (in a length of 5 there will be no node with the value 5)
    //- no node in the list will point to null so there has to be a cycle in some point
    // of the linked list

    //A. We know the position of a node with multiple incoming pointers is a duplicate
    // in our array because the nodes that pointed to it must have the same value
    //B. We find the node with multiple incoming pointers by finding the first node in
    // the cycle
    //C. We find the first node in the cycle by starting at the head, going the lenght
    // of the cycle and seeing if we're back at the first node
    //D. We find the length of the cycle by remembering a position inside the cycle and
    // then counting how many steps it takes to get back to it
    //E. We get inside a cycle by starting at the head and travelling n steps

    //GO BACKWARDS THROUGH THESE

    public int findDuplicate(int[] intArray) {

        final int n = intArray.length - 1;

        //STEP 1: GET INSIDE A CYCLE
        //starting at head
        int positionInCycle = n + 1;
        for (int i = 0; i < n; i++) {
            positionInCycle = intArray[positionInCycle - 1];
        }

        //STEP 2: FIND THE LENGTH OF THE CYCLE
        int rememberedPositionInCycle = positionInCycle;
        int currentPositionInCycle = intArray[positionInCycle - 1];
        int cycleStepCount = 1;

        while (currentPositionInCycle != rememberedPositionInCycle) {
            currentPositionInCycle = int[currentPositionInCycle - 1];
            cycleStepCount += 1;
        }

        //STEP 3: FIND THE FIRST NODE IN THE CYCLE
        int pointerStart = n + 1;
        int pointerAhead = n + 1;
        for (int i = 0; i < cycleStepCount; i++) {
            pointerAhead = intArray[pointerAhead - 1];
        }

        while (pointerStart != pointerAhead) {
            pointerStart = intArray[pointerStart - 1];
            pointerAhead = intArray[pointerAhead - 1];
        }

        return pointerStart;
    }
}
