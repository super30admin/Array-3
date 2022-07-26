// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    //time: O(n)
    //space: O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(nums == null|| n ==0) return;
        k=k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums, l, r);
            l++; r--;
        }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

/*
class Solution {
    //time: O(n)
    //space: O(1)
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        k = k%n;
        
        //reverse first n-k elements
        for(int i=0; i<(n-k)/2; i++){
            int temp1 = nums[i];
            nums[i] = nums[(n-k)-i-1];
            nums[(n-k)-i-1] = temp1;
        }
        
        //print(nums);
        
        //reverse first k elements
        int m=0;
        for(int j=(n-k); j<(n-k/2); j++){
            int temp2 = nums[j];
            nums[j] = nums[n-m-1];
            nums[n-m-1] = temp2;
            m++;
        }
        
        //print(nums);
        
        //reverse all elements
        for(int l=0; l<n/2; l++){
            int temp3 = nums[l];
            nums[l] = nums[n-l-1];
            nums[n-l-1] = temp3;
        }
        
        //print(nums);
    }
    
    private void print(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        
        System.out.println(" ");
    }
}
 */  
