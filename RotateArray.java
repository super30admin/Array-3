/*
Method 1:
TC: We call reverse thrice. O(n) + O(n). So, it is O(n)
SC: O(1)

1. Reverse the array.
2. Divide the array at k. If(k > n, we reduce the k by modulus operator)
3. Reverse first half and second half.

Method 2:

TC: O(n)
SC: O(n) - new array

1. Create new array. Populate the elements by rotating index.
2. Copy the new array to original array.




*/

public class RotateArray {
   public void rotate(int[] arr, int k){
       if(k == 0) return;
       if(arr == null || arr.length <= 1) return;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
   }
   
   private void reverse(int[] arr, int start, int end){
       while(start <= end){
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
       }
   }

   public void rotateExtraSpace(int[] nums, int k){
    int n = nums.length;
    int[] arr = new int[n];
    k = k % n;
    for(int i = 0; i < n; i++){
        arr[i] = nums[(i - k + n) % n];
    }
    
    for(int i = 0; i < n; i++){
        nums[i] = arr[i];
    }
   }

   public static void main(String[] args){
       int[] arr = new int[]{1,2,3,4,5,6,7};
       RotateArray rotate = new RotateArray();
       rotate.rotate(arr, 4);

       for(int n : arr){
           System.out.print(n + " ");
       }
       System.out.println();

       rotate.rotateExtraSpace(arr, 5);
       for(int n : arr){
        System.out.print(n + " ");
    }
   }
}
