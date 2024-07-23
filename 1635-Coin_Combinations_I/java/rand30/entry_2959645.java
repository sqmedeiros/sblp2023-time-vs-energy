import java.io.*;
import java.util.*;
 
//import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
 
 
 
 
 public class entry_2959645 {
    public static long mod = (long)1e9+7;
    public static ArrayList<Integer>[] graph;
    public static void sort(int[] arr){
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        for(int u:arr) list.add(u);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    public static void sort(long[] arr){
        ArrayList<Long> list = new ArrayList<>(arr.length);
        for(long u:arr) list.add(u);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
        int t = 1;
       // t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(in,out);
        }
        out.close();
    }
//static int[] ftree;
public static void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    long[] dp = new long[x+1];
    int[] coins = in.readIntArray(n);
    Arrays.sort(coins);
    dp[0] = 1;
    for(int i = 1;i<dp.length;i++){
        dp[i] = 0;
        for (int j = 0; j < coins.length && i>=coins[j]; j++) {
            dp[i]  += dp[i-coins[j]];
            if(dp[i]>=mod) dp[i]-=mod;
        }
    }
    out.println(dp[x]);
}
 
private static long total(int[] list, long mid) {
    long ans = 0;
    long sum = 0;
    for (int i = 0; i < list.length; i++) {
        if(list[i]>mid){
            return Integer.MAX_VALUE;
        }
        else if(sum+list[i] <= mid) sum+=list[i];
        else{
            ans++;
            sum = list[i];
        }
    }
    return (ans+1);
}
private static long prod(long[] list,long mid) {
    long ans = 0;
    for(long k:list) ans += mid/k;
    return ans;
}
static boolean[] visited;
static TreeSet<String> all;
private static String ktimes(char c, int i) {
    StringBuilder str = new StringBuilder("");
    for (int j = 0; j < i; j++) {
        str.append(c);
    }
    return str.toString();
}
static class DSU{
    int[] parent;
    int[] weight;
    int maxweight = 1;
    int numc;
    public DSU(int n){
        numc = n;
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
           //min[i] = max[i] = i;
        }
    }
    public void union(int u, int v){
        int p = get(u);
        int q = get(v);
        if(p==q) return;
        if(weight[p]>=weight[q]){
            parent[q] = p;
            weight[p] += weight[q];
            maxweight = Math.max(maxweight, weight[p]);
        }
        else{
            parent[p] = q;
            weight[q] += weight[p];
            maxweight = Math.max(maxweight, weight[q]);
        }
        numc--;
    }
    public int get(int u){
        while(parent[u]!=u){
            u = parent[u];
        }
        return u;
    }
    
}
 
private static boolean valid(int i, int j) {
    return i>=0 && i<3 && j<3 && j>=0;
}
private static boolean valid(char[][] grid,boolean[][] visited, int i, int j) {
    return i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]!='#' && !visited[i][j];
}
   
}
 
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
 
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
 
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
 
    public int nextInt() {
        return Integer.parseInt(next());
    }
 
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble(){
        return Double.parseDouble(next());
    }
    public int[] readIntArray(int size){
        int[] list = new int[size];
        for(int i = 0;i<size;i++) list[i] = nextInt();
        return list;
    }
    public long[] readLongArray(int size){
        long[] list = new long[size];
        for(int i = 0;i<size;i++) list[i] = nextLong();
        return list;
    }
    public double[] readDoubleArray(int size){
        double[] list = new double[size];
        for(int i = 0;i<size;i++) list[i] = nextDouble();
        return list;
    }
    public String linereader() {
        String s = null;
        try{
            s = reader.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
 
}
class Pair<T extends Comparable<T>,K extends Comparable<K> > implements Comparable<Pair<T,K>>{
    T first;
    K second;
    public Pair(T first, K second){
        this.first  = first;
        this.second = second;
    }
    @Override
    public String toString(){
        return first+" "+second;
    }
    @Override
    public int compareTo(Pair<T,K> o) {
        // TODO Auto-generated method stub
        if((first).compareTo(o.first)!=0) return first.compareTo(o.first);
        else return second.compareTo(o.second);
    }
 
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 