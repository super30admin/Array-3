// Time : O(N) | Space: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // if k greater than n, we should take mod of n
        if(k>n) {
            k = k%n;
        }
        n--;
        int j = n-k;
        int i=0;
        // reversing first n-k elements
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
        i=n-k+1;
        j=n;
        // reverse last k elements
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
        i=0;
        j=n;
        // then reverse whole array
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}