//TC : O(n)
//SC: O(1)

public class RotateArray {
    public void rotate(int[] nums, int k) {

      k = k %  nums.length;
      reverse(nums, 0, nums.length-1);
      reverse(nums, 0, k-1);
      reverse (nums, k,nums.length-1 );
    }

    private void reverse(int[] arr, int l, int r){

      while(l <r){
        swap(arr, l, r);
        l++;
        r--;
      }
    }

    private void swap(int[] arr, int a, int b){
      int t=arr[a];
      arr[a]=arr[b];
      arr[b]=t;
    }
  }
