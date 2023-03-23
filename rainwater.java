class Solution {
    public int trap(int[] height) {
        int i = 0;
        if(height.length==0) return 0;
        int j = height.length-1;
        int left = 0;
        int right = 0;
        int count = 0;
        while(i<j){
            left = Math.max(left,height[i]);
            right = Math.max(right,height[j]);
            if(left<right){
                count = count + left-height[i];
                i++;
            }
            else {
                count = count + right-height[j];
                j--;
            }
    }
        return count;}
}