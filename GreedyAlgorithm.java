import java.util.*;

public class GreedyAlgorithm {
    // Travel Cost Matrix 
    static int[][] costMatrix = {
        {0, 15, 25, 35},
        {15, 0, 30, 28},
        {25, 30, 0, 20},
        {35, 28, 20, 0}
    };

    // Location names
    static String[] locations = {
        "Hospital",
        "Emergency Location B",
        "Emergency Location C",
        "Emergency Location D"
    };
    
    // Greedy Route 
    public static String greedyEAROP(int[][] dist) {
        int n = dist.length;
        boolean[] visited = new boolean[n];
        visited[0] = true; 
        int current = 0;
        int totalCost = 0;
        StringBuilder path = new StringBuilder(locations[0]);

        for (int i = 0; i < n - 1; i++) {
            int nextNode = -1;
            int minCost = Integer.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[current][j] < minCost && dist[current][j] != 0) {
                    minCost = dist[current][j];
                    nextNode = j;
                }
            }
            visited[nextNode] = true;
            totalCost += minCost;
            current = nextNode;
            path.append(" -> ").append(locations[current]);
        }
        
        totalCost += dist[current][0]; // Return to Hospital
        path.append(" -> ").append(locations[0]).append(" | Total Cost: ").append(totalCost);
        return "Greedy Ambulance Route: " + path.toString();
    }

    // Driver Method
    public static void main(String[] args) {
        // Route Optimization Algorithms
        System.out.println(greedyEAROP(costMatrix));
    }
}