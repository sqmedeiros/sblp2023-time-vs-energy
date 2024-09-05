/**
*@author Aobakwe Junior Garebagae 202108492, Emmanuel Mbuse 202104513, Terrence Kano Titus 202107760
*Question 4
*File Name: DistinctNumbers.java
*Compile: javac DistinctNumbers.java
*Exercute: java DistinctNumbers
 */
 
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class entry_7605417 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
 
        // Read the input values into an array
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
 
        // Use a set to store distinct values
        Set<Integer> distinctValues = new HashSet<>();
 
        // Iterate through the array and add values to the set
        for (int i = 0; i < n; i++) {
            distinctValues.add(values[i]);
        }
 
        // Print the number of distinct values
        System.out.println(distinctValues.size());
    }
}
