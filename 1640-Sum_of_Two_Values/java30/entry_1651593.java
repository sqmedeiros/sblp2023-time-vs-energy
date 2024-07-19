import java.util.*;
import java.io.*;
 
public class entry_1651593 {
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		long X = Long.parseLong(str.nextToken());
		str = new StringTokenizer(br.readLine());
		
		long[][] arr = new long[N][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = Long.parseLong(str.nextToken());
			arr[i][1] = i+1;
		}
		br.close();
		Arrays.sort(arr, (a,b)->(int)(a[0]-b[0]));
		int p1 = 0, p2 = N-1;
		while(p1 < p2) {
			if(arr[p1][0] + arr[p2][0] == X) {
				System.out.println(arr[p1][1] + " " + arr[p2][1]);
				p1 = -1;
				break;
			} else if (arr[p1][0] + arr[p2][0] < X)
				p1++;
			else
				p2--;
		}
		if(p1 != -1)
			System.out.println("IMPOSSIBLE");
	}
 
}
