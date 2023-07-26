import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class entry_5778137 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner obj=new Scanner(System.in);
		String input1[] = obj.nextLine().split(" ");
		int n=Integer.parseInt(input1[0]);
		int x=Integer.parseInt(input1[1]);
		String input2[]=obj.nextLine().split(" ");
		
		Set<Integer> trrObj=new TreeSet<>();
		int num1=0,num2=-1;
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			num1=Integer.parseInt(input2[i]);
			trrObj.add(num1);
			arr[i]=num1;
			
		}
		int i;
		for( i=0;i<n;i++)
		{
		num1=arr[i];
		if(num1>=x)
			continue;
		
		
		if(trrObj.contains(x-arr[i]))
			{num2=x-arr[i];
			int j;
			for(j=n-1;j>=0;j--)
			{
				
			if(arr[j]==num2)
				break;
			
			}
			
			if(i==j)
			{
//				System.out.print("IMPOSSIBLE");
//				return;
				continue;
			}
			
			System.out.print((i+1)+" "+ (j+1));
			return;
			}
			}
		
			System.out.print("IMPOSSIBLE");
			return;
		
 
		
		
		
	}
 
}
