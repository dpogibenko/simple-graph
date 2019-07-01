package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.GraphPathFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class DfsGraphPathFinder<T> implements GraphPathFinder<T> {

    @Nullable
    @Override
    public List<T> findPath(@NotNull Map<T, Set<T>> adjMap,
                            @NotNull T fromVertex,
                            @NotNull T toVertex) {
        return findPathRecursive(adjMap, fromVertex, toVertex, new HashSet<>());
    }

    @Nullable
    private List<T> findPathRecursive(@NotNull Map<T, Set<T>> adjMap,
                                      @NotNull T fromVertex,
                                      @NotNull T toVertex,
                                      @NotNull Set<T> visited) {
        Set<T> adj = adjMap.get(fromVertex);
        if (adj.contains(toVertex)) {
            return Arrays.asList(fromVertex, toVertex);
        }
        visited.add(fromVertex);
        for (T vertex : adj) {
            if (!visited.contains(vertex)) {
                List<T> path = findPathRecursive(adjMap, vertex, toVertex, visited);
                if (path != null) {
                    ArrayList<T> result = new ArrayList<>();
                    result.add(fromVertex);
                    result.addAll(path);
                    return result;
                }
            }
        }
        return null;
    }
}
