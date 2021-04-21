//TC: O(2n) --> O(n)
//SC: O(n)

class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0)
            return 0;
        int[] ct = new int[citations.length+1];
        for(int i=0;i<citations.length;i++) //h-index --> number of citations from that index >= remaining citations.
        {
            if(citations[i]>=ct.length)     //Taking extra array to store the array of size of citations array+1.
                ct[ct.length-1]++;      //keeping the count of citation value with index of the extra array taken.
            else
                ct[citations[i]]++;     //If value is more than the size of the array, add count the last index.
        }
        int count = 0;
        for(int i=ct.length-1;i>=0;i--) //Now traversing from behind and keeping the count of previous value and checking if the count is greater than or equal to the index return i;
        {
            count+=ct[i];
            if(count>=i)
                return i;
        }
        return 0;
    }
}