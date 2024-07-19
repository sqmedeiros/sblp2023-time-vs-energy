// Source: https://usaco.guide/general/io
 
import java.io.*;
import java.util.StringTokenizer;
 
public class entry_3683074 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int times = Integer.parseInt(r.readLine());
		for(int i=0; i<times; i++)
		{
			StringTokenizer st = new StringTokenizer(r.readLine());
			long y = Integer.parseInt(st.nextToken());
			long x = Integer.parseInt(st.nextToken());
			long total;
			if(x==y)
				total=(x-1)*y+1;
			else if(Math.max(x, y)==x&&x%2==0)
				total=(x-1)*(x-1)+y;
			else if(Math.max(x,y)==x&&x%2==1)
				total=x*x-y+1;
			else if(y%2==0)
				total=y*y-x+1;
			else
				total=(y-1)*(y-1)+x;
			pw.println(total);
		}
		pw.close();
	}
}