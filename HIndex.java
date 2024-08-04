//TC - O(n)
//Sc - O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
        int[] result = new int[n+1]; // H-index is from 0 to n, so create an array that takes up all the H-index. 
        for(int i = 0; i < n; i++){
            int index = citations[i];
            if(index > n){
                result[n]++;
            }
            else{
                result[index]++;
            }
        }
        int sum = 0;
        for(int j = n; j >= 0; j--){
            sum = sum + result[j];
            if(sum >= j){
                return j;
            }

        }

    return 0;
    }
}
