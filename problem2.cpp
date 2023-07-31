/*
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Sort the array in ascending order and find the index in reverse order like from n to 1, where citation is >= index.
*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(),citations.end());
        int n = citations.size();
        for(int i{};i<n;++i){
            if(citations.at(i)>=n-i) return n-i;
        }
        return 0;
    }
};

/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
add the elements to a hashmap. Go from largest index to smallest and add the totat number of papers in the bucket.
When the number of papers increase than index give that index.
*/

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> hashmap(n+1,0);
        for(int i{};i<n;++i){
            if(citations.at(i)>n) hashmap.at(n)++;
            else hashmap.at(citations.at(i))++; 
        }
        int sum{};
        for(int i{n};i>=0;--i){
            sum = sum+hashmap.at(i);
            if(sum>=i) return i;
        }
        return 0;
    }
};