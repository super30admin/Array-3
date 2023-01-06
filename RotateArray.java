//approach -1
//take a reverse of the entire array
//take the reverse of the small chunk from 0 to k-1
//take another reverse of the k to n-1
//tc - two pass - O(n), sc -O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length ==0 || nums ==  null) return ;

        int n = nums.length;

        k = k%n; //to avoid k>n cases
        //[1,2,3,4,5]; k = 2
        reverse(nums, 0, n-1);
        //[5,4,3,2,1]
        reverse(nums, 0, k-1);
        //[4,5,3,2,1]
        reverse(nums, k, n-1);
        //[4,5,1,2,3]
    }

    private void reverse(int[] nums, int left, int right)
    {
        while(left <= right)
        {
            swap(nums, left, right);
            left++; right--;
        }
    }
    private void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

/*
 * approach -2
 * 1. swap last k elements - (n-k, n-1)
 * 2. swap front part, (0, n-k-1)
 * 3. swap entire array (0, n-1)
 * tc - O(n), sc - O(1)
 */


class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length ==0 || nums ==  null) return ;

        int n = nums.length;

        k = k%n; //to avoid k>n cases
        //[1,2,3,4,5]; k = 2
        reverse(nums, n-k, n-1);
        //[1,2,3,5,4]
        reverse(nums, 0, n-k-1);
        //[3,2,1,5,4]
        reverse(nums, 0, n-1);
        //[4,5,1,2,3]
    }

    private void reverse(int[] nums, int left, int right)
    {
        while(left <= right)
        {
            swap(nums, left, right);
            left++; right--;
        }
    }
    private void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}