import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.StreamSupport;
 
public class entry_3903106 {
    //    static int mod = 998244353;
    static int mod = 1000000007;
    public static void main(String str[]) throws IOException{
        Reader sc = new Reader();
 
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
////        sc.nextLine();
//        while(t-->0){
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)    arr[i] = sc.nextInt();
        int[] dp = new int[x+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1;i<=x;i++){
            for(int j: arr){
                if(i-j>=0 && dp[i-j]!=-1){
                    if(dp[i]==-1 || dp[i]>dp[i-j]+1) dp[i] = dp[i-j]+1;
                }
            }
        }
        output.write(dp[x]+"\n");
        output.flush();
    }
    static int fun(int[] dp, int[] arr, int n, int x){
        if(x==0)    return 0;
        if(x<0) return -1;
        if(dp[x]!=-1)   return dp[x];
        int min = -1;
        for(int i: arr){
            int temp = 1+fun(dp, arr, n, x-i);
            if(temp>0){
                if(min==-1 || min>temp) min = temp;
            }
        }
        dp[x] = min;
        return min;
    }
 
 
 
    static class Node{
        int ind;
        int anc;
        int w = -1;
        Node(int ii, int xx){
            ind = ii;
            anc = xx;
        }
    }
 
    static int bfsAtD(Graph[] g, int start, int end,int D){
        int[] visited = new int[g.length];
        int[] twoV = new int[g.length];
        Arrays.fill(visited,-1);
        LinkedList<Pair> queue = new LinkedList<Pair>();
        visited[start] = 0;
        Pair p = new Pair(start, 0);
        queue.add(p);
        int count = 0;
        while (queue.size() != 0)
        {
            Pair s = queue.poll();
            int dis = s.two+1;
            for(int i: g[s.one].pq)
            {
                int n = i;
                if(n==end && (dis<=D))  count++;
                if(twoV[n]==0){
                    visited[n] = dis;
                    twoV[n]++;
                    Pair temp = new Pair(n, dis);
                    queue.add(temp);
                }
                else if(twoV[n]==1 && dis-1==visited[n]){
                    twoV[n]++;
                    Pair temp = new Pair(n, dis);
                    queue.add(temp);
                }
 
            }
        }
        return count;
    }
    static int bfs(Graph[] g, int start, int end,boolean[] visited){
        LinkedList<Pair> queue = new LinkedList<Pair>();
 
        visited[start]=true;
        Pair p = new Pair(start, 0);
        queue.add(p);
 
        while (queue.size() != 0)
        {
            Pair s = queue.poll();
            int dis = s.two+1;
            for(int i: g[s.one].pq)
            {
                int n = i;
                if(n==end)    return dis;
                if (!visited[n])
                {
                    visited[n] = true;
                    Pair temp = new Pair(n,dis);
                    queue.add(temp);
                }
            }
        }
        return -1;
    }
 
 
    static class Pair {
        int one;
        int two;
        //        int e=0;
        Pair(int v, int ss) {
            one = v;
            two = ss;
        }
    }
 
 
 
 
 
 
 
 
    static int GCD(int a, int b)
    {
        return (a % b == 0) ?
                Math.abs(b) : GCD(b,a%b);
    }
 
 
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // making and initializing dp array
        int []dp = new int[W + 1];
 
 
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
 
                if (wt[i - 1] <= w)
 
                    // finding the maximum value
                    dp[w] = Math.max(dp[w],
                            dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W]; // returning the maximum value of knapsack
    }
 
 
 
    static int dp(ArrayList<Integer> arr, ArrayList<Integer> num, HashMap<Double, Integer> memo, double curr, int ans){
        if(memo.containsKey((Math.pow(ans,4)*Math.pow(curr,3))))  return memo.get(curr);
        int max = 0;
        int fin = 0;
        for(int i=0;i<arr.size();i++){
            int x = arr.get(i);
            arr.remove(i);
            int y = num.get(i);
            num.remove(i);
            int pp = x;
            if(ans!=-1) pp = (int)gcd(ans, x);
            if(pp==1){
                int temp = pp+arr.size();
                if(max<=temp){
                    max = temp;
                    fin = pp;
                }
                continue;
            }
            int temp = pp + dp(arr, num, memo, curr+(Math.pow(x,7)/Math.pow(x,4)), pp);
            if(max<=temp){
                max = temp;
                fin = pp;
            }
            num.add(i,y);
            arr.add(i,x);
        }
        memo.put(curr, max);
        return max+fin;
    }
 
 
 
    static int max(ArrayList<Integer> al){
        int i=0;
        int max =Integer.MIN_VALUE;
        for(int j=0;j<al.size();j++){
            int k = al.get(j);
            if(k>max){
                i = j;
                max = k;
            }
        }
        return i;
    }
 
 
 
    //Collections.sort(al, new Comparator<Object>() {
    //    @Override
    //    public int compare(Object o1, Object o2) {
    //        return 0;
    //    }
    //});
 
    //    static class Node{
