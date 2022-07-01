package graph;

/**
 * Klasa potrzebna dla zamiany elemtu listy w mapę
 * @author Mirosław Całka
 */
public class Pair{
    int cost;
    int prev;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getPrev() {
        return prev;
    }

    public Pair(int cost, int prev) {
        this.cost = cost;
        this.prev = prev;
    }

    public String toString(){
        return "Koszt: "+cost+", poprzedni wierzchołek: "+prev;
    }
}