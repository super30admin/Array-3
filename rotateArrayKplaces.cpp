#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We move elements to their new positions by rotating them in cycles using modular arithmetic.
Each cycle ends when we return to the starting index, and we repeat from the next unvisited index.
We keep track of the number of moved elements to ensure we cover the whole array.
*/
class Solution{
public:
    void rotate(vector<int>& nums, int k){
        int n = nums.size();
        k = k % n;
        int count = 0;

        for(int i = 0; i < n; i++){
            int currIdx = i;
            int prev = nums[i];

            do{
                int nextIdx = (currIdx + k) % n;
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;
                currIdx = nextIdx;
                count++;
            }while(i != currIdx);
        }
    }
};