//        int ind;
//        int tot = 1;
//        ArrayList<Node> parent = new ArrayList<>();
//        ArrayList<Node> child = new ArrayList<>();
//        Node(int i){
//            ind =i;
//        }
//    }
//    static void dfs(Node[] Nodes, Node ind, Node parent){
//        if(parent!=null){
//            ind.parent.remove(parent);
//            int x = parent.tot;
//            if(parent.ind>ind.ind){
//                x++;
//            }
//            ind.tot = Math.max(x, ind.tot);
//        }
//        if(ind.parent.isEmpty()){
//            for(Node n: ind.child){
//                dfs(Nodes, n, ind);
//            }
//        }
//
//    }
    static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights){
        int ans = 0;
        int n = wallHeights.size();
        for(int i=1;i<n;i++){
            int ind1 = wallPositions.get(i-1);
            int ind2 = wallPositions.get(i);
            if(ind2-ind1==1)    continue;
            int x = wallHeights.get(i-1);
            int y = wallHeights.get(i);
            int index = (y-x+ind1+ind2)/2;
            if(index<=ind1){
                index = ind1+1;
            }
            else if(index>=ind2){
                index = ind2-1;
            }
            ans = Math.max(ans, Math.min(x+(index-ind1),y+(ind2-index)));
        }
        return ans;
    }
 
 
 
 
//        3
//        2 1 1
//        2 3 11
//        3 4 1
//        4
//        2
 
 
    public static ArrayList<Integer> primeFactors(int n)
    {
        // Print the number of 2s that divide n
        ArrayList<Integer> al = new ArrayList<>();
        while (n%2==0)
        {
            al.add(2);
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                al.add(i);
                n /= i;
            }
        }
 
        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            al.add(n);
 
        return al;
    }
 
 
 
 
 
//    static class tempSort implements Comparator<Node> {
//        // Used for sorting in ascending order of
//        // roll number
//        public int compare(Node a, Node b) {
//            return a.size - b.size;
//        }
//    }
 
 
    static long modDivision(long p, long q, long mod){
        p = p%mod;
        long inv = modInverse(q, mod);
        return (inv*p) %mod;
    }
 
 
 
    static long divide(long p, long q, long mod)
    {
        long expo = mod - 2;
 
        while (expo != 0)
        {
            if ((expo & 1) == 1)
            {
//                long temp = p;
//                System.out.println("zero--> "+temp+" "+q);
                p = (p * q) % mod;
//                if(p<0){
//                    System.out.println("one--> "+temp+" "+q);
//                }
            }
            q = (q * q) % mod;
//            if(q<0){
//                System.out.println("two--> "+p+" "+q);
//            }
 
            expo >>= 1;
        }
        return p;
    }
 
 
    static class Graph{
        int ind;
        ArrayList<Integer> pq = new ArrayList<>();
        Set<Integer> set;
        boolean b = false;
        public Graph(int a){
            ind = a;
        }
 
 
    }
 
 
    //
