package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.GraphPathFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Finds path using Depth First Search algorithm
 * @param <T> type of vertices in graph
 */
public class DfsGraphPathFinder<T> implements GraphPathFinder<T> {

    @Nullable
    @Override
    public List<T> findPath(@NotNull Map<T, Set<T>> adjMap,
                            @NotNull T fromVertex,
                            @NotNull T toVertex) {
        return findPathRecursive(adjMap, fromVertex, toVertex, new HashSet<>());
    }

    /**
     * Recursively finds path from one vertex to another
     * @param adjMap map containing adjacency for vertices
     * @param fromVertex source vertex
     * @param toVertex destination vertex
     * @param visited set of visited vertices
     * @return list of vertices forming path from one vertex to another or null if there is no path
     */
    @Nullable
    private List<T> findPathRecursive(@NotNull Map<T, Set<T>> adjMap,
                                      @NotNull T fromVertex,
                                      @NotNull T toVertex,
                                      @NotNull Set<T> visited) {
        Set<T> adj = adjMap.getOrDefault(fromVertex, Collections.emptySet());
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
