//Time Complexity=O(n)
//Space Complexity=O(n)
public class RotateArrayByKPlacesNSpace {

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] nums1=new int[n];
        int j=0;
        k=k%n;
        for(int i=n-k;i<n;i++){
            nums1[j++]=nums[i];
            // System.out.println(nums1[j-1]);
        }

        for(int i=0;i<n-k;i++){
            nums1[j++]=nums[i];
        }

        for(int i=0;i<n;i++){
            nums[i]=nums1[i];
        }
    }
}
