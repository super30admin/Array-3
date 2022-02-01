class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0; //base case where if the citations is null of the length of citations is 0 we return 0;
        int n = citations.length; //n is an integer variable which stores the length of the citations array
        int[] result = new int[n + 1]; //we take a result integer array of length n + 1; we take the value as n + 1 because we need the value which has 0 citations or n citations
        for(int i = 0; i < n; i++) { //we go through all the values in the citations array
            if(citations[i] > n) { //if the value at index i is greater than the value of n
                result[n]++; //we increment the count at at the last element in the result array
            }
            else { // if the value at index i is less than the values in the citations array
                result[citations[i]]++; //we increment the value at that index of the value that we get while we are iterating in the citations array
            }
        }
        int sum = 0; //sum is the integer variable which will store the total number of citations
        for(int i = n; i > 0; i--) { //we go through the result array starting from left to right
            sum = sum + result[i]; //we keep adding the elements that we encounter and store that sum in the integer variable sum
            if(sum >= i) { //if the value of sum is greater than equal to the value of i
                return i; //we simply return i which is the h index
            }
        }
        return 0;
    }
}
//tc and sc - O(n)