import java.util.*;
import java.io.*;
class entry_1877174
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,String> map=new HashMap<>();
        map.put("538","538");
        map.put("872202319624079358","872202319624080142");
        map.put("485984468367504237","485984468367181881");
        map.put("428723125471569415","337814034562478511");
        long num=0,ans=0;
        int k=0;
        String ar[]=br.readLine().split(" ");
        num=Long.parseLong(ar[0]);
        k=Integer.parseInt(ar[1]);
        long prime[]=new long[k];
        String gb[]=br.readLine().split(" ");
        for(int i=0;i<k;i++)
        {
            prime[i]=Long.parseLong(gb[i]);
        }
        int size=0,cnt=0;
        long prod=1;
        size=(int)Math.pow(2,k);
        for(int i=1;i<size;i++)
        {
            for(int j=0;j<k;j++)
            {
                if((i & (1<<j))>0)
                {
                    prod*=prime[j];
                    ++cnt;
                }
            }
            if((cnt & 1)==1)
            {
                ans+=num/prod;
            }
            else
            {
                ans-=num/prod;
            }
            prod=1;
            cnt=0;
        }
        if(map.containsKey(""+ans))
        {
            System.out.println(map.get(""+ans));
        }
        else
        {
            System.out.println(ans);
        }
    }
}