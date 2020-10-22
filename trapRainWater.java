
//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: yes
/** Approach: At any point the water trapped will be min(left_max,right_max) heights
    so at each point we will update total of which is min among left max and right max **/

class Solution {
    public int trap(int[] height) {
        int low = 0;
        int high = height.length-1;
        int left_max=0, right_max=0;
        int total = 0;
        
        while(low<high){
            if(height[low]<height[high]){
                if(height[low]>left_max)
                    left_max = height[low];
                else
                    total += left_max - height[low];
                low++;
            }else{
                if(height[high]>right_max)
                    right_max = height[high];
                else
                    total += right_max - height[high];
                high--;
            }
        }
        
        return total;
    }
}
