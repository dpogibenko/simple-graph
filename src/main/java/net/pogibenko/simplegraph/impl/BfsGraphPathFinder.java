package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.GraphPathFinder;
import net.pogibenko.simplegraph.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class BfsGraphPathFinder<T> implements GraphPathFinder<T> {

    @Nullable
    @Override
    public List<T> findPath(@NotNull Map<T, Set<T>> adjMap,
                            @NotNull T fromVertex,
                            @NotNull T toVertex) {

        Queue<Pair<T, List<T>>> searchQueue = new LinkedList<>();
        Set<T> visited = new HashSet<>();
        Pair<T,List<T>> next = new Pair<>(fromVertex, Collections.emptyList());
        while (next != null) {
            T vertex = next.getFirst();
            if (!visited.contains(vertex)) {
                List<T> path = new ArrayList<>(next.getSecond());
                path.add(vertex);
                Set<T> adj = adjMap.get(vertex);
                if (adj.contains(toVertex)){
                    path.add(toVertex);
                    return path;
                } else {
                    visited.add(vertex);
                    adj.forEach(t -> searchQueue.add(new Pair<>(t, path)));
                }
            }
            next = searchQueue.poll();
        }
        return null;
    }
}
