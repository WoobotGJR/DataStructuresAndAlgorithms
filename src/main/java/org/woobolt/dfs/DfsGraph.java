package org.woobolt.dfs;

import java.util.Stack;

/*
 * Переменная adjMat в данном контексте представляет собой матрицу смежности.
 *
 * В этой матрице каждый элемент [j][k] соответствует связи между вершинами j и
 * k. Если в этом элементе содержится значение 1, это означает наличие ребра
 * между вершинами j и k. Если значение равно 0, это означает отсутствие ребра
 * между этими.
 */

/*
 * пример простого неориентированного графа с несколькими вершинами,
 * представленного в виде матрицы смежности. Предположим, у нас есть граф с 4
 * вершинами (A, B, C, D), и следующие ребра: A - B, A - C, B - D, C - D. Такая
 * матрица смежности будет выглядеть следующим образом:
 */

//   A  B  C  D
//A  0  1  1  0
//B  1  0  0  1
//C  1  0  0  1
//D  0  1  1  0

/*
 * В данной матрице:
 *
 * Вершина A соединена с вершиной B и вершиной C. Вершина B соединена с вершиной
 * A и вершиной D. Вершина C соединена с вершиной A и вершиной D. Вершина D
 * соединена с вершиной B и вершиной C.
 */

/*
 * Давайте рассмотрим пример ориентированного графа с несколькими вершинами и
 * ребрами, представленными в виде матрицы смежности. Допустим, у нас есть граф
 * с 4 вершинами (A, B, C, D), и следующие направленные ребра: A -> B, B -> C, C
 * -> A, D -> B. Такая матрица смежности будет выглядеть следующим образом:
 */

//   A  B  C  D
//A  0  1  0  0
//B  0  0  1  1
//C  1  0  0  0
//D  0  1  0  0

/*
 * В данной матрице:
 *
 * Вершина A имеет ребро, направленное в вершину B. Вершина B имеет ребра,
 * направленные в вершины C и D. Вершина C имеет ребро, направленное в вершину
 * A. Вершина D имеет ребро, направленное в вершину B.
 *
 * Как видно, матрица смежности для ориентированного графа отличается от
 * неориентированного тем, что она может быть несимметричной. Значения в ячейках
 * показывают направление ребер: если в ячейке (i, j) стоит 1, это означает
 * наличие ребра из вершины i в вершину j.
 */


public class DfsGraph {
    private final int MAX_VERTS = 10;
    private DfsVertex vertexArray[]; // массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Stack<Integer> stack; // приватная переменная с именем stack, которая является экземпляром класса Stack, параметризованным типом Integer.

    public DfsGraph() { // инициализация внутрених полей
        vertexArray = new DfsVertex[MAX_VERTS]; // создаётся массив из вершин графа
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // создаётся матрица смежности 10х10
        nVerts = 0; // текущее количество вершин равно нулю
        for (int j = 0; j < MAX_VERTS; j++) { // проходимся по всему массиву и заполняем значение нулями
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>(); // создаём стек при помощи diamond operator, тип стека в данном случае известен из контекста объявленной переменной stack
    }

    public void addVertex(char lab) { // метод для добавления узла в граф
        vertexArray[nVerts++] = new DfsVertex(lab); // мы обращаемся к массиву вершин и прибавляем единицу для следующего значения, а не для текущего и создаём узел с символом из аргументов
    }

    public void addEdge(int start, int end) { // граф ориентированный => матрица смежности симметрична относительно начала
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) { // метод обращается к определённой вершине и получает её символ
        System.out.println(vertexArray[v].getLabel());
    }

    /*
     * Метод dfs() выполняет обход графа в глубину (DFS - Depth-First Search). Вот
     * как это происходит:
     *
     * Помечается начальная вершина графа (обычно это первая вершина) как посещенная
     * и выводится ее метка.
     * Вершина добавляется в стек. Пока стек не пуст, извлекается вершина из вершины стека.
     * Для извлеченной вершины находятся все ее непосещенные смежные вершины.
     * Если у вершины есть непосещенные смежные вершины, одна из них выбирается, помечается
     * как посещенная, выводится ее метка, и добавляется в стек.
     * Если у вершины нет непосещенных смежных вершин, она извлекается из стека.
     * Этот процесс повторяется, пока стек не станет пустым.
     */

    public void dfs() { // обход в глубину
        vertexArray[0].setWasVisited(true); // берётся первая вершина
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) { // пока в стеке есть элементы...
            int v = getAdjUnvisitedVertex(stack.peek()); // вынуть индекс смежной веришины, еcли есть 1, нету -1
            if (v == -1) { // если непройденных смежных вершин нету
                stack.pop(); // элемент извлекается из стека (удаляем тупиковую вершину, или вершину без непроверенных соседей)
            } else { // иначе обрабатываем вершины
                vertexArray[v].setWasVisited(true); // отмечаем вершину посещённой
                displayVertex(v); // отображаем название вершины
                stack.push(v); // элемент попадает на вершину стека
            }
        }

        /*
         * После выполнения обхода графа метод сбрасывает флаги посещения всех вершин,
         * чтобы граф был готов к последующим операциям.
         */
        for (int j = 0; j < nVerts; j++) { // сброс флагов
            vertexArray[j].wasVisited = false;
        }

    }

    /*
     * Вот как работает метод getAdjUnvisitedVertex:
     *
     * Метод принимает в качестве аргумента индекс вершины v, для которой нужно
     * найти непосещенную смежную вершину.
     *
     * Затем метод проверяет все вершины графа, начиная с вершины с индексом v. Для
     * каждой вершины проверяется, является ли она смежной с вершиной v (путем
     * проверки соответствующего значения в матрице смежности adjMat[v][j]).
     *
     * Если вершина с индексом j является смежной с вершиной v (то есть adjMat[v][j]
     * == 1), и эта вершина не была посещена ( vertexArray[j].wasVisited == false),
     * то метод возвращает индекс этой вершины.
     *
     * Если ни одна из смежных вершин не удовлетворяет условиям, метод возвращает
     * -1, что означает, что непосещенные смежные вершины для вершины v больше нет.
     */

    private int getAdjUnvisitedVertex(int v) { // приватный метод, который возвращает непосещённую вершину из стека
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexArray[j].wasVisited) { // если вершина связана с вершиной v и она не посещена, то...
                return j; // возвращает первую найденную вершину
            }
        }
        return -1;
    }


}

/*
 * Так как у нас есть матрица смежности и в методе прохода мы используем цикл,
 * вложенный в цикл, то временная сложность будет O(N²).
 */
