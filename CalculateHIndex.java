/*
    The time complexity is O(NlogN) and the space complexity is O(1).

    Here the intuition is to first sort the array. Then find a position where the value in that position is greater than or equal to
    the length from that position till the end or array. Since the array is sorted every element after our position will be equal or
    greater than our value.

    Yes, the position passed all the test cases in leet code.
 */
class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;

        for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                //Return the length which is our h-index.
                return n-i;
            }
        }

        return 0;
    }
}