import java.util.HashMap;
import java.util.Scanner;
 
class entry_4442302{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long[] arr = new long[Math.toIntExact(n)];
        long curr = 0;
        long max = -1000000000;
        for(int i = 0; i < n; i++) arr[i] = scanner.nextLong();
        for(int i = 0; i < arr.length; i++)
        {
            if(curr+arr[i] > arr[i]) curr += arr[i];
            else curr = arr[i];
            max = Math.max(max, curr);
        }
        System.out.println(max);
    }
}
 
 
 
/*import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Main {
    public static void main(String[] args) {
        Set<Long> set = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        long n1 = scanner.nextLong();
        while(n1 > 0)
        {
            long n2 = scanner.nextLong();
            set.add(n2);
            --n1;
        }
        System.out.println(set.size());
    }
}*/
 
 
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
 
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(palindrome(str));
    }
 
    public static String palindrome(String str) {
        HashMap<Character, Long> counting = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (counting.containsKey(ch)) counting.put(ch, counting.get(ch) + 1);
            else counting.put(ch, Long.valueOf(1));
        }
        int oddCount = 0;
        char oddChar = 0;
        for (Entry<Character, Long> itr : counting.entrySet()) {
            if (itr.getValue() % 2 != 0) {
                oddCount++;
                oddChar = itr.getKey();
            }
        }
        if (oddCount > 1 || oddCount == 1 &&
                str.length() % 2 == 0) return ("NO SOLUTION");
 
        /**String firstHalf = "", lastHalf = "";
        for (Entry<Character, Long> itr : counting.entrySet()) {
            String ss = "";
            for (int i = 0; i < itr.getValue() / 2; i++) ss += itr.getKey();
            firstHalf = firstHalf + ss;
            lastHalf = ss + lastHalf;
        }
        return ((oddCount == 1) ?
                (firstHalf + oddChar + lastHalf) :
                (firstHalf + lastHalf));
    }
}*/
 
 
/*String firstHalf = "", lastHalf = "", tmp = "";
        for(Entry<Character, Integer> itr : counting.entrySet())
        {
            for(int i = 0; i < itr.getValue() / 2; i++) tmp += itr.getKey();
            firstHalf = firstHalf + tmp;
            lastHalf = tmp + lastHalf;
        }
        return (oddCount == 1) ? (firstHalf + oddChar + lastHalf) : (firstHalf + lastHalf);
        }
        }
 
 
 
 
 
 
 
 
 
 
 
 
/* Java program to solve N Queen
Problem using backtracking
import java.util.
class Main {
 
    This function solves the N Queen problem using
        Backtracking. It mainly uses solveNQUtil() to
        solve the problem.
 
    static List<List<Integer>> nQueen(int n) {
        // cols[i] = true if there is a queen previously placed at ith column
        cols = new boolean[n];
        // leftDiagonal[i] = true if there is a queen previously placed at
        // i = (row + col )th left diagonal
        leftDiagonal = new boolean[2*n];
        // rightDiagonal[i] = true if there is a queen previously placed at
        // i = (row - col + n - 1)th rightDiagonal diagonal
        rightDiagonal = new boolean[2*n];
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++)temp.add(0);
        solveNQUtil(result,n,0,temp);
 
        return result;
    }
    private static void solveNQUtil(List<List<Integer>> result,int n,int row,List<Integer> comb){
        if(row==n){
            // if row==n it means we have successfully placed all n queens.
            // hence add current arrangement to our answer
            // comb represent current combination
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int col = 0;col<n;col++){
            // if we have a queen previously placed in the current column
            // or in current left or right diagonal we continue
            if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
                continue;
            // otherwise we place a queen at cell[row][col] and
            //make current column, left diagonal and right diagonal true
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
            comb.set(col,row+1);
            // then we goto next row
            solveNQUtil(result,n,row+1,comb);
            // then we backtrack and remove our currently placed queen
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
        }
    }
    static List<List<Integer> > result
            = new ArrayList<List<Integer> >();
    static boolean[] cols,leftDiagonal,rightDiagonal;
 
    // Driver code
    public static void main(String[] args)
    {
        int n = 4;
 
        List<List<Integer> > res = nQueen(n);
        System.out.println(res);
    }
}*/
 
 
/*        import javax.swing.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        int countOfCH = 0;
        int countOfNECH = 0;
        int ODD = 0;
        String firstHalf = "";
        String secondHalf = "";
        String tmp = "";
        String palindrome = "";
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        char[] ch_str = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch_str.length; i++) {
            if (map.containsKey(ch_str[i])) map.put(ch_str[i], map.get(ch_str[i]) + 1);
            else map.put(ch_str[i], 1);
        }
        for (Map.Entry<Character, Integer> val : map.entrySet()) {
            if (val.getValue() % 2 == 0) {
                countOfCH++;
            }
            ODD = val.getKey();
            countOfNECH++;
        }
        System.out.println(func(countOfNECH, countOfNECH, map, tmp, firstHalf, secondHalf, palindrome,str));
    }
 
    static boolean isTrue(int CH, int NECH, String str) {
        if (NECH > 1) {
            if (NECH > 1 || CH == 1 &&
                    str.length() % 2 == 0) {
                System.out.println("NO PALINDROME");
                return false;
            }
        }
            return true;
    }
        static String func ( int countOfCH, int countOfNECH, Map<Character, Integer > map,
                String tmp, String firstHalf, String secondHalf, String palindrome, String str)
        {
            if (isTrue(countOfCH, countOfNECH, str)) {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    for (int i = 0; i < entry.getValue() / 2; i++) tmp += entry.getKey();
                }
                firstHalf += tmp;
                secondHalf = tmp + secondHalf;
                palindrome = palindrome + firstHalf + secondHalf;
            }
            return palindrome;
        }
}*/
 
 
 
