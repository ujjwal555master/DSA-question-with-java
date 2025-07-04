import java.util.*;



public class connected{
    static class Edges{
        int src;
        int dest;
        int wt;

        public Edges(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;

        }
    }

    static void creategraph(ArrayList<Edges>[] graphes){
        for(int i=0; i<graphes.length; i++){
            graphes[i] = new ArrayList<>();
        }
        //create graphes
        // vertex 0
        graphes[0].add(new Edges(0, 1, 1));

        //vertex 1
        graphes[1].add(new Edges(1, 0, 1));
        graphes[1].add(new Edges(1, 2, 1));
        graphes[1].add(new Edges(1, 3, 1));

        //vertex 2 
        graphes[2].add(new Edges(2,1, 1));
        graphes[2].add(new Edges(2,3, 1));
        graphes[2].add(new Edges(2, 4, 1));

        //vertex 3
        graphes[3].add(new Edges(3, 2, 1));
        graphes[3].add(new Edges(3, 1, 1));

        //vertex 4
        graphes[4].add(new Edges(4, 2, 2));

        //vertex 5
        graphes[5].add(new Edges(5, 6, 1));

        //vertex 6
        graphes[6].add(new Edges(6, 5, 1));

    }

    public static void dfs(ArrayList<Edges>[] graph, int curr, boolean visited[]){
        visited[curr] = true;
        System.out.println(curr);

        for(int i=0; i<graph[curr].size(); i++){
            Edges e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    
    public static void main(String args[]){
        //System.out.println("hello");


        int V = 7;
        ArrayList<Edges> graphes[] = new ArrayList[V];
        creategraph(graphes);
        System.out.println("Node Visited by using dfs");
        boolean visited[] = new boolean[V];
        for(int i=0; i<graphes.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(graphes, i, visited);
            }
        }



    }
}




