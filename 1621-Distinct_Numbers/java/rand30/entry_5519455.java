import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class entry_5519455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] list = br.readLine().split(" ");
        Set<Integer> l = new HashSet<>();
        for(String x : list){
            l.add(Integer.parseInt(x));
        }
        System.out.println(l.size());
    }
}