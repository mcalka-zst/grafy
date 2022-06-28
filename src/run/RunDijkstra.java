package run;

import graph.WeightedGraph;

import java.io.FileNotFoundException;

public class RunDijkstra {
    public static void run() throws FileNotFoundException {

        WeightedGraph graph = new WeightedGraph();
        graph.read("files\\daneWaga.txt");
        graph.show();
}
}