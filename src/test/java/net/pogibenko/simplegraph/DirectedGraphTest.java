package net.pogibenko.simplegraph;

import net.pogibenko.simplegraph.impl.DfsGraphPathFinder;
import net.pogibenko.simplegraph.impl.DirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new DirectedGraph<>(new DfsGraphPathFinder<>());
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
        expected.add(graph.addEdge("second", "fourth"));
        List<Edge<String>> path = graph.getPath("first", "fourth");
        assertNotNull(path);
        assertIterableEquals(expected, path);
    }

    @Test
    void getReversePathNull() {
        graph.addEdge("first", "second");
        graph.addEdge("second", "third");
        graph.addEdge("second", "fourth");
        List<Edge<String>> path = graph.getPath("fourth", "first");
        assertNull(path);
    }
}
