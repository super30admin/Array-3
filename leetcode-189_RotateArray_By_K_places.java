/*
approach1
BF - rotate array k%n times
TC: O(nk)

Approach-2
reverse the entire array - in place
reverse 0 to k-1 elements
reverse k to n-1 elements
tc: O(n)
sc: O(1)

Aproach-3
reverse 0 to n-k-1 element
reverse n-k to n-1 elements
reverse 0 to n-1 elements
tc: O(n)
sc: O(1)
*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k%n; //in case k is bigger than n
        
        //1. reverse the entire array - swap method
        swap(nums, 0, n-1);
        //2 reverse 0 to n-k-1 elements
        swap(nums, 0, k-1);
        //3. reverse n-k to n-1
        swap(nums, k, n-1);
        
    }
    private void swap(int[] arr, int i, int j)
    {
       while(i<j)
       {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
           i++;
           j--;
           
       }
        //System.out.println("Swap: "+Arrays.toString(arr));
        return;
    }
}

//approach -2 
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k%n; //in case k is bigger than n
        
        //1. reverse the entire array - swap method
        swap(nums, 0, n-k-1);
        //2 reverse 0 to n-k-1 elements
        swap(nums, n-k, n-1);
        //3. reverse n-k to n-1
        swap(nums, 0, n-1);
        
    }
    private void swap(int[] arr, int i, int j)
    {
       while(i<j)
       {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
           i++;
           j--;
           
       }
        //System.out.println("Swap: "+Arrays.toString(arr));
        return;
    }
}
