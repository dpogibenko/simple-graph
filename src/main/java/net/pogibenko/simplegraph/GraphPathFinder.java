package net.pogibenko.simplegraph;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GraphPathFinder<T> {

    /**
     * Finds path from one vertex to another
     * @param adjMap map containing adjacency for vertices
     * @param fromVertex source vertex
     * @param toVertex destination vertex
     * @return list of vertices forming path from one vertex to another or null if there is no path
     */
    @Nullable List<T> findPath(@NotNull Map<T, Set<T>> adjMap,
                               @NotNull T fromVertex,
                               @NotNull T toVertex);
}
