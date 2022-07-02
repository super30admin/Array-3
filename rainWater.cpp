O(N) time, O(1) space
class Solution {
public:
    int trap(vector<int>& height) {
        int maxWater = 0;
        int size = height.size();
        int l=0, r = size-1;
        int lw = 0, rw = 0; //heights
        while(l <= r){
            if(lw<=rw){ //right side dam, process left
                if(lw >= height[l]){
                    maxWater += lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{ //left side dam, process right
                if(rw >= height[r]){
                    maxWater += rw - height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return maxWater;
    }
};
