//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n=citations.size();
        vector<int> result(n+1,0);
        
        for(int i=0;i<n;i++)
        {
            if(citations[i]>n)
            {
                result[n]++;
            }
            else
            {
                result[citations[i]]++;
            }
        }
        
        int sum=0;
        for(int i=result.size()-1;i>=0;i--)
        {
            sum+=result[i];
            if(sum>=i)
            {
                return i;
            }
        }
        return 0;
    }
};