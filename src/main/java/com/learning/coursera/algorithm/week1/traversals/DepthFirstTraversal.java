package com.learning.coursera.algorithm.week1.traversals;

import com.learning.coursera.algorithm.week1.domain.Graph;
import com.learning.coursera.algorithm.week1.domain.IGraph;

/**
 * Created by aliHitawala on 4/26/15.
 */
public class DepthFirstTraversal {
    private IGraph graph;
    private boolean[] marked;
    private int[] pathFrom;

    public DepthFirstTraversal(IGraph graph)
    {
        this.graph = graph;
        marked = new boolean[this.graph.V()];
        pathFrom = new int[this.graph.V()];
    }

    public void dfs(int s)
    {
        this.marked[s] = true;
        for(int v : this.graph.adj(s))
        {
            if (!this.marked[v])
            {
                pathFrom[v] = s;
                this.dfs(v);
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
        DepthFirstTraversal traversal = new DepthFirstTraversal(graph1);
        traversal.dfs(0);
        System.out.println(traversal);
    }

    public String toString()
    {
        String result="";
        for (int i=0;i<this.graph.V();i++)
        {
            result += "Vertex = " + i + " Reached from = " + pathFrom[i] + "\n";
        }
        return result;
    }
}
