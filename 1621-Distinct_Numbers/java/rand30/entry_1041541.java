import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
 
public class entry_1041541 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<Integer, Integer> hp = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			int x = in.nextInt();
			if(hp.containsKey(x))
			{
				hp.put(x, hp.get(x)+1);
			}
			else
			{
				hp.put(x, 1);
			}
		}
		System.out.println(hp.size());
		
 
	}
 
}
