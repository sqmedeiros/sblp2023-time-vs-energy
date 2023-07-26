import java.io.*;
import java.util.*;
 
public class entry_1409197 {
    static int n, target;
    static int arr [], sort[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int [n];
        sort = new int [n];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sort[i] = arr[i];
        }
        Arrays.sort(sort);
 
        int left = 0;
        int right = n - 1;
        boolean cont = false;
        while (right < n){
            if (left == right) {
                System.out.println("IMPOSSIBLE");
                break;
            }
            int curr = sort[left] + sort[right];
            if (curr == target) {
                cont = true;
                break;
            }
            else if (curr < target) left++;
            else right--;
        }
        if (cont) {
            int a = sort[left];
            int b = sort[right];
            int first = -1;
            for (int i = 0; i < n; i++){
                if (arr[i] == a){
                    System.out.print((i + 1) + " ");
                    first = i;
                    break;
                }
            }
            for (int i = 0; i < n; i++){
                if (arr[i] == b && i != first){
                    System.out.println((i + 1));
                    break;
                }
            }
        }
    }
}
