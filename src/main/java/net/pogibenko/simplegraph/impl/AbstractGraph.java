package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.Edge;
import net.pogibenko.simplegraph.Graph;
import net.pogibenko.simplegraph.GraphPathFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T> {

    protected Map<T, Set<T>> adjMap = new HashMap<>();

    protected GraphPathFinder<T> pathFinder;

    public AbstractGraph(@NotNull GraphPathFinder<T> pathFinder) {
        this.pathFinder = pathFinder;
    }

    @NotNull
    @Override
    public abstract Edge<T> addEdge(@NotNull T fromVertex, @NotNull T toVertex);

    @NotNull
    protected abstract Edge<T> edge(@NotNull T fromVertex, @NotNull T toVertex);

    @NotNull
    @Override
    public T addVertex(@NotNull T vertex) {
        adjMap.put(vertex, initAdj(vertex));
        return vertex;
    }

    @Nullable
    @Override
    public List<Edge<T>> getPath(@NotNull T fromVertex, @NotNull T toVertex) {
        List<T> path = pathFinder.findPath(adjMap, fromVertex, toVertex);
        return edges(path);
    }

    @NotNull
    protected Set<T> initAdj(@Nullable T t) {
        return new HashSet<>();
    }

    @Nullable
    private List<Edge<T>> edges(@Nullable List<T> path) {
        if (path == null) {
            return null;
        }
        List<Edge<T>> pathEdges = new ArrayList<>();
        for(int i = 1; i < path.size(); i++) {
            T first = path.get(i - 1);
            T second = path.get(i);
            pathEdges.add(edge(first, second));
        }
        return pathEdges;
    }
}
