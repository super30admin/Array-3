//Tc = O(n)
//SC = O(n)
//Here we are finding the index and copying the element into new array using new index.

class RotateArray{
    public void rotate(int[] nums, int k) {
        int res[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[(i+k)%nums.length] = nums[i];
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = res[i];
        }

    }

}