

// the concept here is that of bucket sort. If there are n elements in the array we know that the  h index can range from 0 to n .so we declare an array of n+1 size(to have indexes from 0 to n). Each element in this array is like a bucket. Now for the citations we have, any value above n will be added to nth bucket because maximum answer is capped at n .so we do buckets[n]++. For all other citation values, we increment the count of that respective bucket. Now take running sum of the buckets element and figure out the point where the sum is >= the index value and this gives you the h index.
//Time O(n)
//Space O(n)
class Solution {
    public int hIndex(int[] citations) {
      int n = citations.length;
      
      int [] buckets = new int[n+1];
   
      for(int i :citations)
      {
          if(i>=n)
              buckets[n]++;
           else buckets[i]++;
      }
        int sum=0;
        int i=0;
        for(int j=n;j>=0;j--)
        {   i++;
            sum+=buckets[j];
            if(sum>=j)
                return j;

        }
      return -1;
    }
}