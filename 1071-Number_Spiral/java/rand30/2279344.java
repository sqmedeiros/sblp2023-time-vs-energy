import java.io.*;
import java.util.*;
 
class entry_2279344 {
    public static void main(String[] args) {
        try {
            FastScanner scn = new FastScanner();
 
            long tc = scn.nextLong();
            StringBuilder ans = new StringBuilder();
            while (tc-- > 0) {
                long x = scn.nextLong(), y = scn.nextLong();
 
                if (x < y) {
                    if (y % 2 == 0) {
                        long val = (y - 1) * (y - 1) + 1;
                        ans.append(val + (x - 1)).append('\n');
                    } else {
                        long val = (y) * (y);
                        ans.append(val - (x - 1)).append('\n');
 
                    }
                }else{
                    if (x % 2 == 1) {
                        long val = (x - 1) * (x - 1) + 1;
                        ans.append(val + (y - 1)).append('\n');
                    } else {
                        long val = (x) * (x);
                        ans.append(val - (y - 1)).append('\n');
 
                    }
                }
            }
            System.out.println(ans);
 
        } catch (Exception e) {
            return;
        }
    }
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}