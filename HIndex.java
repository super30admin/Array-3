/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int hIndex(int[] citations) 
    {
        int length = citations.length;
        
        int bucket[] = new int[length+1];
        
        for(int i = 0; i < length; i++)
        {
            int value = citations[i];
            
            if(value >= length)
                bucket[length]++;
            else
                bucket[value]++;
        }
        
        int result = 0;
        
        for(int i = length; i >=0; i-- )
        {
            result = result + bucket[i];
            
            if(result >= i)
                return i;
        }
        
        return 0;
        
    }
}