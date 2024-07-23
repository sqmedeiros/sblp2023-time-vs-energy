// हर हर महादेव
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DecimalFormat;
 
public final class entry_2957902 {
 
    static int inf = Integer.MAX_VALUE;
    static long mod = 1000000000 + 7;
  
   
 
  
    static void ne(Reader sc, BufferedWriter op) throws Exception {
      int n=sc.nextInt();
    
      long[] arr= new long[n];
      for(int i=0;i<n;i++){
          arr[i]=sc.nextLong();
 
      } 
      long maxSofar=-(long)inf;
    //   int max=-inf;
      long sum=0;
      for(int i=0;i<n;i++){
          sum+=arr[i];
         if (sum>maxSofar){
              maxSofar=sum;
          }
          if(sum<0){
              sum=0;
          }
      }
      System.out.println(maxSofar);
     
    }
    
 
    
 
   
    static int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedWriter op = new BufferedWriter(new OutputStreamWriter(System.out));
        Reader sc = new Reader();
       
        // int t = sc.nextInt();
        // while (t-->0){ne(sc, op);}
        
        ne(sc,op);
           
                   
        op.flush();
    }
 
    static void print(Object o) {
        System.out.println(String.valueOf(o));
    }
    static int[] toIntArr(String s){
        int[] val= new int[s.length()];
        for(int i=0;i<s.length();i++){
            val[i]=s.charAt(i)-'a';
        }
        return val;
    }
    static void  sort(int[] arr){
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
 
        }
        Collections.sort(list);
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
    }
 
}
 
// return -1 to put no ahed in array
class pair {
    int xx;
 
    int yy;
 
 
    pair(int xx, int yy ) {
        this.xx = xx;
        this.yy = yy;
    }
}
 
 
class sortY implements Comparator<pair> {
    public int compare(pair p1, pair p2) {
        if (p1.yy > p2.yy) {
            return -1;
        } else if (p1.yy == p2.yy) {
            if (p1.xx > p2.xx) {
                return 1;
            } else if (p1.xx < p2.xx) {
                return -1;
            }
            return 0;
 
        }
        return 1;
    }
}
 
class sortX implements Comparator<pair> {
    public int compare(pair p1, pair p2) {
        if (p1.xx > p2.xx) {
            return 1;
        } else if (p1.xx == p2.xx) {
            if (p1.yy > p2.yy) {
                return 1;
            } else if (p1.yy < p2.yy) {
                return -1;
            }
            return 0;
 
        }
        return -1;
    }
}
 
class debug {
 
    static void print1d(long[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
 
    }
 
    static void print1d(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
 
    }
 
    static void print1d(boolean[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "= " + arr[i] + " ");
        }
 
    }
 
    static void print2d(int[][] arr) {
        System.out.println();
        int n = arr.length;
        int n2 = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
 
    }
 
    static void print2d(long[][] arr) {
        System.out.println();
        int n = arr.length;
        int n2 = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
 
    }
     static void printPair(ArrayList<pair> list) {
        if(list.size()==0){
            System.out.println("empty list");
            return;
        }
       System.out.println();
       for(int i=0;i<list.size();i++){
          System.out.println(list.get(i).xx+"-"+list.get(i).yy);
       }
    }
 
}
 
class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                } else {
                    continue;
                }
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }
 
    public int nextInt() throws IOException {
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
 
    public long nextLong() throws IOException {
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
 
    public double nextDouble() throws IOException {
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
 
    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
 
    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}
