// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(n == 1) return;
        k = k%n;

        reverse(nums, 0, n-k-1); //O(n/2)
        reverse(nums, n-k, n-1); //O(n/2)
        reverse(nums, 0, n-1); //O(n/2)
    }

    private void reverse(int[] nums, int i, int j) {
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(n == 1) return;
        k = k%n;
        int[] arr = new int[n];
        int j=0;
        for(int i=n-k; i<n; i++) {
            arr[j]  = nums[i];
            j++;
        }

        for(int i=0; i<n-k; i++) {
            arr[j] = nums[i];
            j++;
        }

        for(int i=0; i<n; i++)
            nums[i] = arr[i];

    }
}


// Time Complexity : O(kn)
// Space Complexity : O(1)
class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(n == 1) return;
        k = k%n;
        for(int i=1; i<=k; i++) { //O(k)
            int temp = nums[n-1];
            for(int j=n-2; j>=0; j--) //O(n)
                nums[j+1] = nums[j];
            nums[0] = temp;
        }
    }
}