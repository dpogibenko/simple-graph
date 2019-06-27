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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UndirectedEdge<?> that = (UndirectedEdge<?>) o;

        if (!first.equals(that.first) && !first.equals(that.second)) return false;
        return second.equals(that.second) || second.equals(that.first);
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

    @Override
    public String toString() {
        return "UndirectedEdge{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
