package run;

import graph.WeightedGraph;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunDijkstra implements Run {
    public static void run() throws FileNotFoundException {

        WeightedGraph graph = new WeightedGraph();
        graph.read("files\\daneWaga.txt");
        graph.show();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Wpisz numer wierzchołka od którego starujemy: ");
        int startVertex = scanner.nextInt() ;

        System.out.println("\nStartujemy od wierzchołka "+startVertex);
        graph.dijkstra(startVertex);
    }

}