package net.pogibenko.simplegraph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph<>();
    }

    @Test
    void addVertex() {
        String vertex = "first";
        String result = graph.addVertex(vertex);
        Assertions.assertEquals(vertex, result);
    }

    @Test
    void addEdge() {
        String first = "first";
        String second = "second";
        Edge<String> edge = graph.addEdge(first, second);
        Assertions.assertNotNull(edge);
        Assertions.assertEquals(first, edge.getFirst());
        Assertions.assertEquals(second, edge.getSecond());
    }

    @Test
    void getPath() {
        List<Edge<String>> expected = new ArrayList<>();
        expected.add(graph.addEdge("first", "second"));
        graph.addEdge("second", "third");
        expected.add(graph.addEdge("second", "fourth"));
        List<Edge<String>> path = graph.getPath("first", "fourth");
        Assertions.assertIterableEquals(expected, path);
    }
}
