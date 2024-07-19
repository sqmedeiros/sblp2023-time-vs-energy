import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class entry_3696497 {
    static final int mod = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c[] = new int[n+1];
        int n_w[] = new int[x+1];
        n_w[0] = 1;
        for(int i=1;i<=n;i++)
            c[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=x;i++){
            for(int j:c){
                if(i-j >= 0){
                    n_w[i] += n_w[i-j];
                    n_w[i]%=mod;
                }
            }
        }       
        System.out.println(n_w[x]);
 
    }
}