// # Time Complexity : O(n)
// # Space Complexity : O(n)
// # Did this code successfully run on Leetcode : Yes
// # Three line explanation of solution in plain english
// # I use bucket sort to count each element lesser than array length. For numbers greater than array length are combined into the last element.
// Then I add all the counts from left to right. Whenever the sum becomes more or equal to index return index.

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int length = citations.size();
        int bucketLength = length + 1;
        int bucket[bucketLength];
        for (int i = 0; i < bucketLength; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < length; i++) {
            int num = citations[i];
            if (num >= length) {
                bucket[bucketLength-1]++;
            } else {
                bucket[num]++;
            }
        }
        int sum = 0;
        for (int i = bucketLength-1; i >= 0; i--) {
            sum += bucket[i];
            if (sum >= i) {
                return i; 
            }
        }
        return 0;
    }
};
