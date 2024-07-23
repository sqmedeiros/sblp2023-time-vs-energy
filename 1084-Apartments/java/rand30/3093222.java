import java.util.*;
import java.io.*;
import static java.lang.System.out;
import java.util.Stack;
import java.util.Queue;
 
public class entry_3093222
{
 
    static int mod=(int)(1e9+7);
    static long MOD=(long)(1e9+7);
    static FastReader in=new FastReader();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
    public static void main(String args[])
    {  
 
        int tc=1;
     
       // tc=in.nextInt();
        tcloop: while(tc-->0)
        {
            
            int n=in.nextInt();
            int m = in.nextInt();
            long k = in.nextLong();
            long arr[] = in.readLongArray(n);
            long b[] = in.readLongArray(m);
            sort(arr);
            sort(b);
            int c=0;
            int i=0,j=0;
            while(i<n&&j<m){
 
                long lo =arr[i]-k;
                long hi = arr[i]+k;
             //   pr.println(lo+" "+hi+" "+b[j]);
                if(b[j]>=lo&&b[j]<=hi){
                    i++;
                    j++;
                    c++;
                }
                else if(b[j]>hi){
                    i++;
                }
                else{
                    j++;
                }
            }
            pr.println(c);
          
	
 
        }
        pr.flush();
        
    }
 
	static long gcd(long a,long b)
	{
		if(a==0)return b;
		return gcd(b%a,a);
	}
 
    static class Pair implements Comparable<Pair>
    {
        int a,b;
        Pair(int a,int b)
        {
            this.a=a;
            this.b=b;
 
        }
 
        @Override
        public int compareTo(Pair o)
        {
            return Integer.compare(a,o.a);
        }
    }
 
    
 
    static void sort(long[] a) {
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}
    
    
	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
    }
 
    
    static class FastReader
    { 
        BufferedReader br; 
        StringTokenizer st; 
 
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
 
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
 
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
 
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
 
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
        
        int[] readIntArray(int n)
        {
		int a[]=new int[n];
		for(int i=0;i<n;i++)a[i]=nextInt();
		return a;
	}
		
	long[] readLongArray(int n)
	{
		long a[]=new long[n];
		for(int i=0;i<n;i++)a[i]=nextLong();
		return a;
	}
	
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}
 
 
 