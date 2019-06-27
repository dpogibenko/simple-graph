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
        return getPathDepth(first, second, new HashSet<>());
    }

    private Set<T> initAdj(T t) {
        return new HashSet<>();
    }

    private List<Edge<T>> getPathDepth(T first, T second, Set<T> visited) {
        Set<T> adj = adjMap.get(first);
        if (adj.contains(second)) {
            return Collections.singletonList(new UndirectedEdge<>(first, second));
        }
        visited.add(first);
        for (T vertex : adj) {
            if (!visited.contains(vertex)) {
                List<Edge<T>> path = getPathDepth(vertex, second, visited);
                if (path != null) {
                    ArrayList<Edge<T>> result = new ArrayList<>();
                    result.add(new UndirectedEdge<>(first, vertex));
                    result.addAll(path);
                    return result;
                }
            }
        }
        return null;
    }
}
