import java.util.*;
import java.io.*;
 
public class entry_3514129 {
	static BufferedReader in;
    static int n;
 
    public static void main(String[] args) throws IOException {
 
        in = new BufferedReader(new InputStreamReader(System.in));
        init();
        in.close();
    }
 
    static void init() throws IOException {
    	n = Integer.parseInt(in.readLine());
    	HashSet<Integer> set = new HashSet<Integer>();
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	for (int i = 0; i < n; i++)
    	{
    		set.add(Integer.parseInt(st.nextToken()));
    	}
    	System.out.println(set.size());
    }
}