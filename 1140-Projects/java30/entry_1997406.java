import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class entry_1997406 {
    public static void main(String[] args) {
        FastReader scn = new FastReader();
        int nrProj = scn.nextInt();
        Project[] projects = new Project[nrProj];
        for (int i = 0; i < nrProj; i++) {
            projects[i] = new Project(scn.nextInt(), scn.nextInt(), scn.nextInt());
        }
        Arrays.sort(projects);
        int[] ends = new int[nrProj];
        for (int i = 0; i < nrProj; i++) {
            ends[i] = projects[i].end;
        }
 
 
        long[] dp = new long[nrProj];
        dp[0] = projects[0].reward;
 
        for (int i = 1; i < nrProj; i++) {
 
            int start = projects[i].start;
            int index = lastOccurence(ends, start);
 
            if (index < 0) {
                dp[i] = Long.max(dp[i - 1], projects[i].reward);
                continue;
            }
            dp[i] = Long.max(dp[i - 1], projects[i].reward + dp[index]);
 
        }
 
        System.out.println(dp[nrProj - 1]);
 
    }
 
    static int lastOccurence(int[] arr, int value) {
 
        int low = 0;
        int high = arr.length - 1;
 
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];
            if (midVal < value)
                low = mid + 1;
            else if (midVal >= value)
                high = mid - 1;
        }
 
 
        return low - 1;  // key not found.
    }
 
}
 
class Project implements Comparable<Project> {
    int start, end, reward;
 
    public Project(int start, int end, int reward) {
        this.start = start;
        this.end = end;
        this.reward = reward;
    }
 
    @Override
    public int compareTo(Project o) {
        return Integer.compare(end, o.end);
    }
}
 
 
class FastReader {
    BufferedReader br;
    StringTokenizer st;
 
    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }
 
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(next());
    }
 
    long nextLong() {
        return Long.parseLong(next());
    }
 
    double nextDouble() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
 
 