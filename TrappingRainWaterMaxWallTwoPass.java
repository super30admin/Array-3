import java.util.Scanner;

public class TrappingRainWaterMaxWallTwoPass {

        // LEFT AND RIGHT PASSES TOWARDS MAX ELEVATION - TIME O(N) AND SPACE O(1)

        public int trap(int[] height) {

            int n = height.length;

            int maxEle = height[0];
            int maxIdx = 0;

            // find pivot = index of maximum elevation = enclosing limit for sure
            for(int i = 0; i < n; i++) {

                if(height[i] > maxEle) {

                    maxEle = height[i];
                    maxIdx = i;
                }
            }

            int result = 0;

            // left side pass
            int left = 0; int j = 0;

            // until max elevation
            while(j < maxIdx) {

                if(height[j] < height[left] ) {

                    result += height[left] - height[j];
                }

                // if height at iterator is at least as left pointer height, update left
                else {

                    left = j;
                }

                // increment iterator of while loop
                j++;
            }

            // right side pass
            int right = n-1; int k = n-1;

            // until max elevation
            while(k > maxIdx) {

                if(height[k] < height[right] ) {

                    result += height[right] - height[k];
                }

                // if height at iterator is at least as right pointer height, update right
                else {

                    right = k;
                }

                // decrement iterator of while loop to run inwards
                k--;
            }

            return result;
        }

        public static void main(String[] args) {

            TrappingRainWaterMaxWallTwoPass obj = new TrappingRainWaterMaxWallTwoPass();

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