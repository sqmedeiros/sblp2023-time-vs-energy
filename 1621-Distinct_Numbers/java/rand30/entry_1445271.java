import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
 
public class entry_1445271 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
//        int n = scanner.nextInt();
        int n = Integer.parseInt(reader.readLine().trim());
        HashSet<String> set = new HashSet<>();
        int count = 0;
 
        String[] nums = reader.readLine().trim().split(" ");
        for (String i : nums) {
//            int c = scanner.nextInt();
            if(set.contains(i)) {
                continue;
            }
 
            set.add(i);
            count++;
        }
 
        System.out.println(count);
    }
}