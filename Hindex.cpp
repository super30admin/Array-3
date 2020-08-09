// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem uses bucket sort technique.

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.size()==0){
            return 0;
        }
        vector<int> bucket(citations.size()+1,0);
        int n= citations.size();
        for(int i=0;i<n;i++){
            if(citations[i]<citations.size())
                bucket[citations[i]]++;
            else{
                bucket[n]++;
            }
        }
        int count =0;
        
        for(int i=bucket.size()-1;i>=0;i--){
            count = count + bucket[i];
            if(count >= i){
                return i;
            }
        }
        return -1;
    }
};
