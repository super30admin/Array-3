class Solution {
    //sort the citations in ascending order
    //for each paper at index i, we check how many papers (n-i) have atleast that many citations
    //Time Complexity: O(nlogn)
    //Space Complexity: O(1)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i=0;
        while(i<citations.length && citations[citations.length-1-i] >i)
        {
           i++; 
        }
        return i;
    }
}