//Time O(n)
//Space O(1)
//Leetcode: yes
//Issue seen: none
class Solution {
public:
    int trap(vector<int>& height) {
        int i=0;
        int j= height.size()-1;
        int ans = 0;
        
        int LH = height[i];
        int LR = height[j];

        while(i<j){
            //check the left height
            if(LH <= LR){
                i++;
                LH = max(LH, height[i]);
                ans = ans + (LH-height[i]);
            } else {
                j--;
                LR = max(LR, height[j]);
                ans = ans + (LR-height[j]);
            }
        }
        return ans;
    }
};
