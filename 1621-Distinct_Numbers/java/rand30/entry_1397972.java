import java.util.*;
import java.lang.*;
import java.io.*;
 
/**
 * Coding
 */
public class entry_1397972 {
    static int counter;
    public static void main (String args[]) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            
            String[] line = br.readLine().trim().split("\\s+");
            for (String s : line) {
                set.add(Integer.parseInt(s));
            }
 
            System.out.println(set.size());
        } catch (Exception e) {
            return;
        }
    }
}