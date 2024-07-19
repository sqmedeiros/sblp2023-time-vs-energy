import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
 
public class entry_2472358 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
 
        int n = in.nextInt();
 
        for(int i = 0; i < n; i++)
            set.add(in.nextInt());
        
            System.out.println(set.size());
    }
}