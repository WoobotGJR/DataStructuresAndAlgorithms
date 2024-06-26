package org.woobolt.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.List;

/*Этот класс на Java, Graph, представляет собой реализацию алгоритма Дейкстры для поиска кратчайших путей во взвешенном графе.
  Он содержит методы для добавления вершин и рёбер в граф, а также для поиска кратчайших путей от заданной стартовой вершины до всех остальных вершин в графе.

Вот краткое описание его основных атрибутов и методов:

    Атрибуты:
        MAX_VERTS: Константа, представляющая максимальное количество вершин в графе.
        INFINITY: Константа, используемая для представления "бесконечности" в алгоритме.
        vertexList: Массив вершин графа.
        relationMatrix: Матрица связей между вершинами графа, где хранятся веса рёбер.
        countOfVertices: Текущее количество вершин в графе.
        countOfVertexInTree: Количество вершин, которые уже рассмотрены при построении кратчайших путей.
        shortestPaths: Список данных о кратчайших путях от стартовой вершины до всех остальных.
        currentVertex: Текущая вершина, которая рассматривается при выполнении алгоритма.
        startToCurrent: Расстояние от начальной вершины до текущей вершины.

    Методы:
        addVertex(char lab): Метод для добавления новой вершины в граф.
        addEdge(int start, int end, int weight): Метод для добавления ребра между двумя вершинами с заданным весом.
        path(): Метод для поиска кратчайших путей в графе с использованием алгоритма Дейкстры.
        clean(): Метод для очистки данных, связанных с предыдущим поиском кратчайших путей.
        getMin(): Вспомогательный метод для поиска индекса вершины с минимальным расстоянием до стартовой вершины.
        updateShortestPaths(): Вспомогательный метод для обновления данных о кратчайших путях после добавления новой вершины в дерево.
        displayPaths(): Метод для вывода кратчайших путей на экран.
*/
/*
В данной реализации алгоритма Дейкстры список смежности представлен матрицей связей вершин relationMatrix.
 Это двумерный массив, где каждая строка представляет вершину графа, а каждый столбец представляет связи этой вершины с остальными вершинами.
В этой матрице каждый элемент [i][j] соответствует весу ребра из вершины i в вершину j. Если вес равен бесконечности (INFINITY), то ребра между этими вершинами нет.
Например, если у нас есть граф с тремя вершинами (A, B, C) и следующими рёбрами: A -> B (вес 2), A -> C (вес 4), B -> C (вес 1), то матрица связей будет выглядеть следующим образом:
*/
//    A    B    C
//A   0    2    4
//B   ∞    0    1
//C   ∞    ∞    0

//Это означает, что из вершины A есть ребро к вершине B с весом 2, ребро к вершине C с весом 4, из B есть ребро к C с весом 1, а из C нет рёбер к другим вершинам.

public class DijkstraGraph {
    private final int MAX_VERTS = 10;// максимальное количество вершин
    private final int INFINITY = 100000000; // это число у нас будет служить в качестве "бесконечности"
    private DijkstraVertex vertexList[]; // список вершин
    private int relationMatrix[][]; // матрица связей вершин
    private int countOfVertices; // текущее количество вершин
    private int countOfVertexInTree; // количество рассмотренных вершин в дереве
    private List<DijkstraPath> shortestPaths; // список данных кратчайших путей
    private int currentVertex; // текущая вершина
    private int startToCurrent; // расстояние до currentVertex

    public DijkstraGraph() {
        vertexList = new DijkstraVertex[MAX_VERTS]; // матрица смежности
        relationMatrix = new int[MAX_VERTS][MAX_VERTS];
        countOfVertices = 0;
        countOfVertexInTree = 0;
        shortestPaths = new ArrayList<>();// задается пустым
        for (int i = 0; i < MAX_VERTS; i++) {// матрица смежности заполняется
            for (int k = 0; k < MAX_VERTS; k++) { // бесконечными расстояниями
                relationMatrix[i][k] = INFINITY; // задания значений по умолчанию
            }
        }
    }

