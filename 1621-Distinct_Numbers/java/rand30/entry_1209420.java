import java.util.*;
 
public class entry_1209420 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println(Arrays.stream(scanner.nextLine().split(" ")).distinct().count());
        scanner.close();
    }
}
