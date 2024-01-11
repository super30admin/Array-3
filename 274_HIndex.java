/*

citations is not in sorted manner
if sorted, we can just us n-h approach as folows
1. Sort the array. 
2. h index will lie from 1 to n = length of the array 
3. find the index, where, h index value <= citations values. 
4. return that index. 

TC: O(n logn) + O(n)
sc: O(1)*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length; // dont do -1 as h index is 1 to n

        for (int i = 0; i < n; i++) {
            int hindex = n - i;
            if (citations[i] >= hindex)
                return hindex;
        }
        // never found it
        return 0;
    }
}