/*
Approach -1
1. loop through the entire aarray, and find the max height, and store its index in maxId. now we know fir usre that bigger wall exist in the array. 
***go from left to right//till maxId
2. assigm=n lw =0, curr pointer runnung from 0 to maxId. 
3. when we find curr < maxId; 
     and height[curr] > lw ; we can store water at curr pointer. 
4. result = result + lw - height[curr]
5. if lw < = height[curr]; then update lw = height[curr];
6. in any case, update curr++;

Now we'll go from right to left, till maxId; here my lw is standing at maxId, when we got out of While loop 
7. Start curr at n-1; and rw = 0; we surely know that a bigger left wall exist on the left side. 
8. check if curr > maxId; we check if the rw > curr; we can store water
9.  result = result + rw - height[curr];
10. otherwise, if rw <= height[curr]; we update rw == height[curr]
11. in any case; curr--;

TC: O(n) - 2 pass
SC: O(1)
*/
class Solution {
    public int trap(int[] height) {
        // base case
        if (height == null || height.length == 0)
            return -1; // shwing error

        int n = height.length;

        // let's find the bigger wall, and its index.
        int max = -1, maxidx = -1;

        for (int i = 0; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                maxidx = i;
            }
        }

        // we'll go from left to right
        int lw = height[0];
        int curr = 0;
        int result = 0;
        while (curr < maxidx) {
            if (lw > height[curr]) { // store the water
                result = result + lw - height[curr];
            } else {
                lw = height[curr];
            }
            curr++;
        }

        // now we're standing at the maxId, which is the bigger wall. let's consider
        // that as left wall and iterate from right side
        curr = n - 1;
        int rw = height[n - 1];

        while (curr > maxidx) {
            if (height[curr] < rw) { // store the water
                result = result + rw - height[curr];
            } else {
                rw = height[curr];
            }
            curr--;
        }
        return result;
    }
}

/*
 * Approach -2
 * 1. left wall 0; right wall is height of n-1; l =0, r =n-1
 * 2. we''ll do the simultaneous calculation of both the sides.
 * first check to perform over whe loop is - l <=r
 * a. now we check, if the lw <= rw ; we can store the water at left side,
 * so we also check , if the lw is greater than left pointer's height, if so ,
 * store it into result.
 * b. if lw > rw; we can surely store the water on the right side;
 * so we check for, if rw is greater to the right pointer's height, store it to
 * the result
 * 
 * At last return the result.
 * 
 * TC: O(n) - 1 pass
 * SC: O(1)
 */
class Solution {
    public int trap(int[] height) {
        // base case
        if (height == null || height.length == 0)
            return -1; // shwing error

        int n = height.length;

        // we'll go from left to right
        int lw = height[0], rw = height[n - 1];
        int l = 0, r = n - 1;
        int result = 0;

        while (l <= r) {

            // for left storage
            if (lw <= rw) {
                if (lw > height[l]) {
                    result = result + lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            }
            // lw is smaller than rightwall, look for storage on right side.
            else {
                if (height[r] < rw) {
                    result = result + rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}