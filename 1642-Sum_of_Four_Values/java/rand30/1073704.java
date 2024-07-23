import java.io.*;
import java.math.*;
import java.util.*;
 
public class entry_1073704 {
 
	public static void main(String[] args) {
//		int test = fs.nextInt();
		int test = 1;
		for (int cases = 0; cases < test; cases++) {
			int n = fs.nextInt();
			int x = fs.nextInt();
			Pair ar[] = new Pair[n];
			for (int i = 0; i < n; i++) {
				int s = fs.nextInt();
				ar[i] = new Pair(s, i + 1);
			}
			Arrays.sort(ar, new Comparator<Pair>() {
 
				@Override
				public int compare(Pair o1, Pair o2) {
					// TODO Auto-generated method stub
					return o1.first - o2.first;
				}
 
			});
			boolean rs = false;
			for (int l = 0; l < n; l++) {
				int z = ar[l].first;
				int rr = x - z;
				for (int i = l + 1; i < n; i++) {
					int a = ar[i].first;
					int r = rr - a;
					int start = i + 1;
					int end = n - 1;
					while (start < end) {
						if (ar[start].first + ar[end].first == r) {
							rs = true;
							op.print(ar[l].second + " " + ar[start].second + " " + ar[end].second + " " + ar[i].second
									+ "\n");
							break;
						} else if (ar[start].first + ar[end].first < r) {
							++start;
						} else {
							--end;
						}
					}
					if (rs) {
						break;
					}
				}
				if (rs) {
					break;
				}
			}
			if (!rs) {
				op.print("IMPOSSIBLE \n");
			}
			op.flush();
		}
 
	}
 
	static void sieve() {
		boolean prime[] = new boolean[101];
		Arrays.fill(prime, true);
		prime[1] = false;
		for (int i = 2; i * i <= prime.length - 1; i++) {
			for (int j = i * i; j <= prime.length - 1; j += i) {
				prime[j] = false;
			}
		}
	}
 
	static void printArray(int ar[]) {
		Arrays.toString(ar);
	}
 
