//problem1
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int max=0;
        int maxid=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(max<height[i]){
                max=height[i];
                maxid=i;
            }
        }
        int lw=0;
        int i=0;
        while(i<maxid){
            if(lw<=height[i]){
                lw=height[i];
            }else{
                res+=lw-height[i];
            }
            i++;
        }
        int rw=0;
        int j=n-1;
        while(j>maxid){
            if(rw<height[j]){
                rw=height[j];
            }else{
                res+=rw-height[j];
            }
            j--;
        }
        return res;
    }
}
//problem2
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
//problem3
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void reverse(int[] nums,int l,int r){
        while(l<r){
            int te=nums[l];
            nums[l]=nums[r];
            nums[r]=te;
            l++;
            r--;
        }
        return;
    }
}
