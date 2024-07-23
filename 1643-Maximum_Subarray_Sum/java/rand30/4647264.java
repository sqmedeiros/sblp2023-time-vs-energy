import java.io.*; import java.util.*; 
public class entry_4647264
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.MAX_VALUE;
		long ans = Long.MIN_VALUE;
		long sum = 0;
		for(int i=0; i<n; i++){
		    sum+=Integer.parseInt(st.nextToken());
		    if(i!=0){
		        ans=Math.max(Math.max(ans, sum-min), sum);
		    }
		    else{
		        ans=Math.max(ans, sum);
		    }
		    min=Math.min(sum, min);
		}
		pw.println(ans);
		pw.close();
	}
}
