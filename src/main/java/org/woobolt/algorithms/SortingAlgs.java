package org.woobolt.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAlgs {

    /*
     * Сортировка пузырьком (Bubble Sort):
     *
     * Временная сложность в лучшем случае: O(n). Временная сложность в худшем и
     * среднем случае: O(n^2). Этот алгоритм является одним из наименее эффективных,
     * особенно для больших массивов, из-за своей квадратичной временной сложности.
     */
    // Метод для сортировки массива методом пузырька
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                // Если текущий элемент меньше предыдущего, меняем их местами
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            // Уменьшаем количество проверяемых элементов на 1,
            // так как после каждой итерации самый большой элемент "всплывает" в конец массива
            n--;
        } while (swapped);
    }

    /*
     * Сортировка выбором (Selection Sort):
     *
     * Временная сложность в лучшем, худшем и среднем случае: O(n^2). Этот алгоритм
     * обладает постоянной временной сложностью по сравнению с другими алгоритмами,
     * что делает его неэффективным для больших массивов.
     */
    // Также его можно написать при поиске максимального элемента, в таком случае мы будем просто уменьшать n
    // Метод для сортировки массива методом выбора
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Проходим по всем элементам массива
        // цикл идёт до n−1, потому что после n−1 итерации последний элемент будет автоматически отсортирован
        for (int i = 0; i < n - 1; i++) {
            // Предполагаем, что минимальный элемент находится в текущей позиции
            int minIndex = i;

            // Поиск минимального элемента среди оставшихся элементов массива
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Обмен минимального элемента с текущим элементом (если они различны)
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /*
     * Сортировка вставками (Insertion Sort):
     *
     * Временная сложность в лучшем случае: O(n). Временная сложность в худшем
     * случае: O(n^2). В среднем случае: O(n^2). Хотя сортировка вставками
     * эффективна для небольших массивов или почти отсортированных массивов, она
     * менее эффективна для больших массивов из-за квадратичной временной сложности.
     */
    // Метод для сортировки массива методом вставок
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Проходим по всем элементам массива начиная со второго
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Запоминаем текущий элемент
            int j = i - 1;

            // Перемещаем элементы массива, которые больше, чем key, на одну позицию вперед
            // Условие j >= 0 необходимо для того, чтобы ограничить поиск только элементами,
            // находящимися слева от текущей позиции
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key; // Вставляем key в правильную позицию в отсортированной части массива
        }
    }

    /*
     * Сортировка слиянием (Merge Sort):
     *
     * Временная сложность в худшем, лучшем и среднем случае: O(n log n). Это
     * эффективный алгоритм сортировки, который всегда имеет временную сложность O(n
     * log n), независимо от распределения входных данных.
     */
    // Метод для сортировки массива методом слияния
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Находим средний индекс массива
            int mid = left + (right - left) / 2;
//            System.out.println(mid + " left: " + left + " right: " + right);

            // Рекурсивно сортируем левую и правую половины массива
//            System.out.println("Left from: " + left + " to: " + mid);
            mergeSort(arr, left, mid);
//            int middle = mid +1;
//            System.out.println("Right from: " + middle + " to: " + right);
            mergeSort(arr, mid + 1, right);

            // Объединяем отсортированные половины
