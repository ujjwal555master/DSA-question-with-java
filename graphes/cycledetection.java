import java.util.*;
public class cycledetection{

    static class Edge1{
        int src;
        int dest;
        public Edge1(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void creategraph1(ArrayList<Edge1> graphes1[]){
        for(int i=0; i<graphes1.length; i++){
            graphes1[i] = new ArrayList<>();
        }
        // //vertex 0
        // graphes1[0].add(new Edge1(0, 1));
        // graphes1[0].add(new Edge1(0, 2));

        // //vertex 1
        // graphes1[1].add(new Edge1(1, 0));
        // graphes1[1].add(new Edge1(1, 3));

        // //vertex 2
        // graphes1[2].add(new Edge1(2, 0));
        // graphes1[2].add(new Edge1(2, 4));

        // //vertex 3
        // graphes1[3].add(new Edge1(3, 1));
        // graphes1[3].add(new Edge1(3, 5));
        // //graphes1[3].add(new Edge1(3, 4));

        // //vertex 4
        // graphes1[4].add(new Edge1(4, 2));
        // //graphes1[4].add(new Edge1(4, 3));
        // graphes1[4].add(new Edge1(4, 5));

        // //vertex 5
        // graphes1[5].add(new Edge1(5, 3));
        // graphes1[5].add(new Edge1(5, 4));
        // graphes1[5].add(new Edge1(5, 6));

        // //vertex 6
        // graphes1[6].add(new Edge1(6, 5));

        graphes1[0].add(new Edge1(0, 1));
        graphes1[0].add(new Edge1(0, 2));
        graphes1[1].add(new Edge1(1, 3));
        graphes1[2].add(new Edge1(2, 3));
    }


    //Breadth first search utility function
    public static void bfsutil(ArrayList<Edge1> graphes1[], boolean vis[], int src){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(src);

        while(!qu.isEmpty()){
            int curr = qu.remove();
            if(!vis[curr]){
                vis[curr] = true;
                System.out.print(curr);
                for(int i=0; i<graphes1[curr].size(); i++){
                    Edge1 e = graphes1[curr].get(i);
                    qu.add(e.dest);
                }
            }
            
        }
    }

    //Breadth first search
    public static void bfs(ArrayList<Edge1>[] graphes1){
        boolean vis[] = new boolean[graphes1.length];

        for(int i=0; i<graphes1.length; i++){
            if(!vis[i]){
                bfsutil(graphes1, vis, i);
            }
        }

    }
    //df util function 
    public static void dfsutil(ArrayList<Edge1>[] graphes1, boolean vis[], int src){
            vis[src] = true;
            System.out.print(src);
            for(int i=0; i<graphes1[src].size(); i++){
                Edge1 e = graphes1[src].get(i);
                if(!vis[e.dest]){
                    dfsutil(graphes1, vis, e.dest);
                }
            }
    }

    public static void dfs(ArrayList<Edge1>[] graphes1){
        boolean vis[] = new boolean[graphes1.length];
        for(int i=0; i<graphes1.length; i++){
            if(!vis[i]){
                dfsutil(graphes1, vis, i);
            }
        }
    }
    public static boolean cycleutil(ArrayList<Edge1>[] graphes1, boolean vis[], int parent, int src){
        
        vis[src] = true;
        for(int i=0; i<graphes1[src].size(); i++){
            Edge1 e = graphes1[src].get(i);
            //case 1
            if(!vis[e.dest]){
                if(cycleutil(graphes1, vis, src, e.dest)){
                    return true;
                }
            }
            //case 2
            else if(vis[e.dest] && e.dest!= parent){
                return true;
            }
        }
        return false;
    }

    //chech the graph is bipartite or not
    public static boolean isBipartite(ArrayList<Edge1>[] graphes){
        int vis[] = new int[graphes.length];
        for(int i=0;i<graphes.length; i++){
            vis[i] = -1;
        }
        Queue<Integer> qu = new LinkedList<>();

        for(int i=0; i<graphes.length; i++){
            if(vis[i]==-1){
                qu.add(i);
                vis[i] = 0;

                while(!qu.isEmpty()){
                    int curr = qu.remove();
                    for(int j=0; j<graphes[curr].size(); j++){
                        Edge1 e = graphes[curr].get(j);
                        if(vis[e.dest] == -1){
                            int color = vis[curr]==0 ? 1 : 0;
                            vis[e.dest] = color;
                            qu.add(e.dest);
                        }else if(vis[e.dest]==vis[curr]){
                            return false;
                        }
                    }
                }

                
            }
        }
        return true;
    }

    public static boolean cycle(ArrayList<Edge1>[] graphes1){
        boolean vis[] = new boolean[graphes1.length];
        for(int i=0; i<graphes1.length; i++){
            if(!vis[i]){
                if(cycleutil(graphes1, vis, -1, i)){
                    return true;
                }
            }
        }
        return false;
    }

    //For directed graph check cycle exist not
    public static boolean isCycle(ArrayList<Edge1>[] graphes){
        boolean vis[] = new boolean[graphes.length];
        boolean stack[] = new boolean[graphes.length];

        for(int i=0; i<graphes.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graphes, vis, stack, i)){
                    return true;
                }
            }
        }
        return false;

    }

    //create the code of graphes util
    public static boolean isCycleUtil(ArrayList<Edge1>[] graphes, boolean vis[], boolean stack[], int curr){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graphes[curr].size(); i++){
            Edge1 e = graphes[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleUtil(graphes, vis, stack, e.dest)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void orderutil(ArrayList<Edge1>[] graph, Stack<Integer> st, boolean vis[], int curr){
        vis[curr] = true;
        st.push(curr);
        for(int i=0; i<graph[curr].size(); i++){
            Edge1 e = graph[curr].get(i);
            if(!vis[e.dest]){
                orderutil(graph, st, vis, e.dest);
            }
        }
    }


    //topological graph :- print the item based on the dependencies
    public static void order(ArrayList<Edge1>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        // Start the loop of the graph
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                orderutil(graph, st, vis, i);
            }
        }

        while(!st.isEmpty()){
            int val = st.pop();
            System.out.println(val);
        }
    }

    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge1> graphes1[] = new ArrayList[V];
        creategraph1(graphes1);
        //System.out.println("breadth first Search");
        //bfs(graphes1);
        //System.out.println("Depth first search");
        //dfs(graphes1);
        //System.out.println(cycle(graphes1));

        //System.out.println(isBipartite(graphes1));
        System.out.println(isCycle(graphes1));
        order(graphes1);

    }
}