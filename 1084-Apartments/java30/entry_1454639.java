import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;
 
class entry_1454639 {
    private static StreamTokenizer in;
 
    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
 
    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = nextInt();
        }
 
        buildHeap(a);
        buildHeap(b);
        int i = n - 1;
        int j = m - 1;
        int match = 0;
        while (j >= 0 && i >= 0) {
            if (a[0] - k > b[0]) {
                b[0] = b[j--];
                heapify(b, j, 0);
            } else {
                if (a[0] + k < b[0]) {
                    a[0] = a[i--];
                    heapify(a, i, 0);
                } else {
                    match++;
                    b[0] = b[j--];
                    heapify(b, j, 0);
                    a[0] = a[i--];
                    heapify(a, i, 0);
                }
            }
        }
        System.out.println(match);
    }
 
    private static void buildHeap(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
    }
 
    private static void heapify(int[] a, int n, int i) {
        if (n < 0) return;
        int latest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] < a[latest]) latest = l;
        if (r < n && a[r] < a[latest]) latest = r;
        if (latest != i) {
            int tmp = a[latest];
            a[latest] = a[i];
            a[i] = tmp;
 
            heapify(a, n, latest);
        }
    }
}