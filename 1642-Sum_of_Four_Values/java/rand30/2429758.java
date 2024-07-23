import java.io.*;
import java.util.*;
 
public class entry_2429758 {
    private static StreamTokenizer in;
    private static PrintWriter outt;
 
    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
 
    public static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
 
    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_input.txt")));
        outt = new PrintWriter(new BufferedOutputStream(System.out));
 
        int n = nextInt();
        int x = nextInt();
 
        int[] books = new int[n];
        int[] idxs = new int[n];
        for (int i = 0; i < n; i++) {
            books[i] = nextInt();
            idxs[i] = i;
        }
 
        Random rand = new Random(System.currentTimeMillis());
        int next, tmp;
        for (int i = 0; i < n / 4; i++) {
            next = rand.nextInt(n);
            tmp = idxs[i];
            idxs[i] = idxs[next];
            idxs[next] = tmp;
        }
 
        List<Integer> idxList = new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return idxs[index];
            }
 
            @Override
            public int size() {
                return n;
            }
 
            @Override
            public Integer set(int index, Integer element) {
                Integer prev = idxs[index];
                idxs[index] = element;
                return prev;
            }
        };
        Collections.sort(idxList, Comparator.comparingInt(o -> books[o]));
 
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && books[idxs[i - 1]] == books[idxs[i]]) continue;
 
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && books[idxs[j - 1]] == books[idxs[j]]) continue;
 
                int sum = x - books[idxs[i]] - books[idxs[j]];
 
                int minSum = books[idxs[j + 1]] + books[idxs[j + 2]];
                int maxSum = books[idxs[n - 1]] + books[idxs[n - 2]];
 
                if (sum < minSum || sum > maxSum) continue;
 
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    if (sum == books[idxs[l]] + books[idxs[r]]) {
                        outt.println((idxs[i] + 1) + " " + (idxs[j] + 1) + " " + +(idxs[l] + 1) + " " + (idxs[r] + 1));
                        outt.flush();
                        outt.close();
                        return;
                    }
                    while (l < r && sum > books[idxs[l]] + books[idxs[r]]) l++;
                    while (l < r && sum < books[idxs[l]] + books[idxs[r]]) r--;
                }
            }
        }
 
        outt.println("IMPOSSIBLE");
 
        outt.flush();
        outt.close();
    }
}
 
 