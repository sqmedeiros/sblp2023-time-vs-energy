import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class entry_1971169 {
 
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine().trim());
	StringBuilder sb = new StringBuilder();
	while(t-->0) {
		String arr[] = br.readLine().trim().split(" ");
		long y = Long.parseLong(arr[0]);
		long x = Long.parseLong(arr[1]);
		
		sb.append(findElement(y,x)+"\n");
	}
	br.close();
	System.out.println(sb);
}
 
	private static  String findElement(long maxX, long maxY) {
		long ret = 1;
        if(maxX == 1 && maxY == 1) return ret+"";
//        long max = Math.max(maxX, maxY);
        ret = getDiagonalValue(Math.max(maxX, maxY));
//        ret = (long) (Math.pow(max, 2)-(max-1));
        long diff = Math.abs(subtract(maxX,maxY));
 
        if(maxX > maxY){
            if((maxX&1) == 1) ret = subtract(ret,diff);
            else ret = Add(ret,diff);
        }else{
            if((maxY&1) == 1) ret = Add(ret,diff);
            else ret = subtract(ret,diff);
        }
 
        return ""+ret;
    }
	private static long getDiagonalValue(long l){
        return (long)l*l - (subtract(l,1));
    }
//		 if(y == 1 && x == 1) return 1;
//		long max = Math.max(y, x);
//		long diff = Math.abs(y-x);
//		long baseVal = 1;
////		for (int i = 1; i < max; i++) {
////			baseVal = Add(baseVal,i<<1);
////		}
//		max = 10000000;
//		baseVal = (long) (Math.pow(max, 2)-(max-1));
//	
////		for (int i = 0; i < max; i++) {
////			return baseVal;
////		}
//		
//		if(y > x){
//            if((y&1) == 1) baseVal -= diff;
//            else baseVal += diff;
//        }else{
//            if((x&1) == 1) baseVal += diff;
//            else baseVal -= diff;
//        }
//		
////		if(y>=x) {
////			if((diff&1)==0) {
////				return Add(baseVal,diff);
////			}
////			return subtract(baseVal,diff);
////		}
////		if(y<x) {
////			if((diff&1)==0) {
////				return subtract(baseVal,diff);
////			}
////			return Add(baseVal,diff);
////		}
//		return baseVal;
//	}
//	
	private static long subtract(long x, long y)
    {
         
    // Iterate till there
    // is no carry
    while (y != 0)
    {
        // borrow contains common
        // set bits of y and unset
        // bits of x
        long borrow = (~x) & y;
 
        // Subtraction of bits of x
        // and y where at least one
        // of the bits is not set
        x = x ^ y;
 
        // Borrow is shifted by one
        // so that subtracting it from
        // x gives the required sum
        y = borrow << 1;
    }
     
    return x;
    }
	
	private static long Add(long x, long y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            long carry = x & y;
 
            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;
 
            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }
}