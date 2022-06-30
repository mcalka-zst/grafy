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
        int startVertex =0;
        int stopVertex =6;
        do {
            System.out.println("\nStartujemy od wierzchołka 0.");
//            System.out.print("Do którego wierzchołka chcesz dotrzeć? Wpisz liczbę od 1 do "+ (graph.getSize() - 1)+": ");
//            stopVertex = scanner.nextInt();
        } while (stopVertex < 1 || stopVertex > graph.getSize() - 1);
        graph.dijkstra(startVertex, stopVertex);
    }

}