 
/*********CODE BY SHREY_SHREYANSH*********/
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class entry_846035 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
 
        long nextLong() {
            return Long.parseLong(next());
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
 
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt(), cnt = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        for (int i = 1; i <= N; i++)
            pq1.add(sc.nextInt());
        for (int i = 1; i <= M; i++)
            pq2.add(sc.nextInt());
        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            int n = pq1.poll();
            while (!pq2.isEmpty() && pq2.peek() < n - K)
                pq2.poll();
            if (!pq2.isEmpty() && pq2.peek() <= n + K) {
                cnt++;
                pq2.poll();
            }
        }
        System.out.println(cnt);
    }
}