/*Two Sets
 
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long curr = 0;
        long sum = n*(n+1)/2;
        long target = sum/2;
 
        Set<Long> first_list = new LinkedHashSet<>();
        Set<Long> all_list = new LinkedHashSet<>();
        long[] arr = new long[Math.toIntExact(n + 1)];
 
        for(long i = 1; i <= n; i++) {
            arr[Math.toIntExact(i)] = i;
            all_list.add(i);
        }
 
        if (n < 3)
        {
            System.out.println("NO");
        }
        else if (n > 0 && n % 4 == 0)// 7+(kratnoe*4)
        {
            System.out.println("YES");
            fillFirst(arr,first_list,sum,target);
            fillSecond(arr,first_list, all_list,n);
        }
        else if(n>=4) {
            for (long kratnoe = 0; kratnoe < n; kratnoe++) {
                long tmp = (3 + (kratnoe * 4));
                if (tmp > n)
                {
                    System.out.println("NO");
                    break;
                }
                if (tmp == n) {
                    System.out.println("YES");
                    fillFirst(arr,first_list,sum,target);
                    fillSecond(arr,first_list, all_list,n);
                    break;
                }
            }
        }
    }
   static void fillFirst(long[] arr, Set<Long> list, long sum, long target)
    {
        int count = 0;
        long curr = 0;
        for(long i = arr.length - 1; i >=1; i--)
        {
            if(curr < target) {
                curr += arr[Math.toIntExact(i)];
                list.add(arr[Math.toIntExact(i)]);
                count++;
            }
            else if(curr > target)
            {
                curr -= arr[Math.toIntExact(i)];
                list.remove(Math.toIntExact(i));
                count--;
                list.add(target - curr);
                count++;
                break;
            }
            else break;
        }
        Iterator<Long> it = list.iterator();
        System.out.println(count);
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();
    }
    static void fillSecond(long[] arr, Set<Long> list1, Set<Long> list2, long n)
    {
        Arrays.asList(arr);
        Iterator<Long> it1 = list1.iterator();
        Iterator<Long> it2 = list2.iterator();
        while (it1.hasNext())
        {
            while (it2.hasNext())
            {
                if(it1.next() == it2.next()) list2.remove(it2.next());
            }
        }
        System.out.println(n - list1.size());
        while (it2.hasNext()) System.out.print(it2.next() + " ");
        System.out.println();
    }
}*/
 
