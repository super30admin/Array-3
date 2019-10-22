//Time complexity: O(n)
//Space Complexity: O(1)
//Check if the given list of citations is empty if so return 0.
//Sort the given list as it is not sorted and find the length of the citations array (len)
//iterate over the list of citations and check if the len is lesser or equal to the number of citations at i then return len
//else decrement the len
//Finally return the resultant len.
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
        {
            return 0;
        }
        Arrays.sort(citations);
        
        int len = citations.length;
        for(int i=0; i<citations.length; i++)
        {
            if(len<=citations[i])
            {
                return len;
            }
            
            else
            {
                len--;
            }
              
        }
        return len;
    }
}