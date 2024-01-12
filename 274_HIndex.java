/*

citations is not in sorted manner
if sorted, we can just us n-h approach as folows
1. Sort the array. 
2. h index will lie from 0 to n = length of the array 
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

/*
 * approach
 * 1. take the new array of size n+1
 * 2. go to the citations, and mark that indx in arr[] an increase it by 1.
 * 3. when find a value bigger than the n, just keep incrementing the last
 * index.
 * 4. run a nother for loop to find the H index.
 * 5. take a sm variable, an keep a running sum while traversing backwards.
 * 6. when sum >= index value; that index is h-index.
 * TC: O(n) - 2 pass
 * SC: O(n)
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int index = citations[i];
            if (index > n)
                arr[n]++;
            else
                arr[index]++;
        }

        // go backward from the right side and maintain a sum
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum = sum + arr[i];
            if (sum >= i)
                return i;
        }
        // never found it
        return 0;
    }
}