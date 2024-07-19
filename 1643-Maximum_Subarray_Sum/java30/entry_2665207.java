import java.io.*;
import java.util.*;
public class entry_2665207 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		long maxSum = Integer.MIN_VALUE;
		long currSum = 0;
		for(int i = 0;i < N;i++) {
			currSum += nums[i];
			maxSum = Math.max(maxSum, currSum);
			if(currSum < 0) {
				currSum = 0;
			}
		}
		
		System.out.println(maxSum);
	}
}
