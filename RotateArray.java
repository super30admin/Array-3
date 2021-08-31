//T.C:O(N); N is number of elements in array
//S.C:O(1)
class Solution {
    public void rotate(int[] nums, int k) {

        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);


    }
    public static void swap(int[] nums,int i,int j){
        int temp=0;
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void reverse(int num[], int start, int end){
        int i= start;
        int j= end;
        while(i<j)
        {
            swap(num,i,j);
            i++;
            j--;}

    }
}