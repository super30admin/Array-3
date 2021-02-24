//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Create a bucket array of papers and iterate through the array from back
//calculating the sum to calculate the total papers and compare with index for citations.
//When ever the sum crosses index means papers with >= citations then thats the result
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int len = citations.length;
        int[] bucket = new int[len + 1];
        for(int i = 0; i < len; i++)
        {
            if(citations[i]  >= len)
                bucket[len] ++;
            else
                bucket[citations[i]]++;
        }
        int sum =0;
        for(int i = len; i >=0; i--)
        {
            sum += bucket[i];
            if(sum >= i)
            {
                return i;
            }
        }
        return 0;
    }
}