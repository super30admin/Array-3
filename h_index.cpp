// Time Complexity : O(n*logn)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this -

class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int len = citations.size();
        
        int i;
        
        // Sort
        sort(citations.begin(), citations.end());
        
        int max_h = -1;
        int temp_h;
        
        // Find the max h index
        for(i = 0; i < len; i++)
        {
            temp_h = min(citations[i],(len-i));
            
            if(temp_h > max_h)
            {
                max_h = temp_h;
            }
        }
        
        return max_h;
    }
};