//            System.out.println("merge from: " + left + " to: " + right + " with mid: " + mid);
            merge(arr, left, mid, right);
        }
    }

    // Метод для объединения двух отсортированных половин массива
    private static void merge(int[] arr, int left, int mid, int right) {
        // Определяем размер временных массивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Создаем временные массивы
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Копируем данные во временные массивы
        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Слияние временных массивов

        // Индексы начала итерации для каждого временного массива
        int i = 0, j = 0;
        // Индекс начала итерации для результирующего массива
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов из leftArr (если они есть)
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Копирование оставшихся элементов из rightArr (если они есть)
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /*
     * Сортировка быстрая (Quick Sort):
     *
     * Временная сложность в худшем случае: O(n^2). Временная сложность в среднем
     * случае: O(n log n). В среднем случае Quick Sort работает очень быстро и имеет
     * временную сложность O(n log n), но в худшем случае может деградировать до
     * O(n^2), особенно если выбирать неподходящий опорный элемент.
     */
    // Метод для сортировки массива методом быстрой сортировки
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // Вызов вспомогательного метода для сортировки
        quickSort(arr, 0, arr.length - 1);
    }

    // Вспомогательный метод для сортировки массива методом быстрой сортировки
    private static void quickSort(int[] arr, int low, int high) { // ЭТО ЛОКАЛЬНЫЕ ПЕРЕМЕННЫЕ ДЛЯ КАЖДОЙ РЕКУРСИВНО ВЫЗВАННОЙ ФУНКЦИИ
        if (low < high) {
            // Находим индекс опорного элемента (pivot) и проводим разделение массива
//        	System.out.println("Entred partition: " + " With low: " + low + " And high: " + high);
            // ВОТ ЭТО ОБЩАЯ ПЕРЕМЕННАЯ ДЛЯ КАЖДОЙ РЕКУРСИВНОЙ ФУНКЦИИ. ОНА МЕНЯЕТСЯ ПОСЛЕ КАЖДОГО ВЫЗОВА PARTITION ВНЕ ЗАВИСИМОСТИ ОТ ТОГО, КАКОЙ ВЕТКОЙ БЫЛА ВЫЗВАНА
            int pivotIndex = partition(arr, low, high); // ARR ССЫЛКА НА МАССИВ, ТО ЕСТЬ ОН МЕНЯЕТСЯ ПОСЛЕ РЕКУРСИИ

            // Рекурсивно вызываем quickSort для подмассивов до и после опорного элемента
//            int leftHigh = pivotIndex - 1;
//            System.out.println("Entered left, pivot: " + pivotIndex + " With low: " + low + " And high: " + leftHigh);
            quickSort(arr, low, pivotIndex - 1); // рекурсия !!!
//            System.out.println("Out with pivot: " + pivotIndex);
//            int rightLow = pivotIndex + 1;
//            System.out.println("Entered right, pivot: " + pivotIndex  + " With low: " + rightLow + " And high: " + high);
            quickSort(arr, pivotIndex + 1, high); // рекурсия !!!
        }
    }

    // Метод для разделения массива на две части
    private static int partition(int[] arr, int low, int high) {
        // Выбираем опорный элемент (pivot)
        int pivot = arr[high];
        int i = low - 1;

        // 
        // Перемещаем элементы меньшие опорного влево от него, а большие - вправо
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Перемещаем опорный элемент в правильную позицию
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Возвращаем индекс опорного элемента (pivot)
        return i + 1;
    }

    /*
     * Сортировка подсчетом (Counting Sort):
     *
     * Временная сложность в лучшем, худшем и среднем случае: O(n + k), где n -
     * количество элементов в массиве, k - разность между максимальным и минимальным
     * значением в массиве. Этот алгоритм эффективен, когда разность между
     * максимальным и минимальным значением в массиве относительно небольшая.
     */
    // Метод для сортировки массива методом подсчета
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // Находим максимальное значение в массиве
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Создаем массив для подсчета количества вхождений каждого элемента
        int[] countArray = new int[max + 1];

        // Заполняем массив подсчета
        for (int num : arr) {
            countArray[num]++;
        }

        // Восстанавливаем отсортированный массив из массива подсчета
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                arr[index++] = i;
                countArray[i]--;
            }
        }
    }

    // Метод для нахождения максимального значения в массиве
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /*
     * Сортировка по разрядам (Radix Sort): Временная сложность зависит от реализации
     * и используемого алгоритма сортировки в каждом разряде. В среднем случае: O(n
     * * k), где n - количество элементов в массиве, k - количество разрядов в
     * числах. Однако, если используются эффективные алгоритмы сортировки в каждом
     * разряде, то временная сложность Radix Sort может быть линейной, O(n).
     */
    // Метод для сортировки массива методом сортировки по разрядам (Radix Sort)
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int max = getMax(arr); // Находим максимальное значение в массиве

        // Применяем сортировку подсчетом (Counting Sort) для каждого разряда
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortRadix(arr, exp);
        }
    }

    // Метод для сортировки массива по заданному разряду
    private static void countingSortRadix(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Заполняем массив подсчета
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }

        // Преобразуем массив подсчета, чтобы он содержал фактические позиции элементов в результирующем массиве
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Создаем результирующий массив, используя массив подсчета
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Копируем отсортированные элементы обратно в исходный массив
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /*
     * Сортировка кучей (Heap Sort):
     *
     * Временная сложность в худшем, лучшем и среднем случае: O(n log n). Heap Sort
     * всегда имеет временную сложность O(n log n), независимо от распределения
     * входных данных.
     */
    // Метод для сортировки массива методом сортировки кучей
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;

        // Строим кучу (heap) из массива
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Постепенно извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Метод для преобразования массива в кучу с корнем i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем корень как наибольший элемент
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый потомок больше корня
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Рекурсивно heapify поддерево
            heapify(arr, n, largest);
        }
    }

    /*
     * Сортировка корзинами (Bucket Sort):
     *
     * Временная сложность зависит от реализации. В лучшем случае: O(n + k), где k -
     * количество корзин. В худшем случае: O(n^2), если используется сортировка
     * внутри корзин с временной сложностью O(n^2).
     */
    // Метод для сортировки массива методом сортировки корзиной
    public static void bucketSort(int[] arr, int numBuckets) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        // Рассчитываем размер каждой корзины
        double interval = (double) (max - min + 1) / numBuckets;

        // Создаем корзины
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Распределяем элементы массива по корзинам
        for (int num : arr) {
            int bucketIndex = (int) ((num - min) / interval);
            buckets.get(bucketIndex).add(num);
        }

        // Сортируем каждую корзину (обычно используется другой алгоритм сортировки, например, сортировка вставками)
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Объединяем отсортированные корзины в итоговый отсортированный массив
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
