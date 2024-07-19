import java.util.InputMismatchException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;
public class entry_3657877 {
    public static void main(String[] args){
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        int[] dpTable = new int[x+1];
        int minCoin = Integer.MAX_VALUE;
        Arrays.fill(dpTable, -1);
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
            minCoin = Math.min(coins[i], minCoin);
            if(coins[i] <= x)
                dpTable[coins[i]] = 1;
        }
        
        for(int i = minCoin; i < x+1; i++){
            int temp = Integer.MAX_VALUE;
            if(dpTable[i] == 1){
                continue;
            }
            for(int j = 0; j < n; j++){
                if(i - coins[j] >= minCoin &&  dpTable[i - coins[j]] > 0)
                    temp = Math.min(temp, dpTable[i - coins[j]] + 1);
            }
            dpTable[i] = temp!=Integer.MAX_VALUE ? temp : -1;
        }
        System.out.println(dpTable[x]);
    }
}
 
 
class FastScanner{
    private InputStream stream;                                                                                         
    private byte[] buf = new byte[1024];                                                                                
    private int curChar;                                                                                                
    private int numChars;                                                                                               
 
    public FastScanner(InputStream stream)
    {
       this.stream = stream;                                                                                            
    }
 
    int read()
    {
       if (numChars == -1)
          throw new InputMismatchException();                                                                           
       if (curChar >= numChars){
          curChar = 0;                                                                                                  
          try{
             numChars = stream.read(buf);                                                                               
          } catch (IOException e) {
             throw new InputMismatchException();                                                                        
          }
          if (numChars <= 0)
             return -1;                                                                                                 
       }
       return buf[curChar++];                                                                                           
    }
 
    boolean isSpaceChar(int c)
    {
       return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;                                                                 
    }
 
    boolean isEndline(int c)
    {
       return c=='\n'||c=='\r'||c==-1;                                                                                  
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
 
    String next(){
       int c = read();                                                                                                  
       while (isSpaceChar(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isSpaceChar(c));                                                                                         
       return res.toString();                                                                                           
    }
 
    String nextLine(){
       int c = read();                                                                                                  
       while (isEndline(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isEndline(c));                                                                                           
       return res.toString();                                                                                           
    }
 }