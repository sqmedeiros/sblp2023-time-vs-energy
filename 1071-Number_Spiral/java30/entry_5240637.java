import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
/**
 * Number Spiral
 * 
 * @author Sravani
 * 
 *         A number spiral is an infinite grid whose upper-left square has
 *         number 1. Here are the first five layers of the spiral:
 *         
 * 
 *         Your task is to find out the number in row y and column x.
 * 
 *         Input
 * 
 *         The first input line contains an integer t: the number of tests.
 * 
 *         After this, there are t lines, each containing integers y and x.
 * 
 *         Output
 * 
 *         For each test, print the number in row y and column x.
 *         
 *         
 *         Solution :------  Observe the patter in the grid its like
 *         1. for every odd no of x it is square and fover evey even no of y it is square
 *         2. so for every odd no of x and x > y  r = x2-y+1
 *         3. for every even no of y and y>=x   r = y2-x+1
 *         4. for remaining that means even no of x and x > y r= (x-1)*(x-1)+y and
 *            for odd no of y and y>x   r = (y-1)*(y-1)+x
 * 
 */
public class entry_5240637 {
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		long y,x;
		
		for(int i=0;i<t;i++) {
			String sb = br.readLine();
			StringTokenizer st = new StringTokenizer(sb, " ");
			y  = Integer.parseInt(st.nextToken());
			x =  Integer.parseInt(st.nextToken());
			
			if(x>y) {
				if(x%2 == 1)
					writer.println(x*x-y+1);
				else {
					x--;
					writer.println(x*x+y);
				}
			} else
			{
				if(y%2 == 0)
					writer.println(y*y-x+1);
				else
				{
					y--;
					writer.println(y*y+x);
				}
					
					
			}
			
			
		}
		writer.flush();
		
	}
 
}