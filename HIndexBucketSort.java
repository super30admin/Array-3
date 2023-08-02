import java.util.Scanner;

public class HIndexBucketSort {

        // BUCKET SORT - TIME O(N) AND SPACE O(N)

        public int hIndex(int[] citations) {

            if(citations == null)    return 0;

            int n = citations.length;

            int[] bucket = new int[n+1];   // O(N) space

            // put a paper with at least citations[i] into that bucket
            for(int cit: citations) {      // O(N)

                // if number of citations increase total number of papers, put those papers in last bucket
                if(cit >= n) {

                    bucket[n]++;
                }

                else {
                    // put a paper into bucket with index as its number of citations
                    bucket[cit]++;
                }
            }

            int numCit = 0;

            // iterate from the last of bucket array
            for(int i = n; i >= 0; i--) {   // O(N)

                // count minimum number of citations for each paper
                numCit += bucket[i];

                // if number of citations cross number of papers, return that paper index as H-index
                if(numCit >= i) {

                    return i;
                }
            }
            return 9999;
        }

        public static void main(String[] args) {

            HIndexBucketSort obj = new HIndexBucketSort();

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
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(N)
*/