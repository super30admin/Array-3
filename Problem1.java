//finding the max height wall and calculting the trapper water on left and right

// o(n) time complexity
// O(1) space complexity


class Solution {
    public int trap(int[] height) {
        
        int units = 0;
        int max = 0;
        int maxId = -1;
        int n = height.length;

        for(int i = 0 ; i<n ; i++){
            if(height[i] > max){
                max = height[i];
                maxId = i;
            }
        }

        int lw = 0;;
        int l = 1;

        while(l < maxId){
            if(height[l] < height[lw]){
                units = units + (height[lw] - height[l]);
            } else {
                lw = l;
            }
            l++;

        }

        int rw = n-1; int r = n-2;

        while(r > maxId){
            if(height[rw] > height[r]){
                units = units + (height[rw]- height[r]);
            } else {
                rw = r;
            }
            r--;
        }

        return units;
        
    }
}
