package net.pogibenko.simplegraph;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Graph<T> {

    @NotNull
    T addVertex(@NotNull T vertex);

    @NotNull
    Edge<T> addEdge(@NotNull T first, @NotNull T second);

    @Nullable
    List<Edge<T>> getPath(@NotNull T first, @NotNull T second);
}
