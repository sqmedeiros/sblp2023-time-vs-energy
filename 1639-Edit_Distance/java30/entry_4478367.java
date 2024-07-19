import java.util.*;
public class entry_4478367 {
 
  static int[][] memo ;
 // static long mod=(int)1e9 + 7;
 
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
       solve();
 
    }
 
      static void solve() {
          String s=sc.next();
          String t=sc.next();
 
          memo=new int[s.length()+1][t.length()+1];
 
          for (int[] e:memo
               ) {
              Arrays.fill(e,-1);
          }
          for (int i = 0; i < s.length()+1; i++) {
              memo[i][0]=i;
          }
 
          for (int i = 0; i < t.length()+1; i++) {
              memo[0][i]=i;
          }
 
 
          for (int i = 1; i < s.length()+1; i++) {
              for (int j = 1; j < t.length()+1; j++) {
                  if(s.charAt(i-1)==t.charAt(j-1)){
                      memo[i][j]=memo[i-1][j-1];
                  }
                  else{
                      memo[i][j]=1+Math.min(memo[i-1][j-1],Math.min(memo[i-1][j],memo[i][j-1]));
                  }
              }
          }
 
      System.out.println(memo[s.length()][t.length()]);
 
    }
 
    static int fun(String s,String t,int i,int j){
        if(i<0 && j<0){
            return 0;
        }
       if(i<0) return j+1;
       if(j<0) return i+1;
       if(memo[i][j]!=-1) return memo[i][j];
       if(s.charAt(i)==t.charAt(j)) return memo[i][j]=fun(s,t,i-1,j-1);
       else {
           return memo[i][j]=Math.min(1+Math.min(fun(s,t,i,j-1),fun(s,t,i-1,j)),1+fun(s,t,i-1,j-1));
       }
 
    }
 
}
 