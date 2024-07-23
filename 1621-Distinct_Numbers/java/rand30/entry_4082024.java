import java.util.*;
import java.io.*;
 
 
public class entry_4082024 {
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(read.readLine());
        
        int count = Integer.parseInt(st.nextToken());
 
        // Read 2nd line
        st = new StringTokenizer(read.readLine());
 
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i =0; i<count; i++) {
            s.add(Integer.parseInt(st.nextToken()));
 
        }
 
        System.out.println(s.size());
 
 
 
 
    }
}