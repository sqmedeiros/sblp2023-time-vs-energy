import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
 
 
public class entry_3974493 {
 
		static BufferedWriter output = new BufferedWriter(
	            new OutputStreamWriter(System.out));
		static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		static int mod = 998244353;
		static String toReturn = "";
 
		static int steps = Integer.MAX_VALUE;
		static int maxlen = 1000005;
		
		
		
		/*MATHEMATICS FUNCTIONS START HERE
		MATHS
		MATHS
		MATHS
		MATHS*/
		static long gcd(long a, long b) {
			if(b == 0) return a;
			else return gcd(b, a % b);
		}
 
		static long powerMod(long x, long y, int mod) {
			if(y == 0) return 1;
			long temp = powerMod(x, y / 2, mod);
			temp = ((temp % mod) * (temp % mod)) % mod;
			if(y % 2 == 0) return temp;
			else return ((x % mod) * (temp % mod)) % mod;
		}
		
		static long modInverse(long n, int p) {
			return powerMod(n, p - 2, p);
		}
		
		static long nCr(int n, int r, int mod, long [] fact, long [] ifact) {
			return ((fact[n] % mod) * ((ifact[r] * ifact[n - r]) % mod)) % mod;
		}
		
		static boolean isPrime(long a) {
			if(a == 1) return false;
			else if(a == 2 || a == 3 || a== 5) return true;
			else if(a % 2 == 0 || a % 3 == 0) return false;
			for(int i = 5; i * i <= a; i = i + 6) {
				if(a % i == 0 || a % (i + 2) == 0) return false;
			}
			return true;
		}
		static int [] seive(int a) {
			int [] toReturn = new int [a + 1];
			for(int i = 0; i < a; i++) toReturn[i] = 1;
			toReturn[0] = 0;
			toReturn[1] = 0;
			toReturn[2] = 1;
			for(int i = 2; i * i <= a; i++) {
				if(toReturn[i] == 0) continue;
				for(int j = 2 * i; j <= a; j += i) toReturn[j] = 0;
			}
			return toReturn;
		}
		static long [] fact(int a) {
			long [] arr = new long[a + 1];
			arr[0] = 1;
			for(int i = 1; i < a + 1; i++) {
				arr[i] = (arr[i - 1] * i) % mod;
			}
			return arr;
		}
		/*MATHS
		MATHS
		MATHS
		MATHS
		MATHEMATICS FUNCTIONS END HERE */
		
		/*SWAP FUNCTION START HERE
		  SWAP
		  SWAP
		  SWAP
		  SWAP
		 */
		static void swap(int i, int j, int [] arr) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		static void swap(int i, int j, String [] arr) {
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		static void swap(int i, int j, char [] arr) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		/*SWAP
		  SWAP
		  SWAP
		  SWAP
		 SWAP FUNCTION END HERE*/
		
		
		
		/*BINARY SEARCH METHODS START HERE
		 * BINARY SEARCH
		 * BINARY SEARCH
		 * BINARY SEARCH
		 * BINARY SEARCH
		 */
		static boolean BinaryCheck(long test, long [] arr, long health) {
			for(int i = 0; i <= arr.length - 1; i++) {
				if(i == arr.length - 1) health -= test;
				else if(arr[i + 1] - arr[i] > test) {
					health = health - test;
				}else {
					health = health - (arr[i + 1] - arr[i]);
				}
				if(health <= 0) return true;
			}
			return false;
		}
		
		static long binarySearchModified(long start1, long n, ArrayList<Long> arr, int a, long r) {
			long start = start1, end = n, ans = -1;
			while(start < end) {
				long mid = (start + end) / 2;
				//System.out.println(mid);
				if(arr.get((int)mid) + arr.get(a) <= r && mid != start1) {
					ans = mid;
					start = mid + 1;
				}else{
					end = mid;
				}
			}
			//System.out.println();
			return ans;
		}
		static int binarySearch(int start, int end, long [] arr, long val) {
			
			while(start < end) {
				
				int mid = (int)Math.ceil((start + end) / 2.0);
				//System.out.println(mid);
				if(arr[mid] > val) end = mid - 1;
				else start = mid;
			}
			return start;
		}
		/*BINARY SEARCH
		 * BINARY SEARCH
		 * BINARY SEARCH
		 * BINARY SEARCH
		 * BINARY SEARCH
		 BINARY SEARCH METHODS END HERE*/
		
		
		/*RECURSIVE FUNCTION START HERE
		 * RECURSIVE
		 * RECURSIVE
		 * RECURSIVE
		 * RECURSIVE
		 */
		
		static int recurse(int x, int y, int n, int steps1, Integer [][] dp) {
			if(x > n || y > n) return 0;
			if(dp[x][y] != null) {
				return dp[x][y];
			}
			else if(x == n || y == n) {
				
				return steps1;
			}
			
			return dp[x][y] = Math.max(recurse(x + y, y, n, steps1 + 1, dp), recurse(x, x + y, n, steps1 + 1, dp));
		}
		/*RECURSIVE
		 * RECURSIVE
		 * RECURSIVE
		 * RECURSIVE
		 * RECURSIVE
		 RECURSIVE FUNCTION END HERE*/
		
		/*GRAPH FUNCTIONS START HERE
		 * GRAPH
		 * GRAPH
		 * GRAPH
		 * GRAPH
		 * */
		static class edge{
			int from, to;
			long weight;
			public edge(int x, int y, long weight2) {
				this.from = x;
				this.to = y;
				this.weight = weight2;
			}
		}
		static class sort implements Comparator<pair>{
 
			
			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				if(o1.a > o2.a) return 1;
				if(o1.a == o2.a) return 0;
				else return -1;
			}
			
		}
		static void addEdge(ArrayList<ArrayList<edge>> graph, int from, int to, long weight) {
			edge temp = new edge(from, to, weight);
			edge temp1 = new edge(to, from, weight);
			graph.get(from).add(temp);
			//graph.get(to).add(temp1);
		}
		static int ans = 0;
		