//    static class Pair{
//        int a=0;
//        int b=0;
//        int in = 0;
//        int ac = 0;
//        int ex = 0;
//    }
    long fun2(ArrayList<Integer> arr, int x){
        ArrayList<ArrayList> al = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        fun(arr, x, al, curr, 0);
        if(al.size()==0)    return 0;
        int max = 0;
        for(ArrayList<Integer> i: al){
            if(i.size()>max)    max = i.size();
        }
        for(int i=0;i<al.size();i++){
            if(al.get(i).size()!=max){
                al.remove(i);
                i--;
            }
        }
        for(ArrayList<Integer> i: al){
            Collections.sort(al, Collections.reverseOrder());
        }
        long ans = 0;
 
        for(ArrayList<Integer> i: al){
            long temp = 0;
            for(int j: i){
                temp*=10;
                temp+=j;
            }
            if(ans<temp)    ans = temp;
        }
        return ans;
 
    }
    void fun(ArrayList<Integer> arr, int x, ArrayList<ArrayList> al, ArrayList<Integer> curr, int i){
        if(x<0) return ;
        if(x==0) {
            al.add(curr);
            return;
        }
        for(int j=i;j<arr.size();j++){
            ArrayList<Integer> temp = new ArrayList<>(curr);
            fun(arr, x-arr.get(j), al, temp, j);
        }
    }
 
 
 
    // Returns n^(-1) mod p
    static long modInverse(long n, long p)
    {
        return (long)power(n, p - 2, p);
    }
 
 
 
 
    // Returns nCr % p using Fermat's
    // little theorem.
    static long nCrModPFermat(int n, int r,
                              int p, long[] fac)
    {
 
        if (n<r)
            return 0;
        // Base case
        if (r == 0)
            return 1;
 
        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        long x = modInverse(fac[r], p);
        long y = modInverse(fac[n - r], p);
 
        return (fac[n] * x
                % p * y
                % p)
                % p;
    }
 
    static long[] sum(String[] str){
        int n = str[0].length();
        long ans[] = new long[n];
        for(String s: str){
            for(int i=0;i<n;i++)   ans[i]+=s.charAt(i);
        }
        return ans;
    }
 
//    static class tSort implements Comparator<Pair>{
//
//        public int compare(Pair s1, Pair s2) {
//            if (s1.b < s2.b)
//                return -1;
//            else if (s1.b > s2.b)
//                return 1;
//            return 0;
//        }
//    }
 
 
//    static boolean checkCycle(Tree[] arr,  boolean[] visited, int curr, int Node){
//        if(curr==Node && visited[curr]) return true;
//        if(visited[curr])   return false;
//        visited[curr]  = true;
//        for(int i: arr[curr].al){
//            if(checkCycle(arr, visited, i, Node))    return true;
//        }
//        return false;
//    }
 
 
//    static boolean allCombinations(int n){      //Global round 15
//        int three2n = 1;
//        for (int i = 1; i <= n; i++)
//            three2n *= 3;
//
//        for (int k = 1; k < three2n; k++) {
//            int k_cp = k;
//            int sum = 0;
//            for (int i = 1; i <= n; i++) {
//                int s = k_cp % 3;
//                k_cp /= 3;
//                if (s == 2) s = -1;
//                sum += s * a[i];
//            }
//            if (sum == 0) {
//                return true;
//            }
//        }
//        return false;
//    }
 
    static ArrayList<String> fun( int curr, int n, char c){
        int len = n-curr;
        if(len==0)  return null;
        ArrayList<String> al = new ArrayList<>();
        if(len==1){
            al.add(c+"");
            return al;
        }
        String ss = "";
        for(int i=0;i<len/2;i++){
            ss+=c;
        }
        ArrayList<String> one = fun(len/2+curr, n, (char)(c+1));
        for(String str: one){
            al.add(str+ss);
            al.add(ss+str);
        }
        return al;
    }
    static ArrayList convert(int x, int k){
        ArrayList<Integer> al = new ArrayList<>();
        if(x>0) {
            while (x > 0) {
                al.add(x % k);
                x /= k;
            }
        }
        else    al.add(0);
        return al;
    }
 
 
 
 
    static int max(int x, int y, int z){
        int ans = Math.max(x,y);
        ans = Math.max(ans, z);
        return ans;
    }
    static int min(int x, int y, int z){
        int ans = Math.min(x,y);
        ans = Math.min(ans, z);
        return ans;
    }
 
