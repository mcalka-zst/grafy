import run.RunDijkstra;
import run.RunWithArray;
import run.RunWithArrayList;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunProgram {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wybierz jedną z opcji:");
            System.out.println("1. Przeszukiwanie grafu BFS i DFS z macierzą sąsiedztwa");
            System.out.println("2. Przeszukiwanie grafu BFS i DFS z listą sąsiadów");
            System.out.println("3. Algorytm Dijkstry");
            System.out.println("4. Zakończ");
            int choice = scanner.nextInt();
            System.out.println("-------------------------------------------------------------");
            switch (choice) {
                case 1:
                    RunWithArray.run();
                    break;
                case 2:
                    RunWithArrayList.run();
                    break;
                case 3:
                    RunDijkstra.run();
                    break;
                case 4:
                    System.exit(0);
                default:break;
            }
            System.out.println("-------------------------------------------------------------");
        }

    }
}
