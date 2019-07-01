package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.Edge;
import net.pogibenko.simplegraph.Graph;
import net.pogibenko.simplegraph.GraphPathFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class UndirectedGraph<T> implements Graph<T> {

    private Map<T, Set<T>> adjMap = new HashMap<>();

    private GraphPathFinder<T> pathFinder;

    public UndirectedGraph(GraphPathFinder<T> pathFinder) {
        this.pathFinder = pathFinder;
    }

    @NotNull
    @Override
    public T addVertex(@NotNull T vertex) {
        adjMap.put(vertex, initAdj(vertex));
        return vertex;
    }

    @NotNull
    @Override
    public Edge<T> addEdge(@NotNull T fromVertex, @NotNull T toVertex) {
        adjMap.computeIfAbsent(fromVertex, this::initAdj).add(toVertex);
        adjMap.computeIfAbsent(toVertex, this::initAdj).add(fromVertex);
        return new UndirectedEdge<>(fromVertex, toVertex);
    }

    @Nullable
    @Override
    public List<Edge<T>> getPath(@NotNull T fromVertex, @NotNull T toVertex) {
        List<T> path = pathFinder.findPath(adjMap, fromVertex, toVertex);
        return toEdges(path);
    }

    @NotNull
    private Set<T> initAdj(T t) {
        return new HashSet<>();
    }

    @Nullable
    private List<Edge<T>> toEdges(@Nullable List<T> path) {
        if (path == null) {
            return null;
        }
        List<Edge<T>> pathEdges = new ArrayList<>();
        for(int i = 1; i < path.size(); i++) {
            pathEdges.add(new UndirectedEdge<>(path.get(i-1), path.get(i)));
        }
        return pathEdges;
    }
}
