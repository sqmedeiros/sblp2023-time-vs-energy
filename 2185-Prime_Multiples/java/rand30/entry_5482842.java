/*
                       _oo0oo_
                      o8888888o
                      88" . "88
                      (| -_- |)
                      0\  =  /0
                    ___/`---'\___
                  .' \\|     |// '.
                 / \\|||  :  |||// \
                / _||||| -:- |||||- \
               |   | \\\  -  /// |   |
               | \_|  ''\---/''  |_/ |
               \  .-\__  '-'  ___/-. /
             ___'. .'  /--.--\  `. .'___
          ."" '<  `.___\_<|>_/___.' >' "".
         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
         \  \ `_.   \_ __\ /__ _/   .-` /  /
     =====`-.____`.___ \_____/___.-`___.-'=====
                       `=---='
 
*/
 
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.Math.*;
 
public class entry_5482842 {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.parseDouble(next());
		}
 
		float nextFloat() {
			return Float.parseFloat(next());
		}
 
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
 
	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
 
	}
 
	static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}
 
	public static class Pair implements Comparable<Pair> {
		public int index;
		public int value;
 
		public Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
 
		@Override
		public int compareTo(Pair other) {
			// multiplied to -1 as the author need descending sort order
			if (other.index < this.index) return 1;
			if (other.index > this.index) return -1;
			if(other.value < this.value) return -1;
			if(other.value > this.value) return 1;
			return 0;
		}
 
		@Override
		public String toString() {
			return this.index + " " + this.value;
		}
	}
 
	static int isPrime(long d) {
		if (d == 1)
			return -1;
		for (int i = 2; i <= (long) Math.sqrt(d); i++) {
			if (d % i == 0)
				return i;
		}
		return -1;
	}
 
	static boolean isPali(String n) {
		String s = n;
		int l = 0;
		int r = s.length() - 1;
		while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
		return true;
	}
 
	static void decimalTob(long n, int k, int arr[], int i) {
		arr[i] += (n % k);
		n /= k;
		if (n > 0) {
			decimalTob(n, k, arr, i + 1);
		}
	}
 
	static long powermod(long x, long y, long mod) {
		if (y == 0) return 1;
		long value = powermod(x, y / 2, mod);
		if (y % 2 == 0) return (value * value) % mod;
		return (value * (value * x) % mod) % mod;
	}
 
	static long power(long x, long y) {
		if (y == 0) return 1;
		long value = power(x, y / 2);
		if (y % 2 == 0) return (value * value);
		return value * value * x;
	}
 
	static int bS(int l, int r, int find, Integer arr[]) {
		int ans = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] >= find) {
				ans = mid;
				r = mid - 1;
			} else l = mid + 1;
		}
		return ans;
	}
 
	static void build(int index, int l, int r, int seqtree[], int arr[]) {
		if (l == r) {
			seqtree[index] = arr[l];
			return;
		}
		int mid = (l + r) / 2;
		build(2 * index + 1, l, mid, seqtree, arr);
		build(2 * index + 2, mid + 1, r, seqtree, arr);
		seqtree[index] = Math.max(seqtree[2 * index + 1], seqtree[2 * index + 2]);
	}
 
	static int query(int index, int low, int high, int l, int r, int seqtree[]) {
		if (high < l || low > r) return Integer.MIN_VALUE;
		if (l <= low && r >= high) {
			return seqtree[index];
		}
		int mid = (low + high) / 2;
		int left = query(2 * index + 1, low, mid, l, r, seqtree);
		int right = query(2 * index + 2, mid + 1, high, l, r, seqtree);
		return Math.max(left, right);
	}
 
	static class Trie {
		int arr[][] = new int[1124250 + 1][26];
		int index = 0;
		int current = 0;
		int ans = 0;
 
		public void insert(int z) {
			if (arr[current][z] == 0) {
				arr[current][z] = ++index;
				ans++;
			}
			current = arr[current][z];
		}
 
		public void clear() {
			current = 0;
		}
	}
 
	static int greater(int l, int r, long z, ArrayList<Integer> arr) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr.get(mid) > z) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
 
	static int lesser(int l, int r, long z, ArrayList<Integer> arr) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr.get(mid) < z) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l - 1;
	}
	static boolean check(int mid,  int arr[]){
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] % mid == 0) count++;
		}
		return count >= 2;
	}
	public static void main(String[] args) throws Exception {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = 1;
		outerloop:
		while (t-- > 0) {
			long n = sc.nextLong();
			int k = sc.nextInt();
			long arr[] = new long[k];
			for(int i = 0; i < k; i++) arr[i] = sc.nextLong();
			ArrayList<Long> ss = new ArrayList<>();
			long ans = 0;
			for(int i = 0; i < k; i++){
				ans += n / arr[i];
				for(long e: ss){
					if(n / Math.abs(e) >= arr[i]){
						ans += n / (-e*arr[i]);
					}
				}
				int z = ss.size();
				for(int j = 0; j < z; j++){
					if(n / Math.abs(ss.get(j)) >= arr[i]){
						ss.add(-1 * ss.get(j) * arr[i]);
					}
				}
				ss.add(arr[i]);
			}
//			  out.println(ss);
			out.println(ans);
		}
 
		out.close();
	}
}