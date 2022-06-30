package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeightedGraph_copy implements Graph {
    private ArrayList<ArrayList<Neighbour>> graph = new ArrayList<>(); //lista sąsiedztwa
    private int size = 0;//ustalana podczas wczytywania grafu

    //------------------------------------------------


    public void read(String path) throws FileNotFoundException {
        File fileIn = new File(path);
        Scanner in = new Scanner(fileIn);
        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
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
        this.size = this.graph.size();

    }

    public void show() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.println("Sąsiedzi wierzchołka " + i + ": " + graph.get(i));
        }

    }

    public int getSize() {
        return this.size;
    }

    //-------------------------------------------------------------------------
    public void dijkstra(int startVertex) {
        final int inf = Integer.MAX_VALUE;

        ArrayList<Vertex> q = new ArrayList<>(); //wierzchołki, gdzie najmniejszy koszt jest niepoliczony
        ArrayList<Vertex> s = new ArrayList<>(); //wierzchołki, gdzie najmniejszy koszt został policzony
        for (int i = 0; i < getSize(); i++) {
            if (i == startVertex) {
                q.add(new Vertex(i, 0, -1));
            } else { //oprócz startowego, koszty ustawiamy jako nieskończoność
                q.add(new Vertex(i, inf, -1));
            }
        }
        //lista do przechowywania informacji o wierzchołkach sąsiadujących (ich kosztach i wierzchołkach poprzednich)
        ArrayList<Vertex> neighboursVertexTemp = new ArrayList<>();
        while (!q.isEmpty()) {
            //badamy sąsiadów wierzchołka i zmieniamy koszty dotarcia
            for (Neighbour neighbour : this.graph.get(startVertex)) {
                int nr = neighbour.getNumber();//nr badanego sąsiada
                int newCost = q.get(startVertex).getCost() + neighbour.getWeight();

                if (q.get(nr).getCost() > newCost) { //np. Koszty[1]>Koszty[0]+3 (bo ∞>0+3), to  Koszty[1]=Koszty[0]+3=3
                    q.get(nr).setCost(newCost);
                    q.get(nr).setPrev(startVertex);//oznaczamy poprzedni wierzchołek (np. dla wierzchołka 1 poprzednikiem był 0)
                }
                neighboursVertexTemp.add(q.get(nr));

            }
            Vertex minVertex = findMin(neighboursVertexTemp);
            s.add(q.get(startVertex)); //przenosimy bieżacy wierzchołek z q do s
            q.remove(q.get(startVertex));
            startVertex = minVertex.getNumber();
        }

    }

    //-------------------------------------------------------------------------
    private Vertex findMin(ArrayList<Vertex> vertices) {
        if (vertices.size() == 0) {
            return null;
        }
        int min = vertices.get(0).getCost(); //na poczatku pierwszy uznajemy za najbliższy
        Vertex vertexMin = vertices.get(0);
        for (int i = 1; i < vertices.size(); i++) {
            if (min > vertices.get(i).getCost()) {
                min = vertices.get(i).getCost();
                vertexMin = vertices.get(i);
            }
        }
        return vertexMin;
    }

}
