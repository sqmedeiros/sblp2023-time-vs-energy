import java.util.*;
import java.io.*;
 
class entry_3681096 {
 
  static PrintWriter out = new PrintWriter(System.out);
  static int mod = (int)1e9 + 7;
  static int N = (int) 1e6 + 3;
 
  public static void main(String[] args) {
    FastReader fs = new FastReader();
    int n = fs.nextInt();
    int amt = fs.nextInt();
    int[] cost = new int[n];
    int[] page = new int[n];
 
    for(int i = 0; i < n; i++) {
    	cost[i] = fs.nextInt();
    }
    for(int i = 0; i < n; i++) {
    	page[i] = fs.nextInt();
    }
 
    int[][] dp = new int[n+1][amt+1];
    for(int i = 0; i <= amt; i++) {
    	dp[0][i] = 0;
    }
    for(int i = 0; i <= n; i++) {
    	dp[i][0] = 0;
    }
    for(int i = 1; i <= n; i++) {
    	for(int j = 1; j <= amt; j++) {
    		if(cost[i-1] <= j) {
    			dp[i][j] = Math.max((page[i-1] + dp[i-1][j-cost[i-1]]), dp[i-1][j]);
    		}else {
    			dp[i][j] = dp[i-1][j];
    		}
    	}
    }
 
    out.println(dp[n][amt]);
    out.flush();
  }
 
  static int knapSack(int[] cost, int[] page, int Total, int n, int[][] t) {
  	if(n == 0 || Total == 0) {
  		return 0;
  	}
  	if(t[n][Total] != -1) {
  		return t[n][Total];
  	}
  	if(Total >= cost[n-1]) {
  		return t[n][Total] = Math.max(page[n-1] + knapSack(cost, page, Total - cost[n-1], n-1, t), knapSack(cost, page, Total, n-1, t));
  	} else {
  		return t[n][Total] = knapSack(cost, page, Total, n-1, t);
  	}
  }
 
  static void print2D(int[][] arr, int n, int m) {
  	for(int i = 0; i <= n; i++) {
  		for(int j = 0; j <= m; j++) {
  			out.print(arr[i][j] + " ");
  		}
  		out.println();
  	}
  }
  static int maxDigit(int n) {
  	String s = n + "";
  	int max = Integer.MIN_VALUE;
  	for(int i = 0; i < s.length(); i++) {
  		max = Math.max(max, Integer.parseInt(s.charAt(i) + ""));
  	}
 
  	return max;
  }
 
  static void shiftArr(int[] a, int index) {
     int temp = a[index];
     for(int i = index; i > 0; i--) {
        a[i] = a[i-1];
     }
     a[0] = temp;
  }
 
  static void reverse(int[] a, int index) {
    int i = index, j = a.length-1;
    while(i < j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      i++; 
   }
  }
 
  static void comparePair(Pair[] a) {
    Arrays.sort(a, new Comparator<Pair>() {
      @Override public int compare(Pair p1, Pair p2) {
         if(p1.x == p2.x) { return p1.y - p2.y;}
         return p1.x - p2.x;  
    }}); 
  }
 
  static String rvr(String s){
     StringBuilder sb = new StringBuilder(s);
     sb.reverse();
     return sb.toString();
  }  
 
  static void op(int[] a, int n){
   int max = Integer.MIN_VALUE; 
   for(int i = 0; i < n; i++){
       max = Math.max(max, a[i]);
    }
    for(int i = 0; i < n; i++){
       a[i] = max - a[i];
    }
  }
 
  static int isCs(String x, String y, int n, int m, int[][] dp){
     if(n == 0 || m == 0){
         return 0;
     }
     if(dp[n-1][m-1] != 0) {return dp[n-1][m-1];}
     if(x.charAt(n-1) == y.charAt(m-1)){
        return dp[n-1][m-1] = isCs(x, y, n-1, m-1, dp) + 1;
     }else{
       return dp[n-1][m-1] = Math.max(isCs(x, y, n-1, m, dp), isCs(x, y, n, m-1, dp));
     }  
 }
  
  static int binarySearch(int[] a){
    int n = a.length;
    return 0;
   } 
 
  static boolean distinct(String s){
    for(int i = 0; i < s.length()-1; i++){
      for(int j = i+1; j < s.length(); j++){
         if(s.charAt(i) == s.charAt(j)){
              return false;
          }
      }
    }
    return true;
  }
 
  static long sumOfDigit(long n){
   long sum = 0;
   while(n > 0){
     long rem = n % 10;
     sum += rem;
     n = n / 10;
   }
   return sum;
  }
 
  static void swap(int a, int b){
     int temp = a;
     a = b;
     b = temp;
  }
 
