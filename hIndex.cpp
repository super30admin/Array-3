// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Maintain another array of size greater by 1
// 2. Traverse through citations and increment that index of new array with index=citation value. If citation val goes out of bound, add to last element
// 3. Traverse new array and return index where running sum equals or exceeds index

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> nums(n+1);
        for(int i=0;i<n;i++){
            if(citations[i]>n)
                nums[n]++;
            else
                nums[citations[i]]++;
        }
        int sum=0;
        for(int i=n; i>=0; i--){
            sum+=nums[i];
            if(sum>=i)
                return i;
        }
        return -1;
    }
};
