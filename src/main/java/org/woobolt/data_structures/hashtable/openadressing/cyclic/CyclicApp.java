package org.woobolt.data_structures.hashtable.openadressing.cyclic;

public class CyclicApp {
    public static void main(String[] args) {
        Cyclic hashTable = new Cyclic(10);

        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(11, "Eleven"); // Приведет к коллизии
        hashTable.put(21, "Twenty-One"); // Приведет к коллизии

        System.out.println("Value for key 1: " + hashTable.get(1));
        System.out.println("Value for key 11: " + hashTable.get(11)); // Должно быть "Eleven"
        System.out.println("Value for key 21: " + hashTable.get(21)); // Должно быть "Twenty-One"

        hashTable.remove(11);
        System.out.println("Value for key 11 after removal: " + hashTable.get(11)); // Должно быть null

        System.out.println("Is key 2 present? " + hashTable.containsKey(2)); // Должно быть true
        System.out.println("Is key 11 present? " + hashTable.containsKey(11)); // Должно быть false

        System.out.println("Displaying hash table contents:");
        hashTable.display();
    }
}
