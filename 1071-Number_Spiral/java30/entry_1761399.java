import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class entry_1761399 {
 
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        final int n = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder(8 * 1024 * 1024);
 
        for(int i = 0; i < n; i++){
            StringTokenizer line = new StringTokenizer(in.readLine());
            int row = Integer.parseInt(line.nextToken());
            int column = Integer.parseInt(line.nextToken());
            long max = Math.max(row, column);
            long min = Math.min(row, column);
            long upperBound = max * max;
            long lowerBound = ((max - 1) * (max - 1)) + 1;
            long res;
            if((max == row && max % 2 == 0) || (max == column && max % 2 != 0)){
                res = (upperBound - min) + 1;
            }
            else {
                res = (lowerBound + min) - 1;
            }
            builder.append(res);
            builder.append("\n");
        }
        System.out.print(builder);
    }
}