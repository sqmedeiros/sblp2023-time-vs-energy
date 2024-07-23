import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class entry_5413104 {
 
    static final int MODE = 1000_000_007;
    static int[] waysAmount;
    static int[] c;
 
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        
 
        int maxCoin = 0;
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
            if (c[i] > maxCoin) maxCoin = c[i];
        }
 
        waysAmount = new int[x + 1 + maxCoin];
        waysAmount[0] = 1;
 
        for (int coin : c) {
            for (int i = 0; i <= x; i++) {
                waysAmount[i + coin] = (waysAmount[i] + waysAmount[i + coin]) % MODE;
            }
        }
 
        System.out.println(waysAmount[x]);
    }
}