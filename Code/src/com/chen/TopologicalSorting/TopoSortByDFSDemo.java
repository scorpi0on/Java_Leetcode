package com.chen.TopologicalSorting;

import java.util.LinkedList;
import java.util.List;

public class TopoSortByDFSDemo {
    public void topoSortByDFS(int v, LinkedList<Integer> adj[]) {
        //逆邻接表，知道每个顶点的入度
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }
        //数组标记路径
        boolean[] visited = new boolean[v];
        //深度遍历每个顶点
        for (int i = 0; i < v; ++i) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        System.out.print("->" + vertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);

        TopoSortByDFSDemo topoSortByDFSDemo = new TopoSortByDFSDemo();
        topoSortByDFSDemo.topoSortByDFS(graph.getV(), graph.getAdj());
    }
}
