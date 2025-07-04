import java.util.*;

class Topologicalsort{
    //Create a class for edges
    static class Edge1{
        int src;
        int dest;
        public Edge1(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    //for creating graph using Edge
    static void creategraph1(ArrayList<Edge1> graphes1[]){
        //Initialize the value
        for(int i=0; i<graphes1.length; i++){
            graphes1[i] = new ArrayList<>();
        }
        
        //Adding some value
        graphes1[0].add(new Edge1(0, 3));

        graphes1[2].add(new Edge1(2, 3));

        graphes1[3].add(new Edge1(3, 1));

        graphes1[4].add(new Edge1(4, 1));
        graphes1[4].add(new Edge1(4, 0));

        graphes1[5].add(new Edge1(5, 0));
        graphes1[5].add(new Edge1(5, 2));
    }

    //Calculate indegree 
    public static void calindeg(ArrayList<Edge1>[] graph, int indeg[]){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge1 e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    //Topological sort
    public static void toposort(ArrayList<Edge1>[] graph){
        int indeg[] = new int[graph.length];
        calindeg(graph, indeg);
        Queue<Integer> qu = new LinkedList<>();

        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0){
                qu.add(i);
            }
        }

        while(!qu.isEmpty()){
            int v = qu.remove();
            System.out.println(v);
            for(int i=0; i<graph[v].size(); i++){
                Edge1 e = graph[v].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    qu.add(e.dest);
                }
            }
            
        }
    }

    public static void allpath(ArrayList<Edge1>[] graph, int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        for(int i=0; i<graph[src].size(); i++){
            Edge1 e = graph[src].get(i);
            allpath(graph, e.dest, dest, path+src);
        }
    }

    public static void main(String arg[]){
        int V = 6;
        ArrayList<Edge1> graphes1[] = new ArrayList[V];

        creategraph1(graphes1);
        //toposort(graphes1);
        int src=5;
        int dest=1;
        allpath(graphes1, src, dest, "");
    }
}