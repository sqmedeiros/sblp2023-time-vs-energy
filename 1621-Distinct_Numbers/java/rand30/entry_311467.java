import java.util.*;
 
public class entry_311467
{
 
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		long total = s.nextLong();	
		Set<Long> members = new HashSet<>();
 
		int lim = 0;
		while (lim < total)
		{
			long num = s.nextLong();
			members.add(num);
			lim++;
		}
 
		System.out.println(members.size());
 
		s.close();
	}
 
}
