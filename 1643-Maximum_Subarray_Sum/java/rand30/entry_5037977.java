import java.util.*;
import java.io.*;
 
public class entry_5037977 {
 
	static Scanner in;
	static int n;
	static long a[], max=-1000000000l;
	
	public static void main(String[] args) {
 
		in = new Scanner(System.in);
		n = in.nextInt();
		
		a = new long[n+1];
 
		for(int i=1; i<=n; i++) {
			long num = in.nextLong();
			a[i] = Math.max(num+a[i-1], num);
			max = Math.max(a[i], max);
		}		
		
		System.out.println(max);
	}
}
