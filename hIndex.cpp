//time complexity:O(nlogn)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using sorting
//any issues faced? no

class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end());
        int l=0;
        int r=citations.size()-1;
        int n=citations.size();
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(citations[mid]==n-mid)
                return n-mid;
            else if(citations[mid]<n-mid)
                l=mid+1;
            else
                r=mid-1;
        }
        return n-l;
    }
};