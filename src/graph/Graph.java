package graph;

import java.io.FileNotFoundException;

/**
 * @author Mirosław Całka
 */
public interface Graph {
    public void read(String path) throws FileNotFoundException;
    public void show();

}
