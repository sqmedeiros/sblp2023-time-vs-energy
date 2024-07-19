import java.io.DataInputStream;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.lang.*;
 import java.io.*;
 
 /* Name of the class has to be "Main" only if the class is public. */
 public class entry_5869590
 {
     public static class Reader {
         final private int BUFFER_SIZE = 1 << 16;
         private DataInputStream din;
         private byte[] buffer;
         private int bufferPointer, bytesRead;
  
         public Reader()
         {
             din = new DataInputStream(System.in);
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }
  
         public Reader(String file_name) throws IOException
         {
             din = new DataInputStream(
                 new FileInputStream(file_name));
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }
  
         public String readLine() throws IOException
         {
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
  
         public int nextInt() throws IOException
         {
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
  
         public long nextLong() throws IOException
         {
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
  
         public double nextDouble() throws IOException
         {
             double ret = 0, div = 1;
             byte c = read();
             while (c <= ' ')
                 c = read();
             boolean neg = (c == '-');
             if (neg)
                 c = read();
  
             do {
                 ret = ret * 10 + c - '0';
             } while ((c = read()) >= '0' && c <= '9');
  
             if (c == '.') {
                 while ((c = read()) >= '0' && c <= '9') {
                     ret += (c - '0') / (div *= 10);
                 }
             }
  
             if (neg)
                 return -ret;
             return ret;
         }
  
         private void fillBuffer() throws IOException
         {
             bytesRead = din.read(buffer, bufferPointer = 0,
                                  BUFFER_SIZE);
             if (bytesRead == -1)
                 buffer[0] = -1;
         }
  
         private byte read() throws IOException
         {
             if (bufferPointer == bytesRead)
                 fillBuffer();
             return buffer[bufferPointer++];
         }
  
         public void close() throws IOException
         {
             if (din == null)
                 return;
             din.close();
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
                 if(st.hasMoreTokens()){ 
                     str = st.nextToken("\n"); 
                 } 
                 else{ 
                     str = br.readLine(); 
                 } 
             } 
             catch (IOException e) { 
                 e.printStackTrace(); 
             } 
             return str; 
         } 
     } 
     public static long gcd(long a,long b)
     {
         if(b==0)
         return a;
         return gcd(b,a%b);
     }
     public static void fill(int a[],Reader s,int n) throws java.lang.Exception
     {
         for(int i=0;i<n;i++)
         a[i]=s.nextInt();
     }
     public static void fill(double a[],Reader s,int n) throws java.lang.Exception
     {
         for(int i=0;i<n;i++)
         a[i]=s.nextDouble();
     }
     public static void fill(long a[],Reader s,int n) throws java.lang.Exception
     {
         for(int i=0;i<n;i++)
         a[i]=s.nextLong();
     }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
		//Reader s=new Reader();
		//Scanner s=new Scanner(System.in);
		FastReader s=new FastReader();
		StringBuilder sb=new StringBuilder();
		int n=s.nextInt();
        int x=s.nextInt();
        int pg[]=new int[n];
        int val[]=new int[n];
        int total=0;
        for(int i=0;i<n;i++)
        {
            val[i]=s.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            pg[i]=s.nextInt();
        }
        long dp[][]=new long[2][x+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=x;j++)
            {
                if(j-val[i-1]>=0)
                {
                    dp[1][j]=Math.max(dp[0][j],pg[i-1]+dp[0][j-val[i-1]]);
                }
                else
                dp[1][j]=dp[0][j];
            }
            for(int j=1;j<=x;j++)
            dp[0][j]=dp[1][j];
        }
        System.out.println(dp[1][x]);
    }
 }
 