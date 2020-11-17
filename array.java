//trapping rain water
//Logic: tHE WATER TRAPPED WILL DEPEND UPON LOWER ELEVATION ,USE TWO POINTER MOVE IT WHEREVER THE HIGHT IS HIGH AND
//CHECK THE WATER TRAPPED BY CHECKING THE LEVEL 
O(N)
O(1)

class Solution {
    public int trap(int[] height) {
        
        if(height==null || height.length==0) return 0;
        int result=0 , left = 0 , right = height.length-1 , level=0;
        
        
        while(left< right){
            //lower elevation to find max water that can be trapped
            int lower = height[height[left] < height[right] ? left++ : right-- ];
            // check how much water is trapped
            level=Math.max(lower,level);
            result += level - lower;
        }
            
            
        return result;
    }
}

//Rotate Array
//O(N)
//O(1)
//Logic: rotate in 3 steps
//normal rotate ,rotate from start to k-1 and then k-1 to end
class Solution {
    public void rotate(int[] nums, int k) {
       if(nums.length==0 || k < 2) return ;
       //k > nums.length 
        k%= nums.length;
        reverse(nums,0,nums.length -1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    private void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}