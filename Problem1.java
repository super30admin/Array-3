/*
Trapping Rain Water
approach: at each iteration, we have to keep track of left max and right max;
1. O(n)memory calculate left and right max for each element and put in seperate arrays, at last min(lmax, rmax)-height[i] gives water
2. O(1)memory, take 2 pointers at 0 and n-1, all we care about is which is small, so move that side and calculate
time: O(n)
 */
public class Problem1 {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1;
        int lmax = height[0], rmax = height[r];
        int water = 0, curr = 0;
        while(l<r) {
            //check if left<right
            if(height[l]<height[r]) {
                l++;
                lmax = Math.max(lmax, height[l]);
                curr = lmax-height[l];
                water+=curr<0?0:curr;
            }
            else {
                r--;
                rmax = Math.max(rmax, height[r]);
                curr = rmax-height[r];
                water+=curr<0?0:curr;
            }
        }
        return water;
    }
}
