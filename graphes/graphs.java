import java.util.*;



public class graphs{
    static class Edges{
        int src;
        int dest;
        int wt;

        public Edges(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;

        }

        @Override
        public String toString() {
            return "Edge from " + src + " to " + dest + " with weight " + wt;
        }
    }

    public static void main(String args[]){
        System.out.println("hello");
        ArrayList<Edges> graphes = new ArrayList<>();

        graphes.add(new Edges(0, 1, 5));
        for (Edges e : graphes) {
            System.out.println(e);
        }
    }
}




