import java.util.Arrays;

public class TestArray3 {
    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();
        int [] test1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] test2 = {4,2,0,3,2,5};
        int [] test3 = {1,2,3,4,5};
        System.out.println("Amount of water trapped " +solver.trap(test1));
        System.out.println("Amount of water trapped " +solver.trap(test2));
        System.out.println("Amount of water trapped " +solver.trap(test3));
        //tests for HIndex
        HIndex2 helper = new HIndex2();
        int[] citations = {3,0,6,1,5};
        System.out.println("HIndex of the given citation are " +helper.hIndex(citations));
        // Test for Rotating Array with k elements
        RotateArray processor = new RotateArray();
        int [] rotateArray1 = {1, 2, 3, 4, 5, 6, 7};
        processor.rotate(rotateArray1, 3);
        System.out.println("Rotated array by k=" + 3 + " is " + Arrays.toString(rotateArray1));    }
}
