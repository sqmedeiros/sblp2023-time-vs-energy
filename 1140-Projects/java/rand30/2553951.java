import java.io.*;
import java.util.*;
 
public class entry_2553951
{
    public static void main(String args[])throws Exception
    {
        FastReader fr=new FastReader();
        int n=fr.nextInt();
        int i,j,a[][]=new int[n][3],r[]=new int[n+1];
        for(i=0;i<n;i++)
        {
            for(j=0;j<3;j++)
            a[i][j]=fr.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]>o2[0]?1:-1;
                else return -1;
            }});
 
        for(i=0;i<n;i++) r[i+1]=a[i][1];
        long ans=0,dp[]=new long[n+1];
        for(i=0;i<n;i++)
        {
            int qe=binarys(r,a[i][0]);
            long val=query(0,n,0,qe,0)+a[i][2];
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
 
    static class FastReader
    {
        final private int BUFFER_SIZE=1<<16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer,bytesRead;
 
        public FastReader()
        {
            dis=new DataInputStream(System.in);
            buffer=new byte[BUFFER_SIZE];
            bufferPointer=bytesRead=0;
        }
 
        public int nextInt() throws IOException
        {
            int ret=0;
            byte c=read();
            while(c<=' ') c=read();
            boolean neg=(c=='-');
            if(neg) c=read();
            do
            {
                ret=ret*10+c-'0';
            }while((c=read())>='0' && c<='9');
            if(neg) return -ret;
            return ret;
        }
 
        private void fillBuffer()throws IOException
        {
            bytesRead=dis.read(buffer,bufferPointer=0,BUFFER_SIZE);
            if(bytesRead==-1) buffer[0]=-1;
        }
        private byte read() throws IOException
        {
            if(bufferPointer==bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}