//    static long treeTraversal(Tree arr[], int parent, int x){
//        long tot = 0;
//        for(int i: arr[x].al){
//            if(i!=parent){
//                tot+=treeTraversal(arr, x, i);
//            }
//        }
//        arr[x].child = tot;
//        if(arr[x].child==0) arr[x].child = 1;
//        return tot+1;
//    }
 
    public static int primeFactors(int n, int k)
    {
        int ans = 0;
 
        while (n%2==0)
        {
            ans++;
            if(ans>=k)  return k;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                ans++;
                n /= i;
                if(ans>=k)  return k;
            }
        }
 
        if (n > 2)  ans++;
        return ans;
    }
    static int binaryLow(ArrayList<Integer> arr, int x, int s, int e){
        if(s>=e){
            if(arr.get(s)>=x)  return s;
            else    return s+1;
        }
        int m = (s+e)/2;
        if(arr.get(m)==x)  return m;
        if(arr.get(m)>x)   return binaryLow(arr,x,s,m);
        if(arr.get(m)<x)   return binaryLow(arr,x,m+1,e);
        return 0;
    }
    static int binaryLow(int[] arr, int x, int s, int e){
        if(s>=e){
            if(arr[s]>=x)  return s;
            else    return s+1;
        }
        int m = (s+e)/2;
        if(arr[m]==x)  return m;
        if(arr[m]>x)   return binaryLow(arr,x,s,m);
        if(arr[m]<x)   return binaryLow(arr,x,m+1,e);
        return 0;
    }
    static int binaryHigh(int[] arr, int x, int s, int e){
        if(s>=e){
            if(arr[s]<=x)  return s;
            else    return s-1;
        }
        int m = (s+e)/2;
        if(arr[m]==x)  return m;
        if(arr[m]>x)   return binaryHigh(arr,x,s,m-1);
        if(arr[m]<x)   return binaryHigh(arr,x,m+1,e);
        return 0;
    }
 
 
//    static void arri(int arr[], int n, Reader sc) throws IOException{
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//    }
//    static void arrl(long arr[], int n, Reader sc) throws IOException{
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextLong();
//        }
 
 
    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static long power(long x, long y, long p)
    {
        long res = 1; // Initialize result
 
        x = x % p; // Update x if it is more than or
        // equal to p
 
        if (x == 0)
            return 0; // In case x is divisible by p;
 
        while (y > 0)
        {
 
            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;
 
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res%p;
    }
 
 
 
 
 
 
//    static class SortbyI implements Comparator<Pair> {
//        // Used for sorting in ascending order of
//        // roll number
//        public int compare(Pair a, Pair b)
//        {
//            if(a.a>=b.a) return 1;
//            else return -1;
//        }
//    }
//    static class SortbyD implements Comparator<Pair> {
//        // Used for sorting in ascending order of
//        // roll number
//        public int compare(Pair a, Pair b)
//        {
//            if(a.a<b.a) return 1;
//            else if(a.a==b.b && a.b>b.b)    return 1;
//            else return -1;
//        }
//    }
//    static int binarySearch(ArrayList<Pair> a, int x, int s, int e){
//        if(s>=e){
//            if(x<=a.get(s).b)  return s;
//            else    return s+1;
//        }
//        int mid = (e+s)/2;
//        if(a.get(mid).b<x){
//            return binarySearch(a, x, mid+1, e);
//        }
//        else    return binarySearch(a,x,s, mid);
//    }
 
    //    static class Edge{
//        int a;
//        int b;
//        int c;
//        int sec;
//        Edge(int a, int b, int c, int sec){
//            this.a = a;
//            this.b = b;
//            this.c = c;
//            this.sec = sec;
//        }
//
//    }
    static class Tree{
        int a;
 
        ArrayList<Tree> al = new ArrayList<>();
        Tree(int a){
            this.a = a;
        }
 
 
    }
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
 
 
    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;
 
        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;
 
        return true;
    }
    static ArrayList<Integer> sieveOfEratosthenes(int n)
    {
        ArrayList<Integer> al = new ArrayList<>();
        // Create a boolean array
        // "prime[0..n]" and
        // initialize all entries
        // it as true. A value in
        // prime[i] will finally be
        // false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++)
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                al.add(i);
        }
        return al;
    }
 
}