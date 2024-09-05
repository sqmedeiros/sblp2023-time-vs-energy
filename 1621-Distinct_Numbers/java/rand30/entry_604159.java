import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class entry_604159
{
    static int N;
    static ArrayList<Integer> numbers;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> set = new HashSet<>(numbers);
        System.out.println(set.size());
    }
}
