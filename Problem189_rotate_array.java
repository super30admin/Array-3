/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */

class Solution {

    public void rotate(int[] nums, int k) {
        // reversingTechnique(nums,k);
        positionalSwap(nums,k);
    }

    // Method 1
    private void reversingTechnique(int[] nums, int k){
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int left, int right){

        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }


    // Method 2
    private void positionalSwap(int[] nums,int k){
        k %= nums.length;
        int count=0;
        for(int start =0; count < nums.length; start++){
            int current = start;
            int previous = nums[start];
            do{
                int next = (current+k)%nums.length;
                int temp = nums[next];
                nums[next] = previous;
                previous = temp;
                count++;
                current = next;
            }while(current != start);
        }
    }
}