  static int[] numArr(int n){
     int len = countDigit(n);
     int[] a = new int[len];
     int i = 0;
     
     while(i < len){
         a[i] = n % 10;
         n = n / 10;
         i++;          
     }
     return a;
  }  
 
 static void lcs(String X, String Y, int m, int n, int temp)
    {
        int[][] L = new int[m+1][n+1];
   
        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] 
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
   
        // Following code is used to print LCS
        int index = L[m][n];
        temp = index;
   
        // Create a character array to store the lcs string
        char[] lcs = new char[index+1];
        lcs[index] = '\u0000'; // Set the terminating character
   
        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (X.charAt(i-1) == Y.charAt(j-1))
            {
                // Put current character in result
                lcs[index-1] = X.charAt(i-1); 
                  
                // reduce values of i, j and index
                i--; 
                j--; 
                index--;     
            }
   
            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
     else
      j--;
   }
   for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);
    
    }
 
  static void sortDe(int[] a) {
		ArrayList<Integer> l = new      ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
                int list = l.size() - 1;
		for (int i = 0; i < a.length; i++)
		{	a[i] = l.get(list);
                        list--;
                }
	}
 
  
  static void bracket(int n){
     for(int i = 0; i < n; i++){
         out.print("(");
     }
     for(int i = 0; i < n; i++){
         out.print(")");
     }
     
  }
 
  static int countDigit(int n){
     return (int) Math.floor(Math.log10(n)) + 1;
  }
 
  static int countDigit(long n){
     return (int) Math.floor(Math.log10(n)) + 1;
  }
 
  static void print(int[] ar){
     for(int i = 0; i < ar.length; i++){
         out.print(ar[i] + " ");
     }
  }
 
  static long countEven(long n){
     long c = 0;
     long rem = 0;
     while(n > 1){
         rem = n % 10;
         if(rem % 2 == 0){
            c++;
         }
         n = n / 10;
     }
     return c;
  }
 
  static boolean divisor(long n){
      int count = 2;
      for(int i = 2; i*i <= n; i++){
           if(n % i == 0){
               count++;
           }
           if(count < 3){
                break;
            }
      }
      if(count == 3){return true;}
      else{return false;}      
  }
 
  static String reverseString(String s){
      int j = s.length() - 1;
      String st = new String();
      while(j >= 0){
        st += s.charAt(j);
        j--;
      }
      return st;
   } 
 
  static boolean isPallindrome(String s){
     int i = 0, j = s.length() - 1;
     while(i < j){
        if(s.charAt(i) != s.charAt(j)){
             return false;
         }
         i++;
         j--;
     }
     return true;
  }
 
  static boolean lcsPallindrom(String s){ 
     int i = 0, j = s.length()-1;
     while(i < j){
         if(s.charAt(i) != s.charAt(j)){
             return false;
         }
         i++;
         j--;
     } 
     return true;    
  }
 
  static int[] nprimeNumbers(int n){  
     int[] mark = new int[n+1];
     Arrays.fill(mark, 1);
    
     mark[0] = 0;
     mark[1] = 0;
 
     for(int i = 2; i < mark.length; i++){
         if(mark[i] == 1){
           for(int j = i*i; j < mark.length; j += i){
                mark[j] = 0;
         }
       }
     }
     return mark;
   }
 
  static long gcd(long a, long b){
    if(b > a){return gcd(b, a);}
    if(b == 0){return a;}     
    return gcd(b, a % b);
  }
 
 
  static int gcd(int a, int b){
    if(b > a){return gcd(b, a);}
    if(b == 0){return a;}     
    return gcd(b, a % b);
  }
 
  static class Pair implements Comparable<Pair>{
       int x;
       int y;
       Pair(int x, int y){
          this.x = x;
          this.y = y;
        }
       public int compareTo(Pair p) {
         if(x == p.x) return y - p.y;
         return x - p.x;
       }
  }
 
  static class lvlcompare implements Comparator<Pair> {
     public int compare(Pair p1, Pair p2){
        if(p1.x == p2.x){
              return 0;
         }else if(p1.x > p2.x){
              return 1;
         }else {
              return -1;
         }
     }
  }  
  
  static long count(long n){
     long ct = 0;
     while(n > 0){
         n = n / 10;
         ct++;
     }
     return ct;
  }
 
  static void sort(int[] a) { ArrayList<Integer> l = new
ArrayList<>(); for (int i : a) l.add(i); Collections.sort(l); for (int
i = 0; i < a.length; i++) a[i] = l.get(i); }
 
 
  static void sort(long[] a) {
   ArrayList<Long> l = new ArrayList<>();
    for (long i : a)
     l.add(i);
     Collections.sort(l);
   for (int i = 0; i < a.length; i++) a[i] = l.get(i);
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
  }
}