//Problem 119 : Rotate Array
//TC: O(N)
//SC: O(1)

/*Steps
    Bruteforce : TC:O(N) | SC:O(N)
                 Create a new array then start inserting elements from k index of the new array in a circular rotation. Means first insert 0 to n-k element in the new array starting from the kth index, the remaining elements to 0 to k-1 index.
    Optimize: TC:O(N) | SC:O(1)
              1) For Right Shift:
                  a) Reverse the whole array
                  b) Reverse  k to n elements
                  c) Reverse  0 to k-1 elements
              
              2) For Left Shift
                  a) Reverse the whole array
                  b) Reverse from n-k  to n elements
                  c) Reverse  0 to n-k-1 elements    
*/

class Solution119 {
    public void rotate(int[] nums, int k) {
       
        if(nums==null || nums.length==0) return;
        //TC:O(2n)=>O(n)
        int n = nums.length;
        
        if(k>=n){
            k = k%n;//if k is greater than the input array length, consider than array as a circular array
        }
        //For Right Shift
        //1) Reverse the whole array
        reverse(nums,0,n-1);
        
        //2)Reverse  k to n elements
        reverse(nums,k,n-1);
        
        //3)Reverse  0 to k-1 elements
        reverse(nums,0,k-1);
        
        //For left shift
        //1)Reverse whole array 
        //reverse(nums,0,n-1);
        //2) Reverse from n-k elements
        //reverse(nums,n-k,n-1);
        //3 reverse from 0 to n-k-1 elements
        //reverse(nums,0,n-k-1);
        
       
    }
    
    
    private void reverse(int[] nums, int i, int j){
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;     
    }
    
}

       