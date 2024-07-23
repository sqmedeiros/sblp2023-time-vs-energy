import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_4291313 {
    static int MOD=(int)1e9+7;
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    // static Scanner sc = new Scanner(System.in);
    static FastReader sc=new FastReader();
    // @Harshit Maurya 
    public static void reverse(int[] arr, int l, int r) {
        int d = (r - l + 1) / 2;
        for (int i = 0; i < d; i++) {
            int t = arr[l + i];
            arr[l + i] = arr[r - i];
            arr[r - i] = t;
        }
    }
    // QUICK MATHS
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
 
    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public static void main(String[] args) {
        // if (System.getProperty("ONLINE_JUDGE") == null) {
        //  try {
        //      System.setOut(new PrintStream(
        //                        new FileOutputStream("convention.out")));
        //      sc = new Scanner(new File("convention.in"));
        //  } catch (Exception e) {
        //  }
        // }
        solve();
    }
    // BIT MAGIC
    public int getMSB(int b) {
        return (int)(Math.log(b) / Math.log(2));
    }
    //HELPER FUNCTIONS
    private static int[] nextIntArray(int n){
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    private static ArrayList<Integer> nextIntList(int n){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        return list;
    }
     private static int[][] nextInt2DArray(int m,int n){
        int arr[][]=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        return arr;
    }
    private static long[] nextLongArray(int n){
        long arr[]=new long[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextLong();
        }
        return arr;
    }
    private static double[] nextDoubleArray(int n){
        double arr[]=new double[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextDouble();
        }
        return arr;
    }
    static int[] copy(int A[]) {
        int B[]=new int[A.length];
        for(int i=0;i<A.length;i++) {
            B[i]=A[i];
        }
        return B;
    }
    static long[] copy(long A[]) {
        long B[]=new long[A.length];
        for(int i=0;i<A.length;i++) {
            B[i]=A[i];
        }
        return B;
    }
    static long sum(int A[]) {
        long sum=0;
        for(int i : A) {
            sum+=i;
        }
        return sum;
    }
    static long sum(long A[]) {
        long sum=0;
        for(long i : A) {
            sum+=i;
        }
        return sum;
    }
    static void print(int A[]) {
        for(int i : A) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void print(long A[]) {
        for(long i : A) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
     private static int lower_bound_strict(long[] arr, long target)
    {   
        int start = 0, end = arr.length-1;
        if(end == 0) return -1;
        if (target > arr[end]) return end;
 
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
    static void solve() {
        int n=sc.nextInt();
        long task[][]=new long[n][3];
        long dp[]=new long[n+1];
        for(int i=0; i<n; i++){
            task[i][0]=sc.nextInt();
            task[i][1]=sc.nextInt();
            task[i][2]=sc.nextInt();
        }
        
        Arrays.sort(task,(o1,o2)->( Long.signum(o1[1]-o2[1])));
            long end_points[]=new long[n];
            for(int i=0; i<n; i++){
                end_points[i]=task[i][1];
            } 
            dp[0]=task[0][2];
            for(int idx=1; idx<n; idx++){
            //pick
            long pick=task[idx][2];
            int j=lower_bound_strict(end_points, task[idx][0]);
            if(j!=-1)
                pick+=dp[j];
 
            //not pick
            long notpick=dp[idx-1];
            dp[idx]=Math.max(pick, notpick);
         }
         System.out.println(dp[n-1]);
    }
}