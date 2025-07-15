import java.util.Arrays;

//Time complexity: O(nlogn) for sorting where n is the number of citations
//Space complexity: O(1) for sorting in place

// LeetCode Problem: https://leetcode.com/problems/h-index/
//Intuition: The h-index is defined as the maximum value h such that the given author 
// has published h papers that have each been cited at least h times. To find the h-index, 
// we can sort the citations in ascending order and then perform a linear search to 
// find the maximum h that satisfies the condition.

public class HIndex {
    public int hIndex(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        int length = citations.length - 1;
        /*
         * citations = [3,0,6,1,5]
         * citations = [6,5,1,1,0]
         * i = 2 breaks!!
         * 
         */
        while (i < citations.length && citations[length] > i) {
            // System.out.println("c:"+(citations.length - 1 - i)+"
            // c[c]:"+citations[citations.length - 1 - i]+" "+"i:"+i);
            length--;
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }
}
