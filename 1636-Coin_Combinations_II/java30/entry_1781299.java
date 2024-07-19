import java.util.*;
import java.io.*;
 
public class entry_1781299 {
 
	static int mod=(int)1e9+7;
	
	static void solve(Reader in, PrintWriter out){
		int n=in.nextInt();
		int x=in.nextInt();
		int c[]=in.readArray(n);
		int dp[]=new int[x+1];
		dp[0]=1;
		for(int i: c) {
			for(int j=i; j<=x; ++j) {
				dp[j]+=dp[j-i];
				dp[j]%=mod;
			}
		}
		out.println(dp[x]);
	}
	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Reader in=new Reader(System.in);	
		int ts=1;
//		ts=in.nextInt();
		while(ts-->0) solve(in, out);
		out.close();
	}
	
	static void sort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i: a) al.add(i);
		Collections.sort(al);
		for(int i=0; i<a.length; ++i) a[i]=al.get(i);
	}
	
	static class Reader{
		
		BufferedReader br;
		StringTokenizer to;
		
		Reader(InputStream stream){
			br=new BufferedReader(new InputStreamReader(stream));
			to=new StringTokenizer("");
		}
		String nextLine() {
			String line="";
			try {
				line=br.readLine();
			}catch(IOException e) {};
			return line;
		}
		String next() {
			while(!to.hasMoreTokens()) {
				try {
					to=new StringTokenizer(br.readLine());	
				}catch(IOException e) {}
			}
			return to.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		int [] readArray(int n) {
			int a[]=new int[n];
			for(int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long [] readLongArray(int n) {
			long [] a =new long[n];
			for(int i=0; i<n; ++i) a[i]=nextLong();
			return a;
		}
	}	
	
}