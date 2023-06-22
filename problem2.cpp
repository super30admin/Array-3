
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach 1: using sorting 
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int hIndex(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        int n = arr.size();
        for(int i = 0;i<n;i++)
        {
            if(arr[i]>=n-i) return n-i;
        }
        return 0;
    }
};

// Approach 2: using count sort
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int>v(n+1,0);
        for(int i = 0;i<n;i++){
            if(citations[i]>=n){
                v[n]++;
            }
            else{
                v[citations[i]]++;
            }
        }
        int rsum = 0;
        for(int i = n;i>=0;i--){
            rsum+=v[i];
            if(rsum>=i) return i;
        }
        return 99;
    }
};