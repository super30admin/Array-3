// Time Complexity : O(n log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.size()==0){
            return 0;
        }
        sort(citations.begin(),citations.end());
        int n = citations.size();
        for(int i=0;i<n;i++){
            int diff = n-i;
            if(citations[i]>=diff){
                return diff;
            }
        }
        return 0;
    }
};

//Bucket sort

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.size()==0){
            return 0;
        }
        int n = citations.size();
        vector<int> buckets(n+1);
        for(int i=0;i<n;i++){
            if(citations[i]>=n){
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }
        int sum = 0;
        
        for(int i=n;i>=0;i--){
            sum = sum + buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return 100;
    }
};
