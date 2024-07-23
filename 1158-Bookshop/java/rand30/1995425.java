// package cses.dynamicProgramming;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_1995425 {
	static class Book{
		int price, pages;
		Book(int price, int pages){
			this.price = price;
			this.pages = pages;
		}
	}
 
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int booksPrice[] = new int[Integer.parseInt(st.nextToken())];
		Book[] Books = new Book[booksPrice.length];
		int max = Integer.parseInt(st.nextToken());
 
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < booksPrice.length; i++) booksPrice[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		int maxPagesCount = 0;
		for(int i = 0; i < Books.length; i++){
			Books[i] = new Book(booksPrice[i],Integer.parseInt(st.nextToken()));
			maxPagesCount += Books[i].pages;
		} 
		br.close();
 
		System.out.println(maxPages(Books, max, maxPagesCount));
	}
 
	private static int maxPages(Book Books[], int max, int maxPagesCount){
		int dp[][] = new int[Books.length+1][max+1];
		
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				if(Books[i-1].price <= j)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- Books[i-1].price] + Books[i-1].pages);
				else dp[i][j] = dp[i-1][j];
			}
		}
		// for(int i[]:dp)System.out.println(Arrays.toString(i));
		return dp[Books.length][max];
	}	
}