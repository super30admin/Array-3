// Time - O(N)
// Space - O(N)


class Solution {
    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0) return 0;

        int n = citations.length;

        int [] bucket = new int[n+1];

        for(int i = 0; i < n; i++) { // iterate through citations array

            if(citations[i] >= n) { // if citations is more then or equal to length then add it to the last place of the bucket

                bucket[n] += 1;

            }
            else {

                bucket[citations[i]]  += 1; // add 1 to the indices of citations in the bucket

            }

        }

        int sum = 0;

        for(int i = n; i >= 0; i--) { // iterate from the last

            sum += bucket[i]; // calculate the sum
            if(sum >= i) return i; // if the sum surpasses indices value then return the citation index

        }

        return 920471;
    }
}