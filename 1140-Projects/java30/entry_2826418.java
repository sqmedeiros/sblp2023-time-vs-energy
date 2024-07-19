import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
 
public class entry_2826418 {
    private static StreamTokenizer in;
    private static PrintWriter out;
 
    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
 
    public static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
 
    public static void main(String[] args) throws IOException {
//        in = new StreamTokenizer(new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\problems\\src\\main\\resources\\test_input.txt")));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 
        int n = nextInt();
 
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
            arr[i][2] = nextInt();
        }
//        shuffle(arr);
        Arrays.sort(arr, Comparator.comparingInt(x -> x[1]));
 
        long[] dp = new long[n];
        dp[0] = arr[0][2];
        for (int i = 1; i < n; i++) {
            int l = -1;
            int r = i;
            while (l + 1 != r) {
                int mid = (l + r)/2;
                if (arr[mid][1] >= arr[i][0]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            long colab = arr[i][2];
            if (l >= 0) {
                colab += dp[l];
            }
 
            dp[i] = Math.max(dp[i - 1], colab);
        }
 
        out.print(dp[n - 1]);
        out.flush();
    }
 
    private static void shuffle(int[][] arr) {
        int n = arr.length;
        int[] tmp = new int[3];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < n / 4; i++) {
            int next = r.nextInt(n);
            for (int j = 0; j < 3; j++) {
                tmp[j] = arr[i][j];
            }
            for (int j = 0; j < 3; j++) {
                arr[i][j] = arr[next][j];
            }
            for (int j = 0; j < 3; j++) {
                arr[next][j] = tmp[j];
            }
        }
    }
}