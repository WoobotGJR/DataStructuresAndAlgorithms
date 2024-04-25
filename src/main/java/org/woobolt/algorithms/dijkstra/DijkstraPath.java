package org.woobolt.algorithms.dijkstra;

import java.util.ArrayList;
import java.util.List;
/*
Этот класс на Java, Path, представляет собой объект, который содержит информацию о пути в графе. Он имеет следующие атрибуты:

    distance: Это текущее расстояние от начальной вершины до данного пути.
    parentVertices: Это список индексов (или идентификаторов) вершин, которые были пройдены для достижения данного пути.

Класс имеет конструктор для инициализации distance, а также методы доступа (getter) и изменения (setter) для обоих атрибутов.

Вот описание методов:

    Path(int distance): Конструктор для создания нового объекта Path с заданным расстоянием.
    getDistance(): Метод доступа для получения расстояния данного пути.
    setDistance(int distance): Метод изменения для установки расстояния данного пути.
    getParentVertices(): Метод доступа для получения списка индексов (или идентификаторов) вершин-родителей данного пути.
    setParentVertices(List<Integer> parentVertices): Метод изменения для установки списка индексов (или идентификаторов) вершин-родителей данного пути.
*/

public class DijkstraPath { // объект данного класса содержащий расстояние и предыдущие и пройденные вершины
    private int distance; // текущая дистанция от начальной вершины
    private List<Integer> parentVertices; // текущий родитель вершины

    public DijkstraPath(int distance) {
        this.distance = distance;
        this.parentVertices = new ArrayList<>();
    }

    public int getDistance() { // Дистанция до узла
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Integer> getParentVertices() { // Список путей родителей
        return parentVertices;
    }

    public void setParentVertices(List<Integer> parentVertices) {
        this.parentVertices = parentVertices;
    }
}
/*
 * Использование типа данных List<Integer> для атрибута parentVertices имеет
 * несколько преимуществ:
 *
 * Гибкость: List<Integer> предоставляет гибкость в хранении последовательности
 * целых чисел, представляющих индексы или идентификаторы родительских вершин.
 * Это позволяет легко добавлять, удалять или изменять родительские вершины при
 * необходимости.
 *
 * Универсальность: Использование интерфейса List позволяет выбирать из
 * различных реализаций списков в зависимости от потребностей приложения.
 * Например, вы можете использовать ArrayList, если ожидается большое количество
 * родительских вершин, или LinkedList, если требуется частая вставка или
 * удаление элементов.
 *
 * Простота использования: Методы, предоставляемые интерфейсом List, такие как
 * add(), remove(), get(), делают работу с коллекцией более удобной и понятной.
 *
 * Совместимость с Java Collections Framework: Использование List делает класс
 * более совместимым с другими компонентами Java Collections Framework, что
 * облегчает интеграцию и взаимодействие с другими частями программы.
 */