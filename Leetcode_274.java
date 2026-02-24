//Count array - count number of occurances of every citation. If the citation[i]>=n, count nth element
//Come from end of count array
//Add the elements - if the elements counts>=i, return i
//TC: O(2n)
//SC: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;

        int[] count=new int[n+1];

        for(int i:citations){
            if(i>=n){
                count[n]+=1;
            }else{
                count[i]+=1;
            }
        }

        int sum=0;

        for(int i=n;i>=0;i--){
            sum+=count[i];

            if(sum>=i){
                return i;
            }
        }

        return 0;

        
    }
}
