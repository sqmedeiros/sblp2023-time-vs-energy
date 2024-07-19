import java.util.*;
import java.io.*;
 
public class entry_4220897 {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int x = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(in.readLine());
		Number[] numbers = new Number[n];
		for(int i = 0; i < n; i++) {
			Number num = new Number(i, Integer.parseInt(tokenizer.nextToken()));
			numbers[i] = num;
		}
		in.close();
		Arrays.sort(numbers);
		
		PrintWriter out = new PrintWriter(System.out);
		int i = 0;
		int j = n - 1;
		while(i < j) {
			if(numbers[i].value + numbers[j].value < x) {
				i++;
			}
			else if(numbers[i].value + numbers[j].value > x) {
				j--;
			}
			else {
				out.println((Math.min(numbers[i].index, numbers[j].index) + 1) + " " + (Math.max(numbers[i].index, numbers[j].index) + 1));
				out.close();
				return;
			}
		}
		out.println("IMPOSSIBLE");
		out.close();
	}
	
	static class Number implements Comparable<Number> {
		int index;
		int value;
		public Number(int i, int v) {
			index = i;
			value = v;
		}
		public int compareTo(Number n) {
			return value - n.value;
		}
	}
 
}
