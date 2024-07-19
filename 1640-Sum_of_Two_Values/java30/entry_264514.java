import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
/**
 * You are given an array of n integers, and your task is to find two values (at distinct positions) whose sum is x.
 *
 * Input
 *
 * The first input line has two integers n and x: the array size and the target sum.
 * The second line has n integers a1,a2,…,an: the array values.
 *
 * Output
 *
 * Print two integers: the positions of the values.
 * If there are several solutions, you may print any of them.
 * If there are no solutions, print IMPOSSIBLE.
 * */
public class entry_264514 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        final int n = Integer.parseInt(st.nextToken());
        final int x = Integer.parseInt(st.nextToken());
        final double halfX = x / 2.;
 
        boolean allLessHalf = true;
        boolean allMoreHalf = true;
 
        List<Pair> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            a.add(new Pair(val, i));
            if (val >= halfX) allLessHalf = false;
            if (val <= halfX) allMoreHalf = false;
        }
 
        if (allLessHalf || allMoreHalf) {
            System.out.println("IMPOSSIBLE");
            return;
        }
 
        a.sort(Pair::compareTo);
 
        int i = 0;
        int j = a.size() - 1;
        while (i < j) {
            if (a.get(i).value + a.get(j).value < x) {
                i++;
            } else if (a.get(i).value + a.get(j).value == x) {
                System.out.println(String.format("%d %d", a.get(j).idx+1, a.get(i).idx+1));
                return;
            } else {
                j--;
            }
        }
 
        System.out.println("IMPOSSIBLE");
    }
 
    private static class Pair implements Comparable<Pair> {
        int value;
        int idx;
 
        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
 
        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
}
