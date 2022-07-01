package graph;

/**
 * Klasa opisujaca krawędź grafu ważonego
 * Zawiera numer wierzchołka początkowego i końcowego oraz wagę

 * @author Mirosłw Całka
 */
public class DirectedEdge {
    private int begin;
    private int end;
    private int weight;

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    public DirectedEdge(int startVertex, int stopVertex, int weight) {
        this.begin = startVertex;
        this.end = stopVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {

        return "[start: " + begin + ", stop: " + end + ", waga: "+weight+"]";
    }


}
