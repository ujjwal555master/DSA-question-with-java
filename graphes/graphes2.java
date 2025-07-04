import java.util.*;



public class graphes2{
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
        graphes[0].add(new Edges(0, 1, 5));

        //vertex 1
        graphes[1].add(new Edges(1, 0, 5));
        graphes[1].add(new Edges(1, 2, 1));
        graphes[1].add(new Edges(1, 3, 3));

        //vertex 2 
        graphes[2].add(new Edges(2,1, 1));
        graphes[2].add(new Edges(2, 4, 2));

        //vertex 3
        graphes[3].add(new Edges(3, 2, 1));
        graphes[3].add(new Edges(3, 1, 3));

        //vertex 4
        graphes[4].add(new Edges(4, 2, 2));

    }

    public static void bfstraversal(ArrayList<Edges>[] graphes){
        Queue<Integer> q1 = new LinkedList<>();
        boolean visited[] = new boolean[graphes.length];

        q1.add(0);

        while(!q1.isEmpty()){
            int curr = q1.remove();
            if(!visited[curr]){
                System.out.println(curr);
                visited[curr] = true;
                for(int i=0; i<graphes[curr].size(); i++){
                    Edges e = graphes[curr].get(i);
                    q1.add(e.dest);
                }
            }
        }
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

    public static boolean haspath(ArrayList<Edges>[] graph, int src, int dest, boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edges e = graph[src].get(i);
            if(!vis[e.dest] && haspath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        //System.out.println("hello");


        int V = 5;
        ArrayList<Edges> graphes[] = new ArrayList[V];
        creategraph(graphes);
        bfstraversal(graphes);
        System.out.println("Node Visited by using dfs");
        dfs(graphes, 0, new boolean[V]);
        System.out.println(haspath(graphes, 0, 10, new boolean[V]));



    }
}




