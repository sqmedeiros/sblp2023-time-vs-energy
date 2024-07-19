// Rohit Bohra | 14/05/2021 : 17:56:00
import java.io.*;
import java.util.*;
 
@SuppressWarnings("unchecked")
class entry_2147401 {
 
    public static void main(String args[])throws IOException{
        
        int n=sc.nextInt();
        int x=sc.nextInt();
 
        int[] coins = sc.readArray(n);
        // Arrays.sort(c);
 
        int max=M;
        int[] dp = new int[x+1];
        Arrays.fill(dp,max);
        dp[0]=0;
 
        // min coins
        // 
 
        for(int i=1;i<=x;i++){
            for(int c : coins){
                if(i-c>=0)
                dp[i] = Math.min(dp[i-c]+1,dp[i]);
            }
        }
        
 
        out.println(dp[x]==max ? -1 : dp[x]);
 
        out.close();
    }
    
 
    static int M=(int)Math.pow(10,9)+7;
 
    public static void sort(int[] arr,boolean reverse){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n =arr.length;
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }
 
        if(reverse)
        Collections.sort(list,Collections.reverseOrder());
        else
        Collections.sort(list);
 
        for(int i=0;i<n;i++){
            arr[i] = list.get(i);
        }
    }
 
    public static double min(double ...a){
        double min=Double.MAX_VALUE;
        for(double i : a)
        min =Math.min(i,min);
        return min;
    }
 
    public static long min(long ...a){
        long min=Long.MAX_VALUE;
        for(long i : a)
        min =Math.min(i,min);
        return min;
    }
 
    public static int min(int ...a){
        int min=Integer.MAX_VALUE;
        for(int i : a)
        min =Math.min(i,min);
        return min;
    }
 
    public static double max(double ...a){
        double max=Double.MIN_VALUE;
        for(double i : a)
        max =Math.max(i,max);
        return max;
    }
 
    public static long max(long ...a){
        long max=Long.MIN_VALUE;
        for(long i : a)
        max =Math.max(i,max);
        return max;
    }
 
    public static int max(int ...a){
        int max=Integer.MIN_VALUE;
        for(int i : a)
        max =Math.max(i,max);
        return max;
    }
    static class Pair{
 
        // Implementing equals() and hashCode()
        // Map<Pair, V> map = //...
 
        private final int x;
        private final int y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
 
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
 
    static FastScanner sc = new FastScanner();
    static PrintWriter out =new PrintWriter(System.out);
 
    static class FastScanner {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer("");
            String next() {
                while (!st.hasMoreTokens())
                    try {
                        st=new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return st.nextToken();
            }
            
            int nextInt() {
                return Integer.parseInt(next());
            }
            int[] readArray(int n) {
                int[] a=new int[n];
                for (int i=0; i<n; i++) a[i]=nextInt();
                return a;
            }
            long nextLong() {
                return Long.parseLong(next());
            }
            public long[] readLongArray(int n) {
                long[] a=new long[n];
                for (int i=0; i<n; i++) a[i]=nextLong();
                return a;
            }
    }
}