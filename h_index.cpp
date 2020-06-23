//Time Complexity=O(n)
//Space Complexity=O(n)
//Ran successfully on leetcode

class Solution {
public:
    int hIndex(vector<int>& citations) {
        //Keep an array for storing then count o
        if(citations.empty())
        return 0;
        int n = citations.size();
        vector<int>buckets(n + 1, 0);
        for(int i = 0; i < n; ++i){
            if(citations[i] >= n)
                buckets[n]++;
            else
                buckets[citations[i]]++;
        }
        int paper = 0;
        for(int i = n; i >= 0; --i)
        {
            paper += buckets[i];
            if(paper >= i)
                return i;
        }
        return -1;
    }
};