		static void dfs(ArrayList<ArrayList<edge>> graph, int vertex, boolean [] visited, int dest) {
			//System.out.println(graph.get(vertex).size());
			if(ans == 2) return;
			if(vertex == dest) {
				ans++;
				return;
			}
			if(visited[vertex]) return;
			visited[vertex] = true;
			
			for(int i = 0; i < graph.get(vertex).size(); i++) {
				edge temp = graph.get(vertex).get(i);
				if(!visited[temp.to]) {
					//System.out.println(temp.to);
					//toReturn[(int) temp.weight] = weight;
					dfs(graph, temp.to, visited, dest);
					//weight = 5 - weight;
 
				}
			}
		}
		static void bfs(ArrayList<ArrayList<edge>> graph, int vertex, boolean [] visited, int [] toReturn, Queue<Integer> q, int weight) {
			if(visited[vertex]) return;
			visited[vertex] = true;
			if(graph.get(vertex).size() > 2) return;
			int first = weight;
			for(int i = 0; i < graph.get(vertex).size(); i++) {
				edge temp = graph.get(vertex).get(i);
				if(!visited[temp.to]) {
					q.add(temp.to);
					toReturn[(int) temp.weight] = weight;
					weight = 5 - weight;
				}
			}
			if(!q.isEmpty())bfs(graph, q.poll(), visited, toReturn, q, 5 - first);
		}
		
