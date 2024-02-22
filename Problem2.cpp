class Solution {
public:
    int hIndex(vector<int>& citations) {
        if (citations.empty()) return 0;
        
        // Bucket Sort
        int n = citations.size();
        vector<int> buckets(n + 1, 0);

        for (int ele : citations) {
            if (ele >= n) {
                buckets[n]++;
            } else {
                buckets[ele]++;
            }
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
};