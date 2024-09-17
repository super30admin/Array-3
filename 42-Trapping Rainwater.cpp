/*
TC = O(n)
SC = O(1)
where n is the size of the height array.
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int l=0,r=n-1;
        int lw=0,rw=0;
        int ans=0;
        while(l<=r)
        {
            if(lw<=rw)
            {
                if(height[l]<lw)
                {
                    ans+=(lw-height[l]);
                }   
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else
            {
                if(height[r]<rw)
                {
                    ans+=(rw-height[r]);
                }   
                else
                {
                    rw = height[r];
                }
                r--;
            }
        }
        return ans;
    }
};

/*
TC = O(n)
SC = O(1)
where n is the size of the height array.
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int l=0,r=n-1;
        int lw=0,rw=0;
        int ans=0;
        while(l<=r)
        {
            if(lw<=rw)
            {
                lw = max(lw,height[l]);
                ans+=(lw-height[l]);
                l++;
            }
            else
            {
                rw = max(rw,height[r]);
                ans+=(rw-height[r]);
                r--;
            }
        }
        return ans;
    }
};
