package graph;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeightedGraph implements Graph {
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
    public void dijkstra(int startVertex, int stopVertex) {
        final int inf = Integer.MAX_VALUE;
        ArrayList<Integer> q = new ArrayList<>(); //wierzchołki, gdzie najmniejszy koszt jest niepoliczony
        ArrayList<Integer> s = new ArrayList<>(); //wierzchołki, gdzie najmniejszy koszt został policzony
        ArrayList<Integer> costs = new ArrayList<>();//koszty dotarcia do wierzchołka
        ArrayList<Integer> prev = new ArrayList<>(); //poprzedni wierzchołek
        for (int i = 0; i < getSize(); i++) {
            q.add(i);
            if (i == startVertex) {
                costs.add(0);
            } else { //oprócz startowego, koszty ustawiamy jako nieskończoność
                costs.add(inf);
            }
            prev.add(-1);
        }
        ArrayList<Neighbour> neighboursTemp = new ArrayList<>();
        while (!q.isEmpty()) {
            //badamy sąsiadów wierzchołka i zmieniamy koszty dotarcia
            for (Neighbour neighbour : this.graph.get(startVertex)) {
                if (costs.get(neighbour.getNumber()) > costs.get(startVertex) + neighbour.getWeight()) { //np. Koszty[1]>Koszty[0]+3 (bo ∞>0+3), to  Koszty[1]=Koszty[0]+3=3
                    costs.set(neighbour.getNumber(), costs.get(startVertex) + neighbour.getWeight());

                }
                neighboursTemp.add(neighbour);
                prev.set(neighbour.getNumber(), startVertex);//oznaczamy poprzedni wierzchołek (np. dla wierzchołka 1 poprzednikiem był 0)
            }
            Pair min = findMin(costs);

            s.add(startVertex); //przenosimy bieżacy wierzchołek z q do s (z dokładniej ich numery)
            q.remove(startVertex);
        }
        System.out.println(s);
        System.out.println(costs);
        System.out.println(prev);

    }

    //źle - trzeba użyć costs
    //-------------------------------------------------------------------------
    //funkcja parę - nr wierzchołak o najmniejszym koszcie oraz wartośc kosztów.
    private Pair findMin(ArrayList<Integer> costs) {
        if (costs.size() == 0) {
            return null;
        }
        int min = costs.get(0); //na poczatku pierwszy uznajemy za najbliższy
        int minNr = 0;
        for (int i = 1; i < costs.size(); i++) {
            if (min > costs.get(i)) {
                min = costs.get(i);
                minNr = i;
            }
        }
        return new Pair(minNr, min);

    }

}
