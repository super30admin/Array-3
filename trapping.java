// O(n)
class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int max = 0;
        int maxIdx = 0;
        int result = 0;
        for(int i=0;i<n;i++){
            if(height[i]>max){
                max = height[i];
                maxIdx = i;
            }         
        }
        // process left to max
        int l =0;
        for(int i = 1;i<maxIdx;i++){
            if(height[i]>height[l]){
                l=i;
            }else{
                result = result+height[l]-height[i];
            }
        }
        System.out.println(result);
        int r = n-1;
        for(int i =n-2;i>maxIdx;i--){
            if(height[i]>height[r]){
                r=i;
            }else{
                result = result+height[r]-height[i];
            }
        }
        return result;
    }
}