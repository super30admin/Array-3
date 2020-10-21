// TC: O(n^2)
// SC: O(1)

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        
        if(nums.length >= 2){
            // swapping last element with first k times and shift rest of the elements
            for(int j=0; j<k; j++){
                int temp = nums[nums.length-1];
                for (int i = nums.length-2; i >= 0; i--) {                
                    nums[i+1] = nums[i];
                }
                nums[0] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        rotate(nums, target);
    }
}