//TC: O(n)
//SC : O(1)

//Idea : reverse the whole array first
//reverse 0  to k-1
//reverse k to n;

class Solution {
    public void rotate(int[] nums, int k) {
       
     if(k>nums.length){
         k = k % nums.length;
     }   
     rotaterArr(nums,0,nums.length-1);
     rotaterArr(nums,0,k-1);  
     rotaterArr(nums,k,nums.length-1);
        
     
    }
    
    public void rotaterArr(int[] nums,int l,int h){
        int n =nums.length;
        while (l<h && l<n && h<n){
            swap(nums, l,h);
            l++;
            h--;
        }
    }
    public void swap(int[] nums,int a , int b){
        int temp =0;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
