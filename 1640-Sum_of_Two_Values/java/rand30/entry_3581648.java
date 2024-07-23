import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_3581648 {
 
    public static class Number implements Comparable<Number> {
        int value;
        int index;
 
        public Number(int v, int i) {
            value = v;
            index = i;
        }
 
        @Override
        public int compareTo(Number o) {
            return Integer.compare(value, o.value);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int len = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Number[] arr = new Number[len];
        int p1 = 0; int p2 = len - 1;
 
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = new Number(Integer.parseInt(st.nextToken()), i);
        } Arrays.sort(arr);
 
        while (p1 < p2) {
            if (arr[p1].value + arr[p2].value == target) {
                break;
            } else if (arr[p1].value + arr[p2].value < target) {
                p1++;
            } else {
                p2--;
            }
        }
 
        if (arr[p1].value + arr[p2].value == target && arr[p1].index != arr[p2].index) {
            System.out.println((arr[p1].index + 1) + " " + (arr[p2].index + 1));
        } else {
            System.out.println("IMPOSSIBLE");
        }
 
        r.close();
    }
}
