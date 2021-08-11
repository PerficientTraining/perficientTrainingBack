
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang

.*;
public class SalesByMatch {

    static long mod = 1000000007;
    static public HashMap<String, Integer> map = new HashMap<String, Integer>();
    static public HashMap<Integer, String> map1 = new HashMap<Integer, String>();

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.readInt();
        int a[] = new int[101];
        for (int i = 0; i < n; i++) {
            a[in.readInt()]++;
        }
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += (a[i]) / 2;
        }
        System.out.println(sum);
    }

    public static void printAllKLengthRec(char set[], String prefix, int n, int k, int a[][]) {

        // Base case: k is 0, print prefix
        if (k == 0) {
            String tar = prefix;
            int sum = 0;
            for (int i = 0; i < tar.length(); i++) {
                sum += a[i][tar.charAt(i) - 97];
            }
            System.out.println(sum);
            return;
        }

        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because we have added a new character
            printAllKLengthRec(set, newPrefix, n, k - 1, a);
        }
    }

    public static int BinarySearch(int x, int a[]) {
        int l = 0;
        int r = a.length - 1;
        int temp = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < x) {
                temp = mid;
                l = mid + 1;
            } else if (a[mid] > x) {
                r = mid - 1;
            } else if (a[mid] < x) {
                l = mid + 1;
            }

        }
        return temp;
    }

    public static long gcd(long x, long y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    public static int abs(int a, int b) {
        return (int) Math.abs(a - b);
    }

    public static long abs(long a, long b) {
        return (long) Math.abs(a - b);
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static long max(long a, long b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static long min(long a, long b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static long pow(long n, long p, long m) {
        long result = 1;
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return n;
        }
        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            if (result >= m) {
                result %= m;
            }
            p >>= 1;
            n *= n;
            if (n >= m) {
                n %= m;
            }
        }
        return result;
    }

    public static long pow(long n, long p) {
        long result = 1;
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return n;
        }
        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            p >>= 1;
            n *= n;
        }
        return result;

    }

    static class Pair implements Comparable<Pair> {

        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            if (this.a != o.a) {
                return Integer.compare(this.a, o.a);
            } else {
                return Integer.compare(this.b, o.b);
            }
            //return 0;
        }

        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return p.a == a && p.b == b;
            }
            return false;
        }

        public int hashCode() {
            return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
        }

    }

    static long sort(int a[]) {
        int n = a.length;
        int b[] = new int[n];
        return mergeSort(a, b, 0, n - 1);
    }

    static long mergeSort(int a[], int b[], long left, long right) {
        long c = 0;
        if (left < right) {
            long mid = left + (right - left) / 2;
            c = mergeSort(a, b, left, mid);
            c += mergeSort(a, b, mid + 1, right);
            c += merge(a, b, left, mid + 1, right);
        }
        return c;
    }

    static long merge(int a[], int b[], long left, long mid, long right) {
        long c = 0;
        int i = (int) left;
        int j = (int) mid;
        int k = (int) left;
        while (i <= (int) mid - 1 && j <= (int) right) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                c += mid - i;
            }
        }
        while (i <= (int) mid - 1) {
            b[k++] = a[i++];
        }
        while (j <= (int) right) {
            b[k++] = a[j++];
        }
        for (i = (int) left; i <= (int) right; i++) {
            a[i] = b[i];
        }
        return c;
    }

    public static int[] radixSort(int[] f) {
        int[] to = new int[f.length];
        {
            int[] b = new int[65537];
            for (int i = 0; i < f.length; i++) {
                b[1 + (f[i] & 0xffff)]++;
            }
            for (int i = 1; i <= 65536; i++) {
                b[i] += b[i - 1];
            }
            for (int i = 0; i < f.length; i++) {
                to[b[f[i] & 0xffff]++] = f[i];
            }
            int[] d = f;
            f = to;
            to = d;
        }
        {
            int[] b = new int[65537];
            for (int i = 0; i < f.length; i++) {
                b[1 + (f[i] >>> 16)]++;
            }
            for (int i = 1; i <= 65536; i++) {
                b[i] += b[i - 1];
            }
            for (int i = 0; i < f.length; i++) {
                to[b[f[i] >>> 16]++] = f[i];
            }
            int[] d = f;
            f = to;
            to = d;
        }
        return f;
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }
    }
}
