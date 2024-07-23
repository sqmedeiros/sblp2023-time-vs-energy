import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class entry_1236498 implements AutoCloseable {
 
    public static void main(String[] args) {
        try (
                entry_1236498 movieFestivalII = new entry_1236498();//Initialize class element
        ) {
            movieFestivalII.solve();
        }
    }
 
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter output = new PrintWriter(System.out);
    StringTokenizer tokens;
 
    static final class Interval implements Comparable<Interval> {
        final int ini;
        final int end;
 
        public Interval(int ini, int end) {
            this.ini = ini;
            this.end = end;
        }
 
        @Override
        public int compareTo(Interval o) {
            if (o.end == end)
                return Integer.compare(ini, o.ini);
 
            return Integer.compare(end, o.end);
        }
    }
 
    Random random = new Random(123);
    private void swap(int ini, int end, Interval[] letters) {
        Interval tmp = letters[ini];
        letters[ini] = letters[end];
        letters[end] = tmp;
    }
 
    public int partition(int l, int h, Interval[] values) {
        int pivot = l + random.nextInt(h - l + 1);
        swap(l,  pivot, values);
        int ini = l;
        for (int i = ini+1; i <= h; i++) {
            if (values[i].compareTo(values[l]) < 0) {
                ini++;
                swap(ini, i, values);
            }
        }
 
        swap(ini, l, values);
        return ini;
    }
 
    public void quickSort(int ini, int end, Interval[] values) {
        if (ini >= end)
            return;
 
        int part = partition(ini, end, values);
 
        quickSort(ini, part-1, values);
        quickSort(part+1, end, values);
    }
 
    public void solve() {
        int n = nextInt();
        int k = nextInt();
 
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
 
            intervals[i] = new Interval(a, b);
        }
        quickSort(0, intervals.length - 1, intervals);
 
        int count = 0;
        TreeMap<Integer, Integer> multiSet = new TreeMap<>();
        multiSet.put(0, k);
        for (int i = 0; i < intervals.length; i++) {
            Integer pos = multiSet.floorKey(intervals[i].ini);
            if (pos != null) {
                count++;
                Integer value = multiSet.get(pos);
                if (value == 1)
                    multiSet.remove(pos);
                else {
                    multiSet.put(pos, value - 1);
                }
                multiSet.put(intervals[i].end,
                        multiSet.getOrDefault(intervals[i].end, 0) + 1);
            }
 
        }
        printLine(count);
    }
 
    public void print(Object n) {
        output.print(n);
    }
 
    public void printLine(Object n) {
        output.println(n);
    }
 
    public void close() {
        output.close();
    }
 
    private long nextLong() {
        String token = nextString();
        return Long.parseLong(token);
    }
 
    private int nextInt() {
        String token = nextString();
        return Integer.parseInt(token);
    }
 
 
    private String nextString() {
        while (tokens == null || !tokens.hasMoreTokens()) {
            getLineTokenizer();
        }
 
        return tokens.hasMoreTokens() ? tokens.nextToken() : null;
 
    }
 
    private boolean getLineTokenizer() {
        try {
            String line = reader.readLine();
 
            tokens = new StringTokenizer(line);
            return tokens.hasMoreTokens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
 
 
