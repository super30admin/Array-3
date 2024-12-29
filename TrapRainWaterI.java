// Time complexity = O(n)
// Space complexity = O(1)
// get max as the height (This is the biggest barrier)
// once we get this we know nothing can beat this.
// then start from the left and move towards the max.
// start from thr right and move towards the max.
class Solution {
    public int trap(int[] height) {
        int maxIdx = -1;
        int max=0;
        int result=0;
        for(int i=0;i< height.length;i++) {
            if(max< height[i]) {
                maxIdx = i;
                max = height[i];
            }
        }
        // got the max height -> max.
        // from left to max
        int left =0;
        int lw =0;
        while(left< maxIdx) {
            // lw is the let wall.
            // l is the left pointer.
            if(height[lw] > height[left]) {
                // will be able to trap water
                result+= height[lw]-height[left];
            } else {
                lw=left;
            }
            left++;
        }
        // from right to max
        int right = height.length-1;
        int rw = height.length-1;
        while(right> maxIdx) {
            if(height[rw] > height[right]) {
                // will be able to trap water.
                result+= height[rw]- height[right];
            } else {
                rw = right;
            }
            right--;
        }
        return result;
    }
}