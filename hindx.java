class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int h=0;
        if(n==1 ){
            if(citations[0]==0)return 0;
            return 1;
        }
        if(citations[0]==0 )h=citations[1];
       for(int i=0;i<n;i++){
           if(citations[i]>h ){
               h=citations[i];
           }
           if( n-i<=h){
               return h=n-i;
       
           }
               }
        return h;
    
}}
