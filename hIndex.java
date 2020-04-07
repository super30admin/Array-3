class Solution {
    public int hIndex(int[] citations) {
        if(citations == 0 || citations.length == 0)
            return 0;
        //return hIndexSort(citations);
        return hIndexBucketSort(citations);
    }
    
    /*
    len - i equals the number of papers that have higher citations than the iTh paper.
    Time Complexity : O(nLogn) 
    SPace Complexity: O(1) space
    */
    private int hIndexSort(int[]citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int len = citations.length;
        for (int i = 0; i < len; i++){
            if (citations[i] >= len - i)
                return (len - i);
        }
    }
    /*
    len - i equals the number of papers that have higher citations than the iTh paper.
    Time Complexity : O(nLogn) 
    SPace Complexity: O(1) space
    */
    // Bucket Sort, Hashing. Time: O(n), Space: O(n)
    public int hIndexBucketSort(int[]citations) {
        int len = citations.length;
        int[] buckets = new int[len + 1];
        // counting papers for each citation number
        for (int i = 0; i < len; i++)
            buckets[Math.min(citations[i], len)]++;
        // finding the h-index
        for (int i = len, count = 0; i >= 0; i--) {
            count += buckets[i];
            if (count >= i)
                return i;
        }
     
    }
}


