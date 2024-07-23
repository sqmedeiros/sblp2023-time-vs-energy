import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
 
//Built using CHelper plug-in
//Living Life In the Night :)
//Anime :>
//Never Give Up
 
public class entry_5193257 {
public static void main(String[] args) {
InputStream inputStream = System.in;
OutputStream outputStream = System.out;
InputReader in = new InputReader(inputStream);
PrintWriter out = new PrintWriter(outputStream);
TaskB1 solver = new TaskB1();
int testCount = Integer.parseInt(in.next());
for (int i = 1; i <= testCount; i++)
solver.solve(1, in, out);
out.close();
}
}
 
class TaskB1 {
public void solve(int testNumber, InputReader in, PrintWriter out){
 
// Code begins here
// long x = in.nextLong();
// long y = in.nextLong();
// long ans;
// long maximum = Math.max(x,y);
// if(maximum == x){
//     if(x % 2 == 0){
//         ans = x * x;
//         ans -= y-1;
//     }
//     else{
//         x--;
//         ans = x * x;
//         ans += y;
//     }
// }
// else{
//     if(y % 2 == 1){
//         ans = y*y;
//         ans -= x-1;
//     }
//     else{
//         y--;
//         ans = y*y;
//         ans += x;
//     }
// }
// out.println(ans);
long y = in.nextLong();
long x = in.nextLong();
long z = Math.max(y,x);
long z2 = (z-1)*(z-1),ans;
if(z % 2 == 1){
    if(y == z){
        ans = z2 + x;
    }
    else{
        ans = z2+2*z-y;
    }
}
else{
    if(x == z){
        ans = z2 + y;
    }
    else{
        ans = z2+2*z-x;
    }
}
out.println(ans);
 
}
}
 
class InputReader {
public BufferedReader reader;
public StringTokenizer tokenizer;
public InputReader(InputStream stream) {
reader = new BufferedReader(new InputStreamReader(stream), 32768);
tokenizer = null;
}
 
public String next()
{
 
while (tokenizer == null || !tokenizer.hasMoreTokens()) 
{
try {
tokenizer = new StringTokenizer(reader.readLine());
}
catch (IOException e) {
throw new RuntimeException(e);
}
}
return tokenizer.nextToken();
}
 
public int nextInt() {
return Integer.parseInt(next());
}
public long nextLong() {
    return Long.parseLong(next());
}
}