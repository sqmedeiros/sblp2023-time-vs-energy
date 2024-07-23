import java.io.*;
import java.util.Arrays;
 
 
/**
 * Math
 * 
 * Ejercicio 8: Prime Multiples
 * Explicación: Principio de inclusión-exclusión. Cada primo representa un 
 * conjunto donde su cardinalidad es n/a[i], que simboliza los números de 1 
 * hasta n que son divisibles por a[i]. La respuesta al problema es la unión
 * de todos los conjuntos por el principio IE.
 * 
 * La intersección de los conjuntos es n/prod(conjuntos)
 * 
 * Complejiddad: O(2^k)
 * 
 * @author Reynell
 */
public class entry_2607598 {
    static long n;
    static int k;
    static long[]a;
    
    public static void main(String[]args) throws IOException{
        
        String[]data;
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        data = f.readLine().split(" ");
        n = Long.valueOf(data[0]);
        k = Integer.valueOf(data[1]);
        
        data = f.readLine().split(" ");
        a = new long[k];
        for(int i = 0 ; i < k ; ++i)
            a[i] = Long.valueOf(data[i]);
        
        Arrays.sort(a);
        long res = solve(-1, 1, 1, new boolean[k], false);
        System.out.println(res);
    }
    
    /**
     * Método que implementa el principio de inclusión exclusión mediante
     * backtracking de combinaciones
    */
    public static long solve(int in, int e, long acum, boolean[]choosed, boolean op){
        if(e == k+1)
            return 0;
        long res = 0l;
        for( int i = in + 1 ; i < k ; ++i){
            if(!choosed[i]){
                if(n / (acum*a[i]) == 0)
                    continue;
                if( Math.log10(acum) + Math.log10(a[i]) >= Math.log10(Long.MAX_VALUE))
                    continue;
                choosed[i] = true;        
                res = res + (op?-1:1)*( n / (acum*a[i]) ) + solve(i, e+1, acum*a[i], choosed, !op);      
                choosed[i] = false;
            }
        }
        return res;
    }
 
    
}