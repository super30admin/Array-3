/*
Time: O(n + max_citation)
Space: O(max_citation)

Binary search
    - if kth paper has k citations, the h-index is atleast k (update lo value) 
    - otherwise, h-index is atmost k-1 (update hi value)

*/

class Solution {
public:
    //bucket sort in descending order
    //space = time = o(max_value)
    vector<int> bucket_sort(vector<int>& c){
        int maxi = 0;

        for(auto u: c)  maxi = max(maxi, u);

        vector<int>cnt(maxi+1, 0);
        for(auto u: c)  cnt[u]++;

        vector<int> ret;
        for(int i=maxi; i>=0; i--){
            while(cnt[i]--)  ret.push_back(i);
        }

        return ret;
    }

    int hIndex(vector<int>& cites) {
        int n = cites.size();
        
        //O(max_citation)
        vector<int> sorted = bucket_sort(cites);
        
        //edge case
        if(sorted[0] == 0)  return 0;

        //binary search
        //if kth paper has k citations, the h-index is atleast k (update lo value) 
        //otherwise, h-index is atmost k-1 (update hi value)

        //O(log(n))
        int lo = 0, hi = n-1;
        while(lo<hi){
            int mid = (lo+hi+1)/2;

            if(sorted[mid] >= mid+1)  lo = mid;
            else  hi = mid-1;
        }

        return lo+1;
    }
};
