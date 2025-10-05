#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We count how many papers have exactly i citations using a bucket array.
If a paper has more than n citations, we treat it as n because H-index can't exceed total papers.
We go backward from n to 0, and the first index where cumulative count sum ≥ i, that's the H-index.
*/
class Solution{
public:
    int hIndex(vector<int>& citations){
        int n = citations.size();
        vector<int> buckets(n + 1, 0);

        for(int ele : citations){
            if(ele > n) buckets[n]++;
            else buckets[ele]++;
        }

        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += buckets[i];
            if(sum >= i) return i;
        }
        return -1;
    }
};
