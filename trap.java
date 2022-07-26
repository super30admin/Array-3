// approch 1
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1 forward pass backward pass
    public static int trap1(int[] height) {
        // null case
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;

        // two pointers for calculate water being trapped;
        int slow = 0;
        int fast = 0;
        int result = 0;
        int curr = 0;
        // forward pass
        while (fast < n) {
            // if we found height at slow pointer greater than the fast pointer
            // we add diffrence into current element
            // whenever we heat height that is at fast pointer greater than the slow pointer
            // height we add current into result and update the slow pointer
            // here after the peak element we are not encounter height greater than peak
            // element
            // so we are not going to add anything in result
            if (height[slow] > height[fast]) {
                curr += height[slow] - height[fast];
            } else {
                result += curr;
                slow = fast;
                // reset current
                curr = 0;
            }
            fast++;
        }
        // backward pass
        // same as the forward pass but here we are going backward until peak element
        fast = n - 1;
        slow = n - 1;
        curr = 0;
        while (fast >= 0) {
            if (height[slow] >= height[fast]) {
                curr += height[slow] - height[fast];
            } else {
                result += curr;
                slow = fast;
                // reset current
                curr = 0;
            }
            fast--;
        }
        return result;
    }

    // approch 2 left wall right wall
    public static int trap2(int[] height) {
        // null case
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;

        // two pointers for calculate water being trapped;
        int l = 0;
        int r = n - 1;
        // two walls for storing water
        int lw = 0;
        int rw = 0;
        int result = 0;

        while (l <= r) {
            // first we check whichever wall height is smaller we process on this side
            if (lw <= rw) {
                // here we check if height at left pointer is smaller than left wall than we add
                // diffrence into the result else we update the left heigth
                if (height[l] < lw) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if (height[r] < rw) {
                    result += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }
}