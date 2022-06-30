package graph;

/**
 * Klasa opisujaca krawędź grafu ważonego
 * Zawiera numer wierzchołka początkowego i końcowego oraz wagę

 * @author Mirosłw Całka
 */
public class DirectedEdge {
    private int startVertex;
    private int stopVertex;
    private int weight;

    public int getStartVertex() {
        return startVertex;
    }

    public int getStopVertex() {
        return stopVertex;
    }

    public int getWeight() {
        return weight;
    }

    public DirectedEdge(int startVertex, int stopVertex, int weight) {
        this.startVertex = startVertex;
        this.stopVertex = stopVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {

        return "[start: " + startVertex + ", stop: " + stopVertex+ ", waga: "+weight+"]";
    }
}
