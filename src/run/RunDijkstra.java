package run;

import graph.WeightedGraph;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunDijkstra implements Run {
    public static void run() throws FileNotFoundException {

        final int inf = Integer.MAX_VALUE;
        WeightedGraph graph = new WeightedGraph();
        graph.read("files\\daneWaga.txt");
        graph.show();

        Scanner scanner = new Scanner(System.in);
        int startVertex =0;
        int stopVertex;
        do {
            System.out.println("\nStarujemy od wierzchołka 0.");
            System.out.print("Do którego wierzchołka chcesz dotrzeć? Wpisz liczbę od 1 do "+ (graph.getSize() - 1)+": ");
            stopVertex = scanner.nextInt();
        } while (stopVertex < 1 || stopVertex > graph.getSize() - 1);
    }
}