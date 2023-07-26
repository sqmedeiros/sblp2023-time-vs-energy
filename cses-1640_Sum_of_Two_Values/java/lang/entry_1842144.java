import java.io.*;
import java.util.*;
 
public class entry_1842144 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//        BufferedReader in = new BufferedReader(new FileReader("file.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("file.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        StringTokenizer sta = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(sta.nextToken());
        }
        int[] original = array.clone();
        Arrays.sort(array);
        int left = 0;
        int right = N - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                indexes(original, array[left], array[right]);
                return;
            } else if (array[left] + array[right] < target) left++;
            else right--;
        }
        System.out.println("IMPOSSIBLE");
    }
    static void indexes(int[] original, int a, int b) {
        int i1 = -1;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == a) {
                i1 = i + 1;
                original[i] = Integer.MIN_VALUE;
                break;
            }
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] == b) {
                System.out.println(i1 + " " + (i + 1));
                return;
            }
        }
    }
}
