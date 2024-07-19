import java.io.*;
import java.util.StringTokenizer;
 
public class entry_2034667 {
 
	static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out);
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        long n = Long.parseLong(st.nextToken());
 
        while(n > 0) {
            st = new StringTokenizer(r.readLine());
            long row = Long.parseLong(st.nextToken());
            long col = Long.parseLong(st.nextToken());
 
            long diagonal = (Math.max(row, col) * Math.max(row, col)) - Math.max(row, col) + 1;
 
            if(col > row) {
                if(col % 2 == 1) diagonal += col - row;
                else diagonal -= col - row;
            } else {
                if(row % 2 == 1) diagonal -= row - col;
                else diagonal += row - col;               
            }
 
            pw.println(diagonal);
 
            n -= 1;
        }
 
 
        pw.close();
    }
}