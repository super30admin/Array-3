//TC:O(n)
//SC: O(n)
class Solution {
public:
    int trap(vector<int>& height) {
       int n = height.size();
       int result = 0;

       int l = 0, lw = height[0];
       int r = n-1, rw = height[n-1];

       while(l<= r)
       {
           if(lw<rw)
           {
               if(height[l] < lw)
               {
                   result += lw - height[l];
               }else
               {
                   lw = height[l];
               }
               l++;
           }
           else{
               if(height[r] < rw)
               {
                   result += rw - height[r];
               }
               else
               {
                   rw = height[r];
               }
               r--;
           }
       } 
       return result;
    }
};