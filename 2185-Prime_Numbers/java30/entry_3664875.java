import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.*;
 
public class entry_3664875 {
    static class in {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");
 
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }
 
        static int nextInt() throws IOException {
            //System.out.println(" I WAS CALLED");
            return Integer.parseInt(next());
        }
 
        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
 
        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        static String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static long mod = 1000000000+7;
    static long give_sum(long a){
        long ans = (a*(a+1))/2;
        return ans;
    }
 
    static long pow_(long num,long pow,long mod){
        if(pow==0)return 1L;
        if(pow%2==0){
            long temp = pow_(num,pow/2,mod)%mod;
            return (temp*temp)%mod;
        }
        else{
            long temp =pow_(num,pow-1,mod)%mod;
            return ((num%mod)*temp)%mod;
        }
    }
 
    public static void main(String[] args) throws IOException {
       long n = in.nextLong();
       int k= in.nextInt();
       long[] arr = new long[k];
       for(int i=0;i<k;i++)arr[i]=in.nextLong();
       long ans=0;
       int limit = 1<<k;
       for(int mask = 1;mask<limit;mask++){
           long temp = n;
           int count=0;
           for(int i=0;i<k;i++){
               if((mask&(1<<i))>0){
                   count++;
                   temp=temp/arr[k-1-i];
               }
           }
           if(count==0)continue;
           if(count%2==1){
               ans=ans+temp;
           }
           else{
               ans=ans-temp;
           }
       }
        System.out.println(ans);
    }
 
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 