package com.learning.coursera.algorithm.week1.challenges;

import com.learning.coursera.algorithm.week1.domain.Graph;
import com.learning.coursera.algorithm.week1.domain.IGraph;
import com.learning.coursera.algorithm.week1.traversals.DepthFirstTraversal;

/**
 * Created by aliHitawala on 4/26/15.
 */
public class ConnectedComponents {
    private IGraph graph;
    private boolean[] marked;
    private int id[];

    public ConnectedComponents(IGraph graph)
    {
        this.graph = graph;
        marked = new boolean[this.graph.V()];
        id = new int[this.graph.V()];
    }

    public void find(int s)
    {
        int count = 1;
        for (int i=0;i<this.graph.V();i++)
        {
            if (!marked[i])
            {
                id[i] = count++;
                this.dfs(i);
            }
        }
    }

    private void dfs(int v)
    {
        marked[v] = true;
        for (int w : this.graph.adj(v))
        {
            if (!marked[w])
            {
                id[w] = id[v];
                dfs(w);
            }
        }
    }

    public String toString()
    {
        String result="";
        for (int i=0;i<this.graph.V();i++)
        {
            result += "Vertex v = " + i + " Connected Component ID = " + id[i]  + "\n";;
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
        graph1.addEdge(7,8);
        graph1.addEdge(9,10);
        ConnectedComponents cc = new ConnectedComponents(graph1);
        cc.find(0);
        System.out.println(cc);
    }
}
