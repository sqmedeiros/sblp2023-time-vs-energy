import java.util.*;
import java.io.*;
import java.math.*;
import java.util.LinkedList;
public class entry_3005237
{
    // static class Pair{
    //     int i,j;
    //     String dir;
    //     Pair(int p,int q,String r)
    //     {
    //         i=p;
    //         j=q;
    //         dir=r;
    //     }
    // }
    
  
  static class Pair{
        long s,e,p;
        Pair(long _s,long _e,long _p)
        {
            s=_s;
            e=_e;
            p=_p;
        }
    }
    public static int bs(Pair arr[],int i)
    {
        int l=0,h=i-1;
        int ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(arr[mid].e<arr[i].s)
            {
              if(arr[mid+1].e < arr[i].s)
                l=mid+1;
            else
                return mid;
            }
            else
              h=mid-1;
        }
        return ans;
    }
   
  public static void process()throws IOException
  {
 
     int n=ni();
    Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new Pair(nl(),nl(),nl());
        }
        Arrays.sort(arr,(a,b)->Long.compare(a.e,b.e));
        long dp[]=new long[n];
        dp[0]=arr[0].p;
        
        for(int i=1;i<n;i++)
        {
            int j=bs(arr,i);
 
            if(j!=-1)
            dp[i]=Math.max(dp[j]+arr[i].p,dp[i-1]);
            else
            dp[i]=Math.max(arr[i].p,dp[i-1]);
          
        }
        pn(dp[n-1]);
 
  }
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;
 
           //PrintWriter out=new PrintWriter("output");
        //oj = System.getProperty("ONLINE_JUDGE") != null;
        //if(!oj) sc=new AnotherReader(100);
    
    // int T=ni(); while(T-->0)
     process();
 //   int i=1;
 //      int T=ni();
 // while(T-->0)
 //     {
 //      p("Case #"+i+": ");
 //            process();
 //            i++;
 //    }
        long s = System.currentTimeMillis();
      
        out.flush();
        if(!oj)
            System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }
    static void sort(long arr[],int n)
    {
    shuffle(arr,n);
    Arrays.sort(arr);
    }
    static void shuffle(long arr[],int n)
    {
        Random r=new Random();
        for(int i=0;i<n;i++)
        {
          long temp=arr[i];
          int pos=i+r.nextInt(n-i);
          arr[i]=arr[pos];
          arr[pos]=temp;
        }
    }
 
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static String nn()throws IOException{return sc.next();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static long bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static int[] iarr(int N)throws IOException{int[]ARR=new int[N];for(int i=0;i<N;i++){ARR[i]=ni();}return ARR;}
    static long[] larr(int N)throws IOException{long[]ARR=new long[N];for(int i=0;i<N;i++){ARR[i]=nl();}return ARR;}
    static boolean multipleTC=false;
            
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
 
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}