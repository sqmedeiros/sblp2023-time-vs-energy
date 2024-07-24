import java.util.HashSet;
import java.util.Scanner;
 
public class entry_8855045 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<Integer> dist = new HashSet<Integer>();
        int N = s.nextInt();
        for(int i =0; i < N;i++){
            int v = s.nextInt();
            dist.add(v);
        }
        System.out.println(dist.size());
    }
}