class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0; 
        int max_height = 0; 

        for(int i = 0; i < height.size(); i++) {
            if(height[max_height] < height[i]) max_height = i; 
        }


        //calcuate amount of rain water held for left side: 
        int max_left = 0; 
        for(int i = 0; i <= max_height; i++) {
            if(height[max_left] < height[i]) max_left = i; 
            ans += min(height[max_left], height[max_height]) - height[i];
        }


        int max_right = height.size()-1; 
        for(int i = height.size()-1; i > max_height; i--) {
            if(height[max_right] < height[i]) max_right = i; 
            ans += min(height[max_right], height[max_height]) - height[i];
        }

        return ans; 


        // for(int i = 1; i < height.size()-1; i++) {
        //     int max_left = 0; 
        //     int max_right = 0;
        //     //to find max left: 
        //     for(int j = i; j >= 0; j--) {
        //         max_left = max(max_left, height[j]);
        //     }

        //     //to find max right: 
        //     for(int j = i; j < height.size(); j++) {
        //         max_right = max(max_right, height[j]);
        //     }

        //     ans += min(max_left, max_right) - height[i];
        // }

        //return ans;
    }
};