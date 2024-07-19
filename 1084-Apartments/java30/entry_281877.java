import java.io.*;
import java.util.*;
 
import org.xml.sax.HandlerBase;
 
public class entry_281877 {
 
 
	public static void main(String[] args) throws Exception{
 
		BufferedReader  jk =  new BufferedReader(new InputStreamReader( System.in))  ; 
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)) ; 
		StringTokenizer ana = new StringTokenizer(jk.readLine()) ; 
		int n = Integer.parseInt(ana.nextToken()) ;
		int m = Integer.parseInt(ana.nextToken()) ; 
		int k = Integer.parseInt(ana.nextToken() );
		ana = new StringTokenizer(jk.readLine()) ; 
		ArrayList<Integer> applicants = new ArrayList<>() ; 
		ArrayList<Integer> appartements = new ArrayList<>() ; 
		for(int i=0 ;i<n ;i++)
		{
			applicants.add(Integer.parseInt(ana.nextToken())) ; 
		}
		ana = new StringTokenizer(jk.readLine()) ; 
		for(int i=0 ;i<m;i++)
		{
			appartements.add(Integer.parseInt(ana.nextToken())) ; 
		}
		Collections.sort(applicants);
		Collections.sort(appartements);
		int i=0 ; int j=0 ; int res = 0 ;
		while(i<n && j<m)
		{
			int appli = applicants.get(i) ; int app = appartements.get(j) ;
			int lb = appli-k ; int ub = appli+k ;
			if(app<lb) j++ ; 
			else if(app>ub) i++;
			else
			{
				res++ ; i++ ; j++ ; 
			}
		}
		out.println(res);
		out.flush();
	}
}
 
 
 