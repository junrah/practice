package ex05.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Graph {

    static class Vertex {
        String data;
        List<Vertex> adjacentList; // 이 노드와 연결된 Vertex들을 담을

        Vertex(String data) {
            this.data = data;
            adjacentList = new ArrayList<Vertex>();
        }

        void add(Vertex... adjacent) {
            adjacentList.addAll(Arrays.asList(adjacent));
        }

        public String toString() {
            return data;
        }
    }

    private void findPath(List<List<Vertex>> list, Stack<Vertex> path, Vertex current, Vertex dest) {
        System.out.println(current + " 추가");

        if (path == null) {
            path = new Stack<>();
        }
        if (current == dest) {
            path.push(current);
            Stack<Vertex> completePath = new Stack<>();
            completePath.addAll(path);
            list.add(completePath);
            System.out.println("목적지 도달! - " + path);
            return;
        }
        if (path.contains(current)) {
            System.out.print("중복! ");
            path.push(current);
            return;
        }
        path.push(current);
        for (Vertex v : current.adjacentList) {
            System.out.println("current path : " + path);
            findPath(list, path, v, dest);
            if(path.isEmpty()){
                break;
            }
            System.out.println("pop : " + path.pop());
        }
    }

    public List<List<Vertex>> findAllPath(Vertex start, Vertex dest) {
        List<List<Vertex>> list = new ArrayList<>();
        findPath(list, null, start, dest);
        return list;
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        Graph.Vertex a = new Graph.Vertex("A");
        Graph.Vertex b = new Graph.Vertex("B");
        Graph.Vertex c = new Graph.Vertex("C");
        Graph.Vertex d = new Graph.Vertex("D");
        Graph.Vertex e = new Graph.Vertex("E");
        Graph.Vertex f = new Graph.Vertex("F");
        Graph.Vertex g = new Graph.Vertex("G");
        Graph.Vertex h = new Graph.Vertex("H");
        Graph.Vertex i = new Graph.Vertex("I");
        Graph.Vertex j = new Graph.Vertex("J");

        a.add(b, f);
        b.add(a, d);
        c.add(g);
        d.add(b);
        e.add(f, i);
        f.add(a, e, g, h);
        g.add(c, f, i);
        h.add(f, j);
        i.add(e, g, j);
        j.add(h, i);

        // 시작점 : a
        // 끝점 : i
        List<List<Vertex>> list = graph.findAllPath(a, i);
        System.out.println(list);
    }
}
