import java.util.*;
import java.io.*;
 
class entry_345998 {
	static FastReader fr=new FastReader();
	static PrintWriter fw= new PrintWriter(new BufferedOutputStream(System.out));
	
	static void solve() throws Exception{
		long r=fr.nextLong();
		long c=fr.nextLong();
		if (r>=c){
			if ((r&1)==1) fw.println((r-1)*(r-1)+c);
			else fw.println(r*r-c+1);
		}
		else{
			if ((c&1)==1) fw.println(c*c-r+1);
			else fw.println((c-1)*(c-1)+r);
		}
	}
	
	public static void main(String args[]) throws Exception
    {
		long t= fr.nextLong();		
		while (t-->0) solve();	
		fw.close();
    }  
	
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
		String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}