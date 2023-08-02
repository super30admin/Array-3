import java.util.Scanner;
import java.util.Arrays;
public class HIndexArraySort {

        // ARRAY SORT METHOD - TIME O(NlogN) AND SPACE O(1)

        public int hIndex(int[] citations) {

            if(citations == null)    return 0;

            Arrays.sort(citations);       // O(NlogN)

            int n = citations.length;

            // iterate over citations array to get H-index
            for(int i = 0; i < n; i++) {   // O(N)

                // how many papers got more than i-citations
                int cit = n - i;

                // at least h papers getting at least h citations
                if(citations[i] >= cit) {

                    // output h-index
                    return cit;
                }
            }

            return 0;
        }

        public static void main(String[] args) {

            HIndexArraySort obj = new HIndexArraySort();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Number of papers:  ");
            int n = scanner.nextInt();

            int[] citations = new int[n];

            System.out.print("Number of Citations:  ");
            for(int i = 0; i < n; i++) {

                citations[i] = scanner.nextInt();
            }

            int answer = obj.hIndex(citations);

            System.out.print("H index of researcher is " + answer);
        }

}

/*
TIME COMPLEXITY = O(NlogN)

SPACE COMPLEXITY = O(1)
*/