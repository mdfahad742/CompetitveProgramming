import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution {

    public int[] solve(int A, int[] B, int[] C, int[] D) {
        Graph G = new Graph(A);
        for (int i = 0; i < A - 1; i++) {
            G.addEdge(B[i] - 1, C[i] - 1);
        }
        for (int i = 0; i < D.length; i++) {
            G.remove(B[D[i] - 1] - 1, B[D[i] - 1] - 1);
        }
        CC cc = new CC(G);
        int arr[] = cc.arr();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mp.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B[] = new int[A];
        int C[] = new int[A];
        for (int i = 0; i < A - 1; i++) {
            B[i] = sc.nextInt();
        }
        for (int i = 0; i < A - 1; i++) {
            C[i] = sc.nextInt();
        }
        int D[] = new int[A - 3];
        for (int i = 0; i < A - 3; i++) {
            D[i] = sc.nextInt();
        }
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solve(A, B, C, D)));
    }

    class CC {
        boolean marked[];
        int[] id;
        int count;
        CC(Graph G) {
            marked = new boolean[G.V];
            id = new int[G.V];
            for (int v = 0; v < G.V; v++) {
                if (!marked[v]) {
                    dfs(G, v);
                    count++;
                }
            }
        }
        void dfs(Graph G, int v) {
            marked[v] = true;
            id[v] = count;
            for (int w : G.adj(v)) {
                if (!marked[w])
                    dfs(G, w);
            }
        }
        int[] arr() {
            return id;
        }
    }
    class Graph {
        int V;
        LinkedHashSet<Integer> adj[];
        Graph(int V) {
            this.V = V;
            adj = new LinkedHashSet[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedHashSet<>();
            }
        }
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }
        void remove(int v, int w) {
            adj[w].remove(v);
            adj[v].remove(w);
        }
        Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }
}


