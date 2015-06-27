package com.learning.coursera.algorithm.week1.domain;

import java.util.List;

/**
 * Created by aliHitawala on 4/26/15.
 */
public interface IGraph {
    int V();
    int E();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);

}
