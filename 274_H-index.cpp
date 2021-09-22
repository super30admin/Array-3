// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.empty() || citations.size() == 0)
            return 0;
        int n = citations.size();
        vector<int> index (n+1, 0);
        for(int citation : citations){
            if(citation >= n)
                index[n]++;
            else
                index[citation]++;
            
        }
        int rsum = 0;
        for(int i=n; i>=0; i--){
            rsum += index[i];
            if(rsum >= i)
                return i;
        }
        return 389;
    }
};
