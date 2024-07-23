/* package codechef; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet; 
 
/* Name of the class has to be "Main" only if the class is public. */
public class entry_2223240 {	
	static long dp[];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		FastReader sc = new FastReader();
	    PrintWriter out = new PrintWriter(System.out, true);
		int t=1;
		while(t-->0){		
			int n =sc.nextInt();
			int sum = sc.nextInt();
			int arr[] = new int[n];
			int dp[] = new int[sum+1];
			
			for(int i=0;i<n ;i++) arr[i] = sc.nextInt();
			dp[0]=1;
			
			for(int i=0;i<n;i++) {
				for(int j=arr[i];j<sum+1;j++) {
					dp[j] = (dp[j]+dp[j-arr[i]])%1000000007;
				}
			}
			System.out.println(dp[sum]);
		}
	}
		static class FastReader {
	    BufferedReader in;
	    StringTokenizer st;
	    
	    public FastReader() {
	        in = new BufferedReader(new InputStreamReader(System.in));
	    }
	    
	    String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(in.readLine());
	            }
	            catch (Exception IO) {
	                IO.printStackTrace();
	            }
	        }
	        
	        return st.nextToken();
	    }
	    
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    
	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    
	    Double nextDouble() {
	        return Double.parseDouble(next());
	    }
	    
	    String nextLine() {
	        String str = "";
	        try {
	            str = in.readLine();
	        } catch(Exception IO) {
	            IO.printStackTrace();
	        }
	        
	        return str;
	    }
	    
	    long[] nextLongArray(int size) {
	        long[] arr = new long[size];
	        
	        for (int i = 0; i < size; i++) {
	            arr[i] = this.nextLong();
	        }
	        
	        return arr;
	    }
	    
	    int[] nextIntegerArray(int size) {
	        int[] arr = new int[size];
	        
	        for (int i = 0; i < size; i++) {
	            arr[i] = this.nextInt();
	        }
	        
	        return arr;
	    }
	    
	    double[] nextDoubleArray(int size) {
	        double[] arr = new double[size];
	        
	        for (int i = 0; i < size; i++) {
	            arr[i] = this.nextDouble();
	        }
	        
	        return arr;
	    }
	    
	    void printArray(Object[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            System.out.println(arr[i] + " ");
	        }
	        System.out.println();
	    }
	}
}