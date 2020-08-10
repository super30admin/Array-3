//Time: O(N)
//Space: O(1)
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size()<2) return;
        int n = nums.size();
        if(k>n){
            k = k%n;
        }
        reverse(nums, 0, n-1);
        reverse(nums,0,k-1);
        reverse(nums,k, n-1);
    }
    
    void reverse(vector<int>& nums,int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    void swap(vector<int>& nums, int& i, int& j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};