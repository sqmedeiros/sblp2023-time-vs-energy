import java.io.*;
import java.util.*;
class entry_3490383 
{
	private static final long MOD = 1000000007;
	public static void main(String[] args) {
		FastReader fs = new FastReader();
		int no_of_coins = fs.nextInt();
		int x = fs.nextInt();
		int[] coins = new int[no_of_coins];
		for(int i=0;i<no_of_coins;i++){
			coins[i] = fs.nextInt();
		}
		/*
		Recursive solution
		//System.out.println(coinSum(coins,x));
		*/
 
		
		//DP Solution
		long[] DP = new long[x+1];
		DP[0] = 1;
		for(int i=1;i<=x;i++){
			for(int j=0;j<coins.length;j++){
				if(i-coins[j]<0) continue;
				DP[i]+=DP[i-coins[j]]%MOD;
			}
		}
		System.out.println(DP[x]%MOD);
 
		/*
		Memoization technique
		long[] cache = new long[x];
		Arrays.fill(cache, -1);
		System.out.println(coinSumMemoisation(coins, x, cache));
		*/
 
	}
	/*
	Recursion way of doing..
	*/
	private static long coinSum(int[] coins, int x){
		if(x<0) return 0;
		else if(x==0) return 1;
		else{
			long sum = 0;
			for(int j : coins)
				sum+=coinSum(coins,x-j)%MOD;
			return sum%MOD;
		}
	}
	/*
	Recursion way of doing..
	Introducing Memoization techniques
	Try to optimise the solution
	*/
	private static long coinSumMemoisation(int[] coins, int x, long[] cache){
		if(x<0) return 0;
		else if(x==0) return 1;
		else{
			if(cache[x-1]>-1) return cache[x-1]%MOD;
			int sum = 0;
			for(int j : coins)
				sum+=coinSumMemoisation(coins,x-j,cache)%MOD;
			cache[x-1] = sum;
			return cache[x-1];
		}
	}
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}