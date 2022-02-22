// Time Complexity :O(n) n is the length of the height array
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :yes
class Solution {
    public int trap(int[] height) {
       if(height == null || height.length == 0) return 0;
        int l = 0;
        int r =height.length -1;
        int lw =0;
        int rw =0;
        int result =0;
        while(l <= r){
            if(lw <= rw){
                if(height[l] < lw){
                    result += lw - height[l];
                }else {
                    lw = height[l];
                }
                l++;  
            }else {
                if(height[r] < rw){
                result += rw - height[r];
            }else{
                rw = height[r];
            }
            r--;
        }
    }
        return result;
    }
}
// Time Complexity :O(n) n is the length of the citations array
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :yes
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int [] buckets = new int[n+1];
        for(int i = 0;i< n;i++){
            if(citations[i] < n){
                buckets[citations[i]]++;
            }else{
                buckets[n]++; 
            }    
        }
        int sum =0;
        for(int i = n;i>=0;i--){
            sum+=buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}
// Time Complexity :O(n) n is the length of the nums array
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :yes
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length ==0) return;
       int n = nums.length;
        if(k > n){
            k = k%n;
        }
        //reverse the whole array
        reverse(nums,0,n-1);
        //reverse the array from k to n
        reverse(nums,k,n-1);
        //reverse the array from 0 to k-1
        reverse(nums,0,k-1);
    }
    public void reverse(int[] nums, int l, int r){
        while(l < r){
             swap(nums,l,r);
                l++;
                r--;
        }
       
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
