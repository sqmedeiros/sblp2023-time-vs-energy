import java.io.*;
import java.util.*;
import java.math.*; 
 
 
//import javafx.util.*; 
public class entry_3940528
{    
	static PrintWriter out = new PrintWriter(System.out);
	static FastReader in = new FastReader();	
	static int INF = Integer.MAX_VALUE;
    static int NINF = Integer.MIN_VALUE;
    static int mod = 1000000007;
    static int ans = 0;
	public static void main (String[] args) throws java.lang.Exception
    {
    	//check if you have to take product or the constraints are big
    	int n = i();
    	ArrayList<pair> arr = new ArrayList<>();
    	ArrayList<Integer> ep = new ArrayList<>();
    	for(int i = 0;i < n;i++){
    		int s = i();
    		int e = i();
    		int v = i();
    		arr.add(new pair(s,e,v));
    	}
    	Collections.sort(arr);
    	for(pair p : arr){
    		ep.add(p.y);
    	}
    	long[] dp = new long[n + 1];
    	for(int i = 1;i <= n;i++){
    		pair p = arr.get(i - 1);
    		long op1 = dp[i - 1];
    		long op2 = (long)p.z + dp[get_smaller(ep,p.x) + 1];
    		dp[i] = Math.max(op1,op2);
	    }	
    	long ans = dp[n];
    	out.println(ans);
    	out.close();
	}
	public static int get_smaller(ArrayList<Integer> arr, int index){
		int ans = -1;
		int l = 0;
		int r = arr.size() - 1;
		while(l <= r){
			int mid = (l + r)/2;
			int curr = arr.get(mid);
			if(curr < index){
				ans = mid;
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
		return ans;
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
 	int z;
	public pair(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
		return Integer.compare(this.y,other.y);
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