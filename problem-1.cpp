// t-c: n
// s-c: 1
class Solution {
public:
    int trap(vector<int>& height) {
        int result = 0, lw = 0, l = 1, rw = height.size()-1, r = rw-1;
        while(l <= r){
            if(height[lw] < height[rw]){
                if(height[l] < height[lw]){
                    result += (height[lw] - height[l]);
                }
                else{
                    lw = l;
                }
                l++;
            }
            else{
                if(height[r] < height[rw]){
                    result += (height[rw] - height[r]);
                }
                else{
                    rw = r;
                }
                r--;
            }
        }
        return result;   
    }
};
