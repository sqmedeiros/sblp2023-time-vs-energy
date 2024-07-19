import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class entry_5953213
{
    static FastReader sc = new FastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
 
    static int[] parent;
    static long[] arr;
    static long[] tree;
 
    static int n;
    static int[] was;
 
    static ArrayList<Integer>[] adj;
 
    static boolean[] prime;
 
    static int cnt;
    public static void main(String[] args) throws IOException
    {
        long n = sc.nextLong();
        int k = sc.nextInt();
        long[] arr = sc.nextArrLong(k);
        long ans = 0;
        for(int i = 0 ; i<(1<<k) ; i++)
        {
            long curr = 1;
            int c=0;
            for(int j = 0;j<k;j++)
            {
                if((i & (1<<j))!=0)
                {
                    if(n/curr<arr[j]){
                        curr=-1;
                        break;
                    }
                    curr *= arr[j];
                    c++;
                }
            }
            if(c==0||curr<0){
                continue;
            }
            if(c%2==0) ans-= (n/curr);
            else ans+=(n/curr);
        }
        out.println(ans);
        out.flush();
 
    }
 
 
    static class Pair
    {
        int x;
        int y;
        public Pair(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString()
        {
            return this.x + " ^ " + this.y;
        }
    }
 
    public static void union(int p,int q)
    {
        p = find(p);
        q = find(q);
        q = parent[q];
        if(q == p) return;
        parent[p] = q;
        cnt--;
    }
    public static int find(int p)
    {
        while( p != parent[p] ) p = parent[p];
        return p;
    }
 
    public static void build(int l , int r , int ind)
    {
        if(l==r)
        {
            tree[ind] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        build(l,mid,2*ind+1);
        build(mid+1,r,2*ind+2);
        tree[ind] = tree[ind*2+1]+tree[ind*2+2];
    }
    public static long get(int l , int r , int ind , int ql , int qr)
    {
        if(r < ql || l > qr)
        {
            return 0;
        }
        if(l >= ql && r <= qr)
        {
            return tree[ind];
        }
        int mid = (l+r)/2;
        return get(l,mid,2*ind+1,ql,qr)+get(mid+1,r,2*ind+2,ql,qr);
    }
    public static void update(int l, int r , int ind , int pos, int san)
    {
        if (l == pos && l == r)
        {
            tree[ind] = san;
            return;
        }
 
        int mid = (l + r) / 2;
        if (pos <= mid)
        {
            update(l, mid, ind * 2 + 1, pos, san);
        } else
        {
            update(mid + 1, r, ind * 2 + 2, pos, san);
        }
 
        tree[ind] = tree[ind * 2 + 1] + tree[ind * 2 + 2];
    }
 
    static class FastReader
    {
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is)
        {
            in = is;
        }
 
        int scan() throws IOException
        {
            if (index >= total)
            {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException
        {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan())
            {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException
        {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
            {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan())
            {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException
        {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
            {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan())
            {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        int[] nextArrInt(int n) throws IOException
        {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
 
        long[] nextArrLong(int n) throws IOException
        {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}