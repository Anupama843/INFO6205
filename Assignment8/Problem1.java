package Assignment8;

/*
1. Given a graph and a source vertex in the graph,
find shortest paths from source to all vertices in the given graph.
 */

public class Problem1 {
    static final int VALUE = 9;
    public int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < VALUE; i++) {
            if (sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }

        }
        return min_index;
    }
    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < VALUE; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
    void adjacencyMatrix(int graph[][], int source) {
        int distance[] = new int[VALUE];
        Boolean sptSet[] = new Boolean[VALUE];
        for (int i = 0; i < VALUE; i++) {
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        distance[source] = 0;
        for (int count = 0; count < VALUE - 1; count++) {
            int j = minDistance(distance, sptSet);
            sptSet[j] = true;
            for (int i = 0; i < VALUE; i++){
                if (!sptSet[i] && graph[j][i] != 0 &&
                        distance[j] != Integer.MAX_VALUE &&
                        distance[j] + graph[j][i] < distance[i]){
                    distance[i] = distance[j] + graph[j][i];
                }

            }

        }
        printSolution(distance);
    }

    public static void main(String[] args) {

        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Problem1 p = new Problem1();
        p.adjacencyMatrix(graph, 0);

    }
}
