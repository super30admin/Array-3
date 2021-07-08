//TC: O(n)
//SC : O(1)

class Solution {
    public int trap(int[] height) {
        if(height.length<3 ) return 0;
        int result =0;
        int l=0; int r=height.length-1;
        
        while(l<r && height[l]<height[l+1]) l++;
        
        while(l<r && height[r]<height[r-1]) r--;
        
        while(l<r){
            int ptr1 = l;
            int ptr2 = r;
            if(height[ptr1]<height[ptr2]){
                while(l<r && height[ptr1]>height[++l]){
                    result += height[ptr1] - height[l];
                }
            }else{
                while(l<r && height[ptr2]>height[--r]){
                    result += height[ptr2] - height[r];
                }
            }
        }
        return result;
    }
}
