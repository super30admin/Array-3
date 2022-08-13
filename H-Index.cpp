// Appraoch 1 - Sprt the array
// Time Complexity - O(nlogn)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int n = citations.size();
        for(int i = 0; i < n; i++){
            int diff = n - i;
            if(citations[i] >= diff)
                return diff;
        }
        return 0;
    }
};

// Appraoch 2 - Bucket Sort
// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> buckets(n+1);
        
        for(int i = 0; i < n; i++){
            if(citations[i] >= n)
                buckets[n]++;
            else
                buckets[citations[i]]++;
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += buckets[i];
            if(sum >= i)
                return i;
        }
        return 0;
    }
};