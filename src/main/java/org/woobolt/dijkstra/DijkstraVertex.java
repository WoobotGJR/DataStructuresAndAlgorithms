package org.woobolt.dijkstra;

/*
Этот класс на Java, Vertex, представляет собой вершину в графе. Он имеет два основных атрибута:

    label: Это представляет идентификатор или название вершины. Он имеет тип char.
    isInTree: Это логический флаг, указывающий, включена ли в данный момент вершина в дерево или нет.

В классе есть конструктор для инициализации атрибута label, а также методы доступа (getter) и изменения (setter) для обоих атрибутов.

Вот описание методов:

    Vertex(char label): Конструктор для создания нового объекта Vertex с заданным меткой.
    getLabel(): Метод доступа для получения метки вершины.
    setLabel(char label): Метод изменения для установки метки вершины.
    isInTree(): Метод доступа для проверки того, находится ли вершина в данный момент в дереве.
    setInTree(boolean inTree): Метод изменения для установки флага, указывающего, находится ли вершина в дереве или нет.
*/

public class DijkstraVertex {
    private char label;
    private boolean isInTree;

    public DijkstraVertex(char label) {
        this.label = label;
        this.isInTree = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isInTree() {
        return isInTree;
    }

    public void setInTree(boolean inTree) {
        isInTree = inTree;
    }
}

