import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.nio.file.FileAlreadyExistsException;
import java.rmi.ConnectIOException;
import java.io.*;
 
public class entry_3320910 {
    static FastReader in;
    static PrintWriter out;
 
    static int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }
 
    static void p(Object o) {
        out.print(o);
    }
 
    static void pn(Object o) {
        out.println(o);
    }
 
    static void pni(Object o) {
        out.println(o);
        out.flush();
    }
 
    static String n() throws Exception {
        return in.next();
    }
 
    static String nln() throws Exception {
        return in.nextLine();
    }
 
    static int ni() throws Exception {
        return Integer.parseInt(in.next());
    }
 
    static long nl() throws Exception {
        return Long.parseLong(in.next());
    }
 
    static double nd() throws Exception {
        return Double.parseDouble(in.next());
    }
 
    static class FastReader {
        static BufferedReader br;
        static StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }
 
        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }
 
        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
 
    static long power(long a, long b) {
        if (a == 0L)
            return 0L;
        if (b == 0)
            return 1;
        long val = power(a, b / 2);
        val = val * val;
        if ((b % 2) != 0)
            val = val * a;
        return val;
    }
 
    static long power(long a, long b, long mod) {
        if (a == 0L)
            return 0L;
        if (b == 0)
            return 1;
        long val = power(a, b / 2L, mod) % mod;
        val = (val * val) % mod;
        if ((b % 2) != 0)
            val = (val * a) % mod;
        return val;
    }
 
    static ArrayList<Long> prime_factors(long n) {
        ArrayList<Long> ans = new ArrayList<Long>();
        while (n % 2 == 0) {
            ans.add(2L);
            n /= 2L;
        }
        for (long i = 3; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                ans.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            ans.add(n);
        }
        return ans;
    }
 
    static void sort(ArrayList<Long> a) {
        Collections.sort(a);
    }
 
    static void reverse_sort(ArrayList<Long> a) {
        Collections.sort(a, Collections.reverseOrder());
    }
 
    static void swap(long[] a, int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 
    static void swap(List<Long> a, int i, int j) {
        long temp = a.get(i);
        a.set(j, a.get(i));
        a.set(j, temp);
    }
 
    static void sieve(boolean[] prime) {
        int n = prime.length - 1;
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
 
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    public static void sort(long[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
 
    public static void sort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
 
    static void merge(int[] arr, int l, int mid, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];
        for (int i = l; i <= mid; i++) {
            left[i - l] = arr[i];
        }
        for (int i = mid + 1; i <= r; i++) {
            right[i - (mid + 1)] = arr[i];
        }
        int left_start = 0;
        int right_start = 0;
        int left_length = mid - l + 1;
        int right_length = r - mid;
        int temp = l;
        while (left_start < left_length && right_start < right_length) {
            if (left[left_start] < right[right_start]) {
                arr[temp] = left[left_start++];
            } else {
                arr[temp] = right[right_start++];
            }
            temp++;
        }
        while (left_start < left_length) {
            arr[temp++] = left[left_start++];
        }
        while (right_start < right_length) {
            arr[temp++] = right[right_start++];
        }
    }
 
    static void merge(long[] arr, int l, int mid, int r) {
        long[] left = new long[mid - l + 1];
        long[] right = new long[r - mid];
        for (int i = l; i <= mid; i++) {
            left[i - l] = arr[i];
        }
        for (int i = mid + 1; i <= r; i++) {
            right[i - (mid + 1)] = arr[i];
        }
        int left_start = 0;
        int right_start = 0;
        int left_length = mid - l + 1;
        int right_length = r - mid;
        int temp = l;
        while (left_start < left_length && right_start < right_length) {
            if (left[left_start] < right[right_start]) {
                arr[temp] = left[left_start++];
            } else {
                arr[temp] = right[right_start++];
            }
            temp++;
        }
        while (left_start < left_length) {
            arr[temp++] = left[left_start++];
        }
        while (right_start < right_length) {
            arr[temp++] = right[right_start++];
        }
    }
 
    static class pair implements Comparable<pair> {
        int a, b;
 
        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
 
        public int compareTo(pair p) {
            return this.a - p.a;
        }
 
    }
 
    static HashMap<Long, Integer> map_prime_factors(long n) {
        HashMap<Long, Integer> map = new HashMap<>();
        while (n % 2 == 0) {
            map.put(2L, map.getOrDefault(2L, 0) + 1);
            n /= 2L;
        }
        for (long i = 3; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 2) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map;
    }
 
    static long divisor(long n) {
        long count = 0;
        for (long i = 1L; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i)
                    count=(count+i)%mod;
                else
                    {
                        count = (count+i)%mod;
                        count=(count+n/i)%mod;
                    }
            }
        }
        return count;
    }
 
    static void smallest_prime_factor(int n) {
        smallest_prime_factor[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (smallest_prime_factor[i] == 0) {
                smallest_prime_factor[i] = i;
                for (int j = i * i; j <= n; j += i) {
                    if (smallest_prime_factor[j] == 0) {
                        smallest_prime_factor[j] = i;
                    }
                }
            }
        }
    }
 
    static int[] smallest_prime_factor;
    static int count = 1;
    static int[] p = new int[100002];
    static long[] flat_tree = new long[300002];
    static int[] in_time = new int[1000002];
    static int[] out_time = new int[1000002];
    static long[] subtree_gcd = new long[100002];
    static int w = 0;
    static boolean poss = true;
    static long mod = 1000000007L;
 
    static class comparator implements Comparator<pair> {
        public int compare(pair a, pair b) {
            if (a.a == b.a)
                return b.b - a.b;
            return a.a - b.a;
        }
    }
    /*
     * (a^b^c)%mod
     * Using fermats Little theorem
     * x^(mod-1)=1(mod)
     * so b^c can be written as b^c=x*(mod-1)+y
     * then (a^(x*(mod-1)+y))%mod=(a^(x*(mod-1))*a^(y))mod
     * the term (a^(x*(mod-1)))%mod=a^(mod-1)*a^(mod-1)
     * 
     */
 
    public static void main(String[] args) throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int tc = 1;
        while (tc-- > 0) {
            long n=nl();
            int k=ni();
            long[] a=new long[k];
            for(int i=0;i<k;i++){
                a[i]=nl();
            }
            long[] even_odd=new long[k+1];
            for(int i=1;i<(1<<k);i++){
                int count=0;
                long val=1L;
                long pre=n;
                for(int j=0;j<k;j++){
                    if((i&(1<<j))!=0){
                        count++;
                        pre=pre/a[j];
                    }
                }
                even_odd[count]+=(pre);
            }
            long ans=0;
            for(int i=1;i<=k;i++){
                if(i%2==0){
                    ans-=even_odd[i];
                }else ans+=even_odd[i];
            }
            pn(ans);
        }
        out.flush();
        out.close();
    }
 
    static int index(List<pair> arr, int val, int l) {
        int r = arr.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid).a > val) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
 
    static int index1(List<Integer> arr, int val, int l) {
        int r = arr.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) >= val) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
 
    static void swap(int a, int b) {
        pn("before" + a + " " + b);
        int temp = a;
        a = b;
        b = temp;
        pn("befor===e" + a + " " + b);
    }
 
    static void Union(int[] parent, int[] rank, int i, int j) {
        int x = find(i, parent);
        int y = find(j, parent);
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }
 
    static int find(int i, int[] parent) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i], parent);
    }
 
    static int area(Map<Integer, List<Integer>> map, int i, int j, boolean[][] visited, int max) {
        visited[i][j] = true;
        int total = 1;
        if (!map.containsKey(i * max + j))
            return total;
        for (int neighbour : map.get(i * max + j)) {
            int r = neighbour / max;
            int c = neighbour % max;
            if (!visited[r][c]) {
                total += area(map, r, c, visited, max);
            }
        }
        return total;
    }
 
    static void find(int l, int r, int level, int[] arr, int[] depth) {
        if (r < l)
            return;
        int max = find(l, r, arr);
        depth[max] = level;
        find(l, max - 1, level + 1, arr, depth);
        find(max + 1, r, level + 1, arr, depth);
    }
 
    static int find(int l, int r, int[] arr) {
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[index] < arr[i]) {
                index = i;
            }
        }
        return index;
    }
 
    static long start(int[] a, int k) {
        if (a.length == 0)
            return 0;
        if (a.length <= k)
            return 2 * a[a.length - 1];
        long ans = 0;
        int i = 0;
        for (i = k - 1; i < a.length; i += k) {
            ans += 2 * a[i];
        }
        i -= k;
        if (i != a.length - 1) {
            return ans + 2 * a[a.length - 1];
        } else
            return ans;
    }
 
    static long end(int[] a, int k) {
        if (a.length == 0)
            return 0;
        if (a.length <= k)
            return a[a.length - 1];
        if (k == 1) {
            long sum = 0;
            for (int i = 0; i < a.length - 1; i++)
                sum += 2 * a[i];
            return sum + a[a.length - 1];
        }
        long ans = 0;
        int i = 0;
        for (i = k - 1; i < a.length; i += k) {
            if (i != a.length - 1)
                ans += 2 * a[i];
        }
        i -= k;
        return ans + a[a.length - 1];
    }
 
    static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            p(a[i] + " ");
        pn("");
    }
 
    static long count(long n) {
        long count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }
 
    static void swap(long a, long b) {
        long temp = a;
        a = b;
        b = temp;
    }
 
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
 
    static int LcsOfPrefix(String a, String b) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
                count++;
            }
            i++;
        }
        return a.length() + b.length() - 2 * count;
    }
 
    static void reverse(int[] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }
 
    static char get_char(int a) {
        return (char) (a + 'a');
    }
 
    static void dfs(int i, List<List<Integer>> arr, boolean[] visited, int parent) {
        visited[i] = true;
        for (int v : arr.get(i)) {
            if (!visited[v]) {
                dfs(v, arr, visited, i);
            }
        }
    }
 
    static int find1(List<Integer> a, int val) {
        int ans = -1;
        int l = 0;
        int r = a.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a.get(mid) >= val) {
                r = mid - 1;
                ans = mid;
            } else
                l = mid + 1;
        }
        return ans;
    }
 
    static int find2(List<Integer> a, int val) {
        int l = 0;
        int r = a.size() - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a.get(mid) <= val) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }
 
    static void dfs(List<List<Integer>> arr, int node, int parent, long[] val) {
        p[node] = parent;
        in_time[node] = count;
        flat_tree[count] = val[node];
        subtree_gcd[node] = val[node];
        count++;
        for (int adj : arr.get(node)) {
            if (adj == parent)
                continue;
            dfs(arr, adj, node, val);
            subtree_gcd[node] = gcd(subtree_gcd[adj], subtree_gcd[node]);
        }
        out_time[node] = count;
        flat_tree[count] = val[node];
        count++;
    }
}