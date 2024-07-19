import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class entry_3597590 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
 
        String str1[] = br.readLine().split(" ");
        String str2[] = br.readLine().split(" ");
 
        PriorityQueue<Integer> applicants = new PriorityQueue<>(n);
        PriorityQueue<Integer> apartments = new PriorityQueue<>(m);
 
 
        for (int i = 0; i < n; i++) {
            applicants.add(Integer.parseInt(str1[i]));
        }
 
        for (int i = 0; i < m; i++) {
            apartments.add(Integer.parseInt(str2[i]));
        }
 
 
        int ans = 0;
 
        // two pointers
 
        while(!applicants.isEmpty() && !apartments.isEmpty()){
            if(Math.abs(applicants.peek()-apartments.peek())<=k){
                ans++;
                applicants.poll();
                apartments.poll();
            }
            else if(applicants.peek()>apartments.peek()){
                apartments.poll();
            }
            else{
                applicants.poll();
            }
        }
 
        System.out.println(ans);
    }
}