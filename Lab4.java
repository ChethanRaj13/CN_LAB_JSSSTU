import java.util.*;

class Edges{
    int u;
    int v;
    int cost;
    Edges(int u, int v, int cost){
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}

public class Lab4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int V = sc.nextInt();

        System.out.println("Enter the number of edges: ");
        int n = sc.nextInt();

        Edges[] edges = new Edges[n];

        for(int i = 0; i < n ; i++){
            System.out.println("Enter the edge"+i+1+" (u , v , cost)");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            edges[i] = new Edges(u,v,cost);
        }

        int[] dist = new int[V];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 0; i < V; i++){
            for(Edges e : edges){
                if(dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.cost < dist[e.v]){
                    dist[e.v] = dist[e.u] + e.cost;
                }
            }
        }
        for(Edges e : edges){
            if(dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.cost < dist[e.v]){
                System.out.println("the graph has negative cost");
                return;
            }
        }
        for(int i = 0; i < V; i++){
            System.out.println("0 -> " + i + ": " + dist[i]);
        }
    }
}
