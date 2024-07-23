import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class entry_4391845 {
    static class book {
        int price;
        int pages;
 
        book(int price, int pages) {
            this.pages = pages;
            this.price = price;
        }
    }
 
    static class bookComparator implements Comparator<book> {
 
        @Override
        public int compare(entry_4391845.book o1, entry_4391845.book o2) {
            return o1.price - o2.price;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
 
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
 
        int[] h = new int[n];
        int[] s = new int[n];
 
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(tokenizer.nextToken());
        }
 
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(tokenizer.nextToken());
        }
 
        book[] books = new book[n];
        for (int i = 0; i < n; i++) {
            books[i] = new book(h[i], s[i]);
        }
 
        Arrays.sort(books, new bookComparator());
 
        int[][] dp = new int[n + 1][x + 1];
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (j < books[i - 1].price) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], books[i - 1].pages + dp[i - 1][j - books[i - 1].price]);
                }
            }
        }
 
        pw.println(dp[n][x]);
 
        pw.flush();
        pw.close();
        br.close();
 
    }
}
