package org.woobolt.algorithms.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanoiTower {
    public static void main(String[] args) throws IOException {
        int n = getInt(); // Количество дисков
        char fromRod = 'A'; // Исходный стержень
        char toRod = 'C'; // Целевой стержень
        char auxRod = 'B'; // Вспомогательный стержень

        // Вызываем метод для перемещения дисков
        moveDisks(n, fromRod, toRod, auxRod);
    }

    // Метод для перемещения дисков
    public static void moveDisks(int n, char fromRod, char toRod, char auxRod) {
        // Базовый случай: если есть только один диск, перемещаем его и выходим
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }

        // Рекурсивно перемещаем (n-1) дисков с исходного стержня на вспомогательный стержень
        moveDisks(n - 1, fromRod, auxRod, toRod);
        // Перемещаем оставшийся диск с исходного стержня на целевой стержень
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        // Рекурсивно перемещаем (n-1) дисков с вспомогательного стержня на целевой стержень
        moveDisks(n - 1, auxRod, toRod, fromRod);
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
/*
    Алгоритм решения головоломки Ханойской башни основан на следующей идее:

    Базовый случай: Если у нас есть только один диск, перемещение его сразу на целевой стержень просто - мы просто переносим
     его с исходного стержня на целевой.

    Рекурсивный шаг: Предположим, что мы умеем перемещать (n-1) дисков с исходного стержня на вспомогательный стержень.
     Тогда, чтобы переместить n дисков с исходного стержня на целевой, мы можем:
    Переместить (n-1) дисков с исходного стержня на вспомогательный стержень.
    Переместить оставшийся (верхний) диск с исходного стержня на целевой.
    Переместить (n-1) дисков с вспомогательного стержня на целевой стержень.

    Этот процесс будет рекурсивно повторяться до тех пор, пока у нас не останется только один диск, и мы сможем переместить
     его напрямую на целевой стержень.

    Таким образом, рекурсивный вызов функции moveDisks решает подзадачи меньшего размера, перемещая (n-1) дисков с
     исходного стержня на вспомогательный стержень, и затем перемещая оставшийся диск на целевой стержень. Этот процесс
      повторяется, пока не будут перемещены все диски с исходного стержня на целевой, используя вспомогательный стержень.
*/
