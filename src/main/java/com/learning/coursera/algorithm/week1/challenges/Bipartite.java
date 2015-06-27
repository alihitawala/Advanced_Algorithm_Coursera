package com.learning.coursera.algorithm.week1.challenges;

import com.learning.coursera.algorithm.week1.domain.Graph;
import com.learning.coursera.algorithm.week1.domain.IGraph;

/**
 * Created by aliHitawala on 4/26/15.
 */
public class Bipartite {
    private IGraph graph;
    private int[] sets;
    private boolean[] marked;
    private boolean isBipartite;

    public Bipartite(IGraph graph)
    {
        this.graph = graph;
        sets = new int[this.graph.V()];
        marked = new boolean[this.graph.V()];
        isBipartite = true;
    }

    public void checkBipartedness(int s)
    {
        sets[s] = 1;
        this.dfs(s);
    }

    private void dfs(int s)
    {
        marked[s] = true;
        for (int v : this.graph.adj(s))
        {
            if (!marked[v])
            {
                this.sets[v] = this.sets[s] * -1;
                dfs(v);
            }
            else if(marked[v] && this.sets[v] == this.sets[s])
            {
                this.isBipartite = false;
            }
        }
    }

    public String toString()
    {
        String result = "";
        if (!this.isBipartite)
        {
            return "The graph is not bipartite.";
        }
        result += "The graph is bipartite. \n";
        for(int i=0;i<this.graph.V(); i++)
        {
            result += "Vertex = " + i + " Set part of = " + this.sets[i] + "\n";
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
        Bipartite bipartite = new Bipartite(graph1);
        bipartite.checkBipartedness(0);
        System.out.println(bipartite);

        graph1 = new Graph();
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(0,5);
        graph1.addEdge(0,6);
        graph1.addEdge(3,1);
        graph1.addEdge(3,2);
        graph1.addEdge(4,2);
        graph1.addEdge(4,5);
        graph1.addEdge(4,6);
        bipartite = new Bipartite(graph1);
        bipartite.checkBipartedness(0);
        System.out.println(bipartite);
    }
}
