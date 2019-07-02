package net.pogibenko.simplegraph;

public interface Edge<T> {

    /**
     * @return first vertex of edge
     */
    T getFirst();

    /**
     * @return second vertex of edge
     */
    T getSecond();
}
