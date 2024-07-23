import java.util.*;
import java.io.*;
 
public class entry_3197975 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int length = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        Pair[] array = new Pair[length];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < length; i++) {
            array[i] = new Pair(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(array);
        int left = 0;
        int right = length - 1;
        while(left < right) {
            if(array[left].value + array[right].value > sum) right--;
            else if(array[left].value + array[right].value < sum) left++;
            else {
                out.println((array[left].index + 1) + " " + (array[right].index + 1));
                in.close();
                out.close();
                System.exit(0);
            }
        }
        out.println("IMPOSSIBLE");
        in.close();
        out.close();
    }
 
    public static class Pair implements Comparable<Pair> {
        int value;
        int index;
 
        public Pair(int v, int i) {
            value = v;
            index = i;
        }
 
        public int compareTo(Pair p) {
            if(value < p.value) return -1;
            if(value > p.value) return 1;
            if(index < p.index) return -1;
            if(index > p.index) return 1;
            return 0;
        }
    }
}
