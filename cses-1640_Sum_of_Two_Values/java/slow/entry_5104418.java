import java.util.Arrays;
import java.util.Scanner;
public class entry_5104418{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int target=input.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        int[] new_arr=new int[n];
        System.arraycopy(arr, 0, new_arr, 0, n);
        Arrays.sort(arr);
        int p1=0;int p2=n-1;
        int flag=0;
        while (p1<p2){
            if (arr[p1]+arr[p2]>target){
                p2--;
            }
            else if(arr[p1]+arr[p2]<target){
                p1++;
            }
            else {
                int a=arr[p1];int b=arr[p2];
                flag=1;
                int ans1=0;int ans2=0;
                for (int i=0;i<n;i++){
                    if (new_arr[i]==a){
                        ans1=i+1;new_arr[i]=-1;break;
                    }
                }
                for (int i=0;i<n;i++){
                    if (new_arr[i]==b){
                        ans2=i+1;break;
                    }
                }
                System.out.println(ans1+" "+ans2);
                break;
            }
        }
        if (flag==0){
            System.out.println("IMPOSSIBLE");
        }
    }
    public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
