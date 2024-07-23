import java.math.BigInteger;
import java.util.*;
public class entry_1086749 {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		BigInteger n=new BigInteger(sc.nextLine());
		String x=sc.nextLine();
		String arr[]=x.split(" ");
	    HashSet<String> set=new HashSet(Arrays.asList(arr));
	    System.out.println(set.size());
	  	}
 
}