import java.io.*;
import java.util.*;
import java.math.*; 
 
 
//import javafx.util.*; 
public class entry_3936952
{    
	static PrintWriter out = new PrintWriter(System.out);
	static FastReader in = new FastReader();	
	static int INF = Integer.MAX_VALUE;
    static int NINF = Integer.MIN_VALUE;
    static long mod = 1000000007;
	public static void main (String[] args) throws java.lang.Exception
    {
    	//check if you have to take product or the constraints are big
    	char[] a = in.nextLine().toCharArray();
    	char[] b = in.nextLine().toCharArray();
    	int n = a.length;
    	int m = b.length;
    	int[][] dp = new int[n + 1][m + 1];
    	for(int j = 0;j < m + 1;j++){
    		dp[0][j] = j;
    	}
    	for(int i = 0;i < n + 1;i++){
    		dp[i][0] = i;
    	}
    	for(int i = 1;i <= n;i++){
    		for(int j = 1;j <= m;j++){
    			if(a[i - 1] == b[j - 1]){
					dp[i][j] = dp[i - 1][j - 1];
					continue;
				}
				int replace = 1 + dp[i - 1][j - 1];
				int add = 1 + dp[i][j - 1];
				int delete = 1 + dp[i - 1][j];
				int ans = Math.min(Math.min(replace,add),delete);
				dp[i][j] = ans;
    		}
    	}
    	int ans = dp[n][m];
    	out.println(ans);
    	out.close();
	}
	public static int helper(int i, int j, char[] a, char[] b, int[][] dp){
		if(i < 0){
			return j + 1;
		}
		if(j < 0){
			return i + 1;
		}
		if(dp[i][j] != -1){
			return dp[i][j];
		}
		if(a[i] == b[j]){
			return helper(i - 1,j - 1,a,b,dp);
		}
		int replace = 1 + helper(i - 1,j - 1,a,b,dp);
		int add = 1 + helper(i,j - 1,a,b,dp);
		int delete = 1 + helper(i - 1,j,a,b,dp);
		int ans = Math.min(Math.min(replace,add),delete);
		return dp[i][j] = ans;
	}
	public static int min(int[] arr){
		int min = INF;
		int n = arr.length;
		for(int i = 0;i < n;i++){
			min = Math.min(min,arr[i]);
		}
		return min;
	}
   	public static void sort(int[] arr){
		ArrayList<Integer> ls = new ArrayList<>();
		for(int x : arr){
			ls.add(x);
		}
		Collections.sort(ls);
		for(int i = 0;i < arr.length;i++){
			arr[i] = ls.get(i);
		}
	}
	public static void reverse(int[] arr){
		int n = arr.length;
		for(int i = 0;i < n/2;i++){
			int temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
	}
	public static void sort(long[] arr){
		ArrayList<Long> ls = new ArrayList<>();
		for(long x : arr){
			ls.add(x);
		}
		Collections.sort(ls);
		for(int i = 0;i < arr.length;i++){
			arr[i] = ls.get(i);
		}
	}
	public static void reverse(long[] arr){
		int n = arr.length;
		for(int i = 0;i < n/2;i++){
			long temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
	}
	public static void print(int[] arr){
		int n = arr.length;
		for(int i = 0;i < n;i++){
			out.print(arr[i] + " ");
		}
		out.println();
	}
	public static void print(ArrayList<Integer> arr){
		int n = arr.size();
		for(int i = 0;i < n;i++){
			out.print(arr.get(i) + " ");
		}
		out.println();
	}
	static int i()
	{
		return in.nextInt();
	}
 
	static long l()
	{
		return in.nextLong();
	}
 
	static int[] input(int N){
		int A[]=new int[N];
		for(int i=0; i<N; i++)
		{
			A[i]=in.nextInt();
		}
		return A;
	}
 
	static long[] inputLong(int N){
		long A[]=new long[N];
		for(int i=0; i<A.length; i++)A[i]=in.nextLong();
		return A;
	}
}
class pair implements Comparable<pair> {
	int x;
	int y;
 
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
 
	public String toString() {
		return x + " " + y;
	}
 
	public boolean equals(Object o) {
		if (o instanceof pair) {
			pair p = (pair) o;
			return p.x == x && p.y == y;
		}
		return false;
	}
 
	// public int hashCode() {
	// 	    return new Integer(x).hashCode() * 31 + new Integer(y).hashCode();
	//  }
 
	public int compareTo(pair other) {
		if(this.x == other.x){
			return Integer.compare(other.y,this.y);
		}else{
			return Integer.compare(this.x,other.x);
		}
	}
}
class FastReader
{
	BufferedReader br;
	StringTokenizer st;
	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
 
	String next()
	{
		while(st==null || !st.hasMoreElements())
		{
			try
			{
				st=new StringTokenizer(br.readLine());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
 
	int nextInt()
	{
		return Integer.parseInt(next());
	}
 
	long nextLong()
	{
		return Long.parseLong(next());
	}
 
	double nextDouble()
	{
		return Double.parseDouble(next());
	}
 
	String nextLine()
	{
		String str="";
		try
		{
			str=br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return str;
	}
 
}
// in.nextLine().toCharArray();