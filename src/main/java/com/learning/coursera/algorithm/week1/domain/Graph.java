package com.learning.coursera.algorithm.week1.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aliHitawala on 4/26/15.
 */
public class Graph implements IGraph{
    private Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    private int numberOfEdges = 0;
    public Graph() {

    }

    @Override
    public int V() {
        return this.adjList.keySet().size();
    }

    @Override
    public int E() {
        return this.numberOfEdges;
    }

    private boolean isVertexPresent(int v)
    {
        return adjList.containsKey(v);
    }

    @Override
    public void addEdge(int v, int w) {
        this.numberOfEdges++;
        if (isVertexPresent(v))
        {
            this.adjList.get(v).add(w);
        }
        else
        {
            List<Integer> list = new ArrayList<Integer>();
            list.add(w);
            this.adjList.put(v, list);
        }
        if (isVertexPresent(w))
        {
            this.adjList.get(w).add(v);
        }
        else
        {
            List<Integer> list = new ArrayList<Integer>();
            list.add(v);
            this.adjList.put(w, list);
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        if (this.adjList.containsKey(v))
        {
            return this.adjList.get(v);
        }
        return new ArrayList<Integer>();
    }
}
