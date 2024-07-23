import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 
// Cses034 Sum of Four Values https://cses.fi/problemset/task/1642
// Time limit: 1.00 s Memory limit: 512 MB 1726/1870
//
// You are given an array of n integers, and your task is to find four values (at distinct
// positions) whose sum is x.
//
// Input
//
// The first input line has two integers n and x: the array size and the target sum.
//
// The second line has n integers a_1,a_2,...,a_n: the array values.
//
// Output
//
// Print four integers: the positions of the values. If there are several solutions, you may print
// any of them. If there are no solutions, print IMPOSSIBLE.
//
// Constraints
//
//  * 1 <= n <= 1000
//
//  * 1 <= x,a_i <= 10^9
//
// Example
//
// Input:
//
// 8 15
//
// 3 2 5 8 1 3 2 3
//
// Output:
//
// 2 4 6 7
//
public class entry_1216169 {
  final static Random RAND = new Random();
  final static int MOD = 1000000007;
  final static double EPS = 1e-9;
 
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int x = in.nextInt();
    int[][] a = new int[n][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = i + 1;
    }
    Arrays.sort(a, (v,w) -> Integer.compare(v[0], w[0]));
    for (int i = 0; i < n-3; i++) {
      for (int j = n-1; j >= i + 3; j--) {
        int sum = x - (a[i][0] + a[j][0]);
        if ((sum < a[i+1][0] + a[i+2][0]) || (sum > a[j-1][0] + a[j-2][0])) {
          continue;
        }
        int k = i+1;
        int l = j-1;
        while (k < l) {
          if (a[k][0] + a[l][0] == sum) {
            System.out.format("%d %d %d %d\n", a[i][1], a[j][1], a[k][1], a[l][1]);
            in.close();
            return;
          } else if (a[k][0] + a[l][0] < sum) {
            k++;
          } else {
            l--;
          }
        }
      }
    }
    System.out.println("IMPOSSIBLE");
    in.close();
  }
}