package run;

import graph.GraphWithArray;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunWithArray implements Run {
    public static void run() throws FileNotFoundException {
        GraphWithArray graph = new GraphWithArray();
        graph.read("files\\dane1.txt");
        graph.show();
        Scanner scanner = new Scanner(System.in);
        int startVertex;
        do {
            System.out.print("\nOd którego wierzchołka zaczynamy? Wpisz liczbę od 0 do "+ (graph.getNumberOfVertices() - 1)+": ");
            startVertex = scanner.nextInt();
        }while(startVertex<0 || startVertex>graph.getNumberOfVertices()-1);
        graph.bfs(startVertex);
        graph.dfs(startVertex);
        System.out.println();
    }
}
