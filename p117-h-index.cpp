// Time Complexity: O(NlogN) N = size of citations vector
// Space Complexity: O(1)
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        for(int i = 0; i < citations.size(); i++) {
            int diff = citations.size() - i;
            if(diff <= citations[i])
                return diff;
        }
        return 0;
    }
};

// Using Bucket sort
// Time Complexity: O(n) n = size of citations vector
// Space Complexity: O(n) n+1 = size of buckets vector
class Solution {
public:
    int hIndex(vector<int>& citations) {
        vector<int> buckets(citations.size()+1, 0);
        int sum = 0;
        for(int i = 0; i < citations.size(); i++) {
            if(citations[i] > citations.size()-1)
                buckets[citations.size()]++;
            else 
                buckets[citations[i]]++;
        }
        
        for(int i = buckets.size()-1; i >= 0; i--) {
            sum += buckets[i];
            if(sum >= i)
                return i;
        }
        
        return 0;
    }
};
