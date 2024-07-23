import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.TreeMap;
 
public class entry_5352689 {
    static int n;
    static int k;
    static Movie[] movies;
    static TreeMap<Integer, Integer> endings = new TreeMap<Integer, Integer>();
    static void add(int x){
        if(endings.containsKey(x)){
            endings.put(x, endings.get(x) + 1);
        } else {
            endings.put(x, 1);
        }
    }
 
    static void remove(int x){
        endings.put(x, endings.get(x) - 1);
        if(endings.get(x) == 0){
            endings.remove(x);
        }
    }
    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        n = io.nextInt();
        k = io.nextInt();
        movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Movie(io.nextInt(), io.nextInt());
        }
        Arrays.sort(movies, Comparator.comparingInt(a -> a.end));
 
        int moviesWatched = 0;
        endings.put(0, k);
        for (Movie movie: movies) {
            Integer remove = endings.floorKey(movie.start);
            if (remove != null) {
                remove(remove);
                add(movie.end);
                moviesWatched++;
            }
        }
        io.println(moviesWatched);
        io.close();
    }
 
    static class Movie{
        int start;
        int end;
        Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
 
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1<<16];
        private int curChar, numChars;
 
        // standard input
        public FastIO() { this(System.in,System.out); }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
 
        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }
 
        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c; do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }
        public int nextInt() { // nextLong() would be implemented similarly
            int c; do { c = nextByte(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10*res+c-'0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}