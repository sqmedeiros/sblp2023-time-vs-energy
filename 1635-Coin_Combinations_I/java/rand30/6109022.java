import java.util.Scanner;
 
public class entry_6109022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int x = scanner.nextInt();
 
        int[] moedas = new int[n];
        for (int i = 0; i < n; i++) {
            moedas[i] = scanner.nextInt();
        }
 
        System.out.println(combinacao(moedas, x));
 
    }
 
    public static int combinacao(int[] moedas, int x) {
        int[] s = new int[x + 1];
        s[0] = 1;
 
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < moedas.length; j++) {
                if (i - moedas[j] >= 0) {
                    s[i] = (s[i] + s[i - moedas[j]]) % 1000000007;
                }
            }
        }
 
        return s[x];
    }
}