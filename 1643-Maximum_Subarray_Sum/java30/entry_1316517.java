import java.util.Scanner;
 
public class entry_1316517 {
 
    public static void main(String[] args)
    {
        Scanner io = new Scanner(System.in);
        int n =io.nextInt();
        int[] Ar = new int[n];
        long maxSum = -1000000001;
        long tempMaxSum = 0;
 
 
        for(int i=0; i<n; i++)
        {
            Ar[i] = io.nextInt();
        }
        maxSum = Ar[0];
        tempMaxSum = Ar[0];
        for(int i =1; i<n; i++) {
            if (Ar[i] > maxSum && maxSum < 0)
            {
                maxSum = Ar[i];
                tempMaxSum = Ar[i];
            }
            else if (Ar[i] > 0)
            {
                tempMaxSum += Ar[i];
                if(tempMaxSum >maxSum)
                    maxSum =tempMaxSum;
            }
            else if(Ar[i] <0)
            {
                if(tempMaxSum + Ar[i] <0)
                {
                    if(tempMaxSum > maxSum)
                        maxSum = tempMaxSum;
                    if(maxSum >0)
                        tempMaxSum = 0;
                }
                else
                {
                    tempMaxSum += Ar[i];
                }
            }
        }
        System.out.println(maxSum);
    }
}
