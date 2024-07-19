import java.io.*;
import java.util.*;
 
/**
 * CSES ProblemSet: DP: Coin Combinations 2
 *
 * @author amaheshwari
 *
 * @version 02.22.20
 */
 
@SuppressWarnings("Duplicates")
public class entry_335560 {
 
    static int[] coins;
    static int[] prefdp;
    static final int MOD = 1000000007;
 
    public static void main(String[] args) throws IOException {
 
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        s.nextLine();
 
        coins = new int[x+1]; //1-indexed
        prefdp = new int[n+1];//1-indexed both ways
 
        for(int i = 1; i <= x; i++){
            coins[i]=s.nextInt();
        }
        s.close();
 
        prefdp[0]=1;
        // key code change: iterate over C on the OUTSIDE now
        for(int c = 1; c <= x; c++){
            for(int i = 1; i <= n; i++){
                if(coins[c]>i || prefdp[i-coins[c]]==0) continue;
                prefdp[i]=(prefdp[i]+ prefdp[i-coins[c]])%MOD;
            }
        }
 
//        for(int i = 1; i <= n; i++){
//            for(int c = 1; c <= x; c++){
//                System.out.print(prefdp[i][c] + " ");
//            }
//            System.out.println();
//        }
 
        System.out.println(prefdp[n]);
 
    }
}