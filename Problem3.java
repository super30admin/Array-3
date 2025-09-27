
// Time Complexity: O(n)
// Space Complexity: O(1)

// We use the reverse method to reverse the elements in the array
// We first reverse the first n-k elements, then we reverse the last k elements
// Finally, we reverse the whole array to get the desired result

class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    void reverse(int a[],int l,int r){
        while(l<r){
            int t=a[l];
            a[l]=a[r];
            a[r]=t;
            l++;
            r--;
        }
    }
}