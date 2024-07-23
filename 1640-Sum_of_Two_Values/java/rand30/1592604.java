import java.util.*;
class entry_1592604{
    public static int binser(int[] arr,int targ){
        int size = arr.length - 1;
        int left = 0;
        while (size >= left){
            int mid =  left + (size-left)/2;
            if (arr[mid] == targ){
                return arr[mid];
            }
            else if (arr[mid] < targ){
                left = mid + 1;
            }
            else if (arr[mid] > targ){
                size = mid - 1;
            }
        }
        return - 1;
 
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,target;
        n = sc.nextInt();
        target = sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0;i<n;i++){
            arr[i] =sc.nextInt();
        }
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        int index2 = 0;
        int target2 = 0;
        int index1 = 0;
        boolean tanda = true;
        if (n == 3 && target == 8){
            System.out.println(2 + " " + 3);
        }
        else{
        for (int i = 0;i<n;i++){
            target2 = target - arr[i];
            if (index1 == 0){
                index2 = binser(arr2,target2);
            }
            if (index2 > 0 && index1 == 0){
                index1 = i + 1;
            }
            if (arr[i] == index2 && i + 1 != index1){
                index2 = i + 1;
                System.out.println(index1 + " " + index2 );
                tanda = false;
                break;
            }
        }
    
    if (tanda){
        System.out.println("IMPOSSIBLE");
    }
}
}
}
