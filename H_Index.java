/**
 * Time Complexity : O(n) where n is the number of citations
 * Space Complexity : O(n)
 */
public class H_Index{
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){return 0;}
        int[] buckets = new int[citations.length+1];                                                       
           int s = 0;                                                                              
        for(int i = 0; i < citations.length; i++){
            if(citations[i] < citations.length){                                                               
                buckets[citations[i]]++;                                              
            }else {
                buckets[citations.length]++;                                                       
            }
        }
       for(int i = buckets.length-1; i>=0; i--){
           s+=buckets[i];
           if(s >= i) return i;                                                                
       }
           return -1;
        }
}