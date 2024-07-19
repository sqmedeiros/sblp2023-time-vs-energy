import java.util.*;
public class entry_4375331
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<Integer> hm = new HashSet();
		for(int i=0;i<n;i++){
		    hm.add(sc.nextInt());
		}
		System.out.println(hm.size());
		
	}
}