    public void addVertex(char label) {// задание новых вершин
        vertexList[countOfVertices++] = new DijkstraVertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        relationMatrix[start][end] = weight; // задание ребер между вершинами, с весом между ними
    }

    /*
     * Помечаем начальную вершину: Устанавливаем начальную вершину (с индексом 0)
     * как включенную в дерево. Устанавливаем количество вершин в дереве равным 1.
     *
     * Заполнение коротких путей для вершин: Для каждой вершины в графе заполняем
     * начальные значения кратчайших путей в список shortestPaths. Начальным
     * родителем для каждой вершины является начальная вершина (с индексом 0).
     *
     * Поиск кратчайших путей: Пока не все вершины включены в дерево: Находим
     * вершину с наименьшим расстоянием от начальной вершины, вызывая метод
     * getMin(). Если расстояние до найденной вершины равно "бесконечности", выводим
     * сообщение о недостижимых вершинах и завершаем цикл. Обновляем текущую вершину
     * и расстояние от начальной вершины до текущей. Помечаем текущую вершину как
     * включенную в дерево. Увеличиваем количество вершин в дереве. Обновляем
     * информацию о кратчайших путях с помощью метода updateShortestPaths().
     *
     * Вывод результатов: После того как все вершины включены в дерево, выводим
     * результаты кратчайших путей с помощью метода displayPaths().
     */

    public void path() {
        int startTree = 0; // Начинаем с вершины с индексом 0
        vertexList[startTree].setInTree(true); // Помечаем начальную вершину как включенную в дерево
        countOfVertexInTree = 1; // Устанавливаем количество вершин в дереве равным 1, так как начальная вершина
        // уже включена

        for (int i = 0; i < countOfVertices; i++) { // Перебираем все вершины
            int tempDist = relationMatrix[startTree][i]; // Получаем расстояние от начальной вершины до текущей вершины
            DijkstraPath path = new DijkstraPath(tempDist); // Создаем объект Path с текущим расстоянием
            path.getParentVertices().add(0); // Добавляем начальную вершину как родительскую для текущей вершины
            shortestPaths.add(path); // Добавляем созданный объект Path в список shortestPaths
        }

        while (countOfVertexInTree < countOfVertices) { // Пока не все вершины включены в дерево
            int indexMin = getMin(); // Находим индекс вершины с наименьшим расстоянием от начальной вершины
            int minDist = shortestPaths.get(indexMin).getDistance(); // Получаем минимальное расстояние до этой вершины

            if (minDist == INFINITY) { // Если расстояние равно "бесконечности"
                System.out.println("В графе присутствуют недостижимые вершины");
                break; // Выходим из цикла
            } else {
                currentVertex = indexMin; // Обновляем текущую вершину
                startToCurrent = shortestPaths.get(indexMin).getDistance(); // Обновляем расстояние от начальной вершины
                // до текущей
            }

            vertexList[currentVertex].setInTree(true); // Помечаем текущую вершину как включенную в дерево
            countOfVertexInTree++; // Увеличиваем количество вершин в дереве
            updateShortestPaths(); // Обновляем информацию о кратчайших путях
        }

        displayPaths(); // Выводим результаты на экран
    }

    public void clean() { // очиска дерева
        countOfVertexInTree = 0;
        for (int i = 0; i < countOfVertices; i++) {
            vertexList[i].setInTree(false);
        }
    }

    private int getMin() {
        int minDist = INFINITY; // Устанавливаем начальное значение минимального расстояния как "бесконечность"
        int indexMin = 0; // Устанавливаем начальное значение индекса вершины с минимальным расстоянием

        for (int i = 1; i < countOfVertices; i++) { // Перебираем все вершины, начиная с индекса 1
            if (!vertexList[i].isInTree() && shortestPaths.get(i).getDistance() < minDist) { // Если вершина еще не
                // включена в дерево и
                // расстояние до нее
                // меньше текущего
                // минимального
                minDist = shortestPaths.get(i).getDistance(); // Обновляем значение минимального расстояния
                indexMin = i; // Обновляем индекс вершины с минимальным расстоянием
            }
        }

        return indexMin; // Возвращаем индекс вершины с минимальным расстоянием
    }

