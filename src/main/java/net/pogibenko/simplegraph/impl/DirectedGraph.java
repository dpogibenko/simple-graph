package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.Edge;
import net.pogibenko.simplegraph.Graph;
import net.pogibenko.simplegraph.GraphPathFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Implementation for directed graphs
 * @param <T> type of vertices in this graph
 */
public class DirectedGraph<T> extends AbstractGraph<T> {

    public DirectedGraph(@NotNull GraphPathFinder<T> pathFinder) {
        super(pathFinder);
    }

    @NotNull
    @Override
    public Edge<T> addEdge(@NotNull T fromVertex, @NotNull T toVertex) {
        adjMap.computeIfAbsent(fromVertex, this::initAdj).add(toVertex);
        adjMap.computeIfAbsent(toVertex, this::initAdj);
        return edge(fromVertex, toVertex);
    }

    @NotNull
    @Override
    protected DirectedEdge<T> edge(@NotNull T fromVertex, @NotNull T toVertex) {
        return new DirectedEdge<>(fromVertex, toVertex);
    }
}
