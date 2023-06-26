
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// we calculate the water trapped at each index, so to do that, we need to know the Lmaxheight and Rmaxheight.\
// we precompute the values and use them to get the answer.

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int>Lmax(n,0),Rmax(n,0);
        Lmax[0] = height[0];
        Rmax[n-1] = height[n-1];
        for(int i = 1;i<n;i++){
            Lmax[i] = max(Lmax[i-1],height[i]);
        }
        for(int i = n-2;i>=0;i--){
            Rmax[i] = max(Rmax[i+1],height[i]);
        }
        long long ans = 0;
        for(int i = 0;i<n;i++){
            ans+= (min(Rmax[i],Lmax[i]) - height[i]);
        }
        return ans;
    }
};

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int rwall = -1,lwall = -1;
        int left = 0,right = n-1;
        int ans = 0;
        while(left<=right)
        {
            if(lwall<rwall)
            {
                if(lwall<=height[left])
                {
                    lwall = height[left];
                }
                else
                {
                    ans+= lwall-height[left];
                }
                left++;
            }
            else
            {
                if(rwall<=height[right])
                {
                    rwall = height[right];
                }
                else
                {
                    ans+= rwall-height[right];
                }
                right--;
            }
        }
        return ans;
    }
};