package s30.arrays.array3;


//Algo: observe the input carefully, we can reverse whole array and reverse  small parts for k

//TC: O(n);
//SC: O(1);
public class RotateArray {

    public void rotate(int[] nums, int k) {

        k = k%nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }

    private void reverse(int[] arr, int start, int end){

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {

    }
}
