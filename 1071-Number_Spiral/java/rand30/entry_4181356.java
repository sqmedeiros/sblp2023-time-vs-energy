import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_4181356 {
public static void main (String[] args) {  		
	  int t=sc.nextInt();
	  while(t-->0) {
	    long x=sc.nextLong();long y=sc.nextLong();
	    if (x < y)
        {
            if (y % 2 == 1)
            {
                long r = y * y;
                 out.println(r - x + 1); 
            }
            else
            {
                long r = (y - 1) * (y - 1) + 1;
               out.println(r +x - 1);
            }
        }
        else
        {
            if (x % 2 == 0)
            {
                long r = x * x;
               out.println(r-y+1);
            }
            else
            {
                long r = (x - 1) * (x - 1) + 1;
                out.println(r+y-1);
            }
        }
	  }		
////////////////////////////////////////////////////////////////////  	
out.flush();out.close();
}//*END OF MAIN METHOD*
static final Random random = new Random();
static class FastScanner {
public long[][] readArrayL;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st=new StringTokenizer("");
String next() {
while (!st.hasMoreTokens())
try {
st=new StringTokenizer(br.readLine());
} catch (IOException e) {e.printStackTrace();
}
return st.nextToken();
}
int nextInt() {
return Integer.parseInt(next());
}
long[] readArrayL(int n) {
long a[]=new long[n];
for(int i=0;i<n;i++) a[i]=nextLong();
return a;
}
int[] readArray(int n) {
int[] a=new int[n];
for (int i=0; i<n; i++) a[i]=nextInt();
return a;
}
long nextLong() {
return Long.parseLong(next());
}
double nextDouble() {
return Double.parseDouble(next());
}
}
static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
static FastScanner sc = new FastScanner();
}//*END OF MAIN CLASS*
 
 
 
 
 
 
 