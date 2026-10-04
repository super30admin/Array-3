// doinf bucket sort to identify the count based on number of citations, once we have the array created , add count to so th count is equal to number of citations
// o((n) time complexity
// o(n) space  complexity

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length ;
        int[] buckets = new int[n+1];
         
        int min = Integer.MAX_VALUE;
        int totalMin;

         for( int c: citations){
            if( c>= n ){
                buckets[n]++;
            } else {
                buckets[c]++;
            }
         }

         int count = 0;

         for(int i = n ; i>=0; i--){
            count = count + buckets[i];
            if(count >= i ){
                return i;
            }
         }
          
         return -1;   
        
        
        
    }
}
