package net.pogibenko.simplegraph;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Graph<T> {

    /**
     * Adds new vertex to this graph
     * @param vertex vertex to add
     * @return added vertex. It may be copy of original vertex itself or copy of it.
     */
    @NotNull
    T addVertex(@NotNull T vertex);

    /**
     * Adds new edge to this graph
     * @param fromVertex first vertex of edge
     * @param toVertex second vertex of edge
     * @return created edge
     */
    @NotNull
    Edge<T> addEdge(@NotNull T fromVertex, @NotNull T toVertex);

    /**
     * Finds path from one vertex to another
     * @param fromVertex source vertex
     * @param toVertex destination vertex
     * @return list of edges forming path from one vertex to another or null if there is no path
     */
    @Nullable
    List<Edge<T>> findPath(@NotNull T fromVertex, @NotNull T toVertex);
}
