package graph;

import java.io.FileNotFoundException;

public interface Graph {
    public void read(String path) throws FileNotFoundException;
    public void show();

}
