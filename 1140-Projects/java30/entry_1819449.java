import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class entry_1819449 {
	static class Reader{
		final private int BUFFER_SIZE = 1 << 8;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
		public Reader(){
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		public Reader(String file_name) throws IOException{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
	public String readLine() throws IOException{
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1){
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}
	public int nextInt() throws IOException{
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do{
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
		return -ret;
		return ret;
	}
	public long nextLong() throws IOException{
		long ret = 0;
		byte c = read();
		while (c <= ' ')
		c = read();
		boolean neg = (c == '-');
		if (neg)
		c = read();
		do {
		ret = ret * 10 + c - '0';
		}while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	public double nextDouble() throws IOException{
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
		ret = ret * 10 + c - '0';
		}while ((c = read()) >= '0' && c <= '9');
		if (c == '.'){
			while ((c = read()) >= '0' && c <= '9'){
				ret += (c - '0') / (div *= 10);
			}
		}
		if (neg)
			return -ret;
		return ret;
	}
	private void fillBuffer() throws IOException{
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
		buffer[0] = -1;
	}
	private byte read() throws IOException{
		if (bufferPointer == bytesRead)
		fillBuffer();
		return buffer[bufferPointer++];
	}
	public void close() throws IOException{
		if (din == null)
		return;
		din.close();
	}
}
	static class Project{
		int start,end,reward;
		Project(int start, int end, int reward){
			this.start=start;
			this.end=end;
			this.reward=reward;
		}
	}
	static Reader rs;
	public static void main(String[] args) throws IOException{
		rs=new Reader();
		solve();
		
	}
	public static void solve() throws IOException{
		int n=rs.nextInt();
		Project []projects=new Project[n];
		for(int i=0; i<n; ++i){
			projects[i]=new Project(rs.nextInt(),rs.nextInt(),rs.nextInt());
		}
		Arrays.sort(projects,new Comparator<Project>(){
			@Override
			public int compare(Project p1, Project p2){
				return p1.end-p2.end;
			}
		});
		long dp[]=new long[n+1];
		dp[0]=0;
		for(int i=1; i<=n; ++i){
			int ptr=search(projects, i-1);
			if(ptr!=-1)
			dp[i]=Math.max(dp[i-1],projects[i-1].reward+dp[ptr+1]);
			else
			dp[i]=Math.max(dp[i-1],projects[i-1].reward);
		}
		System.out.println(dp[n]);
	}
	private static int search(Project[] projects, int index){
		
		int lv=0,uv=index-1;
		while(lv<=uv){
			int mid=lv+(uv-lv)/2;
			if(projects[mid].end<projects[index].start){
				if(projects[mid+1].end<projects[index].start)
					lv=mid+1;
				else
					return mid;
			}
			else{
				uv=mid-1;
			}
		}
		return -1;
	}
}