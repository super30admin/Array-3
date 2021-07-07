//Time complexity is O(NLogN)
//Space complexity is O(1)
//This solution is submitted on leetcode

import java.util.Arrays;

public class BigN115HIndexNewSolutions {
	class Solution {
	    public int hIndex(int[] citations) {
	        //edge case
	        if(citations == null || citations.length==0)
	            return 0;
	        Arrays.sort(citations);
	        int n = citations.length;
	        int i = n-1;
	        int h = 0;
	        while(i>=0 && h<citations[i]){
	            i--;
	            h++;
	        }
	        return h;
	    }
	}
}