package org.woobolt.algorithms.sorting;

import java.util.Arrays;

public class RadixSort {

    // Реализация поразрядной сортировки для массива чисел
    public static void radixSort(int[] arr) {
        // Находим максимальное число в массиве, чтобы определить количество цифр
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        // Применяем поразрядную сортировку для каждой цифры, начиная с единиц
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // Помощник для сортировки массива с использованием подсчета
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Подсчитываем количество встречающихся цифр (0-9)
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Изменяем count[i] так, чтобы count[i] содержал фактическую позицию
        // данного элемента в output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Строим output массив
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Копируем отсортированный output массив в arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }


    // Реализация поразрядной сортировки для массива чисел
    public static void radixSortByte(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp <<= 1) {
            countSortByte(arr, exp);
        }
    }

    // Помощник для сортировки массива с использованием подсчета
    private static void countSortByte(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[2];

        for (int i = 0; i < n; i++) {
            count[(arr[i] & exp) >> exp]++;
        }

        count[1] += count[0];

        for (int i = n - 1; i >= 0; i--) {
            output[--count[(arr[i] & exp) >> exp]] = arr[i];
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    // Пример использования
    public static void main(String[] args) {
        int[] arr1 = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] arr2 = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr1);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr1));
        radixSortByte(arr2);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr2));
    }
}