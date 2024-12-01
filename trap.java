class Solution {
    public int trap(int[] height) {
        int slow=0,fast=0;
        int n=height.length;
        int curr=0,res=0;

        for(fast=1; fast<n; fast++){
            if(height[fast]<=height[slow]){
                curr+=height[slow]-height[fast];
            }
            else{
                res+=curr;
                curr=0;
                slow=fast;
            }
        }
        curr=0;
        slow=n-1;
        for(fast=n-2;fast>=0;fast--){
            if(height[fast]<height[slow]){
                curr+=height[slow]-height[fast];
            }
            else{
                res+=curr;
                curr=0;
                slow=fast;
            }
        }
        return res;
    }
}
