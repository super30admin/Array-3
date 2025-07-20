//Time Complexity : O(nlogn)
//Space Complexity : O(1)
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end());
        int ans=0;
        for(int i=citations.size()-1;i>=0;i--){
            if(citations[i]>ans){
                ans++;
            }
            else 
                break;
        }
        return ans;
    }
};