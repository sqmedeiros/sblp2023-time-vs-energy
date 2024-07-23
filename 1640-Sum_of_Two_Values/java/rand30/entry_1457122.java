//package cses;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class entry_1457122 {
    
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
        String str1[] = bf.readLine().split(" ");
		int n = Integer.parseInt(str1[0]);
		int sum =  Integer.parseInt(str1[1]);
		 ArrayList<Pair3> list = new ArrayList<>();
		 String str[] = bf.readLine().split(" ");
		 for(int i=0; i<n; i++)
		 {
			 int k = Integer.parseInt(str[i]);
			 list.add(new Pair3(k, i+1));
		 }
		 Collections.sort(list);  
	      int i=0; 
	      int j = n-1;
	      int flag = 1;
	      while( i < j)
	      {
	    	  
	    	  if(list.get(i).data + list.get(j).data < sum)
	    	  {
	    		  i++;
	    	  }
	    	  else if(list.get(i).data + list.get(j).data > sum)
	    	  {
	    		  j--;
	    	  }
	    	  else
	    	  {
	    		  System.out.println(list.get(i).index + " " +list.get(j).index);
	    		  flag = 0;
	    		  break;
	    	  }
	      }
	      
	      if(flag == 1)
	    	  System.out.println("IMPOSSIBLE"); 
	}
 
}
 
class Pair3 implements Comparable<Pair3>{
	int data;
	int index;
	
	Pair3(int data, int index)
	{
		this.data = data;
		this.index  =  index;  	
	}
	
	
	@Override
	public int compareTo(Pair3 p) {
		// TODO Auto-generated method stub
		return this.data - p.data;
	}
}
