package net.pogibenko.simplegraph;

import java.util.List;

public interface Graph<T> {

    T addVertex(T vertex);

    Edge<T> addEdge(T first, T second);

    List<Edge<T>> getPath(T first, T second);
}
