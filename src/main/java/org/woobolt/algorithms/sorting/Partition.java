package org.woobolt.algorithms.sorting;

public class Partition {
    private int[] theArray;

    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left - 1;           // right of first elem
        int rightPtr = right + 1;         // left of pivot
        while(true)
        {
            while(leftPtr < right &&       // find bigger item
                    theArray[++leftPtr] < pivot)
                ;  // (nop)

            while(rightPtr > left &&       // find smaller item
                    theArray[--rightPtr] > pivot)
                ;  // (nop)
            if(leftPtr >= rightPtr)        // if pointers cross,
                break;                      //    partition done
            else                           // not crossed, so
                swap(leftPtr, rightPtr);    //    swap elements
        }  // end while(true)
        return leftPtr;                   // return partition
    }  // end partitionIt()
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2)  // swap two elements
    {
        int temp;
        temp = theArray[dex1];             // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }  // end swap()
}
