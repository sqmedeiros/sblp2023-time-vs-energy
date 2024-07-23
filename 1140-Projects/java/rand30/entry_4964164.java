import java.io.*;
import java.util.*;
 
public class entry_4964164{
	private static final String name = "palpath";
	private static PrintWriter out;
	private static FastIO sc;
	private static final int mod = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        try{
            sc = new FastIO(name+".in");
            out = new PrintWriter(name+".out");
        }catch(FileNotFoundException e) {
            sc = new FastIO(System.in);
            out = new PrintWriter(new BufferedOutputStream(System.out));
        }
        int N = sc.nextInt();
        int[][] nums = new int[N][3];
        for(int[] arr: nums) {
        	arr[0] = sc.nextInt();
        	arr[1] = sc.nextInt();
        	arr[2] = sc.nextInt();
        }
        Arrays.sort(nums, (a, b) -> a[1]-b[1]);
        TreeMap<Integer, Long> map = new TreeMap<>();
        for(int[] arr: nums) {
        	Map.Entry<Integer, Long> lower = map.lowerEntry(arr[0]);
        	if(lower != null) map.put(arr[1], Math.max(map.lastEntry().getValue(), lower.getValue()+arr[2]));
        	else map.put(arr[1], Math.max(map.isEmpty() ? 0:map.lastEntry().getValue(), arr[2]));
        }
        out.println(map.lastEntry().getValue());
        out.close();
    }
    private static class Cnt {
    	public TreeMap<Integer, Integer> map;
    	public Cnt() {
    		map = new TreeMap<>();
    	}
    	public void add(int num) {
    		add(num, 1);
    	}
    	public void rem(int num) {
    		add(num, -1);
    	}
    	public void rem(int num, int cnt) {
    		add(num, -cnt);
    	}
    	public void add(int num, int cnt) {
    		Integer get = map.get(num);
    		if(get == null) get = 0;
    		get+=cnt;
    		if(get == 0) map.remove(num);
    		else map.put(num, get);
    	}
    }
    private static class BIT {
        private final long[] bit;
        private final long[] arr;
        private final int len;
        public BIT(int len) {
            bit = new long[len + 1];
            arr = new long[len];
            this.len = len;
        }
        public long get(int ind) {
        return arr[ind];
        }
        public void set(int ind, long val) {
            add(ind, val - arr[ind]);
        }
        public void add(int ind, long val) {
            arr[ind] += val;
            ind++;
            for (; ind <= len; ind += ind & -ind) bit[ind] += val;
        }
        public long prev(int ind) {
            ind++;
            long sum = 0;
            for (; ind > 0; ind -= ind & -ind) sum += bit[ind];
            return sum;
        }
        public long sum(int a, int b) {
            return prev(b)-(a == 0 ? 0:prev(a-1));
        }
    }
    private static class SegTree {
        public static interface Oper{
            long solve(long a, long b);
        }
        private long[] tree;
        private final int n;
        private final Oper oper;
        public SegTree(int n, Oper oper) {
            this.n = n;
            tree = new long[n<<1];
            this.oper = oper;
        }
        public long get(int a, int b) {
            a += n;
            b += n;
            long curr = 0;
            boolean checked = false;
            while (a <= b) {
                if ((a&1) == 1) {
                    if(checked) curr = oper.solve(curr, tree[a++]);
                    else curr = tree[a++];
                    checked = true;
                }
                if ((b&1) == 0) {
                    if(checked) curr = oper.solve(curr, tree[b--]);
                    else curr = tree[b--];
                    checked = true;
                }
                a = a>>1;
                b = b>>1;
            }
            return curr;
        }
        public void set(int index, long val) {
            index += n;
            tree[index] = val;
            for (index = index>>1; index >= 1; index = index>>1)
            tree[index] = oper.solve(tree[index<<1], tree[(index<<1)+1]);
        }
        public long get(int index) {
            return tree[index+n];
        }
    }
    private static class FastIO {
        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0, end = 0;
        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }
        public FastIO(InputStream is) throws Exception {
            dis = is;
        }
        public int nextInt() throws Exception {
            int ret = 0;
            byte b;
            do {
            b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }
            return (negative) ? -ret : ret;
        }
        public long nextLong() throws Exception {
            long ret = 0;
            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }
            return (negative) ? -ret : ret;
        }
        private byte nextByte() throws Exception {
            while(pointer >= end) {
                end = dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }
        public double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
        public String next() throws Exception {
            StringBuffer ret = new StringBuffer();
            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }
            return ret.toString();
        }
    }
}