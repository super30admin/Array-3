// 274.
// time - O(n)
// space - O(n)
class Solution {
    public int hIndex(int[] citations) {
        //h index is a value between 0 and citations.length
        //in every index of hArray stores paper with citations equal to index value
        //except for last index which stores number of papers with ciations greater than or equal to last index value
        //eg - citations[] = [3,0,6,1,5]
        //h index is between 0 and 5
        //hArray = [1,1,0,1,0,2]
        int[] hArray = new int[citations.length + 1];
        for(int citation : citations)
        {
            if(citation > citations.length)
            {
                hArray[hArray.length - 1]++;
            }
            else
            {
                hArray[citation]++;
            }
        }
        
        //hArray = [1,1,0,1,0,2]
        // i = 5 -> if 5 is answer then there must be atleast 5 paper with citations above or equal to 5 (only 2) - add 2 to result
        // i = 4 -> if 4 is answer then there must be atleast 4 paper with citations above or equal to 4 (only 2) - add 0 to result
        // i = 3 -> if 3 is answer then there must be atleast 3 paper with citations above or equal to 3 - there are 3 (2 + 1) - return 3 (i)
        int total = 0;
        for(int i = hArray.length - 1; i >= 0; i--)
        {
            total += hArray[i];
            //if index with number of papers with citations greater than or equal to index if found, return it
            if(total >= i) 
            {
                return i;
            }
        }
        return 0; //never reaches here
    }
}