    /*
     * Цикл перебора вершин: Метод перебирает все вершины, начиная с индекса 1
     * (поскольку первая вершина пропускается). Для каждой вершины проверяется,
     * входит ли она уже в дерево (if (vertexList[vertexIndex].isInTree())). Если
     * вершина уже в дереве, она пропускается, так как кратчайший путь до нее уже
     * найден.
     *
     * Вычисление расстояния для текущей вершины: Для текущей вершины vertexIndex
     * вычисляется расстояние от начальной вершины (startToCurrent), которое уже
     * известно, до текущей вершины. Также вычисляется расстояние от начальной
     * вершины через текущую вершину до рассматриваемой вершины (currentToFringe),
     * получая расстояние от начальной вершины до текущей вершины + вес ребра от
     * текущей вершины до рассматриваемой вершины.
     *
     * Сравнение расстояний: Сравнивается расстояние, найденное через текущую
     * вершину, с текущим известным кратчайшим путем до рассматриваемой вершины.
     * Если расстояние через текущую вершину меньше текущего кратчайшего пути, то
     * обновляется информация о кратчайшем пути для рассматриваемой вершины.
     * Обновляется список родительских вершин и расстояние для рассматриваемой
     * вершины.
     *
     * Переход к следующей вершине: После обработки всех вершин, метод завершает
     * свою работу.
     */
    private void updateShortestPaths() {
        int vertexIndex = 1; // Начинаем с индекса 1, так как первая вершина пропускается
        while (vertexIndex < countOfVertices) { // Перебираем все вершины, начиная с индекса 1
            if (vertexList[vertexIndex].isInTree()) { // Если вершина уже включена в дерево, пропускаем ее
                vertexIndex++;
                continue;
            }

            int currentToFringe = relationMatrix[currentVertex][vertexIndex]; // Получаем расстояние от текущей вершины
            // до рассматриваемой вершины
            int startToFringe = startToCurrent + currentToFringe; // Суммируем расстояние от начальной вершины до
            // текущей вершины с расстоянием от текущей вершины
            // до рассматриваемой вершины
            int shortPathDistance = shortestPaths.get(vertexIndex).getDistance(); // Получаем текущее кратчайшее
            // расстояние для рассматриваемой
            // вершины

            if (startToFringe < shortPathDistance) { // Если новое расстояние через текущую вершину меньше текущего
                // кратчайшего расстояния
                List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertex).getParentVertices()); // Создаем
                // копию
                // списка
                // родительских
                // вершин
                // для
                // текущей
                // вершины
                newParents.add(currentVertex); // Добавляем текущую вершину как предыдущую для рассматриваемой вершины
                shortestPaths.get(vertexIndex).setParentVertices(newParents); // Обновляем список родительских вершин
                // для рассматриваемой вершины
                shortestPaths.get(vertexIndex).setDistance(startToFringe); // Обновляем кратчайшее расстояние для
                // рассматриваемой вершины
            }
            vertexIndex++; // Переходим к следующей вершине
        }
    }

    private void displayPaths() { // метод для вывода кратчайших путей на экран
        for (int i = 0; i < countOfVertices; i++) {
            System.out.print(vertexList[i].getLabel() + " = ");
            if (shortestPaths.get(i).getDistance() == INFINITY) {
                System.out.println("0");
            } else {
                String result = shortestPaths.get(i).getDistance() + " (";
                List<Integer> parents = shortestPaths.get(i).getParentVertices();
                for (int j = 0; j < parents.size(); j++) {
                    result += vertexList[parents.get(j)].getLabel() + " -> ";
                }
                System.out.println(result + vertexList[i].getLabel() + ")");
            }
        }
    }
}