// Time Complexity: O(n)
// Space Complexity: O(n)
// Did the code run successfully? Yes

// Approach: 
// 1. We will use two pointers, one starting from the left and one from the right of the array.
// 2. We will keep track of the maximum height seen from the left and right sides.
// 3. At each step, we will compare the heights at the two pointers and move the pointer with the smaller height inward.
// 4. If the height at the current pointer is less than the maximum height seen so far, we can trap water at that position.
// 5. We will add the difference between the maximum height and the current height to the total water trapped.

class Solution {
    public:
        int trap(vector<int>& height) {
            int count = 0, left = 0, right = height.size() - 1; 
            int leftMax = 0, rightMax = 0; 
    
            while(left <= right){
                if(height[left] < height[right]){
                    if(height[left] >= leftMax){
                        leftMax = height[left];
                    }else{
                        count += leftMax - height[left];
                    }
                    left++;
                }else{
                    if(height[right] > rightMax){
                        rightMax = height[right];
                    }else{
                        count += rightMax - height[right];
                    }
                    right--;
                }
            }
            return count;
        }
    };