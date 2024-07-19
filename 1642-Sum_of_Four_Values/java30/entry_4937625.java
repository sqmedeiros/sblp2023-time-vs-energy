import java.io.*;
import java.util.HashMap;
 
public class entry_4937625 {
    public static void main(String[] args) {
        int n=nextInt(),s=nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=nextInt();
        HashMap<Integer,int[]> m=new HashMap<>();
        for(int i=0;i<n;i++) for(int j=i+1;j<n;j++) m.put(a[i]+a[j],new int[]{i,j});
        for(int i=0;i<n;i++) {
            int x=s-a[i];
            for(int j=i+1;j<n;j++) {
                int y=x-a[j];
                if(m.containsKey(y)) {
                    int q[]=m.get(y),k=q[0],l=q[1];
                    if(i!=k&&i!=l&&j!=k&&j!=l&&k!=l) {
                        println(i+1,j+1,q[0]+1,q[1]+1);
                        close();
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    static int nextInt(){
        int x=0,p=1,c=nextChar();if(c=='-'){p=-1;c=read();}
        for(;c>='0'&&c<='9';c=read())x=x*10+c-'0'; return x*p;}
    static int read(){try{return br.read();}catch(Throwable e){return -1;}} 
    static char nextChar(){int c=0;do c=read();while(c<=32);return (char)c;}
    static final BufferedInputStream br=new BufferedInputStream(System.in);
    static final BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static void close(){try{bw.close();}catch(Throwable e){}}
    static void print(String s){try{bw.write(s);}catch(Throwable e){}}
    static void println(Object...s){for(Object e:s) print(e+" ");print("\n");}
}