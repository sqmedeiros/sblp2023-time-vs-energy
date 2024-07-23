import java.util.Scanner;
class entry_1843138 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int c[]=new int[n];
        for(int i=0;i<n;i++)
        c[i]=sc.nextInt();
        int number[]=new int[x+1];
        for(int i=1;i<x+1;i++)
        number[i]=Integer.MAX_VALUE;
        for(int i=1;i<x+1;i++)
        {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if((i-c[j])<0)
                continue;
                min=Math.min(min,number[i-c[j]]);
            }
            if(min==Integer.MAX_VALUE)
            number[i]=min;
            else
            number[i]=min+1;
        }
        if(number[x]==Integer.MAX_VALUE)
        System.out.println(-1);
        else
        System.out.println(number[x]);
        sc.close();
    }
}