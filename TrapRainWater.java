/*
TC: O(N) N - length of array
SC: O(1) we are just using pointers. 

1. The units of water stored depends on it side walls and the current height. 
2. If the walls are of unequal height, the min height decides the capacity of storage.
3. We keep two walls leftMax and rightMax. Whichever is smaller decides area, we move from the direction of smaller wall.
4. Keep updating the area.

*/

public class TrapRainWater{
    public int trap(int[] arr){

        if(arr == null || arr.length == 0) return 0;

        int leftMax = 0, rightMax = 0, area = 0;
        int left = 0, right = arr.length - 1;

        while(left < right){
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);

            if(leftMax < rightMax){
                area += leftMax - arr[left];
                left++;
            }else{
                area += rightMax - arr[right];
                right--;
            }
        }

        return area;
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,1,0,2,0,1,01,3,2,1,2,1};
        TrapRainWater trap = new TrapRainWater();
        System.out.println(trap.trap(arr));
    }
}