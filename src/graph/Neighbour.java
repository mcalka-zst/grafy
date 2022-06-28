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

    public int getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(nr: "+ number+", waga: "+weight+")" ;
    }
}
