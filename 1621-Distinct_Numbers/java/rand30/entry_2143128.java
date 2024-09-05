import java.io.*;
import java.util.Arrays;
 
public class entry_2143128 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long ans = bf.lines()
                        .skip(1)
                        .limit(1)
                        .flatMap(s -> Arrays.stream(s.split(" ")))
                        .mapToInt(Integer::parseInt)
                        .distinct()
                        .count();
 
        System.out.println(ans);
    }
}
