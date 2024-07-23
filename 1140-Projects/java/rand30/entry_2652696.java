import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class entry_2652696 {
 
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
 
        int n = sc.nextInt();
 
        List<Job> jobs = new ArrayList<>();
 
        for(int i=0; i<n; i++) {
           Job job = new Job(sc.nextInt(), sc.nextInt(), sc.nextInt());
           jobs.add(job);
        }
 
        Collections.sort(jobs);
        long[] maxPrice = new long[n];
        maxPrice[0] = jobs.get(0).price;
        for (int i=1; i<n; i++) {
            Job job = jobs.get(i);
            int j = getPreviousJobIndex(job, jobs, i);
            long previousPrice = j > 0 ? maxPrice[j-1] : 0;
            maxPrice[i] = Math.max(maxPrice[i], Math.max(maxPrice[i-1], job.price + previousPrice));
        }
 
        System.out.println(maxPrice[n-1]);
 
    }
 
    private static int getPreviousJobIndex(Job job, List<Job> jobs, int last) {
        int start = 0;
        while (start < last) {
            int mid = ( start + last ) / 2;
            if (jobs.get(mid).end < job.start) {
                start = mid + 1;
            }
            else {
                last = mid;
            }
        }
        return start;
    }
 
    static class Job implements Comparable<Job> {
        int start;
        int end;
        int price;
        Job(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
 
 
        @Override
        public int compareTo(Job job) {
            return this.end - job.end;
        }
 
        @Override
        public String toString() {
            return "start: " + start +
                    ", end: " + end +
                    ", price: " + price;
        }
    }
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in), 32768);
            st = null;
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] intArray(int N) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = nextInt();
            return ret;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        long[] longArray(int N) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = nextLong();
            return ret;
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}