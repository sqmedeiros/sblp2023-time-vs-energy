import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
 
public class entry_2355163 {
 
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = 1;
       // T=fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
        			int n = fs.nextInt();
        		long s=  fs.nextLong();
        		long arr[] = new long[n];
        		
        		for(int i=0;i<n;i++){
        			arr[i] =fs.nextLong();
        		
 
        		}
        			
					findFourElements(arr,n,s);
 
						
 
						}
						
        }
    
    static class pair {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
 
    // The function finds four elements
    // with given sum X
    static void findFourElements(long arr[], int n, long X)
    {
        // Store sums of all pairs in a hash table
        HashMap<Long, pair> mp
            = new HashMap<Long, pair>();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                mp.put(arr[i] + arr[j], new pair(i, j));
 
        // Traverse through all pairs and search
        // for X - (current pair sum).
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = arr[i] + arr[j];
 
                // If X - sum is present in hash table,
                if (mp.containsKey(X - sum)) {
 
                    // Making sure that all elements are
                    // distinct array elements and an
                    // element is not considered more than
                    // once.
                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j
                        && p.second != i && p.second != j) {
                 System.out.print((i+1) + " " + (j+1) + " "+ (p.first+1) + " " + (p.second+1));
                        return;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
 
}