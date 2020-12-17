//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class H_Index_274 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int sum = 0;
        int[] buckets = new int[n+1];
        for(int i = 0; i < n; i++)
        {
            if(citations[i] >= n)
                buckets[n]++;
            else buckets[citations[i]]++;
        }
        for(int i = n; i >= 0; i--)
        {
            sum += buckets[i];
            if(sum >= i)
                return i;
        }
        return 100;
        
      //Time Complexity : O(n logn)
      //Space Complexity : O(1)
//        public int hIndex(int[] citations) {
//            if(citations == null || citations.length == 0)
//                return 0;
//            Arrays.sort(citations);
//            int low = 0;
//            int high = citations.length-1;
//            int n = citations.length;
//            while(low <= high)
//            {
//                int mid = low + (high - low) / 2;
//                if(n-mid == citations[mid])
//                    return n-mid;
//                else if(n-mid > citations[mid])
//                    low = mid+1;
//                else
//                    high = mid-1;
//            }
//            return n - low;
//        }
        
        
        //Time Complexity : O(n logn)
        //Space Complexity : O(1)
//        public int hIndex(int[] citations) {
//            if(citations == null || citations.length == 0)
//                return 0;
//            int n = citations.length;
//            Arrays.sort(citations);
//            for(int i = 0; i < n; i++)
//            {
//                if(n-i <= citations[i])
//                    return n-i;
//            }
//            return 0;
//        }
    }
	public static void main(String[] args)
	{
		H_Index_274 hInd = new H_Index_274();
		int[] citations = {3,0,6,1,5};
		
		System.out.println(hInd.hIndex(citations));
	}
}
