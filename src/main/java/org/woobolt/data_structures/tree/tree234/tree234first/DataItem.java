package org.woobolt.data_structures.tree.tree234.tree234first;

class DataItem {
    public long dData;          // one data item

    public DataItem(long dd)    // constructor
    {
        dData = dd;
    }

    public void displayItem()   // display item, format "/27"
    {
        System.out.print("/" + dData);
    }
}
