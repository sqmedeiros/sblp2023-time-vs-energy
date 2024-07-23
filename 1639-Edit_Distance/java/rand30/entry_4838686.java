import java.util.*;
 
public class entry_4838686{
  public static void main(String[] args) {
    Scanner s = new Scanner (System.in);
    String s1 = s.next();
    String s2 = s.next();
    int[][] data = new int[s1.length() + 1][s2.length() + 1];
    data[0][0] = 0;
    for (int i = 1; i < s1.length() + 1; i ++){
      data[i][0] = i;
    }
    for (int i = 1; i < s2.length() + 1; i ++){
      data[0][i] = i;
    }
    for (int i = 1; i <= s1.length(); i ++){
      for (int j = 1; j <= s2.length(); j ++){
        if (s1.charAt(i-1) == s2.charAt(j-1)){
          data[i][j] = data[i - 1][j - 1];
        } else{
          data[i][j] = Math.min(data[i][j-1], Math.min(data[i-1][j], data[i-1][j-1])) + 1;
        }
      }
    }
 
    // for (int[] arr : data){
    //   System.out.println(Arrays.toString(arr));
    // }
 
    System.out.println(data[s1.length()][s2.length()]);
  }
}