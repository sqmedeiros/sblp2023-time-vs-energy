/* package codechef; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class entry_2444369 {
	public static void main(String[] args) throws java.lang.Exception {
		FastReader in = new FastReader(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 1;
		//t = in.nextInt();
		while (t > 0) {
			--t;
          long n = in.nextLong();
          long ans = 0;
          int k = in.nextInt();
          long arr[] = new long[k];
          for(int i = 0;i<k;i++)
          {
        	  arr[i] = in.nextLong();
          }
          
          ans = permutation(arr,0,n,0);
          sb.append((ans)+"\n");
		}
		System.out.print(sb);
	}
    
	static long permutation(long arr[] , int ind ,long n,int k)
	{
             long ans = 0;		
		
			for(int i = ind;i<arr.length;i++)
			{
				long temp = (n/arr[i]);
				if(k%2 == 0)
				ans+=(temp);
				else 
				ans-=(temp);
				ans+=permutation(arr, i+1,temp, k+1);
			}
		return ans;
	}
	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		else
			return gcd(b % a, a);
	}
 
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}
 
	static void sort(long[] a) {
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}
}
 
class FastReader {
 
	byte[] buf = new byte[2048];
	int index, total;
	InputStream in;
 
	FastReader(InputStream is) {
		in = is;
	}
 
	int scan() throws IOException {
		if (index >= total) {
			index = 0;
			total = in.read(buf);
			if (total <= 0) {
				return -1;
			}
		}
		return buf[index++];
	}
 
	String next() throws IOException {
		int c;
		for (c = scan(); c <= 32; c = scan())
			;
		StringBuilder sb = new StringBuilder();
		for (; c > 32; c = scan()) {
			sb.append((char) c);
		}
		return sb.toString();
	}
 
	String nextLine() throws IOException {
		int c;
		for (c = scan(); c <= 32; c = scan())
			;
		StringBuilder sb = new StringBuilder();
		for (; c != 10 && c != 13; c = scan()) {
			sb.append((char) c);
		}
		return sb.toString();
	}
 
	char nextChar() throws IOException {
		int c;
		for (c = scan(); c <= 32; c = scan())
			;
		return (char) c;
	}
 
	int nextInt() throws IOException {
		int c, val = 0;
		for (c = scan(); c <= 32; c = scan())
			;
		boolean neg = c == '-';
		if (c == '-' || c == '+') {
			c = scan();
		}
		for (; c >= '0' && c <= '9'; c = scan()) {
			val = (val << 3) + (val << 1) + (c & 15);
		}
		return neg ? -val : val;
	}
 
	long nextLong() throws IOException {
		int c;
		long val = 0;
		for (c = scan(); c <= 32; c = scan())
			;
		boolean neg = c == '-';
		if (c == '-' || c == '+') {
			c = scan();
		}
		for (; c >= '0' && c <= '9'; c = scan()) {
			val = (val << 3) + (val << 1) + (c & 15);
		}
		return neg ? -val : val;
	}
}