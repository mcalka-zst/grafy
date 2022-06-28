package run;

import graph.GraphWithArrayList;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunWithArrayList {
    public static  void run() throws FileNotFoundException {
        GraphWithArrayList graph = new GraphWithArrayList();
        graph.read("dane2.txt");
        graph.show();

        Scanner scanner = new Scanner(System.in);
        int startVertex;
        do {
            System.out.print("\nOd którego wierzchołka zaczynamy? Wpisz liczbę od 0 do "+ (graph.getSize() - 1)+": ");
            startVertex = scanner.nextInt();
        }while(startVertex<0 || startVertex>graph.getSize()-1);
        graph.bfs(startVertex);
        graph.dfs(startVertex);
        System.out.println();

    }
}
