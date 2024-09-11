class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int temp=0;
        int[] arr = new int[n];
        int t;
        if(k>n){
            temp= k/n;
            int x = k-(n*temp);
            for(int i=0;i<n;i++){
                t=i+x;
                if(t>=n){
                    t=t-n;
                    arr[t]=nums[i];

                }else{
                    arr[t]=nums[i];

                }

            }
            

        }
        else{
            for(int i=0;i<n;i++){
                t=i+k;
                if(t>=n){
                    t=t-n;
                    arr[t]=nums[i];

                }
                else{
                    arr[t]=nums[i];

                }

            }

        }        
        for(int j=0;j<n;j++){
            nums[j]=arr[j];
        }
        
        
        
        
    }
}