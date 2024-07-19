import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class entry_833138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        PriorityQueue<Integer> buy = new PriorityQueue<>();
        PriorityQueue<Integer> sell = new PriorityQueue<>();
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            buy.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sell.add(Integer.parseInt(st.nextToken()));
        }
        br.close();
 
        int ct = 0;
        while(!sell.isEmpty() && !buy.isEmpty()) {
            if((sell.peek()>=buy.peek()-k)&&(sell.peek()<=buy.peek()+k)) {
                ct++;
                sell.poll();
                buy.poll();
            }
            else if(sell.peek()>(buy.peek()+k)) {
                buy.poll();
            }
            else if(sell.peek()<(buy.peek()-k)){
                sell.poll();
            }
        }
 
        pw.println(ct);
        pw.close();
    }
}