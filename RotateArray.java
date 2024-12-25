// Time complexity:
//Reversing ist n elements O(n), reversing 1 st k elements O(k) and reversing last n elements isO(n-k).
// So overall tc is O(n)+ O(n-k)+ O(k) = O(2n) = O(n)
// Space complexity: O(1)
public class RotateArray {
        public void rotateArray( int [] nums, int k ){
            int n = nums.length;
            k = k % n; // ifk > n we take mod value

            reverse ( nums, 0, n-1); // reverse all the numbers
            reverse (nums,0, k-1); // reverse  1 st k numbers
            reverse(nums, k, n-1); //  reverse numbers from k to n
        }

        private void reverse(int [] nums, int start, int end){

            while( start< end){
                swap (nums, start, end);
                start++;
                end--;
            }
        }

        private void swap( int [] nums, int start, int end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        public static void main(String [] args){
            RotateArray solution = new RotateArray();

            int[] nums = {-1,-100,3,99};
            int k = 2;
            solution.rotateArray(nums, k);

            for ( int num : nums){
                System.out.println(num + "");
            }

        }
    }


