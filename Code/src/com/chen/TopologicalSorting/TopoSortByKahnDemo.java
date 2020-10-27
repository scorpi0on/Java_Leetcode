package com.chen.TopologicalSorting;

import java.util.LinkedList;

public class TopoSortByKahnDemo {

    public void topoSortByKahn(int v, LinkedList<Integer> adj[]) {
        //统计顶点的入度
        int[] inDegree = new int[v];
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j);
                inDegree[w] ++;
            }
        }
        //构造队列，入度为0的顶点入队
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) queue.add(i);
        }
        //循环： 删除入度为空的点， 并把与之相关的顶点入度减一
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j<adj[i].size(); ++j) {
                int k = adj[i].get(j);
                inDegree[k] --;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(3,2);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);

        TopoSortByKahnDemo topoSortByKahnDemo =  new TopoSortByKahnDemo();
        topoSortByKahnDemo.topoSortByKahn(graph.getV(), graph.getAdj());
    }
}
