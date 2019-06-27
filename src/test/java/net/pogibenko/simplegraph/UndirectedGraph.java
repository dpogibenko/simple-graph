package net.pogibenko.simplegraph;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class UndirectedGraph<T> implements Graph<T> {

    private Map<T, Set<T>> adjMap = new HashMap<>();

    @Override
    public T addVertex(@NotNull T vertex) {
        adjMap.put(vertex, initAdj(vertex));
        return vertex;
    }

    @NotNull
    @Override
    public Edge<T> addEdge(@NotNull T first, @NotNull T second) {
        adjMap.computeIfAbsent(first, this::initAdj).add(second);
        adjMap.computeIfAbsent(second, this::initAdj).add(first);
        return new UndirectedEdge<>(first, second);
    }

    @Nullable
    @Override
    public List<Edge<T>> getPath(@NotNull T first, @NotNull T second) {
        return getPathDepth(first, second, new HashSet<>());
    }

    @NotNull
    private Set<T> initAdj(T t) {
        return new HashSet<>();
    }

    @Nullable
    private List<Edge<T>> getPathDepth(@NotNull T first, @NotNull T second, @NotNull Set<T> visited) {
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
