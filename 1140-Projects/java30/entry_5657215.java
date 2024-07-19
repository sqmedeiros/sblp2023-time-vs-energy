import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Solution {
        public class pair implements Comparable<pair>{
            int s,e,val;
            pair(int s,int e,int val){
                this.s=s;this.e=e;this.val=val;
            }
            public int compareTo(pair obj){
                if(this.e>obj.e) return 1;
                else return -1;
            }      
        }
        public long solve(int[][] A) {
            
            int n = A.length ;
            pair[] p=new pair[n];
            
            for(int i=0;i<A.length;i++)
                p[i]=new pair(A[i][0],A[i][1],A[i][2]);
                
            Arrays.sort(p);
            
            long dp[][] = new long[n][2] ;
            dp[0][0] = 0 ;
            dp[0][1] = p[0].val ;
            
            for(int i = 1 ; i<n; i++ ){
                // dp (i,0) max profit for (0-i)jobs such that you dont take ith job 
                dp[i][0] = Math.max(dp[i-1][1] , dp[i-1][0] ) ;
                
                // dp (i,1) -> x 
                // max profit for (0-i)jobs such that you take ith job
                
                int str = p[i].s ;
                
                int l = 0 , h = i-1 ;
                int ind = -1 ;
                
                while(l<=h){
                    int m = (l+h)/2 ;
                    
                    if(p[m].e<str){
                        ind = m ;
                        l = m+1 ;
                    }
                    else{
                        h = m-1 ;
                    }
                }
                
                if(ind==-1){
                    dp[i][1] = p[i].val ;
                }
                else{
                    dp[i][1] = p[i].val + Math.max(dp[ind][1] , dp[ind][0] ) ;
                }
                // System.out.println(p[i].s + " " + p[i].e + " " + p[i].val); 
                // System.out.println(dp[i][0] + " " + dp[i][1]) ; 
            }
            
            return Math.max(dp[n-1][1] , dp[n-1][0] ) ;
        }
    }
 
    
public class entry_5657215 {
 
        static class FastReader {
                BufferedReader br;
                StringTokenizer st;
          
                public FastReader()
                {
                    br = new BufferedReader(
                        new InputStreamReader(System.in));
                }
          
                String next()
                {
                    while (st == null || !st.hasMoreElements()) {
                        try {
                            st = new StringTokenizer(br.readLine());
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return st.nextToken();
                }
          
                int nextInt() { return Integer.parseInt(next()); }
          
                long nextLong() { return Long.parseLong(next()); }
          
                double nextDouble()
                {
                    return Double.parseDouble(next());
                }
          
                String nextLine()
                {
                    String str = "";
                    try {
                        if(st.hasMoreTokens()){
                            str = st.nextToken("\n");
                        }
                        else{
                            str = br.readLine();
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                }
            }
 
        public static void main(String[] args) {
                
                FastReader sc = new FastReader() ;
                int n = sc.nextInt() ;
 
                int A[][] = new int[n][3] ;
 
                for(int i = 0 ; i<n; i++ ){
                        for(int j = 0 ; j<3; j++ ){
                                A[i][j] = sc.nextInt() ;
                        }
                }
                Solution sol = new Solution() ;
                System.out.println(sol.solve(A)) ;
        }
}