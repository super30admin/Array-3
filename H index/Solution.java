// Time Complexity: O(nlogn) 
//space Complexity:O(1)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len  = citations.length;
        for(int i=0;i<citations.length;i++){
            if(len<= citations[i]){
                return len;
            }
            len--;
        }
        return 0;
    }
}
