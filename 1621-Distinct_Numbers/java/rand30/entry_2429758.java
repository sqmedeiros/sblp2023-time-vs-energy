import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class entry_2429758 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> uniqueNumbers = new HashSet<>(n);
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < n; i++) {
                uniqueNumbers.add(Integer.parseInt(st.nextToken()));
            }
            
            br.close();
            System.out.println(uniqueNumbers.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}