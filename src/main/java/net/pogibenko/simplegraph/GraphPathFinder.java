package net.pogibenko.simplegraph;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GraphPathFinder<T> {

    @Nullable List<T> findPath(@NotNull Map<T, Set<T>> adjMap,
                               @NotNull T fromVertex,
                               @NotNull T toVertex);
}
