class Solution {
    public void rotate(int[] nums, int k) {
        
        //O(n)time and O(n)space approach
//         int[]temp = new int[nums.length];
        
        
//         for(int i = 0; i < nums.length;i++)
//         {
//             temp[(i+k) % nums.length] = nums[i];
//         }
        
//         for(int i = 0; i <nums.length;i++)
//         {
//             nums[i] = temp[i];
//         }
         k %= nums.length;
        
        //better approach is O(n)time and O(1)space
        //first reverse the entire array
        //then reverse the first k elements
        //then reverse the n-k elements
        /*
        time complexity :O(n)
        space complexity :O(1)
        */
        System.out.println(k);
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
    
    
    public void reverse(int[]nums,int start,int end)
    {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}