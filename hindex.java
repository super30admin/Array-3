//This is not a effiecient solution 
//Time complexity - O(nlogn)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null ||citations.length == 0){
            return 0;
        }
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            int diff = n - i;
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
        
    }
}