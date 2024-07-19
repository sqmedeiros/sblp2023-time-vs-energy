import java.util.*; 
import java.io.*; 
 
public class entry_4137759 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        long[] psum = new long[N+1];
        for (int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            psum[i+1] = input+psum[i];
        }
        long minVal = psum[0];
        long maxDiff = psum[1]; 
        for (int i=1; i<psum.length; i++){
            if (psum[i]-minVal>maxDiff){
                maxDiff = psum[i]-minVal; 
            }
            if (psum[i]<minVal){
                minVal = psum[i];
            }
        }
        pw.println(maxDiff);
        pw.close();
    }
}
