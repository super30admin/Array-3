//Time Complexity=O(n*k)
//Space Complexity=O(1)
public class RotateArrayByKBruteForce {

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        for(int i=0;i<k;i++){
            int prev=nums[n-1];
            for(int j=0;j<n;j++){
                int temp=nums[j];
                nums[j]=prev;
                prev=temp;
            }
        }
    }
}
