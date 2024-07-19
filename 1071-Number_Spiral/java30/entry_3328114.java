//package problem1_number_spiral;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class entry_3328114 {
	
	
	static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;
 
		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}
 
		public void print(Object object) throws IOException {
			bw.append("" + object);
		}
 
		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}
 
		public void close() throws IOException {
			bw.close();
		}
	}
	public static void main(String[] args) throws IOException {
		
			
		int testCases = 0;
		FastReader in=new FastReader();
		FastWriter out = new FastWriter();
		testCases = in.nextInt();
		
		while(testCases > 0)
		{
			long row = 0,column = 0;
			//boolean vertical = false;
			//boolean clockwise = false;
			long ans = 0;
			row = in.nextLong();
			column = in.nextLong();
			
			//for any row / column find the number in infinite Number Spiral.
			//long minCoordinate = Math.min(row, column);
			long maxCoordinate = Math.max(row, column);
 
			//depending on co ordinate it is horizontal or vertical 0/1
			//depending on value of max square .... find direction clockwise /anti -clockwise 1/0
			
			if(row < column)
			{
				//vertical = true;
				if(maxCoordinate % 2 == 0)
				{
					//clockwise = true;
					ans = (maxCoordinate-1) * (maxCoordinate-1) + row;
				}
				else
				{
					//clockwise = false;
					ans = (maxCoordinate-1) * (maxCoordinate-1) + 2 * maxCoordinate - row;
				}
				
				
			}
			else if(row > column)
			{
				//vertical = false;
				if(maxCoordinate % 2 == 0)
				{
					//clockwise = true;
					ans = (maxCoordinate-1) * (maxCoordinate-1) + 2 * maxCoordinate - column;
					
				}
				else
				{
					//clockwise = false;
					ans = (maxCoordinate-1) * (maxCoordinate-1) + column;
				}
				
			}
			else
			{
				ans = (maxCoordinate-1) * (maxCoordinate-1) + maxCoordinate;
			}
			
			out.println(ans);
			
			
			
			testCases--;
		}
		out.close();
 
	}
 
}