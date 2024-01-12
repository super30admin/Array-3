//TC O(n)
//SC O(1)

//1. Used a helper function which returns the reversed string when first and last index are passd
//2. To find the rotated array
// reverse the whole array. Then reverse the k elements from the beg and the other half.

class Problem3 {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[]nums, int start, int end){

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}