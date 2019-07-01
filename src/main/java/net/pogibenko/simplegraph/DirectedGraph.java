package net.pogibenko.simplegraph;

import java.util.List;

public class DirectedGraph<T> implements Graph<T> {

    @Override
    public T addVertex(T vertex) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Edge<T> addEdge(T first, T second) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Edge<T>> getPath(T first, T second) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
