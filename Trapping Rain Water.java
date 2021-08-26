class Solution {
    public int trap(int[] height) {

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftmax = 0;
        int rightmax = 0;
        int ans = 0;

        for(int i=0 ; i<height.length ; i++){

            leftmax = Math.max(leftmax,height[i]);
            left[i] = leftmax;
        }

        for(int i=height.length-1 ; i>=0 ; i--){

            rightmax = Math.max(rightmax,height[i]);
            right[i] = rightmax;
        }

        for(int i=0 ; i<height.length ; i++){

            int possible_ht = Math.min(left[i],right[i]);

            ans = ans + (possible_ht - height[i]);

        }

        return ans;
    }
}
