// There are three approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: Brute force using Extra array
// Time Complexity : O(2n) = O(n)
//      n: number of elements
//   Storing in new array and copying to old array
// Space Complexity : O(n)
//      n: number of elements
//    For extra array
class Problem3S1 {
    public void rotate(int[] nums, int k) {

        // edge case case
        if(nums == null || nums.length < 2)
            return;
        
        // initialize
        int n = nums.length;
        k = k%n; // for fast rotation
        
        // temporary array
        int[] temp = new int[n];

        // copy elements from kth positon
        for(int i=0; i< n; i++)
            temp[(i+k)%n] = nums[i];
      
        // copy back to original array
        for(int i=0; i<n; i++)
            nums[i] = temp[i];
        
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Brute force in place
// Time Complexity : O(nk) 
//      n: number of elements
//      k: number of times to rotate
//   Rotating the array k times
// Space Complexity : O(1)
//    No extra space
class Problem3S2 {

    /** Rotate the array k times */
    public void rotate(int[] nums, int k) {

        // edge case
        if(nums == null || nums.length < 2)
            return;
        // initialize
        int n = nums.length;
        k = k%n; // fast rotate

        // for swapping
        int temp,previous;
        
        // rotate k times
        for(int i=0; i<k; i++){
            
            previous = nums[n-1];

            // rotate
            for(int j=0;j<n;j++){
                // swap 
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        
    }
}

// Your code here along with comments explaining your approach
// Approach 3: By Dividing the array
// 1. Reverse the array.
// 2. Reverse 1st half from 0 to k-1.
// 3. Reverse 2nd half from k to n-1.
// Time Complexity : O(2n) = O(n)
//      n: number of elements
// Space Complexity : O(1)
//    No extra space
// Note: For Left hand rotation,
//       1st half -> 0 to n-k-1, 
//       2nd half-> n-k to n-1
class Problem3S3 {

    // global
    int[] nums;
    int temp;
    /** Rotate the array k times */
    public void rotate(int[] nums, int k) {

        // edge case
        if(nums == null || nums.length < 2)
            return;
        // initialize
        int n = nums.length;
        k = k%n; // fast rotate
        this.nums = nums; // for global

        // Reverse the entire array
        int low = 0, high = n-1; 
        reverse(low, high); 
        
        // Reverse 0 to K-1
        low = 0; high=k-1;
        reverse(low, high);

       // Reverse k to n
        low = k; high= n-1;
        reverse(low, high);
    }
    
    /** void reverse */
    private void reverse(int low, int high){

        // iterate all the element and swap
        while(low < high){
            temp = nums[low];
            nums[low++] = nums[high];
            nums[high--] =  temp;
        }
    }
}