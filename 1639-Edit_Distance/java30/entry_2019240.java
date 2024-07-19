import java.util.*;
import java.math.*;
import java.io.*; 
 public class entry_2019240{
 
static FastReader scan=new FastReader();
 public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
  //static LinkedList<Integer>edges[];
  static LinkedList<Pair>edges[];
  static boolean stdin = true;
    static String filein = "input";
    static String fileout = "output";
static int dx[] = { -1, 0, 1, 0 };
static int dy[] = { 0, 1, 0, -1 };
int dx_8[]={1,1,1,0,0,-1,-1,-1};
int dy_8[]={-1,0,1,-1,1,-1,0,1};
static char sts[]={'U','R','D','L'};
static boolean prime[];
static long LCM(long a,long b){
    return (Math.abs(a*b))/gcd(a,b);
   }
    public static int upperBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = low+(high-low) / 2;
            if ( array[mid]>value) {
                high = mid ;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
   static long gcd(long a, long b) {
    if(a!=0&&b!=0)
        while((a%=b)!=0&&(b%=a)!=0);
    return a^b;
}
static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            if((n&1)!=1)
                count++;
            //count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
 static void sieve(long n) 
    { 
        
        prime = new boolean[(int)n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
           
            if(prime[p] == true) 
            { 
                
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
    }  
  
 
 
           static boolean isprime(long x)
           {
            for(long i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
                return true;
           }
           static int perm=0,FOR=0;
           
     
 
static boolean flag=false;
static int len=100000000;
 
static ArrayList<Pair>inters=new ArrayList<Pair>();
 
  
static class comp1 implements  Comparator<Pair>{  
public int compare(Pair o1,Pair o2){
return  Integer.compare((int)o2.x,(int)o1.x);
}
  }
  public static class comp2 implements Comparator<Pair>{  
public int compare(Pair o1,Pair o2){
return Integer.compare((int)o2.x,(int)o1.x); 
}
  }
  static StringBuilder a,b;
 
    static boolean isPowerOfTwo(int n)
{
    if(n==0)
    return false;
 
return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == 
       (int)(Math.floor(((Math.log(n) / Math.log(2)))));
}
static ArrayList<Integer>v;
static ArrayList<Integer>pows;
static void block(long x) 
{ 
   v = new ArrayList<Integer>(); 
      
    pows=new ArrayList<Integer>();
   
    while (x > 0)  
    { 
        v.add((int)x % 2); 
        x = x / 2; 
    } 
  
    // Displaying the output when 
    // the bit is '1' in binary 
    // equivalent of number. 
    for (int i = 0; i < v.size(); i++)  
    { 
        if (v.get(i)==1)  
        { 
      pows.add(i); 
        } 
    } 
 
} 
 
 
   static long ceil(long a,long b)
   {
    if(a%b==0)
        return a/b;
    return a/b+1;
   }
   static int n,m;
   static int arr[];
   static int dp[][]=new int[5001][5001];
   static String s1,s2;
static int rec(int i,int j)
{
  
   
   if(i==-1){
   return j+1;
   }
   if(j==-1)
    return i+1;
 
   
   
   if(dp[i][j]!=-1)
    return dp[i][j];
    if(s1.charAt(i)==s2.charAt(j))
    {
       // if(i+cnt1>j+cnt2)
        //{
             //out.println("FUCK");
            return dp[i][j]=rec(i-1,j-1);
        //}
        //else 
        //{
 
          //  return dp[i][j]=rec(i+1,j+1,cnt1-1,cnt2-1)+1;
       // }
    }
    else 
    {
       // if(i+cnt1>j+cnt2)
        //{
         //   out.println(i+" "+j);
            return dp[i][j]=Math.min(rec(i-1,j-1),Math.min(rec(i-1,j),rec(i,j-1)))+1;
        //}
       // else 
        //{*/
          //  return dp[i][j]=rec(i+1,j+1,cnt1-1,cnt2-1);
        //}
 
    }
 
 
}
public static void main(String[] args)  throws Exception 
{
//SUCK IT UP AND DO IT ALRIGHT
//scan=new FastReader("hps.in");
//out = new PrintWriter("hps.out");
   //System.out.println(countSetBits(2015));
    //int elem[]={1,2,3,4,5};
//System.out.println("avjsmlfpb".compareTo("avjsmbpfl"));
int tt=1;
/*for(int i=0;i<=100;i++)
    if(prime[i])
        arr.add(i);
    System.out.println(arr.size());*/
   // check(new StringBuilder("05:11"));
   // System.out.println(26010000000000L%150);
 
//tt=scan.nextInt();
  //  System.out.println(2^6^4);
    //StringBuilder o=new StringBuilder("GBGBGG");
    //o.insert(2,"L");
 
//System.out.println(gcd(99970002,99980000));
 
outer:while(tt-->0)
{
   
s1=scan.next();
s2=scan.next();
if(s2.length()>s1.length())
{
    String tmp=s1;
    s1=s2;
    s2=tmp;
}
for(int K[]:dp)
Arrays.fill(K,-1);
out.println(rec(s1.length()-1,s2.length()-1));
}
out.close();
 
//SEE UP 
 
}
static class special implements Comparable<special>{
    int x,y;
    String s;
    special(int x,String s,int y)
    {
        this.x=x;
        this.s=s;
        this.y=y;
    }
 
 @Override
        public boolean equals(Object o){
            if (o == this) return true;
            if (o.getClass() != getClass()) return false;
            special t = (special)o;
            return t.x == x && t.y == y&&t.s.equals(s);
        }
 
public int compareTo(special o)
{
    return Integer.compare(x,o.x);
}
}
static long binexp(long a,long n)
{
    if(n==0)
        return 1;
    long res=binexp(a,n/2);
    if(n%2==1)
        return res*res*a;
    else 
        return res*res;
}
 
static long powMod(long base, long exp, long mod) {
       if (base == 0 || base == 1) return base;
       if (exp == 0) return 1;
       if (exp == 1) return (base % mod+mod)%mod;
       long R = (powMod(base, exp/2, mod) % mod+mod)%mod;
       R *= R;
       R %= mod;
       if ((exp & 1) == 1) {
           return (base * R % mod+mod)%mod;
       }
       else return (R %mod+mod)%mod;
   }
static double dis(double x1,double y1,double x2,double y2)
{
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
static long mod(long x,long y)
    {
        if(x<0)
            x=x+(-x/y+1)*y;
        return x%y;
    }
 public static  long pow(long b, long e) {
            long r = 1;
            while (e > 0) {
                if (e % 2 == 1) r = r * b ;
                b = b * b;
                e >>= 1;
            }
            return r;
        }
private static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int object : arr) list.add(object);
        Collections.sort(list);
    //Collections.reverse(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
private static void sort2(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int object : arr) list.add(object);
        Collections.sort(list);
    Collections.reverse(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
 public static class FastReader {
        BufferedReader br;
        StringTokenizer root;
        
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String filename)throws Exception
        {
 
            br=new BufferedReader(new FileReader(filename));
        }
 
        boolean hasNext(){
            String line;
            while(root.hasMoreTokens())
                return true;
            return false;
        }
 
        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (Exception addd) {
                    addd.printStackTrace();
                }
            }
            return root.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception addd) {
                addd.printStackTrace();
            }
            return str;
        }
         public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];
 
            for (int i = 0; i < arraySize; i++) {
                array[i] = nextInt();
            }
 
            return array;
        }
}
 static class Pair implements Comparable<Pair>{
        public long x, y;
        public Pair(long x1, long y1) {
            x=x1;
            y=y1;
        }
        @Override
        public int hashCode() {
            return (int)(x + 31 * y);
        }
        public String toString() {
            return x + " " + y;
        }
        @Override
        public boolean equals(Object o){
            if (o == this) return true;
            if (o.getClass() != getClass()) return false;
            Pair t = (Pair)o;
            return t.x == x && t.y == y;
        }
public int compareTo(Pair o)
{
    return (int)(x-o.x);
 
    }
 
}
 static class tuple{
        int x,y,z;
        tuple(int a,int b,int c){
            x=a;
            y=b;
            z=c;
        }
    }
    static class Edge{
        int d,w;
        Edge(int d,int w)
        {
            this.d=d;
            this.w=w;
        }
    }
}
 
 