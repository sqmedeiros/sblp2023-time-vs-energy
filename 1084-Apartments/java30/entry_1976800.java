import java.io.*;
import java.util.*;
public class entry_1976800 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        int rslt = 0;
        PriorityQueue<Integer> desiredSize = new PriorityQueue<Integer>();
        PriorityQueue<Integer> apartmentSize = new PriorityQueue<Integer>();
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++)
            desiredSize.add(Integer.parseInt(st.nextToken())); //45, 60, 60, 80
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i ++)
            apartmentSize.add(Integer.parseInt(st.nextToken())); //30, 60, 75
 
        while (!apartmentSize.isEmpty() && !desiredSize.isEmpty()) {
 
                int size = apartmentSize.peek();
                int need = desiredSize.peek();
 
                if (size + k >= need && size - k <= need) {
                    rslt ++;
                    apartmentSize.poll();
                    desiredSize.poll();
                }
                else if (size - k > need) desiredSize.poll(); //apartment too big
                else if (size + k < need) apartmentSize.poll(); //apartment too small
        }
        System.out.println(rslt);
    }
}