	static long expmodulo(long a, long b, long c) {
		long x = 1;
		long y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y) % c;
			}
			y = (y * y) % c; // squaring the base
			b /= 2;
		}
		return (long) x % c;
	}
 
	static int modInverse(int a, int m) {
		int m0 = m;
		int y = 0, x = 1;
 
		if (m == 1)
			return 0;
 
		while (a > 1) {
			int q = a / m;
			int t = m;
			m = a % m;
			a = t;
			t = y;
			y = x - q * y;
			x = t;
		}
		if (x < 0)
			x += m0;
		return x;
	}
 
	static int countBits(int number) {
		return (int) (Math.log(number) / Math.log(2) + 1);
	}
 
	static int countDifferentBits(int a, int b) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (((a >> i) & 1) != ((b >> i) & 1)) {
				++count;
			}
		}
		return count;
	}
 
	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
 
	static void sortMyMapusingValues(HashMap<String, Integer> hm) {
 
		List<Map.Entry<String, Integer>> capitalList = new LinkedList<>(hm.entrySet());
 
		Collections.sort(capitalList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		HashMap<String, Integer> result = new HashMap<>();
		for (Map.Entry<String, Integer> entry : capitalList) {
			result.put(entry.getKey(), entry.getValue());
		}
	}
 
	static boolean ispowerof2(long num) {
		if ((num & (num - 1)) == 0)
			return true;
		return false;
	}
 
	static void primeFactors(int n) {
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n /= i;
			}
		}
		if (n > 2)
			System.out.print(n);
	}
 
	static boolean isPrime(long n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
 
		long sq = (long) Math.sqrt(n);
		for (int i = 5; i <= sq; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
 
		return true;
	}
 
	static class Graph {
		HashMap<Integer, LinkedList<Integer>> hm = new HashMap<Integer, LinkedList<Integer>>();
 
		private void addVertex(int vertex) {
			hm.put(vertex, new LinkedList<>());
		}
 
		private void addEdge(int source, int dest, boolean bi) {
			if (!hm.containsKey(source))
				addVertex(source);
			if (!hm.containsKey(dest))
				addVertex(dest);
			hm.get(source).add(dest);
			if (bi) {
				hm.get(dest).add(source);
			}
		}
 
		private boolean uniCycle(int i, HashSet<Integer> visited, int parent) {
			visited.add(i);
			LinkedList<Integer> list = hm.get(i);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				Integer integer = (Integer) it.next();
				if (!visited.contains(integer)) {
					if (uniCycle(integer, visited, i))
						return true;
				} else if (integer != parent) {
					return true;
				}
			}
			return false;
		}
 
		private boolean uniCyclic() {
			HashSet<Integer> visited = new HashSet<Integer>();
			Set<Integer> set = hm.keySet();
			for (Integer integer : set) {
				if (!visited.contains(integer)) {
					if (uniCycle(integer, visited, -1)) {
						return true;
					}
				}
			}
			return false;
		}
 
		private boolean isbiCycle(int i, HashSet<Integer> visited, HashSet<Integer> countered) {
			if (countered.contains(i))
				return true;
			if (visited.contains(i))
				return false;
			visited.add(i);
			countered.add(i);
			LinkedList<Integer> list = hm.get(i);
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				Integer integer = (Integer) it.next();
				if (isbiCycle(integer, visited, countered)) {
					return true;
				}
			}
			countered.remove(i);
			return false;
		}
 
		private boolean isbiCyclic() {
			HashSet<Integer> visited = new HashSet<Integer>();
			HashSet<Integer> countered = new HashSet<Integer>();
			Set<Integer> set = hm.keySet();
			for (Integer integer : set) {
				if (isbiCycle(integer, visited, countered)) {
					return true;
				}
			}
			return false;
		}
	}
 
	static class Node {
		Node left, right;
		int data;
 
		public Node(int data) {
			this.data = data;
		}
 
		public void insert(int val) {
			if (val <= data) {
				if (left == null) {
					left = new Node(val);
				} else {
					left.insert(val);
				}
			} else {
				if (right == null) {
					right = new Node(val);
				} else {
					right.insert(val);
				}
			}
		}
 
		public boolean contains(int val) {
			if (data == val) {
				return true;
			} else if (val < data) {
				if (left == null) {
					return false;
				} else {
					return left.contains(val);
				}
			} else {
				if (right == null) {
					return false;
				} else {
					return right.contains(val);
				}
			}
		}
 
		public void inorder() {
			if (left != null) {
				left.inorder();
			}
			System.out.print(data + " ");
			if (right != null) {
				right.inorder();
			}
		}
 
		public int maxDepth() {
			if (left == null)
				return 0;
			if (right == null)
				return 0;
			else {
				int ll = left.maxDepth();
				int rr = right.maxDepth();
				if (ll > rr)
					return (ll + 1);
				else
					return (rr + 1);
			}
		}
 
		public int countNodes() {
			if (left == null)
				return 1;
			if (right == null)
				return 1;
			else {
				return left.countNodes() + right.countNodes() + 1;
			}
		}
 
		public void preorder() {
			System.out.print(data + " ");
			if (left != null) {
				left.inorder();
			}
 
			if (right != null) {
				right.inorder();
			}
 
		}
 
		public void postorder() {
			if (left != null) {
				left.inorder();
			}
 
			if (right != null) {
				right.inorder();
			}
			System.out.print(data + " ");
 
		}
 
		public void levelorder(Node node) {
			LinkedList<Node> ll = new LinkedList<Node>();
			ll.add(node);
			getorder(ll);
 
		}
 
		public void getorder(LinkedList<Node> ll) {
			while (!ll.isEmpty()) {
				Node node = ll.poll();
				System.out.print(node.data + " ");
				if (node.left != null)
					ll.add(node.left);
				if (node.right != null)
					ll.add(node.right);
			}
		}
	}
 
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
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
 
	static class Pair {
		int first, second;
 
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
 
	}
 
	static class Pair2 {
		int first;
		Pair second;
 
		public Pair2(int first, Pair second) {
			this.first = first;
			this.second = second;
		}
 
	}
 
	static class LongPair {
		long first, second;
 
		public LongPair(long first, long second) {
			this.first = first;
			this.second = second;
		}
 
	}
 
	static class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
 
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
 
		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}
 
		public void close() {
			writer.close();
		}
 
		public void flush() {
			writer.flush();
		}
 
	}
 
	private static final Scanner sc = new Scanner(System.in);
	private static final FastReader fs = new FastReader();
	private static final OutputWriter op = new OutputWriter(System.out);
 
	static int[] getintarray(int n) {
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = fs.nextInt();
		}
		return ar;
	}
 
	static long[] getlongarray(int n) {
		long ar[] = new long[n];
		for (int i = 0; i < n; i++) {
			ar[i] = fs.nextLong();
		}
		return ar;
	}
 
	static int[][] get2darray(int n, int m) {
		int ar[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ar[i][j] = fs.nextInt();
			}
		}
		return ar;
	}
 
	static Pair[] getpairarray(int n) {
		Pair ar[] = new Pair[n];
		for (int i = 0; i < n; i++) {
			ar[i] = new Pair(fs.nextInt(), fs.nextInt());
		}
		return ar;
	}
 
	static void printarray(int ar[]) {
		for (int i : ar) {
			op.print(i + " ");
		}
		op.flush();
	}
 
	static int fact(int n) {
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
 
//	
 
	// function to find largest prime factor
 
}