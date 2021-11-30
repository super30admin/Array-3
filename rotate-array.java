//Timecomplexity:- O(2n+2k-1);
//spacecomplexity:-O(1);
//Did it run on leetcode:- yes.
//Your approach with code:- first reversing the numbers, next reversing until k-1 and lastly reversing from k to last element.
//But in this process taking k to k modulo length for k>nums.length;

class Solution {
    public void rotate(int[] nums, int k) {
         reversing(nums,0,nums.length-1);
         k=k%nums.length;
        reversing(nums,0,k-1);
        reversing(nums,k,nums.length-1);
      
    }
    private void reversing(int[] nums,int front, int back){
        while(front<=back){
            int temp=nums[front];
            nums[front]=nums[back];
            nums[back]=temp;
            front++;
            back--;
        }
    }
}