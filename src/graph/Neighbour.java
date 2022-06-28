package graph;

public class Neighbour {
    private int number;
    private int weight;

    public Neighbour(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public Neighbour() {
    }

    @Override
    public String toString() {
        return "(nr: "+ number+", waga: "+weight+")" ;
    }
}
