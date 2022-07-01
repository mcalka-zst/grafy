package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Mirosław Całka
 */
public class WeightedGraph implements Graph {
    private ArrayList<DirectedEdge> graph = new ArrayList<>(); //lista sąsiedztwa
    private int countOfEdges = 0;//ilość krawędzi - ustalana podczas wczytywania grafu
    private int countOfVertices = 0;//ilość wierzchoków- ustalana podczas wczytywania grafu


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
        this.countOfVertices = in.nextInt();
        in.nextLine();//pobranie linii do końca
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] numbers = line.split(" ");
            int begin = Integer.parseInt(numbers[0]);//początek
            int end = Integer.parseInt(numbers[1]);//koniec
            int weight = Integer.parseInt(numbers[2]);   //waga
            graph.add(new DirectedEdge(begin, end, weight));

        }
        this.countOfEdges = this.graph.size();
    }

    //-------------------------------------------------------------------------
    public void show() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.println(graph.get(i));
        }

    }

    //-------------------------------------------------------------------------
    public int getCountOfEdges() {
        return this.countOfEdges;
    }

    //-------------------------------------------------------------------------

    /**
     * Metoda wyświetlajaca najkrótsze trasy od wierzchołka startVertex do pozostałych
     */
    public void dijkstra(int startVertex) {
        final int inf = Integer.MAX_VALUE;
        // ArrayList<Vertex> g = new ArrayList<>();
        HashMap<Integer, Pair> g = new HashMap<>();//wierzchołki, gdzie najmniejszy koszt jest niepoliczony
        HashMap<Integer, Pair> s = new HashMap<>();//wierzchołki, gdzie najmniejszy koszt jest niepoliczony
        //ArrayList<Vertex> s = new ArrayList<>();//wierzchołki, gdzie najmniejszy koszt został policzony
        boolean[] moved = new boolean[countOfVertices];
        for (int i = 0; i < countOfVertices; i++) {
            if (i == startVertex) {
                g.put(i, new Pair(0, -1));
            } else {
                g.put(i, new Pair(inf, -1));
            }
            moved[i] = false;

        }
        while (!g.isEmpty()) {
            ArrayList<DirectedEdge> neighbours = getNeighbours(startVertex);
            for (DirectedEdge neighbour : neighbours) {
                int nr = neighbour.getEnd();
                if (moved[nr]) break; //
                int weight = neighbour.getWeight();
                int newCost = g.get(startVertex).getCost() + weight;
//                System.out.println(nr+" "+weight);
                if (g.get(nr).getCost() > newCost) {
                    g.get(nr).setCost(newCost);//ustawiamy nowy koszt
                    g.get(nr).setPrev(startVertex);//ustawiamy wierzchołek poprzedni
                }

            }
            moveVertex(startVertex, g, s);
            moved[startVertex] = true;
            if (!g.isEmpty()) startVertex = findMinCostNumber(g);
        }
//        System.out.println(mapToList(s));
        printMap(s);
    }
//-------------------------------------------------------------------------

    /**
     * Metoda zwracająca listę sąsiadów danego wierzchołka
     */
    private ArrayList<DirectedEdge> getNeighbours(int vertex) {
        ArrayList<DirectedEdge> result = new ArrayList<>();
        for (DirectedEdge directedEdge : graph) {
            if (directedEdge.getBegin() == vertex) {
                result.add(directedEdge);
            }
        }
        return result;
    }

    //-------------------------------------------------------------------------

    /**
     * Metoda znajdujaca nr wierzchołka o najniższym koszcie
     *
     * @param vertices
     * @return
     */
    private int findMinCostNumber(HashMap<Integer, Pair> vertices) {

        Set<Map.Entry<Integer, Pair>> entries = vertices.entrySet(); //zamieniam mapę na zbiór, aby go móc iterować
        Iterator<Map.Entry<Integer, Pair>> verticesIterator = entries.iterator();
        Map.Entry<Integer, Pair> entry = verticesIterator.next();
        int minCost = entry.getValue().getCost();
        int nr = entry.getKey();
        while (verticesIterator.hasNext()) {
            entry = verticesIterator.next();
            if (minCost > entry.getValue().getCost()) {
                minCost = entry.getValue().getCost();
                nr = entry.getKey();

            }
        }
        return nr;


    }
    //-------------------------------------------------------------------------

    /**
     * Metoda przenosząca wierzchołek z pomiędzy mapami
     *
     * @param number
     * @param from
     * @param to
     */
    public void moveVertex(int number, HashMap<Integer, Pair> from, HashMap<Integer, Pair> to) {
        to.put(number, from.get(number));
        from.remove(number);
    }

    //----------------------------------------------

    /**
     * Metoda wyświetlanąca mapę <Integer, Pair>
     */
    private static void printMap(HashMap<Integer, Pair> map) {
        Set<Map.Entry<Integer, Pair>> entries = map.entrySet(); //zamieniam mapę na zbiór, aby go móc iterować
        Iterator<Map.Entry<Integer, Pair>> mapIterator = entries.iterator();
        ArrayList<Vertex> list = new ArrayList<>();
        while (mapIterator.hasNext()) {
            Map.Entry<Integer, Pair> entry = mapIterator.next();
            if (entry.getValue().getPrev() != -1) {
                System.out.printf("Najmniejszy koszt dojścia do wierzchołka %d to  %d, poprzedni wierzchołek: %d\n", entry.getKey(), entry.getValue().getCost(), entry.getValue().getPrev());
            }
        }
    }

}