		static void topoSort(ArrayList<ArrayList<Integer>> graph, int vertex, boolean [] visited, ArrayList<Integer> toReturn) {
			if(visited[vertex]) return;
			visited[vertex] = true;
			for(int i = 0; i < graph.get(vertex).size(); i++) {
				if(!visited[graph.get(vertex).get(i)]) topoSort(graph, graph.get(vertex).get(i), visited, toReturn);
			}
			toReturn.add(vertex);
		}
		static boolean isCyclicDirected(ArrayList<ArrayList<Integer>> graph, int vertex, boolean [] visited, boolean [] reStack) {
			if(reStack[vertex]) return true;
			if(visited[vertex]) return false;
			reStack[vertex] = true;
			visited[vertex] = true;
			
			for(int i = 0; i < graph.get(vertex).size(); i++) {
				if(isCyclicDirected(graph, graph.get(vertex).get(i), visited, reStack)) return true;
			}
			reStack[vertex] = false;
			return false;
		}
		static int e = 0;
		static long mst(PriorityQueue<edge> pq, int nodes) {
			long weight = 0;
			while(!pq.isEmpty()) {
				edge temp = pq.poll();
				int x = parent(parent, temp.to);
				int y =  parent(parent, temp.from);
				if(x != y) {
					//System.out.println(temp.weight);
					union(x, y, rank, parent);
					weight += temp.weight;
					e++;
				}
			}
			return weight;
		}
		static void floyd(long [][] dist) { // to find min distance between two nodes
			for(int k = 0; k < dist.length; k++) {
				for(int i = 0; i < dist.length; i++) {
					for(int j = 0; j < dist.length; j++) {
						if(dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
		}
		static void dijkstra(ArrayList<ArrayList<edge>> graph, long [] dist, int src) {
			for(int i = 0; i < dist.length; i++) dist[i] = Long.MAX_VALUE / 2;
			dist[src] = 0;
			boolean visited[] = new boolean[dist.length];
			PriorityQueue<pair> pq = new PriorityQueue<>(new sort());
			pq.add(new pair(src, 0));
			while(!pq.isEmpty()) {
				pair temp = pq.poll();
				
				int index = (int)temp.a;
				for(int i = 0; i < graph.get(index).size(); i++) {
					if(dist[graph.get(index).get(i).to] > dist[index] + graph.get(index).get(i).weight) {
						dist[graph.get(index).get(i).to] = dist[index] + graph.get(index).get(i).weight;
						pq.add(new pair(graph.get(index).get(i).to, graph.get(index).get(i).weight));
					}
					
				}
			}
		}
		static int parent1 = -1;
		static boolean ford(ArrayList<ArrayList<edge>> graph1, ArrayList<edge> graph, long [] dist, int src, int [] parent) {
			for(int i = 0; i < dist.length; i++) dist[i] = Long.MIN_VALUE / 2;
			dist[src] = 0;
			boolean hasNeg = false;
			for(int i = 0; i < dist.length - 1; i++) {
				for(int j = 0; j < graph.size(); j++) {
					int from = graph.get(j).from;
					int to = graph.get(j).to;
					long weight = graph.get(j).weight;
					if(dist[to] < dist[from] + weight) {
						dist[to] = dist[from] + weight;
						parent[to] = from;
					}
				}
			}
			for(int i = 0; i < graph.size(); i++) {
				int from = graph.get(i).from;
				int to = graph.get(i).to;
				long weight = graph.get(i).weight;
				if(dist[to] < dist[from] + weight) {
					parent1 = from;
					hasNeg = true;
					dfs(graph1, parent1, new boolean[dist.length], dist.length - 1);
					//System.out.println(ans);
					dfs(graph1, 0, new boolean[dist.length], parent1);
					//System.out.println(ans);
					if(ans == 2) break;
					else ans = 0;
					
				}
			}
			return hasNeg;
		}
		/*GRAPH FUNCTIONS END HERE
		 * GRAPH
		 * GRAPH
		 * GRAPH
		 * GRAPH
		 */
		/*disjoint Set START HERE
		 * disjoint Set
		 * disjoint Set
		 * disjoint Set
		 * disjoint Set
		 */
		static int [] rank;
		static int [] parent;
		static int parent(int [] parent, int x) {
			if(parent[x] == x) return x;
			else return parent[x] = parent(parent, parent[x]);
		}
		static boolean union(int x, int y, int [] rank, int [] parent) {
			if(parent(parent, x) == parent(parent, y)) {
				return true;
			}
			if(rank[x] > rank[y]) {
				swap(x, y, rank);
			}
			rank[x] += rank[y];
			parent[y] = x;
			return false;
		}
		/*disjoint Set END HERE
		 * disjoint Set
		 * disjoint Set
		 * disjoint Set
		 * disjoint Set
		 */
		
		
		/*INPUT START HERE
		 * INPUT
		 * INPUT
		 * INPUT
		 * INPUT
		 * INPUT
		 */
		
		static int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(sc.readLine());
		}
		static long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(sc.readLine());
		}
		static long [] inputLongArr() throws NumberFormatException, IOException{
			String [] s = sc.readLine().split(" ");
			long [] toReturn = new long[s.length];
			for(int i = 0; i < s.length; i++) {
				toReturn[i] = Long.parseLong(s[i]);
			}
			return toReturn;
		}
		static int max = 0;
		static int [] inputIntArr() throws NumberFormatException, IOException{
			String [] s = sc.readLine().split(" ");
			
			//System.out.println(s.length);
			int [] toReturn = new int[s.length];
		
			for(int i = 0; i < s.length; i++) {
				toReturn[i] = Integer.parseInt(s[i]);
			}
			return toReturn;
		}
		static void print(int n) throws IOException {
			
			output.write(Integer.toString(n) + "\n");
			output.flush();
			
		}
		static void print(String s) throws IOException {
					
					output.write(s + "\n");
					output.flush();
					
				}
		static void print(long n) throws IOException {
			
			output.write(Long.toString(n) + "\n");
			output.flush();
			
		}
		static void print(char n) throws IOException {
			
			output.write(Long.toString(n) + "\n");
			output.flush();
		}
		/*INPUT
		 * INPUT
		 * INPUT
		 * INPUT
		 * INPUT
		 * INPUT END HERE
		 */
		static long [] preCompute(int level) {
			long [] toReturn = new long[level];
			toReturn[0] = 1;
			toReturn[1] = 16;
			for(int i = 2; i < level; i++) {
				toReturn[i] = ((toReturn[i - 1] % mod) * (toReturn[i - 1] % mod)) % mod;
			}
			return toReturn;
		}
		static class pair{
			long a; 
			long b;
			public pair(long in, long y) {
				this.a = in;
				this.b = y;
			}
		}
		
		static long smallestFactor(long a) {
			for(long i = 2; i * i <= a; i++) {
				if(a % i == 0) {
					return i;
				}
			}
			return a;
		}
		static int recurseRow(int [][] mat, int i, int j, int prev, int ans) {
			if(j >= mat[0].length) return ans;
			if(mat[i][j] == prev) {
				return recurseRow(mat, i, j + 1, prev, ans + 1);
			}
			else return ans;
		}
		static int recurseCol(int [][] mat, int i, int j, int prev, int ans) {
			if(i >= mat.length) return ans;
			if(mat[i][j] == prev) {
				return recurseCol(mat, i + 1, j, prev, ans + 1);
			}
			else return ans;
		}
		static int diff(char [] a, char [] b) {
			int sum = 0;
			for(int i = 0; i < a.length; i++) {
				sum += Math.abs((int)a[i] - (int)b[i]);
			}
			return sum;
		}
		
		
		static int [] nextGreaterBack(char [] s) {
			Stack<Integer> stack = new Stack<>();
			int [] toReturn = new int[s.length];
			for(int i = 0; i < s.length; i++) {
				if(!stack.isEmpty() && s[stack.peek()] >= s[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					stack.push(i);
					toReturn[i] = -1;
				}else {
					toReturn[i] = stack.peek();
					stack.push(i);
				}
			}
			return toReturn;
		}
		static int [] nextGreaterFront(char [] s) {
			Stack<Integer> stack = new Stack<>();
			int [] toReturn = new int[s.length];
			for(int i = s.length - 1; i >= 0; i--) {
				if(!stack.isEmpty() && s[stack.peek()] >= s[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					stack.push(i);
					toReturn[i] = -1;
				}else {
					toReturn[i] = stack.peek();
					stack.push(i);
				}
			}
			return toReturn;
		}
		static int lps(String s) {
			int max = 0;
			int [] lps = new int[s.length()];
			lps[0] = 0;
			int j = 0;
			for(int i = 1; i < lps.length; i++) {
				j = lps[i - 1];
				while(j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j - 1];
				if(s.charAt(i) == s.charAt(j)) {
					lps[i] = j + 1;
					max = Math.max(max, lps[i]);
				}
			}
			return max;
		}
		
		static int [][] vectors = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		static String dir = "DRUL";
		static boolean check(int i, int j, boolean [][] visited) {
			if(i >= visited.length || j >= visited[0].length) return false;
			if(i < 0 || j < 0) return false;
			return true;
		}
		static int count = 0;
		static void recurse(boolean [][] visited, int i, int j, String p, int z, Integer [][][] dp) throws IOException {
			
			if(p.length() == z) {
				//System.out.println(i + " " + j);
				if(i == visited.length - 1 && j == 0) {
					count++;
					return;
				}else return;
			}
			if(i == visited.length - 1 && j == 0) {
				return;
			}
			if(visited[i][j]) return;
			visited[i][j] = true;
			for(int k = 0; k < vectors.length; k++) {
				int x = i + vectors[k][0], y = j + vectors[k][1];
				char toAdd = dir.charAt(k);
				if(p.charAt(z) == '?' || p.charAt(z) == toAdd) {
					if(check(x, y, visited) && !visited[x][y]) {
						
						//recurse(visited, x, y, p, z + 1);
						
					}
				}
			}
			visited[i][j] = false;
			
		}
		
		static void solve() throws IOException {
			
			int n = nextInt();
			long [] arr = inputLongArr();
			
			long maxSub = 0;
			long maxTill = 0;
			long max = Long.MIN_VALUE;
			for(int i = 0; i < arr.length; i++) {
				maxTill += arr[i];
				maxSub = Math.max(maxSub, maxTill);
				if(maxTill < 0) maxTill = 0;
				max = Math.max(max, arr[i]);
			}
			if(max != Long.MIN_VALUE && maxSub == 0) {
				if(max == 0) print(maxSub);
				else print(max);
				return;
			}
			print(maxSub);
		}
		
		
 
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			//int t = Integer.parseInt(sc.readLine()); for(int i = 0; i < t; i++) 
			  solve();
		}
 
	}
/*
1
10
6 10 7 9 11 99 45 20 88 31
 */
 
