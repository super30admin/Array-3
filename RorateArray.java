// Time: O(n)
// Space: O(1)

public class RorateArray {
    
       public void rotate(int[] nums, int k) {
            if (k > nums.length) k = k% nums.length;
            rotate(nums, 0, nums.length-1);
            rotate(nums, 0, k-1);
            rotate(nums, k, nums.length-1);
        }
    
        private void rotate(int[] nums, int start, int end){
            while (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end]= temp;
                start++;
                end --;
            }
    
        }
    }
