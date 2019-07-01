package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.Edge;
import net.pogibenko.simplegraph.GraphPathFinder;
import org.jetbrains.annotations.NotNull;

public class UndirectedGraph<T> extends AbstractGraph<T> {

    public UndirectedGraph(@NotNull GraphPathFinder<T> pathFinder) {
        super(pathFinder);
    }

    @NotNull
    @Override
    public Edge<T> addEdge(@NotNull T fromVertex, @NotNull T toVertex) {
        adjMap.computeIfAbsent(fromVertex, this::initAdj).add(toVertex);
        adjMap.computeIfAbsent(toVertex, this::initAdj).add(fromVertex);
        return edge(fromVertex, toVertex);
    }

    @NotNull
    @Override
    protected UndirectedEdge<T> edge(@NotNull T fromVertex, @NotNull T toVertex) {
        return new UndirectedEdge<>(fromVertex, toVertex);
    }
}
