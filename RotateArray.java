public class RotateArray {
  //To rotate right, reverse the whole array, then reverse the first k and remaining n-k parts
  //To rotate left, reverse the first k and the rest, then reverse the full array
  //Time Complexity: O(n)
  //Space Complexity: O(1) 
  public void rotate(int[] nums, int k) {
        k = k%nums.length;      
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int start,int end){
        int c = 0;
        while(start<end)
        {
            c = nums[start];
            nums[start] = nums[end];
            nums[end] = c;
            start++;
            end--;
        }
    }   
}
