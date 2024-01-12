//TC O(n)
//SC O(1)

//Two pass method.
//1. Find the largest wall in the array.
//1. Iterate from left to the tallest wall. If lw > l calculate area else move lw to current wall
//2. Iterate from right to the tallest wall. Perform the same steps.

class Problem1 {
    public int trap(int[] height) {
        int lw=0;
        int l=0;
        int heightMax = 0;
        int heightIndex = -1;
        for(int i=0;i<height.length;i++){
            if(height[i] > heightMax){
                heightMax = height[i];
                heightIndex = i;
            }
        }
        int area = 0;
        while(l < heightIndex){
            if(lw > height[l]){
                area += lw - height[l];
            } else {
                lw = height[l];
            }
            l++;
        }

        int rw = 0;
        int r = height.length-1;
        while(r > heightIndex){
            if(rw > height[r]){
                area += rw - height[r];
            } else {
                rw = height[r];
            }
            r--;
        }

        return area;
    }
}