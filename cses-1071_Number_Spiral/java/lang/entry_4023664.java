import java.util.*;
import java.io.*;
 
class entry_4023664 {
 
  static PrintWriter out = new PrintWriter(System.out);
  static int mod = (int)1e9 + 7;
 
  public static void main(String[] args) {
    FastReader fs = new FastReader();
    
    
    int t = fs.nextInt();
    while(t-- > 0) {
        long x = fs.nextLong();
        long y = fs.nextLong();
 
        if(x < y) {
            if(y % 2 != 0) {
                long r = y * y;
                out.println(r - x + 1);
            } else {
                long r = (y - 1) * (y - 1) + 1;
                out.println(r + x - 1);
            }
        } else {
            if(x % 2 == 0) {
                long r = x * x;
                out.println(r - y + 1);
            } else {
                long r = (x - 1) * (x - 1) + 1;
                out.println(r + y - 1);
            }
        }
    }
 
 
    out.flush();
  }
 
 
// fast Reader for fast input and output
static class FastReader {
BufferedReader br;
StringTokenizer st;
 
public FastReader()
{br = new BufferedReader(new InputStreamReader(System.in));}
 
String next()
{ while (st == null || !st.hasMoreElements()) {
try {st = new StringTokenizer(br.readLine());}
catch (IOException e) {e.printStackTrace();}}
return st.nextToken();}
 
int nextInt() {return Integer.parseInt(next());}
 
long nextLong() {return Long.parseLong(next());}
 
double nextDouble(){return Double.parseDouble(next());}
 
String nextLine()
{ String str = "";
try {str = br.readLine();}
catch (IOException e) {e.printStackTrace();}
return str;
}
char nextChar() {
    return (next().charAt(0));
  }
}
}
