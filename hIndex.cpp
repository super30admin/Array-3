// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int hIndex(vector<int>& citations) {
        vector<int> hIndex(citations.size()+1, 0);
        for(int i = 0; i<citations.size();i++){
            if(citations[i] > citations.size()) hIndex[citations.size()]++;
            else hIndex[citations[i]]++;
        }
        int sum = 0;
        for(int i = hIndex.size()-1;i >=0;i--){
            sum+=hIndex[i];
            if(i <= sum) return i;
        }
        return 98;
    }
};