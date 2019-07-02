package net.pogibenko.simplegraph;

import net.pogibenko.simplegraph.impl.DfsGraphPathFinder;
import net.pogibenko.simplegraph.impl.UndirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph<>(new DfsGraphPathFinder<>());
    }

    @Test
    void addVertex() {
        String vertex = "first";
        String result = graph.addVertex(vertex);
        assertEquals(vertex, result);
    }

    @Test
    void addEdge() {
        String first = "first";
        String second = "second";
        Edge<String> edge = graph.addEdge(first, second);
        assertNotNull(edge);
        assertEquals(first, edge.getFirst());
        assertEquals(second, edge.getSecond());
    }

    @Test
    void getPath() {
        List<Edge<String>> expected = new ArrayList<>();
        expected.add(graph.addEdge("first", "second"));
        graph.addEdge("second", "third");
        expected.add(graph.addEdge("fourth", "second"));
        List<Edge<String>> path = graph.findPath("first", "fourth");
        assertIterableEquals(expected, path);
    }

    @Test
    void getReversePath() {
        List<Edge<String>> expected = new ArrayList<>();
        expected.add(graph.addEdge("fourth", "second"));
        expected.add(graph.addEdge("first", "second"));
        graph.addEdge("second", "third");
        List<Edge<String>> path = graph.findPath("fourth", "first");
        assertIterableEquals(expected, path);
    }
}
