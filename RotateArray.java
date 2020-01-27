/**
LeetCode Submitted : YES
Space Complexity : O(2N)
Time Complexity : O(N)

The idea is to use list twice the size to find the pivot element and then store the elements from pivot element till we reach length of array num.
**/


class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        List<Integer> l = new ArrayList<Integer>();
        
        if(nums == null || nums.length < 1)
            return;
        
        else{
            
            
            for(int i : nums){
                l.add(i);    
            }
        
        
            for(int i : nums){
                l.add(i);    
            }
            
            if(length >= k){
                int pivot = length - k;
        
                //int[] output = new int[length];
                int count = 0;
                for(int i = pivot;i<length + pivot;i++){
                    nums[count] = l.get(i);
                    count++;
                }    
            }else{
                int pivot = 2*length - k;
        
                //int[] output = new int[length];
                int count = 0;
                for(int i = pivot;i<pivot+length;i++){
                    nums[count] = l.get(i);
                    count++;
                }    
                
            }
            
        } 
    }
}
