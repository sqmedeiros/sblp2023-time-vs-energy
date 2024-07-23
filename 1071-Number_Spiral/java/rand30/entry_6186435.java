 
 import java.util.Scanner;
 
 public class entry_6186435 {
	static Scanner scanner=new Scanner(System.in);
	static long y,x;
	static StringBuilder builder=new StringBuilder();
	
	static int ti(String s) {
		return Integer.parseInt(s);
	}
	
	static void exec() {
		y=ti(scanner.next());
		x=ti(scanner.next());
		
		long max=Math.max(x, y);
		long min=Math.min(x, y);
		long diff=max-min;
		
		long c=max*max-max+1;
		
		if((max&1)==0 && y==min || (max&1)==1 && x==min)
			builder.append(c-diff);
		else
			builder.append(c+diff);
		
		builder.append('\n');
	}
	
	public static void main(String[] args) {
		int t=Integer.parseInt(scanner.nextLine());
		
		while(t-->0)
			exec();
		
		System.out.println(builder);
		
		scanner.close();
	}
}
