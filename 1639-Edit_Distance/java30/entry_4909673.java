import java.io.*;
import java.util.*;
import java.lang.*;
 
public class entry_4909673 {
 
    static Uzi uzi;
    static int counter = 0;
//    static int[][] dp;
    static int[] dp;
//    static ArrayList<Integer> list;
    static int[] list;
    static int MOD = 1000000000 + 7;
    static int size = 0;
    static HashMap<Character, String> map;
//    static int[] arr, brr;
 
    public static void main(String[] args) throws IOException {
        FastReader fk = new FastReader();
        PrintWriter pr = new PrintWriter(System.out);
//        uzi = new Uzi();
 
//        int t = fk.nextInt();
        int t = 1;
 
        while (t-- > 0) {
            String s1 = fk.next(), s2 = fk.next();
            pr.println(fxn(s1, s2));
        }
 
 
        pr.close();
    }
 
    private static int fxn(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int [n1 + 1][n2 + 1];
 
        for(int i =0; i<dp.length; i++) {
            for(int j = 0; j<dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
 
        return dp[n1][n2];
    }
 
}
 
class Uzi {
    boolean[] primes;
    int N;
    long[] fact;
 
    public Uzi() {
    }
 
    public Uzi(int n) {
        this.N = n;
        this.primes = new boolean[N + 1];
        this.fact = new long[N + 1];
    }
 
    public int fast_exponentiation(int n, int b, int mod) {
        // Time complexity: O(logn), Space complexity: O(1)
        int res = 1;
        while (b > 0) {
            res = (res * (b % 2 == 1 ? n : 1)) % mod;
            n = (n * n) % mod;
            b >>= 1;
        }
        return res;
 
    }
 
    public void fact() {
        fact[0] = 1;
 
        for (int i = 1; i <= N; i++) {
            fact[i] = i * fact[i - 1];
        }
 
    }
 
    public long gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    public void seive() {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
 
        for (int i = 2; i * i <= N; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i)
                    primes[j] = false;
            }
        }
    }
 
    public int countDivisors(long num) {
        int counter = 0;
 
        for (int i = 1; i*i <= num ; i++) {
            if (num % i == 0)
                counter += (i * i == num) ? 1 : 2;
        }
        return counter;
    }
 
    public boolean binary_search(int[] arr, long key) {
        int s = 0, e = arr.length - 1, curr;
 
        while (s <= e) {
            curr = (s + e) / 2;
            if (arr[curr] == key)
                return true;
            else {
                if (arr[curr] > key)
                    e = curr - 1;
                else
                    s = curr + 1;
            }
        }
 
        return false;
    }
 
    private int elementJustGreater(int[] arr, int k) {
        // to find the first arr[i] >= k using binary search
 
        int s = 0, e = arr.length - 1, curr;
        int ans = -1;
 
        while (s <= e) {
            curr = (s + e) / 2;
            if (arr[curr] >= k) {
                ans = arr[curr];
                e = curr - 1;
            } else
                s = curr + 1;
        }
 
        return ans;
    }
 
    public int[] elementJustSmaller(int[] arr, long k) {
        // to find the first arr[i] <= k using binary search
        int s = 0, e = arr.length - 1, curr;
        int[] ans = {-1, 0};
 
        while (s <= e) {
            curr = (s + e) / 2;
            if (arr[curr] <= k) {               // should be less than or equal to
                //ans = arr[curr];
                if (arr[curr] == k)
                    ans = new int[]{curr, 0};
                else
                    ans = new int[]{curr, 1};
                s = curr + 1;
            } else
                e = curr - 1;
        }
        return ans;
    }
}
 
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
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