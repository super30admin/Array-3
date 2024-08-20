# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

class Solution {
    public int trap(int[] height) {
        int i, n= height.length, water = 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        left[0] = height[0];
        for (i=1;i<n;i++)
            left[i] = Math.max(left[i-1], height[i]);

        right[n-1] = height[n-1];
        for (i=(n-2);i>=0;i--){
            right[i] = Math.max(right[i+1], height[i]);
        }

        for (i=0;i<n;i++){
            water += Math.min(left[i], right[i]) - height[i];
        }
        return water;
    }
}

## Problem2 H-Index (https://leetcode.com/problems/h-index/)

class Solution {
public:
    int hIndex(vector<int>& c) {
        sort(c.begin(), c.end());
        int n = c.size();
        int maxi = 0;
        for(int i = 0; i < n; i++) {
            if(c[i] >= n - i) {
                maxi = max(maxi, n - i);
            }
        }
        return maxi;
    }
};

## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

void rotate1(int nums[],int start,int end) {
    int temp,i;
    for(;start<end;start++,end--){
        temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
}
void rotate(int* nums, int numsSize, int k){

    int k2=(k%numsSize);
    // int k1=numsSize-k2;
    rotate1(nums,0, k2-1);
    rotate1(nums,k2,numsSize-1);
    // rotate1(nums,0,numsSize-1);
}