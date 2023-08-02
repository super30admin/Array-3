import java.util.Scanner;

public class TrappingRainWaterPointerWallPair {

    // LEFT AND RIGHT POINTER WALL PAIRS - TIME O(N) AND SPACE O(1)

    /* Family of three problems
    Trapping rain water
    Container with most water
    Maximum rectangle in a histogram
    */

        public int trap(int[] height) {

            int n = height.length;

            // pointer - wall pairs
            int l = 0;      int r = n-1;
            int lw = 0;     int rw = 0;

            int result = 0;

            // until left pointer crosses right pointer
            while(l <= r) {

                // process from left if right wall is taller
                if(lw <= rw) {

                    // water trapped only if wall is at higher elevation than that of pointer
                    if(lw > height[l]) {

                        result += lw - height[l];
                    }

                    // update wall to pointer height if pointer is higher
                    else {

                        lw = height[l];
                    }
                    // move inwards
                    l++;
                }

                // process from right if left wall is taller
                else{

                    // water trapped only if wall is at higher elevation than that of pointer
                    if(rw > height[r]) {

                        result += rw - height[r];
                    }

                    // update wall to pointer height if pointer is higher
                    else {

                        rw = height[r];
                    }
                    // move inwards
                    r--;
                }
            }
            // output trapped water
            return result;
        }

        public static void main(String[] args) {

            TrappingRainWaterPointerWallPair obj = new TrappingRainWaterPointerWallPair();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Number of elevations: ");
            int n = scanner.nextInt();

            int[] height = new int[n];

            System.out.println("Elevations: ");
            for(int i = 0; i < n; i++) {
                height[i] = scanner.nextInt();
            }

            int answer = obj.trap(height);

            System.out.println("Water that can be trapped after raining is " + answer);
        }



}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(1)
*/