class Rotate{

private void rotateByK(int[] nums, int k)
{
    int n = nums.length;
    int k = k%n;
    
  
     reverse(nums , 0 , n-1);
     reverse(nums, 0, k)
     reverse(nums, k+1, n-1);
     return; 
}
  
  
  private void reverse(int[] nums , int i , int j)
  {
  
    while(i < j)
    {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;

    }
  }
  

}
