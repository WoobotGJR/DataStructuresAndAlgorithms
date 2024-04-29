package org.woobolt.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<String> alpinists = new ArrayList<>();
        alpinists.add("A");
        alpinists.add("B");
        alpinists.add("C");
        alpinists.add("D");
        alpinists.add("E");

        int groupSize = 3;
        List<String> currentGroup = new ArrayList<>();
        chooseGroups(alpinists, groupSize, currentGroup);
    }

    public static void chooseGroups(List<String> alpinists, int groupSize, List<String> currentGroup) {
        if (currentGroup.size() == groupSize) {
            System.out.println(currentGroup);
            return;
        }

        for (int i = 0; i < alpinists.size(); i++) {
            List<String> remainingAlpinists = new ArrayList<>(alpinists.subList(i + 1, alpinists.size()));
            List<String> updatedGroup = new ArrayList<>(currentGroup);
            updatedGroup.add(alpinists.get(i));
            chooseGroups(remainingAlpinists, groupSize, updatedGroup);
        }
    }

    public static void combine(List<String> alpinists, int groupSize, int start, List<String> currentGroup, List<List<String>> allGroups) {
        if (currentGroup.size() == groupSize) {
            allGroups.add(new ArrayList<>(currentGroup));
            return;
        }

        for (int i = start; i < alpinists.size(); i++) {
            currentGroup.add(alpinists.get(i));
            combine(alpinists, groupSize, i + 1, currentGroup, allGroups);
            currentGroup.remove(currentGroup.size() - 1);
        }
    }
}
