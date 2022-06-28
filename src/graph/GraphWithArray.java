package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class GraphWithArray implements Graph {

    private int[][] graph; //tablica sąsiedztwa
    private int numberOfVertices = 0;//ilość wierzchołków
    private int numberOfEdges = 0; //ilość krawędzi
    //ustalana podczas wczytywania grafu

    //------------------------------------------------
    public void read(String path) throws FileNotFoundException {
        File fileIn = new File(path);
        Scanner in = new Scanner(fileIn);
        numberOfVertices = in.nextInt();
        numberOfEdges = in.nextInt();
        graph = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfEdges; i++) {
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
            graph[a][b] = 1; //a jest sąsiadem b
            graph[b][a] = 1; //b jest sąsiadem a
        }
    }
    //-----------------------------------------------

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    //------------------------------------------------
    public void show() {
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //------------------------------------------------
    public void bfs(int startVertex) {
        System.out.print("\nKolejność odwiedzania w BFS: ");
        Boolean[] visited = new Boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        visited[startVertex] = true; //wierzchołek startowy uznajemy, za odwiedzony
        queue.addLast(startVertex); //dodajemy wierzchołek do kolejki
        while (!queue.isEmpty()) {
            int first = queue.getFirst(); //zapamiętujemy pierwszy element z kolejki
            queue.removeFirst(); //usuwamy pierwszy element z kolejki
            System.out.print(first + " ");
            for (int i = 0; i < numberOfVertices; i++) {
                if (graph[first][i] == 1 && !visited[i]) { //odwiedzamy sąsiadów wierzcholka first
                    queue.addLast(i); //sąsiad idzie na koniec kolejki kolejki
                    visited[i] = true; //wierzchołek nr i uznajemy za odwiedzony
                }
            }
        }
    }

    //------------------------------------------------
    public void dfs(int startVertex) {
        System.out.print("\nKolejność odwiedzania w DFS: ");
        Boolean[] visited = new Boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<>();
        visited[startVertex] = true; //wierzchołek startowy uznajemy, za odwiedzony
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int top = stack.pop(); //pobieramy i usuwamy wierzchołek ze stosu
            System.out.print(top + " ");
            for(int i=0; i<numberOfVertices; i++){
                if(graph[top][i]==1 && ! visited[i]){ //odwiedzamy sąsiadów wierzchołka top
                    stack.push(i); //sąsiad idzie na stos
                    visited[i]=true; //wierzchołek nr i uznajemy za odwiedzony
                }
            }
        }
    }
}
