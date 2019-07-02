package net.pogibenko.simplegraph.util;

/**
 * Simple Pair class
 * @param <T> type of first element of pair
 * @param <S> type of second element of pair
 */
public class Pair<T,S> {

    private T first;

    private S second;

    public Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
