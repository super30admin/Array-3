//Leetcode : 189. Rotate Array
//Time Complexity: O(n) , n is the size of the array
//Space Complexity; O(1), No extra space used
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0) return;
        k=k%nums.length;
         reverse(nums,0,nums.length-1);       
         reverse(nums,k,nums.length-1);
        reverse(nums,0,k-1);
        
    }
    
    public int[] reverse(int[] arr,int i, int j){
        while(i<j){
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]= temp;
            i++;
            j--;
        }
        return arr;
    }
}