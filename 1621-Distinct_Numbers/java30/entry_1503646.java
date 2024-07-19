import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_1503646
{
    // static Scanner sc=new Scanner(System.in);
    static ArrayList<Integer> al;
    static HashMap<Long, Integer> map=new HashMap<>();
    static FastReader sc=new FastReader(); 
	public static void main (String[] args) throws java.lang.Exception
	{
        PrintWriter w=new PrintWriter(System.out);
//		int t=sc.nextInt();
//		while(t-->0){
		    int n=sc.nextInt();
		    for(int i=0;i<n;i++){
		        long x=sc.nextLong();
		        map.put(x,map.getOrDefault(x, 0)+1);
		    }
		    System.out.println(map.size());
//		}
		w.flush();
		w.close();
	}
    static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b); 
    }
	static int min(int a,int b){
	    return Math.min(a,b);
	}
	static int min3(int a,int b, int c){
	    return Math.min(Math.min(a,b),c);
	}
	static int max(int a,int b){
	    return Math.max(a,b);
	}
	static int max3(int a,int b, int c){
	    return Math.max(Math.max(a,b),c);
	}
	static void scan(int n,int[] a){
	    for(int i=0;i<n;i++){
	        a[i]=sc.nextInt();
	    }
	}
	static void print(int[] a){
	    int n=a.length;
	    for(int i=0;i<n;i++){
	        System.out.print(a[i]+" ");
	    }
	}
}
class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
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