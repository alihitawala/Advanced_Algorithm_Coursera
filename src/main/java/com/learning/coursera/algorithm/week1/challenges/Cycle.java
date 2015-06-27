package com.learning.coursera.algorithm.week1.challenges;

import com.learning.coursera.algorithm.week1.domain.Graph;
import com.learning.coursera.algorithm.week1.domain.IGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aliHitawala on 4/26/15.
 */
public class Cycle {
    private IGraph graph;
    private List<List<Integer>> cycles;
    private boolean [] marked;
    private int[] from;

    public Cycle(IGraph graph) {
        this.graph = graph;
        marked = new boolean[this.graph.V()];
        from = new int[this.graph.V()];
        cycles = new ArrayList<List<Integer>>();
    }

    public void find(int s) {
        this.dfs(s);
    }

    private void dfs(int s)
    {
        marked[s] = true;
        for(int v : this.graph.adj(s))
        {
            if (!marked[v])
            {
                from[v] = s;
                dfs(v);
            }
            else if (marked[v] && v!= from[s])
            {
                this.saveCycle(v);
            }
        }
    }

    private void saveCycle(int v)
    {
        int start = v;
        List<Integer> list = new ArrayList<Integer>();
        for (;start != from[v];v= from[v])
        {
            list.add(v);
        }
        this.cycles.add(list);
    }

    @Override
    public String toString() {
        String result = "";
        int count = 0;
        for(List<Integer>l : cycles)
        {
            result += "Cycle "+ count + " = ";
            for (int i : l)
            {
                result += i + " ";
            }
            result +="\n";
        }
        return result;
    }

    public static void main(String[] args) {
        //test method
        IGraph graph1 = new Graph();
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(0,5);
        graph1.addEdge(0,6);
        graph1.addEdge(3,4);
        graph1.addEdge(3,5);
        graph1.addEdge(4,5);
        graph1.addEdge(4,6);
        Cycle cycle = new Cycle(graph1);
        cycle.find(0);
        System.out.println(cycle);
    }
}
