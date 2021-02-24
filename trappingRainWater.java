/*time complexity O(n)
space complexity O(n)
approach: populate the left and right max arrays by comparing each element with max value till that point 
water trapped at that point will be minimum of left and ight max at that point minus height of building */


class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        int n=height.length;
        int[] left_max=new int[n];
        left_max[0]=height[0];
        int[] rght_max=new int[n];
        rght_max[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            if(height[i]>left_max[i-1]){
                left_max[i]=height[i];
            }
            else{
                left_max[i]=left_max[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(height[i]>rght_max[i+1]){
                rght_max[i]=height[i];
            }
            else{
                rght_max[i]=rght_max[i+1];
            }
        }
        int sum=0;
        for(int i=1;i<n-1;i++){
            sum+=Math.min(rght_max[i],left_max[i])-height[i];
        }
        return sum;
    }
}