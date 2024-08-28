//Time = O(n)
//Space = O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length; // get the length of the input array
        int left = 0, right = n - 1; // initialize left and right pointers
        int leftMax = 0, rightMax = 0; // initialize left and right maximums
        int ans = 0; // initialize the answer variable to 0
        
        while (left < right) { // iterate until the left and right pointers meet
            if (height[left] < height[right]) { // if the height at left pointer is less than that at right pointer
                if (height[left] >= leftMax) { // if the height at left pointer is greater than or equal to left maximum
                    leftMax = height[left]; // update left maximum
                } else { // otherwise
                    ans += leftMax - height[left]; // add the difference between left maximum and height at left pointer to the answer
                }
                left++; // move left pointer to the right
            } else { // if the height at right pointer is less than or equal to the height at left pointer
                if (height[right] >= rightMax) { // if the height at right pointer is greater than or equal to right maximum
                    rightMax = height[right]; // update right maximum
                } else { // otherwise
                    ans += rightMax - height[right]; // add the difference between right maximum and height at right pointer to the answer
                }
                right--; // move right pointer to the left
            }
        }
        return ans; // return the answer
    }
}
