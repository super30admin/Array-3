//time: O(n)
//space: O(1)
//see sir sol for fewer lines - 8/19
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        if(n == 1 || n == 2) return 0;
        int result = 0;
        int maxi = 0, idx;
        for(int i = 0; i < n; i++) {
            if(height[i] > maxi) {
                maxi = height[i];
                idx = i;
            }
        }
        int i = 0;
        int blocked = 0;
        if(idx != 0) {
            for(int j = 1; j <= idx; j++) {
                if(j == idx) {
                    result += height[i]*(j-i-1);
                    result -= blocked;
                }
                else if((j-i) == 1 && height[j] >= height[i]) {
                    i = j;
                }
                else if(height[j] >= height[i]) {
                    result += height[i]*(j-i-1);
                    result -= blocked;
                    i = j;
                    blocked = 0;
                }
                else {
                    blocked += height[j];
                }
            }
        }
        blocked = 0;
        i = n-1;
        for(int j = i-1; j >= idx; j--) {
            if(j == idx) {
                result += height[i]*(i-j-1);
                result -= blocked;
            }
            else if((i-j) == 1 && height[j] >= height[i]) {
                i = j;
            }
            else if(height[j] >= height[i]) {
                result += height[i]*(i-j-1);
                result -= blocked;
                i = j;
                blocked = 0;
            }
            else {
                blocked += height[j];
            }
        }
        return result;
    }
};