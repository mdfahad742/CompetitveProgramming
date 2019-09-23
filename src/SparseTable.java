public class SparseTable {

    private final int[][] sparse;
    private final int n;
    private final int[] input;

    public SparseTable(int[] input) {
        this.input = input;
        this.n = input.length;
        this.sparse = preprocess(input, this.n);
    }

    private int[][] preprocess(int[] input, int n) {
        int[][] sparse = new int[n][log2(n) + 1];
        for (int i = 0; i < input.length; i++) {
            sparse[i][0] = input[i];
        }

        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
//                if (input[sparse[i][j - 1]] < input[sparse[i + (1 << (j - 1))][j - 1]]) {
//                    sparse[i][j] = sparse[i][j - 1];
//                } else {
//                    sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
//                }
                sparse[i][j] = gcd(sparse[i][j - 1], sparse[i + (1 << (j - 1))][j - 1]);
            }
        }
        return sparse;
    }
    public static int gcd(int a, int b) { if (b == 0) return a;return gcd(b, a % b); }

    public int rangeMinimumQuery(int low, int high) {
        int l = high - low + 1;
        int k = log2(l);
//        if (input[sparse[low][k]] <= input[sparse[low + l - (1<<k)][k]]) {
//            return input[sparse[low][k]];
//        } else {
//            return input[sparse[high - (1<<k) + 1][k]];
//        }
        return gcd(sparse[low][k], sparse[high - (1<<k) + 1][k]);
    }

    private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static void main(String args[]) {
        int[] input = {2, 4, 6, 8};
        SparseTable sparseTableRangeMinimumQuery = new SparseTable(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                System.out.println(i + " " + j);
                System.out.println(sparseTableRangeMinimumQuery.rangeMinimumQuery(i, j));
            }
            System.out.println();
        }
    }
}