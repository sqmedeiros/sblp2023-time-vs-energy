import java.util.Arrays;
import java.util.Scanner;
 
public class entry_5713332 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBooks = sc.nextInt();
        int maxAmount = sc.nextInt();
        int[] bookPrices = new int[numBooks];
        int[] bookPages = new int[numBooks];
        for(int i = 0; i < numBooks; i++) {
            bookPrices[i] = sc.nextInt();
        } 
        for(int i = 0; i < numBooks; i++) {
            bookPages[i] = sc.nextInt();
        }
        System.out.println(findMaxPages(bookPages, bookPrices, maxAmount));
    }
 
    private static long findMaxPages(int[] bookPages, int[] bookPrices, int maxAmount) {
        long[] dp = new long[maxAmount + 1];
        for(int i = 0; i < bookPages.length; i++) {
            int pages = bookPages[i];
            int price = bookPrices[i];
            for(int j = maxAmount; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + pages);
            }
        }
        return dp[dp.length - 1];
    }
}
 
 
// amount = 10
 
//
// 4 8 5 3  price
// 5 12 8 1 pages
 
//  0 1 2 3 4 5 6 7 8  9 10
// [1,0,0,0,5,5,5,5,12,12,12]
 