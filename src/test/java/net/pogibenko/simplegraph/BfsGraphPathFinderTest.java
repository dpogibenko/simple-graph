package net.pogibenko.simplegraph;

import net.pogibenko.simplegraph.impl.BfsGraphPathFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class BfsGraphPathFinderTest {

    private GraphPathFinder<String> pathFinder;

    @BeforeEach
    void setUp() {
        pathFinder = new BfsGraphPathFinder<>();
    }

    @Test
    void findPath() {
        Map<String, Set<String>> adjMap = new LinkedHashMap<>();
        Set<String> aAdj = new LinkedHashSet<>();
        aAdj.add("b");
        aAdj.add("c");
        adjMap.put("a", aAdj);
        Set<String> bAdj = new LinkedHashSet<>();
        bAdj.add("b");
        bAdj.add("c");
        bAdj.add("d");
        adjMap.put("b", bAdj);
        Set<String> cAdj = new LinkedHashSet<>();
        cAdj.add("b");
        cAdj.add("d");
        cAdj.add("f");
        adjMap.put("c", cAdj);
        List<String> expectedPath = Arrays.asList("a", "c", "f");
        List<String> path = pathFinder.findPath(adjMap, "a", "f");
        assertIterableEquals(expectedPath, path);
    }
}
