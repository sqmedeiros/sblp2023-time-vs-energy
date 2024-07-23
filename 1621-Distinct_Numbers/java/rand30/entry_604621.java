import java.io.*;
import java.util.*;
 
public class entry_604621 {
	public static class cell implements Comparable <cell>{
		long val;
		int pos;
		
		public cell(int v, int p) {
			val = v;
			pos = p;
		}
		
		public int compareTo(cell x) {
			return Long.compare(val, x.val);
		}
	}
	public static void main(String args[]) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		long x = in.nextInt();
		cell[] arr = new cell[n];
		if (n <= 2) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		/*
23
82
4493
		 */
		for (int i = 0; i < n; i++) {
			arr[i] = new cell(in.nextInt(), i + 1);
		}
		
		Arrays.sort(arr);
	
		boolean found = false;
		
		for (int i = 0; i < n && !found; i++) {
			for (int j = i + 1; j < n && !found; j++) {
				long target = x - (arr[i].val + arr[j].val);
				int p1 = j + 1;
				int p2 = n - 1;
				while (p1 < p2 && !found) {
					if (arr[p1].val + arr[p2].val  == target) {
						found = true;
						System.out.println(arr[i].pos + " " + arr[j].pos + " " + arr[p1].pos + " " + arr[p2].pos);
					}
					else if (arr[p1].val + arr[p2].val  <= target){
						p1++;
					}
					else
						p2--;
				}
			}
		}
		
		
		if (!found)
			System.out.println("IMPOSSIBLE");
	}
    
    public static void shuffle(int[] arr) {
    	Random rgen = new Random();
    	
    	for (int i = 0; i < arr.length; i++) {
    		int rPos = rgen.nextInt(arr.length);
    		int temp = arr[i];
    		arr[i] = arr[rPos];
    		arr[rPos]=temp;
    	}
    }
 
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
 
        int nextInt() {
            return Integer.parseInt(nextToken());
        }
 
        long nextLong() {
            return Long.parseLong(nextToken());
        }
 
        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}