import java.util.*;
 
public class entry_3716656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
 
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
 
		int[] dp = new int[x + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int w = 0; w <= x; w++) {  
				if (w - coins[i] >= 0) { 
					dp[w] = (dp[w] + dp[w - coins[i]]) % 1000000007;
				}
			}
		}
		System.out.println(dp[x]);
	}
}
 
	
//	public static void main(String[] args) {
//		FastScanner sc = new FastScanner(System.in);
//		int n = sc.nextInt();
//		long[] dp = new long[1000001];
//		dp[0] = 1;
//		dp[1] = 1;
//		dp[2] = 2;
//		dp[3] = 4;
//		dp[4] = 8;
//		dp[5] = 16;
//		dp[6] = 32;
//		for(int i = 7; i < n + 1; i++) {
//			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4] + dp[i - 5] + dp[i - 6]) % 1000000007;
//		}
//		System.out.println(dp[n]);
//	}
//	/*
//	 *  FastScanner developed by Matt Fontaine
//	 */
//	public static class FastScanner{
//		   private InputStream stream;                                                                                         
//		   private byte[] buf = new byte[1024];                                                                                
//		   private int curChar;                                                                                                
//		   private int numChars;                                                                                               
//
//		   public FastScanner(InputStream stream)
//		   {
//		      this.stream = stream;                                                                                            
//		   }
//
//		   int read()
//		   {
//		      if (numChars == -1)
//		         throw new InputMismatchException();                                                                           
//		      if (curChar >= numChars){
//		         curChar = 0;                                                                                                  
//		         try{
//		            numChars = stream.read(buf);                                                                               
//		         } catch (IOException e) {
//		            throw new InputMismatchException();                                                                        
//		         }
//		         if (numChars <= 0)
//		            return -1;                                                                                                 
//		      }
//		      return buf[curChar++];                                                                                           
//		   }
//
//		   boolean isSpaceChar(int c)
//		   {
//		      return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;                                                                 
//		   }
//
//		   boolean isEndline(int c)
//		   {
//		      return c=='\n'||c=='\r'||c==-1;                                                                                  
//		   }
//
//		   int nextInt()
//		   {
//		      return Integer.parseInt(next());                                                                                 
//		   }
//
//		   long nextLong()
//		   {
//		      return Long.parseLong(next());                                                                                   
//		   }
//
//		   double nextDouble()
//		   {
//		      return Double.parseDouble(next());                                                                               
//		   }
//
//		   String next(){
//		      int c = read();                                                                                                  
//		      while (isSpaceChar(c))
//		         c = read();                                                                                                   
//		      StringBuilder res = new StringBuilder();                                                                         
//		      do{
//		         res.appendCodePoint(c);                                                                                       
//		         c = read();                                                                                                   
//		      }while(!isSpaceChar(c));                                                                                         
//		      return res.toString();                                                                                           
//		   }
//
//		   String nextLine(){
//		      int c = read();                                                                                                  
//		      while (isEndline(c))
//		         c = read();                                                                                                   
//		      StringBuilder res = new StringBuilder();                                                                         
//		      do{
//		         res.appendCodePoint(c);                                                                                       
//		         c = read();                                                                                                   
//		      }while(!isEndline(c));                                                                                           
//		      return res.toString();                                                                                           
//		   }
//	}
 