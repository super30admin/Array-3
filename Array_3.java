// Trapping Rain water
//Time Complexity-> O(n)
//Space Complexity ->O(1)
class Solution {
    //Using 2 pointers
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int max = 0; 
        int maxIdx = 0;
        int result = 0;
        //For loop to get the maximum height and its index
        for(int i = 0 ; i<n;i++){
            if(height[i]>max){
                max = height[i];
                maxIdx = i;
            }
        }

        int l = 0;
        int lw = 0;
        while(l<maxIdx){
            if(height[l] > lw){
                lw = height[l];
            }else{
                result = result + (lw - height[l])*1;
            }
            l++;
        }

        int r = n-1;
        int rw = 0;
        while(r>maxIdx){
            if(height[r] > rw){
                rw = height[r];
                
            }else{
                result = result + (rw - height[r])*1;
            }
            r--;
        }

        return result;
        
    }
}

//H-Index
//Time Complexity -> O(n)
//Space Complexity->O(1)
class Solution {
    //Using linear search
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i<n;i++){
            int diff = n - i;
            if(diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }
}

//Rotate array by k places
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k%n;
        //1st method
        //first reverse the whole array
        reverse(nums,0,n-1);
        //then rotate the first k elements
        reverse(nums,0,k-1);
        //then rotate the next n-k elements
        reverse(nums,k,n-1);

        
    }

    private void reverse(int[] nums,int l,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }

    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k%n;
        //2nd method
        //first reverse the first n-k elements
        reverse(nums,0,n-k-1);
        //then reverse the next k,..n-1 elements
        reverse(nums,n-k,n-1);
        //then reverse the whole array
        reverse(nums,0,n-1);

        
    }

    private void reverse(int[] nums,int l,int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }

    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}

