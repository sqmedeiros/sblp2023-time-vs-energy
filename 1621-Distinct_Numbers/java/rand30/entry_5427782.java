import java.util.*;
 
public class entry_5427782 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        System.out.println(
				Arrays.stream(in
						.nextLine()
						.split(" "))
				.distinct()
				.count()
		);
        
    }
}