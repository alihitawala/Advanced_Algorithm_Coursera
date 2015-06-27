package com.learning.coursera.algorithm.week1.traversals;

import com.learning.coursera.algorithm.week1.domain.Graph;
import com.learning.coursera.algorithm.week1.domain.IGraph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by aliHitawala on 4/26/15.
 */
public class BreathFirstTraversal {
    private IGraph graph;
    private boolean[] marked;
    private int[] pathFrom;
    private int[] hops;

    public BreathFirstTraversal(IGraph graph)
    {
        this.graph = graph;
        marked = new boolean[this.graph.V()];
        pathFrom = new int[this.graph.V()];
        hops = new int[this.graph.V()];
    }

    public void bfs(int s)
    {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(s);
        marked[s]=true;
        while(!queue.isEmpty())
        {
            int v = queue.remove();
            for(int w : this.graph.adj(v))
            {
                if (!marked[w])
                {
                    marked[w] = true;
                    pathFrom[w] = v;
                    hops[w] = hops[v]+1;
                    queue.add(w);
                }
            }
        }
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
        BreathFirstTraversal traversal = new BreathFirstTraversal(graph1);
        traversal.bfs(0);
        System.out.println(traversal);
    }

    public String toString()
    {
        String result="";
        for (int i=0;i<this.graph.V();i++)
        {
            result += "Vertex="+i+", Path from="+pathFrom[i]+", hop count="+hops[i] + "\n";
        }
        return result;
    }
}