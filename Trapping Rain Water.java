/*
class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0:
            return 0
        
        answer = 0
        lmax = 0
        rmax = 0
        l = 0
        r = len(height) - 1
        
        while l < r:
            if height[l] < height[r]:
                if height[l] > lmax:
                    lmax = height[l]
                else:
                    answer += lmax - height[l]
                l += 1
            
            else:
                if height[r] > rmax:
                    rmax = height[r]
                
                else:
                    answer += rmax - height[r]
                
                r -= 1
        return answer
*/

// Time - O(n) where n is height size
// Space - O(1)
// Logic - water will be trapped if the adjacent height is less than previous one and hence we travel accordingly
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        
        int l = 0, r = height.length - 1;
        int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
        //int lmax = 0, rmax = 0;
        int answer = 0;
        
        while (l < r){
            if (height[l] < height[r]){             // even if we do (height[l] <= height[r]) it will run right
                if (height[l] > lmax)               // even if we do (height[l] >= lmax) it will run right
                    lmax = height[l];
                else
                    answer += lmax - height[l];
                l++;
            }
            else {
                if (height[r] > rmax)               // even if we do (height[r] >= rmax) it will run right
                    rmax = height[r];
                else
                    answer += rmax - height[r];
                r--;
            }
        }
        return answer;
    }
}

            