import java.util.*;
import java.io.*;
public class entry_6044464 {
        public static void main(String[] args) throws IOException {
BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
StringTokenizer st = new StringTokenizer(r.readLine());
int entries = Integer.parseInt(st.nextToken());
st = new StringTokenizer(r.readLine());
HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < entries; i++) {
        int num = Integer.parseInt(st.nextToken());
        set.add(num);
            }
    int counter = 0;
    for(int element:set){
    counter++;
    }
    pw.print(counter);
r.close();
pw.close();
}
}
