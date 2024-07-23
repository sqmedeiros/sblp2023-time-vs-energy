import java.io.*;
import java.util.*;
 
public class entry_2553958
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        int i,j,a[]=new int[3];
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]>o2[0]?1:-1;
                else return -1;
            }});
 
        for(i=0;i<n;i++)
        {
            String s[]=bu.readLine().split(" ");
            for(j=0;j<3;j++)
            a[j]=Integer.parseInt(s[j]);
            pq.add(new int[]{a[0],a[1],a[2]});
        }
 
        int e[][]=new int[n][3],r[]=new int[n+1];
        for(i=0;i<n;i++)
        {
            e[i]=pq.poll();
            r[i+1]=e[i][1];
        }
        long ans=0,dp[]=new long[n+1];
        for(i=0;i<n;i++)
        {
            int qe=binarys(r,e[i][0]);
            long val=query(0,n,0,qe,0)+e[i][2];
            ans=Math.max(ans,val);
            if(val>dp[i+1])
            {
                dp[i+1]=val;
                update(0,n,i+1,val,0);
            }
        }
        System.out.println(ans);
    }
 
    static int binarys(int a[],int k)
    {
        int l=0,r=a.length-1,m,ans=0;
        while(l<=r)
        {
            m=(l+r)>>1;
            if(a[m]<k)
            {
                ans=m;
                l=m+1;
            }
            else r=m-1;
        }
        return ans;
    }
 
    static long st[]=new long[1000000];
    static void update(int ss,int se,int i,long v,int n)
    {
        if(ss>se) return;
        if(ss==se)
        {
            st[n]=v;
            return;
        }
 
        int m=ss+(se-ss)/2;
        if(i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=Math.max(st[2*n+1],st[2*n+2]);
    }
 
    static long query(int ss,int se,int qs,int qe,int n)
    {
        if(se<qs || ss>qe || ss>se) return 0;
        if(ss>=qs && se<=qe) return st[n];
 
        int m=ss+(se-ss)/2;
        return Math.max(query(ss,m,qs,qe,2*n+1),query(m+1,se,qs,qe,2*n+2));
    }
}