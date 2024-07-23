import java.util.*;
import java.io.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
class SegmentTree {
	int arr[];
	SegmentTree(int nums[]) {
		int n = nums.length;
		arr = new int[n*4];
		set(0,n-1,0,nums);
	}
	public int set(int l, int r, int index,int nums[]){
		if(l>r) return 0;
		if(l==r) {
			return arr[index] = nums[l];
		}
		int mid = l + (r-l)/2;
		return arr[index] = set(l,mid,index*2+1,nums) + set(mid+1,r,index*2+2,nums);
	}
	// inclusive
}
 
public class entry_3037942 {
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
	static Reader sc = new Reader();
	public static void main(String[] args)throws IOException {
		int t = 1;
		while(t-- >0) {
			solve();
		}
	}
	public static int  get(int index,int arr[]) {
		int ans = 0;
		while(index < arr.length) {
			ans += arr[index];
			index += index&(-index);
		}
		return ans;
	}
	public static void set(int index,int arr[]) {
		while(index > 0) {
			arr[index]++;
			index -= index&(-index);
		}
	}
	public static void solve()throws IOException  {
		int n = sc.nextInt(), x =sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0;i<n;i++) {
			set.add(sc.nextInt());
		}
		long dp[] = new long[x+1];
		long mod = (long)1e9+7;
		dp[0] = 1;
 
		for(int coin : set) {
			for(int i = 1;i<=x;i++) {
				if(i-coin>=0) {
					dp[i] +=dp[i-coin];
					if(dp[i]>=mod) dp[i]-=mod;
				}
			}
		}
		System.out.println(dp[x]);
 
	}
	public static long callfun(int num,long memo[]) {
		// System.out.println(num);
		if(num<0) return 0;
		if(num==0) return 1;
		long mod = (long)1e9+7;
		if(memo[num]!=-1) {
			return memo[num]%mod;	
		}
		
		long ans = 0;
		for(int i = 1;i<=6;i++) {
			ans  = (callfun(num-i,memo)%mod  + ans%mod)%mod;
		}
		return memo[num] = ans;
	}
	public static long getPossible(long time ,long arr[],long t) {
		long ans = 0,n = arr.length;
		for(int i =0;i<n;i++) {
			ans += time/arr[i];
			if(ans>=t) return ans;
		}
		return ans;
	}
	public static int last(int val ,int arr[]) { 
		int r = arr.length-1 , l = 0;
		int ans = -1;
		while(l<=r) {
			int mid = l + (r-l)/2;
			if(arr[mid]<=val) l = mid+1;
			else {
				ans = mid;
				r = mid  - 1;
			}
		}
		return ans;
	}
	
	public static int first(int val ,int arr[]) { 
		int r = arr.length-1 , l = 0;
		int ans = -1;
		while(l<=r) {
			int mid = l + (r-l)/2;
			if(arr[mid]>=val) r = mid-1;
			else {
				ans = mid;
				l = mid  + 1;
			}
		}
		return ans;
	}
	public static int[] readarr()throws IOException {
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0;i<n;i++) {
			arr[i] =  sc.nextInt();
		}
		return arr;
	}
 
	public static boolean isPowerOfTwo (long x) {
        return x!=0 && ((x&(x-1)) == 0);
    }
	public static boolean isPrime(long num) {
		if(num==1) return false;
		if(num<=3) return true;
		if(num%2==0||num%3==0) return false;
		for(long i =5;i*i<=num;i+=6) {
			if(num%i==0) return false;
		}
		return true;
	}
	public static boolean isPrime(int num) {
		if(num==1) return false;
		if(num<=3) return true;
		if(num%2==0||num%3==0) return false;
		for(int i =5;i*i<=num;i+=6) {
			if(num%i==0) return false;
		}
		return true;
	}
	public static int gcd(int a , int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	public static long gcd(long a , long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	public static long fac(long num)  {
		long ans = 1;
		int mod = (int)1e9+7;
		for(long i = 2;i<=num;i++) {
			ans  =  (ans*i)%mod;
		}
		return ans;
	}
}
 