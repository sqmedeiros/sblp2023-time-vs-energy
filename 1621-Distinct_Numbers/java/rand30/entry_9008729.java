//  Distinct Numbers
import java.util.*;
import java.lang.*;
import java.io.*;
 
@SuppressWarnings("unchecked")
class entry_9008729 {
    static InOut io = new InOut();
    static int n;
    private static void sort(int l, int r, int[] arr) {
        if(l == r)
            return;
        int mid = l+(r-l)/2;
        sort(l, mid, arr);
        sort(mid+1, r, arr);
        int[] larr = new int[mid-l+1];
        int[] rarr = new int[r-mid];
 
        for(int i = l;i<=mid;i++) {
            larr[i-l] = arr[i];
        }
        for(int i = mid+1;i<=r;i++) {
            rarr[i-mid-1] = arr[i];
        }
        int x = 0, y = 0, ind = l;
 
        while(x<larr.length && y<rarr.length) {
            if(larr[x] <= rarr[y]) {
                arr[ind] = larr[x];
                x++;
            } else {
                arr[ind] = rarr[y];
                y++;
            }
            ind++;
        }
        while(x<larr.length) {
            arr[ind] = larr[x];
            ind++;
            x++;
        }
        while(y<rarr.length) {
            arr[ind] = rarr[y];
            ind++;
            y++;
        }
    }
    private void solve() {
        n = io.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = io.nextInt();
        }
        sort(0, n-1, arr);
        int cnt = 1;
        int curr = arr[0];
        for(int i=0;i<n;i++) {
            //io.print(arr[i]);
            if(arr[i] != curr) {
                cnt++;
                curr = arr[i];
            }
        }
        io.println(cnt);
    }
 
    //basic setup
    private void solver() {
        int t = 1;
        //t = io.nextInt();
        while(t-->0) {
            solve();
        }
    }
 
    public static void main(String[] args) {
        new entry_9008729().solver();
        io.close();
    }
 
    static class InOut extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;
 
        public InOut() {
            this(System.in, System.out);
        }
        public InOut(InputStream in, OutputStream out) {
            super(out);
            br = new BufferedReader(new InputStreamReader(in));
        }
 
        // Old filename version
        public InOut(String name) throws IOException {
            super(name + ".out");
            br = new BufferedReader(new FileReader(name + ".in"));
        }
 
        private String next() {
            try {
                while (st == null || !st.hasMoreElements())
                    st = new StringTokenizer(br.readLine());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public String nextString() {
            return next();
        }
 
        @Override
        public void close() {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.close();
        }
    }
}
