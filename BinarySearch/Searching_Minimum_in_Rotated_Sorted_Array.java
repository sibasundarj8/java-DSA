package Binary_Search;

public class Searching_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[]arr = {5,6,7,8,9,2,3,4};
        System.out.println(findMin(arr));
    }
    static int findMin(int[]arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[n-1])start = mid+1;
            else{
                ans = arr[mid];
                end = mid-1;
            }
        }
        return ans;
    }
}
