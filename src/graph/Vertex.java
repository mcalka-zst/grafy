package graph;

/**
 * Klasa opisujaca wierzchołek grafu ważonego
 * Zawiera numer wierzchołka, koszt dojścia do niego oraz nt wierzchołka poprzedniego

 * @author Mirosłw Całka
 */
public class Vertex {
    private int number;
    private int cost;
    private int prev;

    public Vertex(int number, int cost, int prev) {
        this.number = number;
        this.cost = cost;
        this.prev = prev;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }
    @Override
    public String toString(){
        return number+", "+cost+" "+prev;
    }
}
