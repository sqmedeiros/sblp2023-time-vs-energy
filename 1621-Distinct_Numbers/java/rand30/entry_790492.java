/*
    Author: @__goku__
    ssrivastava990@gmail.com
 
                   `\-.   `
                      \ `.  `
                       \  \ |
              __.._    |   \.       S O N - G O K U
       ..---~~     ~ . |    Y
         ~-.          `|    |
            `.               `~~--.
              \                    ~.
               \                     \__. . -- -  .
         .-~~~~~      ,    ,            ~~~~~~---...._
      .-~___        ,'/  ,'/ ,'\          __...---~~~
            ~-.    /._\_( ,(/_. 7,-.    ~~---...__
           _...>-  P""6=`_/"6"~   6)    ___...--~~~
            ~~--._ \`--') `---'   9'  _..--~~~
                  ~\ ~~/_  ~~~   /`-.--~~
                    `.  ---    .'   \_
                      `. " _.-'     | ~-.,-------._
                  ..._../~~   ./       .-'    .-~~~-.
            ,--~~~ ,'...\` _./.----~~.'/    /'       `-
        _.-(      |\    `/~ _____..-' /    /      _.-~~`.
       /   |     /. ^---~~~~       ' /    /     ,'  ~.   \
      (    /    (  .           _ ' /'    /    ,/      \   )
      (`. |     `\   - - - - ~   /'      (   /         .  |
       \.\|       \            /'        \  |`.           /
       /.'\\      `\         /'           ~-\         .  /\
      /,   (        `\     /'                `.___..-      \
     | |    \         `\_/'                  //      \.     |
     | |     |                 _Seal_      /' |       |     |
 */
 
import java.io.*;
import java.util.*;
 
public class entry_790492
{
    static PrintWriter out = new PrintWriter((System.out));
 
    public static void main(String args[]) throws IOException
    {
        Kioken sc = new Kioken();
        int n=sc.nextInt();
        long k=sc.nextLong();
        ArrayList<Integer> in=new ArrayList<>();
        for(int x=0;x<n;x++)
        {
            in.add(sc.nextInt());
        }
        ArrayList<Long> ar=new ArrayList<>();
        HashMap<Long,ArrayList<Pair>> map=new HashMap<>();
        for(int x=0;x<n;x++)
        {
            for(int y=x+1;y<n;y++)
            {
                long d=in.get(x)+(long)in.get(y);
                ar.add(d);
                if(map.containsKey(d))
                {
                    map.get(d).add(new Pair(x+1,y+1));
                }
                else
                {
                    ArrayList<Pair> l=new ArrayList<>();
                    l.add(new Pair(x+1,y+1));
                    map.put(d,l);
                }
            }
        }
        boolean found=false;
        outer:
        for(long d:map.keySet())
        {
            if(d>k)
            {
                continue;
            }
            long e=k-d;
            if(e==d)
            {
                List<Pair> p=map.get(e);
                for(int x=0;x<p.size();x++)
                {
                    for(int y=x+1;y<p.size();y++)
                    {
                        if(!isEqual(p.get(x),p.get(y)))
                        {
                            found=true;
                            out.println(p.get(x).a+" "+p.get(x).b+" "+p.get(y).a+" "+p.get(y).b);
                            break outer;
                        }
                    }
                }
            }
            else if(map.containsKey(e))
            {
                ArrayList<Pair> p=map.get(d);
                ArrayList<Pair> q=map.get(e);
                for(int x=0;x<p.size();x++)
                {
                    for(int y=0;y<q.size();y++)
                    {
                        if(!isEqual(p.get(x),q.get(y)))
                        {
                            found=true;
                            out.println(p.get(x).a+" "+p.get(x).b+" "+q.get(y).a+" "+q.get(y).b);
                            break outer;
                        }
                    }
                }
            }
        }
        if(!found)
        {
            out.println("IMPOSSIBLE");
        }
        out.close();
    }
    static class Pair
    {
        int a,b;
        public Pair(int a,int b)
        {
            this.a=a;
            this.b=b;
        }
    }
    public static boolean isEqual(Pair a,Pair b)
    {
        return a.a==b.a||a.a==b.b||a.b==b.a||a.b==b.b;
    }
    public static int lower_bound(ArrayList<Integer> ar, int k)
    {
        int s = 0, e = ar.size();
        while (s != e)
        {
            int mid = s + e >> 1;
            if (ar.get(mid) <= k)
            {
                s = mid + 1;
            }
            else
            {
                e = mid;
            }
        }
        return Math.abs(s) - 1;
    }
 
    public static int upper_bound(ArrayList<Integer> ar, int k)
    {
        int s = 0;
        int e = ar.size();
        while (s != e)
        {
            int mid = s + e >> 1;
            if (ar.get(mid) < k)
            {
                s = mid + 1;
            }
            else
            {
                e = mid;
            }
        }
        if (s == ar.size())
        {
            return -1;
        }
        return s;
    }
 
    static class Kioken
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        public String next()
        {
            while (!st.hasMoreTokens())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        public long nextLong()
        {
            return Long.parseLong(next());
        }
 
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        public String nextLine()
        {
            try
            {
                return br.readLine();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
 
        public boolean hasNext()
        {
            String next = null;
            try
            {
                next = br.readLine();
            }
            catch (Exception e)
            {
            }
            if (next == null || next.length() == 0)
            {
                return false;
            }
            st = new StringTokenizer(next);
            return true;
        }
    }
}