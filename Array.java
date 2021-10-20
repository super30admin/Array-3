public class Array{
    // time complexity : N
    // space complecity : 1
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/trapping-rain-water/solution/
    public int trap(int[] height) {
        if(height.length <=1) return 0;
        int l = 0;
        int r = height.length-1;
        int lw = 0;
        int rw = 0;
        int result = 0;
        while(l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    result = result + (lw - height[l]);
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r]<rw){
                    result = result + (rw - height[r]);
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }

    // time complexity : n
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/rotate-array/submissions/
    public void rotate(int[] nums, int k) {
       
        int n = nums.length;
         if(k>nums.length){
            k = k %n;
        }
        rotate(nums,0,n-1);
        rotate(nums,0,k-1);
        rotate(nums,k,n-1);
    }
    private void rotate(int[] nums,int i,int j){
        while(i<nums.length && j>= 0 && i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }

    // time complexity : n
    // space complexity:1
    // did it run on leetcode : yes
    // any doubts: no
    //https://leetcode.com/problems/h-index/submissions/
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucksort = new int[n+1];
        for(int i =0;i<citations.length;i++){
            if(citations[i]>n){
                bucksort[n]++;
            }else{
                bucksort[citations[i]]++;
            }
        }
        
        int sum = 0;
        for(int i = bucksort.length-1;i>=0;i--){
            sum = sum + bucksort[i];
            if(sum >= i){
                return i;
            }
        }
        
        return 0;
        
    }
}