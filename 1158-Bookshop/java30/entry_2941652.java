import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class entry_2941652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        int[] price = new int[n];        
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }
        
 
        /*
         * Everything is now in four variables:
         *  n             - number of books
         *  x             - available money
         *  price[i]      - price of book i
         *  pages[i]      - pages in book i
         */
        
        int[][] m = new int[n + 1][x + 1];
        
        for (int j = 0; j <= x; j++) {
            m[0][j] = 0;
        }
 
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= x; j++) { 
                if (price[i - 1] > j) {
                	m[i][j] = m[i - 1][j];
                } 
                
                else {
                	m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - price[i - 1]] + pages[i - 1]);
                }
            }
        }
        
        System.out.print(m[n][x]);
 
    }
}