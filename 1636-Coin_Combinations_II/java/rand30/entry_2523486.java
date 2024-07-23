import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class entry_2523486 {
    static int n, x;
    static int[] c;
    
    static int[] DP;
    
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        String[]data;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        data = f.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        x = Integer.valueOf(data[1]);
        
        c = new int[n];
        data = f.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i){
            c[i] = Integer.valueOf(data[i]);
        }
        Arrays.sort(c);
        solve();
        System.out.println(DP[x]);
    }
 
    private static void solve() {
        DP = new int[x+1];
        Arrays.fill(DP, 0);
        DP[0] = 1;
        for(int j = 0 ; j < n ; ++j){
            for(int i = 1 ; i <= x; ++i)
            
                if(i - c[j] >=0){
                    DP[i] = DP[i] + DP[i-c[j]];
                    while(DP[i] >= MOD)
                        DP[i]-=MOD;
                    
                }
            }   
        
    }
    
}