import java.util.*;
import java.io.*;
public class entry_4072728 {
	// @formatter:off
	static long mod=(int)(1e9)+7;
//	public static void main(String[] args)throws Exception {
//		Scanner in = new Scanner(System.in);
//		int n=in.nextInt(),x=in.nextInt();
//		int[]a=new int[n];for(int i=0;i<n;i++) a[i]=in.nextInt();
//		long[]dp=new long[x+1];
//		dp[0]=1;
//		for(int i=0;i<=x;i++) {
//			for(int c:a) {
//				if(i+c<=x) {
//					dp[i+c]=(dp[i+c]+dp[i])%mod;
//				}
//			}
//		}
//		System.out.println(dp[x]);
//	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt(),x=in.nextInt();
		int[]a=new int[n];
		for(int i=0;i<n;i++) a[i]=in.nextInt();
		long[]dp=new long[x+1];
		dp[0]=1;
		for(int i=1;i<=x;i++) {
			for(int value:a) {
				if(value<=i) {
					dp[i]=(dp[i]+dp[i-value])%1000000007;
				}
			}
		}
		System.out.println(dp[x]);
		in.close();
	}
//	static int mx=(int)(1e6);
//	static long[]dp=new long[mx+1];
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int N=in.nextInt(), x=in.nextInt();
//		int []arr=new int[N];
//		for(int i=0;i<N;i++) arr[i]=in.nextInt();
//		dp[0]=1;
//		for(int i=1;i<=x;i++) {
//			for(int value:arr) {
//				if(value<=i) {
//					dp[i]=(dp[i]+dp[i-value])%1000000007;
//				}
//			}
//		}
//		System.out.println(dp[x]);
//		in.close();
//	}
}