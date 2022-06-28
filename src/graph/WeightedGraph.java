package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeightedGraph {
    private ArrayList<ArrayList<Neighbour>> graph = new ArrayList<>(); //lista sąsiedztwa
    private int size = 0;//ustalana podczas wczytywania grafu

    //------------------------------------------------
    public void read(String path) throws FileNotFoundException {
        File fileIn = new File(path);
        Scanner in = new Scanner(fileIn);
        int size = in.nextInt();
        for (int i=0; i<size; i++){
          ArrayList<Neighbour> temp = new ArrayList<>();
          graph.add(temp);
        }
        in.nextLine();//pobranie linii do końca
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] numbers = line.split(" ");
            int number = Integer.parseInt(numbers[0]);//bieżący wierzchołek
            int neighbour = Integer.parseInt(numbers[1]);//sąsiad
            int weight = Integer.parseInt(numbers[2]);   //waga
            graph.get(number).add(new Neighbour(neighbour, weight));

        }

    }

    public void show() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.println("Sąsiedzi wierzchołka " + i + ": " + graph.get(i));
        }

    }

}
