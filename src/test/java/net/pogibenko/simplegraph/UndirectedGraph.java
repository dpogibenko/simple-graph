package net.pogibenko.simplegraph;

import java.util.*;

public class UndirectedGraph<T> implements Graph<T> {

    private Map<T, Set<T>> adjMap = new HashMap<>();

    @Override
    public T addVertex(T vertex) {
        adjMap.put(vertex, new HashSet<>());
        return vertex;
    }

    @Override
    public Edge<T> addEdge(T first, T second) {
        adjMap.computeIfAbsent(first, this::initAdj).add(second);
        adjMap.computeIfAbsent(second, this::initAdj).add(first);
        return new UndirectedEdge<>(first, second);
    }

    @Override
    public List<Edge<T>> getPath(T first, T second) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Set<T> initAdj(T t) {
        return new HashSet<>();
    }
}
