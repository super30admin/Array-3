//time complexity: O(n)
//space complexity: O(1)
//executed on leetcode: yes

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<2) return;
        if(k>nums.length) k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums,int first,int last)
    {   while(first<last)
        {
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
        first++;
        last--;
        }
        
    }
}

//if rotation is to be done left by k steps
//input : [1,2,3,4,5,6,7] , k= 3
//output : [4,5,6,7,1,2,3]

/**

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<2) return;
        if(k>nums.length) k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
    }
    public void reverse(int[] nums,int first,int last)
    {   while(first<last)
        {
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
        first++;
        last--;
        }
        
    }
}

**/


