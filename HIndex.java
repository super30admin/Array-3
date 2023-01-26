//Time Complexity: O(n)
//Space Complexity: O(n)

/*
 * maintain a bucket sort array and store the number of citations
 * at each index. if the number is greater than last index, add it 
 * to the last index and we find the h index by moving backward in array.
 */

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n+1];

        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                arr[n]++;
            }
            else{
                arr[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += arr[i];
            if(sum >= i) return i;
        }
        return -1;
    }
}