//TC: O(3n/2) --> O(n)
//SC: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(nums.length == 0 || k==0)
            return;
        
        /*for(int i=0;i<k;i++)
        {
            int lNum = nums[nums.length-1];
            for(int j=nums.length-1;j>0;j--)                
                nums[j] = nums[j-1];
            nums[0] = lNum;
        }*/
        reverse(nums,0,nums.length-1); //reversing the entire string first.
        reverse(nums,0,k-1);        //Then till the k th index and then from k to end.
        reverse(nums,k,nums.length-1);  //So that, after completing these 3 sorts, array will stored as we wanted.
    }
    
    void reverse(int[] nums, int s, int e)
    {
        while(s<e)
        {
            nums[s] = nums[s]+nums[e];
            nums[e] = nums[s]-nums[e];
            nums[s] = nums[s]-nums[e];
            s++;
            e--;
        }
    }
}