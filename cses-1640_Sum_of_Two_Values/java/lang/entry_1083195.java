import java.util.*;
import java.io.*;
 
public class entry_1083195 {
  public static void main(String [] args){
    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    
    int n = in.nextInt();
    int x = in.nextInt();
    Point [] points = new Point[n];
    for(int i = 0; i < n; i++){
      points[i] = new Point(in.nextInt(), i + 1);
    }
    Arrays.sort(points);
    int lo = 0, hi = points.length - 1;
    while(lo < hi){
      int sum = points[lo].value + points[hi].value;
      if(sum > x){
        hi--;
      }else if(sum < x){
        lo++;
      }else{
        out.println(points[lo].pos + " " + points[hi].pos);
        out.close();
        return;
      }
    }
    out.println("IMPOSSIBLE");
    out.close();
  }
 
  static class Point implements Comparable<Point>{
    int value;
    int pos;
    public Point(int value, int pos){
      this.value = value;
      this.pos = pos;
    }
    public int compareTo(Point other){
      return this.value - other.value;
    }
  }
 
  static class FastReader{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st = new StringTokenizer("");
    String next(){
      if(!st.hasMoreElements()){
        try{
          st = new StringTokenizer(br.readLine());
        }catch(IOException e){
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
    int nextInt(){return Integer.parseInt(next());}
    long nextLong(){return Long.parseLong(next());}
    String nextLine(){
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
