import java.util.Arrays;
import java.util.Scanner;
 
public class entry_3503039 {
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        long[] num = new long[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
 
        long maxSubSum = num[0];
        long curPrefSum = 0;
        long minPrefSum = 0;
 
        for(int i = 0; i < n; i++){
            curPrefSum += num[i];
            maxSubSum = Math.max(maxSubSum, curPrefSum - minPrefSum);
            minPrefSum = Math.min(minPrefSum, curPrefSum);
        }
 
        System.out.println(maxSubSum);
    }
}
