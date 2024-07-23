import java.io.*;
import java.util.*;
 
public class entry_1472747 {
//	ArrayList<Node> all_nodes=new ArrayList<>();
//	
//	public void add_neighbour(Node a, Node b) {
//		a.neighbours.add(b);
//		b.neighbours.add(a);
//	}
//	
//	public void dfs(Node root) {
//		if(root.Visited)
//			return;
//		root.Visited=true;
//		System.out.println(root.index);
//		for(Node i: root.neighbours) {
//			if(!i.Visited)
//				dfs(i);
//		}
//		
//	}
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		Scanner sc=new Scanner(System.in);
		entry_1472747 obj=new entry_1472747();
		
		int n=sc.nextInt();
		int x=sc.nextInt();
		
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		long dp[]=new long[x+1];
		
		dp[0]=0;
		
		for(int i=1;i<=x;i++) {
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(i-arr[j]>=0)
					dp[i]=Math.min(dp[i],1+dp[i-arr[j]]);
			}
		}
		if(dp[x]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[x]);
		
		
			
	}
 
}
class Node{
	
	ArrayList<Node> neighbours;
	boolean Visited=false;
	int index=0;
	
	public Node(int i){
		this.index=i;
		this.neighbours=new ArrayList<>();
	}
	
	
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
 
