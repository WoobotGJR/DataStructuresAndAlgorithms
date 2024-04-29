package org.woobolt.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Knapsack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;

        System.out.println(Stream.of(knapsackRecursive(weights, values, capacity, n)).findFirst().get());
        System.out.println(Stream.of(knapsack(weights, values, capacity)).findFirst().get());
    }

    public static int knapsackRecursive(int[] weights, int[] values, int capacity, int n) {
        // Базовый случай: если вместимость рюкзака или количество предметов равны 0,
        // то максимальная стоимость тоже равна 0
        if (n == 0 || capacity == 0)
            return 0;

        // Если вес текущего предмета больше вместимости рюкзака,
        // исключаем этот предмет из рассмотрения и рекурсивно вызываем функцию для оставшихся предметов
        if (weights[n - 1] > capacity)
            return knapsackRecursive(weights, values, capacity, n - 1);

            // Возвращаем максимум из двух случаев:
            // 1. Предмет не включается в рюкзак
            // 2. Предмет включается в рюкзак
        else
            return Math.max(values[n - 1] + knapsackRecursive(weights, values, capacity - weights[n - 1], n - 1),
                    knapsackRecursive(weights, values, capacity, n - 1));
    }

    public static ArrayList<Integer> knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Заполняем массив dp построчно
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Базовый случай: ноль веса или ноль элементов
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Восстановление решения из dp
        int res = dp[n][capacity];
        ArrayList<Integer> itemsInKnapsack = new ArrayList<>();
        int w = capacity;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                itemsInKnapsack.add(i - 1);
                res -= values[i - 1];
                w -= weights[i - 1];
            }
        }

        return itemsInKnapsack;
    }
}
