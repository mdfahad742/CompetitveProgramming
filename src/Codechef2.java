import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.*;

class Codechef2 {
    static Scan sc = new Scan();
    static Print print = new Print();

    public static void main(String[] args) throws IOException {
        int t = sc.scanInt();
        while (t-- > 0) {
            int A = sc.scanInt();
            int B = sc.scanInt();
            int C = sc.scanInt();
            long c = 0, x = 1, y = -1;

            for (int i = 2; i <= A; i++) {
                for (int j = 1; j <= B; j++) {
                    long pos = ((j * j) / (i - 1)) + 2;
                    if (pos <= C)
                        c += (C % modL - pos % modL + 1) % modL;
                }
            }
            print.println(c % modL);
        }
        print.close();
    }

    static long modL = (long) 1e9 + 7;
    static int modI = (int) 1e9 + 7;
}


//class Scan {
//    private byte[] buf = new byte[1024];
//    private int index;
//    private InputStream in;
//    private int total;
//
//    public Scan() {
//        in = System.in;
//    }
//
//    public int scan() throws IOException {
//        if (total < 0)
//            throw new InputMismatchException();
//        if (index >= total) {
//            index = 0;
//            total = in.read(buf);
//            if (total <= 0)
//                return -1;
//        }
//        return buf[index++];
//    }
//
//    public int scanInt() throws IOException {
//        int integer = 0;
//        int n = scan();
//        while (isWhiteSpace(n))
//            n = scan();
//        int neg = 1;
//        if (n == '-') {
//            neg = -1;
//            n = scan();
//        }
//        while (!isWhiteSpace(n)) {
//            if (n >= '0' && n <= '9') {
//                integer *= 10;
//                integer += n - '0';
//                n = scan();
//            } else throw new InputMismatchException();
//        }
//        return neg * integer;
//    }
//
//    public long scanLong() throws IOException {
//        long integer = 0;
//        int n = scan();
//        while (isWhiteSpace(n))
//            n = scan();
//        int neg = 1;
//        if (n == '-') {
//            neg = -1;
//            n = scan();
//        }
//        while (!isWhiteSpace(n)) {
//            if (n >= '0' && n <= '9') {
//                integer *= 10;
//                integer += (long) (n - '0');
//                n = scan();
//            } else throw new InputMismatchException();
//        }
//        return neg * integer;
//    }
//
//    public double scanDouble() throws IOException {
//        double doub = 0;
//        int n = scan();
//        while (isWhiteSpace(n))
//            n = scan();
//        int neg = 1;
//        if (n == '-') {
//            neg = -1;
//            n = scan();
//        }
//        while (!isWhiteSpace(n) && n != '.') {
//            if (n >= '0' && n <= '9') {
//                doub *= 10;
//                doub += n - '0';
//                n = scan();
//            } else throw new InputMismatchException();
//        }
//        if (n == '.') {
//            n = scan();
//            double temp = 1;
//            while (!isWhiteSpace(n)) {
//                if (n >= '0' && n <= '9') {
//                    temp /= 10;
//                    doub += (n - '0') * temp;
//                    n = scan();
//                } else throw new InputMismatchException();
//            }
//        }
//        return doub * neg;
//    }
//
//    public String scanString() throws IOException {
//        StringBuilder sb = new StringBuilder();
//        int n = scan();
//        while (isWhiteSpace(n))
//            n = scan();
//        while (!isWhiteSpace(n)) {
//            sb.append((char) n);
//            n = scan();
//        }
//        return sb.toString();
//    }
//
//    private boolean isWhiteSpace(int n) {
//        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
//            return true;
//        return false;
//    }
//}
//
//class Print {
//    private final BufferedWriter bw;
//
//    public Print() {
//        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    }
//
//    public void print(Object object) throws IOException {
//        bw.append("" + object);
//    }
//
//    public void println(Object object) throws IOException {
//        print(object);
//        bw.append("\n");
//    }
//
//    public void close() throws IOException {
//        bw.close();
//    }
//}
