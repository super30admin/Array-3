//TC : O(n) , n is length of citations
//SC : O(n) , n is length of citations
class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length+1];
        int n=citations.length;
        for(int i=0;i<citations.length;i++){
                count[ Math.min(citations[i],n) ]++;
        }
        int sum = 0;
        for(int i=count.length-1;i>=0;i--){
            sum = sum+count[i];
            if(sum>=i)
                return i;
        }
        return -1;
    }
}