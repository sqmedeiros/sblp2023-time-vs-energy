import java.util.Scanner;
 
public class entry_4861571 {
 
    public static void main(String[] args) {
        entry_4861571 number = new entry_4861571();
        Scanner scanner = new Scanner(System.in);
        long numberOfTest = scanner.nextInt();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfTest; i++) {
            long row = scanner.nextInt();
            long col = scanner.nextInt();
            string.append(number.numberSpiral(row, col));
            string.append("\n");
        }
        System.out.println(string);
    }
 
    private long numberSpiral(final long row, final long col) {
        long result = 0;
        if (row < col) {
            if (col % 2 == 1) {
                long value = col * col;
                result =  value - row + 1;
            } else {
                long value = (col - 1) * (col - 1)+ 1;
                result = value + row - 1;
            }
        } else {
            if (row % 2 == 0) {
                long value = row * row;
                result = value - col + 1;
            } else {
                long value = (row - 1) * (row - 1) + 1;
                result = value + col - 1;
            }
        }
        return result;
    }
}
