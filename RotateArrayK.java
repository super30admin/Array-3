


//Time Complexity :O(n)
//Space Complecity :O(1)
//Did it run on leetcode : yes

    class Solution {
        public void rotate(int[] nums, int k) {

            if(nums.length == 1)
                return;
           // if(nums.length)
          if(k > nums.length)  
            k = k % nums.length;
          reverse(nums,0,nums.length-1);
          reverse(nums,0,k-1);
          reverse(nums,k,nums.length-1);

        }


        private void reverse(int[] nums,int start , int end){
            for(start= start; start<end;start++ ){
            int temp = nums[start];
            nums[start] = nums[end]; 
            nums[end] = temp;
            end--;
        }
        }
    }