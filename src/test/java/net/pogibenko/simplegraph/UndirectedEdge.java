package net.pogibenko.simplegraph;

public class UndirectedEdge<T> implements Edge<T> {

    private T first;

    private T second;

    public UndirectedEdge(T first, T second) {
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
}
