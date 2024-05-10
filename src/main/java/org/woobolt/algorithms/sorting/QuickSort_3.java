package org.woobolt.algorithms.sorting;

public class QuickSort_3 {
    private int[] theArray;          // ref to array theArray
    private int nElems;               // number of data items


    public QuickSort_3(int max)          // constructor
    {
        theArray = new int[max];      // create the array
        nElems = 0;                    // no items yet
    }

    public void quickSort()
    {
        recQuickSort(0, nElems-1);
        // insertionSort(0, nElems-1); // the other option
    }

    public void recQuickSort(int left, int right)
    {
        int size = right-left+1;
        if(size < 10)                   // insertion sort if small
            insertionSort(left, right);
        else                            // quicksort if large
        {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }

    public long medianOf3(int left, int right)
    {
        int center = (left+right)/2;
        // order left & center
        if( theArray[left] > theArray[center] )
            swap(left, center);
        // order left & right
        if( theArray[left] > theArray[right] )
            swap(left, right);
        // order center & right
        if( theArray[center] > theArray[right] )
            swap(center, right);

        swap(center, right-1);           // put pivot on right
        return theArray[right-1];        // return median value
    }

    public void swap(int dex1, int dex2)  // swap two elements
    {
        int temp = theArray[dex1];        // A into temp
        theArray[dex1] = theArray[dex2];   // B into A
        theArray[dex2] = temp;             // temp into B
    }

    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left;             // right of first elem
        int rightPtr = right - 1;       // left of pivot
        while(true)
        {
            while( theArray[++leftPtr] < pivot )  // find bigger
                ;                                  // (nop)
            while( theArray[--rightPtr] > pivot ) // find smaller
                ;                                  // (nop)
            if(leftPtr >= rightPtr)      // if pointers cross,
                break;                    //    partition done
            else                         // not crossed, so
                swap(leftPtr, rightPtr);  // swap elements
        }  // end while(true)
        swap(leftPtr, right-1);         // restore pivot
        return leftPtr;                 // return pivot location
    }

    // insertion sort
    public void insertionSort(int left, int right)
    {
        int in, out;
        //  sorted on the left of out
        for(out=left+1; out<=right; out++)
        {
            int temp = theArray[out];    // remove marked item
            in = out;                     // start shifts at out
            // until one is smaller,
            while(in>left && theArray[in-1] >= temp)
            {
                theArray[in] = theArray[in-1]; // shift item to right
                --in;                      // go left one position
            }
            theArray[in] = temp;          // insert marked item
        }  // end for
    }

}

// here we handle arrays with size less than 10 with insertion sort, which sometimes improves the speed of algs