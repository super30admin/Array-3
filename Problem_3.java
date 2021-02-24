// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        for(int nu:nums){
            list.add(nu);
        }
        for(int i=0;i<k;i++){
            int temp=list.remove(list.size()-1);
            list.add(0,temp);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=list.get(i);
        }
    }
}

///
class Solution {
    public void rotate(int[] nums, int k) {
        int temp=0;
        for(int j=0;j<k;j++){
            temp=nums[0];
            for(int i=1;i<nums.length;i++){
                int val=nums[i] ;
                nums[i]=temp;
                temp=val;
            }
            nums[0]=temp;
        }

        //System.out.println(temp);
    }
}
///
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length-1;
        k=k%nums.length;
        reverse(nums,0,n);
        //System.out.println(Arrays.toString(nums));
        reverse(nums,0,k-1);
        //System.out.println(Arrays.toString(nums));
        reverse(nums,k,n);
        //System.out.println(Arrays.toString(nums));
    }
    
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    
}