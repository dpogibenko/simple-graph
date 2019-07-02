package net.pogibenko.simplegraph.impl;

import net.pogibenko.simplegraph.Edge;

/**
 * Implementation for edges of undirected graphs
 * @param <T> type of vertices in this edge
 */
public class DirectedEdge<T> implements Edge<T> {

    private T first;

    private T second;

    public DirectedEdge(T first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public T getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectedEdge<?> that = (DirectedEdge<?>) o;

        if (!first.equals(that.first)) return false;
        return second.equals(that.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
