import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;

class Codechef {
    static Scan sc = new Scan();
    static Print print = new Print();

    public static void main(String[] args) throws IOException {
        int t = sc.scanInt();
        //int dp[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        while (t-- > 0) {
            int a = sc.scanInt();
            int b = sc.scanInt();
            int c = sc.scanInt();
            int ans = 1 * a + 2 * b + 3 * c;
            //print.println(ans);
            if (a == 0 && b == 0 && c == 0) {
                print.println("NO");
                continue;
            }
            if (ans % 2 != 0) {
                print.println("NO");
                continue;
            }
            else {
                int result = ans / 2;
                int ans1 = result / 3;
                //print.println("3 ans1 " + ans1);
                if (c > ans1) {
                    c -= ans1;
                    result -= 3 * ans1;
                }
                else {
                    result -= 3 * c;
                    c = 0;
                }
                //print.println("3 result " + result);
                if (result == 0) {
                    print.println("YES");
                    continue;
                }
                ans1 = result / 2;
                //print.println("2 ans1 " + ans1);
                if (b > ans1) {
                    b -= ans1;
                    result -= 2 * ans1;
                }
                else {
                    result -= 2 * b;
                    b = 0;
                }
                //print.println("2 result " + result);
                if (result == 0) {
                    print.println("YES");
                    continue;
                }
                ans1 = result / 1;
                //print.println("1 ans1 " + ans1);
                if (a > ans1) {
                    a -= ans1;
                    result -= 1 * ans1;
                }
                else {
                    result -= 1 * a;
                    a = 0;
                }
                //print.println("1 result " + result);
                if (result == 0) {
                    print.println("YES");
                    continue;
                }
                else  {
                    print.println("NO");
                    continue;
                }
            }
        }
        print.close();
    }

    public static int[] intArray(int n) throws IOException { int a[] = new int[n];for (int i = 0; i < n; i++) a[i] = sc.scanInt();return a; }
    public static long[] longArray(int n) throws IOException { long a[] = new long[n];for (int i = 0; i < n; i++) a[i] = sc.scanLong();return a; }
    public static ArrayList<Integer> intList(int n) throws IOException { ArrayList<Integer> a = new ArrayList<>();for (int i = 0; i < n; i++) a.add(sc.scanInt());return a; }
    public static ArrayList<Long> longList(int n) throws IOException { ArrayList<Long> a = new ArrayList<>();for (int i = 0; i < n; i++) a.add(sc.scanLong());return a; }
    public static void shuffle(int[] a) { int n = a.length;for (int i = 0; i < n; i++) { int r = (int) (Math.random() * (i + 1));int swap = a[r];a[r] = a[i];a[i] = swap; } }
    public static int gcd(int a, int b) { if (b == 0) return a;return gcd(b, a % b); }
    public static int findArrayGCD(int arr[], int n) { int result = arr[0];for (int i = 1; i < n; i++) result = gcd(arr[i], result);return result; }
    public static double logb(double a, double b) { return Math.log(a) / Math.log(b); }
    public static long power(long a, long N, long M) {
        if (N == 0) return 1;
        else {
            final long R = power(a, N / 2, M);
            if (N % 2 == 0) return (R * R) % M;
            else return (R * R * a) % M;
        }
    }
    public static int binomialCoeff(int n, int k) {
        int res = 1;
        // Since C(n, k) = C(n, n-k)
        if ( k > n - k )
            k = n - k;
        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    static long modL = (long) 1e9 + 7;
    static int modI = (int) 1e9 + 7;

    static class SparseTable {
        int[] logTable;
        int[][] rmq;
        int[] a;

        public SparseTable(int[] a) {
            this.a = a;
            int n = a.length;

            logTable = new int[n + 1];
            for (int i = 2; i <= n; i++)
                logTable[i] = logTable[i >> 1] + 1;

            rmq = new int[logTable[n] + 1][n];

            for (int i = 0; i < n; ++i)
                rmq[0][i] = i;

            for (int i = n - 1; i >= 0; i--) {
                rmq[0][i] = a[i];
                for (int j = 1; i + (1 << j) - 1 < n; j++) {
                    rmq[j][i] = gcd(rmq[j - 1][i], rmq[j - 1][i + (1 << (j - 1))]);
                }
            }
        }

        public int query(int i, int j) {
            int k = logTable[j - i];
            int x = rmq[k][i];
            int y = rmq[k][j - (1 << k) + 1];
            return gcd(x, y);
        }

    }

}


class Scan {
    private byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0)
            throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            } else throw new InputMismatchException();
        }
        return neg * integer;
    }

    public long scanLong() throws IOException {
        long integer = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += (long) (n - '0');
                n = scan();
            } else throw new InputMismatchException();
        }
        return neg * integer;
    }

    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub *= 10;
                doub += n - '0';
                n = scan();
            } else throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else throw new InputMismatchException();
            }
        }
        return doub * neg;
    }

    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = scan();
        }
        return sb.toString();
    }

    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
            return true;
        return false;
    }
}

class Print {
    private final BufferedWriter bw;

    public Print() {
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
        bw.append("" + object);
    }

    public void println(Object object) throws IOException {
        print(object);
        bw.append("\n");
    }

    public void close() throws IOException {
        bw.close();
    }
}