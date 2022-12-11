class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int v =0, i =0;
        while(v!=n){
            int p = nums[i], j = (i+k)%n;
            while(j!=i){
                ++v;
                int t = nums[j];
                nums[j] = p;
                p = t;
                j = (j+k)%n;
            }
            ++v;
            nums[i] = p;
            ++i;
        }
    }
}
//tc = O(n)
//sc = O(1)
