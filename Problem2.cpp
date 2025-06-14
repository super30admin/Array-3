// Time Complexity : O(N)+O(Nlog(N)) #of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Sort array based on citations and traverse from start to end of array. 
// 2. If current citation is greater than or equal to remaining elements this will be our max value for h-index.

class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end());
        int n=citations.size();
        int ans=0;
        for(int i=0;i<n;i++){
            if(citations[i]>=(n-i)){ans=(n-i);break;}
        }
        return ans;
    }
};
