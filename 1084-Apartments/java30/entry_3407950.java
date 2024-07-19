import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class entry_3407950 {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int applicants[] = new int[n];
		int index = 0;
		str = new StringTokenizer(br.readLine());
		while(str.hasMoreTokens()){
			applicants[index++] = Integer.parseInt(str.nextToken());
		}
		int aparments[] = new int[m];
		index = 0;
		str = new StringTokenizer(br.readLine());
		while(str.hasMoreTokens()){
			aparments[index++] = Integer.parseInt(str.nextToken());
		}
		mergeSort(applicants, 0, n - 1);
		mergeSort(aparments, 0, m - 1);
		int i = 0, j = 0, count = 0;
		while(i < n && j < m){
		    if(Math.abs(applicants[i] - aparments[j]) <= k){
		        count++;
		        i++;
		        j++;
		    }else if(applicants[i] < aparments[j]){
		        i++;
		    }else{
		        j++;
		    }
		}
		System.out.println(count);
	}
	public static void mergeSort(int arr[], int begin, int end){
	    if(begin < end){
	        int mid = (begin + end)/2;
	        mergeSort(arr, begin, mid);
	        mergeSort(arr, mid + 1, end);
	        merge(arr, begin, mid, end);
	    }
	}
	public static void merge(int arr[], int begin, int mid, int end){
	    int p = begin;
	    int q = mid + 1;
	    int temp[] = new int[end - begin + 1];
	    int k = 0;
	    for(int i = begin; i <= end; i++){
	        if(p > mid){
	            temp[k++] = arr[q++];
	        }else if(q > end){
	            temp[k++] = arr[p++];
	        }else if(arr[p] < arr[q]){
	            temp[k++] = arr[p++];
	        }else{
	            temp[k++] = arr[q++];
	        }
	    }
	    for(int i = 0; i < k; i++){
	        arr[begin++] = temp[i];
	    }
	}
}