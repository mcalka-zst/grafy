package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mirosław Całka
 */
public class WeightedGraph implements Graph {
    private ArrayList<DirectedEdge> graph = new ArrayList<>(); //lista sąsiedztwa
    private int size = 0;//ustalana podczas wczytywania grafu

    //------------------------------------------------

    /**
     * Metoda wczytująca graf ważony
     *
     * @param path
     * @throws FileNotFoundException
     */
    public void read(String path) throws FileNotFoundException {
        File fileIn = new File(path);
        Scanner in = new Scanner(fileIn);
        int size = in.nextInt();
        in.nextLine();//pobranie linii do końca
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] numbers = line.split(" ");
            int start = Integer.parseInt(numbers[0]);//początek
            int end = Integer.parseInt(numbers[1]);//koniec
            int weight = Integer.parseInt(numbers[2]);   //waga
            graph.add(new DirectedEdge(start, end, weight));

        }
        this.size = this.graph.size();

    }

    //-------------------------------------------------------------------------
    public void show() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.println(graph.get(i));
        }

    }

    //-------------------------------------------------------------------------
    public int getSize() {
        return this.size;
    }

    //-------------------------------------------------------------------------

    /**
     * Metoda wyświetlajaca najkrótszą trasę pomiedzy podanymi wierzchołkami
     */
    public void dijkstra(int startVertex, int stopVertex) {
        final int inf = Integer.MAX_VALUE;
        ArrayList<Vertex> g = new ArrayList<>();//wierzchołki, gdzie najmniejszy koszt jest niepoliczony
        ArrayList<Vertex> s = new ArrayList<>();//wierzchołki, gdzie najmniejszy koszt został policzony
        for (int i = 0; i < size; i++) {
            if (i == startVertex) {
                g.add(new Vertex(i, 0, -1));
            } else {
                g.add(new Vertex(i, inf, -1));
            }
        }
        while (!g.isEmpty()) {
            ArrayList<DirectedEdge> neighbours = getNeighbours(startVertex);
            moveVertex(startVertex, g, s);
            for (DirectedEdge neighbour : neighbours) {

            }

        }
    }

    /**
     * Metoda zwracająca listę sąsiadów danego wierzchołka
     */
    private ArrayList<DirectedEdge> getNeighbours(int vertex) {
        ArrayList<DirectedEdge> result = new ArrayList<>();
        for (DirectedEdge directedEdge : graph) {
            if (directedEdge.getStartVertex() == vertex) {
                result.add(directedEdge);
            }
        }
        return result;
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

    /**
     * Metoda przenosząca wierzchołek z pomiędzy listami
     *
     * @param number
     * @param from
     * @param to
     */
    public void moveVertex(int number, ArrayList<Vertex> from, ArrayList<Vertex> to) {
        for (Vertex vertex : from) {
            if (number == vertex.getNumber()) {
                to.add(vertex);
                from.remove(vertex);
                break;
            }
        }
    }
}
