Brute : O(N) time and O(N) space
O(N) time and O(1) space

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(k>n) k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    
    void reverse(vector<int>& nums, int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    
    void swap(vector<int>& nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
};
