package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphWithArrayList implements Graph{
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //lista sąsiedztwa
    private int size = 0;//ustalana podczas wczytywania grafu

    //------------------------------------------------
    public void read(String path) throws FileNotFoundException {
        File fileIn = new File(path);
        Scanner in = new Scanner(fileIn);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            ArrayList<Integer> tempList = new ArrayList<>();
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                tempList.add(Integer.parseInt(number));
            }
            this.graph.add(tempList);
        }
        this.size = this.graph.size();
    }

    public int getSize() {
        return this.size;
    }

    //------------------------------------------------
    public void show() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.print("Sąsiedzi wierzchołka " + i + ": ");
            System.out.println(this.graph.get(i));
        }
    }

    //------------------------------------------------
    public void bfs(int startVertex) {
        System.out.print("\nKolejność odwiedzania w BFS: ");
        int numberOfVertices = this.graph.size();
        Boolean[] visited = new Boolean[numberOfVertices];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
        }
        visited[startVertex] = true; //wierzchołek startowy uznajemy, za odwiedzony
        queue.addLast(startVertex);
        while (!queue.isEmpty()) {
            int first = queue.getFirst(); //zapamiętujemy pierwszy element z kolejki
            queue.removeFirst(); //usuwamy pierwszy element z kolejki
            System.out.print(first + " ");
            for (Integer element : this.graph.get(first)) { //przechodzimy po sąsiadach pierwszego elemntu z kolejki
                if (!visited[element]) {
                    queue.addLast(element);//sąsiad idzie na koniec kolejki kolejki
                    visited[element] = true; //wierzchołek element uznajemy za odwiedzony
                }
            }

        }
    }

    //------------------------------------------------
    public void dfs(int startVertex) {
        System.out.print("\nKolejność odwiedzania w DFS: ");
        int numberOfVertices = this.graph.size();
        Boolean[] visited = new Boolean[numberOfVertices];
        Stack<Integer> stack= new Stack<>();
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
        }
        visited[startVertex] = true; //wierzchołek startowy uznajemy, za odwiedzony
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int top = stack.pop(); //pobieramy i usuwamy wierzchołek ze stosu
            System.out.print(top + " ");
            for (Integer element : this.graph.get(top)) { //przechodzimy po sąsiadach pierwszego elemntu z kolejki
                if (!visited[element]) {
                    stack.push(element);//sąsiad idzie na stos
                    visited[element] = true; //wierzchołek element uznajemy za odwiedzony
                }
            }

        }
    }

}
